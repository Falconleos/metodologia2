package service.serviceImpl;

import enums.VacationRequestStatus;
import model.UserEntity;
import model.VacationRequest;
import repository.VacationRepository;
import service.VacationRequestService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class VacationRequestServiceImpl implements VacationRequestService {

    private final VacationRepository vacationRepository;

    public VacationRequestServiceImpl(VacationRepository vacationRepository) {
        this.vacationRepository = vacationRepository;
    }

    @Override
    public VacationRequest createRequest(UserEntity empleado, LocalDate start, LocalDate end, UserEntity supervisor) {

        if (start.isAfter(end)) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de fin.");
        }

        long requestedDays = ChronoUnit.DAYS.between(start, end) + 1;

        if (requestedDays > empleado.getVacationDaysAvailbles()) {
            throw new IllegalArgumentException("Los días solicitados superan los días de vacaciones disponibles.");
        }

        VacationRequest request = new VacationRequest(empleado, start, end, supervisor);
        vacationRepository.save(request);

        return request;
    }

    @Override
    public void approveOrDenyRequest(VacationRequest request, UserEntity supervisor, boolean approve) {
        if (!request.getSupervisor().equals(supervisor)) {
            throw new SecurityException("El supervisor no está autorizado para gestionar esta solicitud.");
        }

        if (request.getStatus() != VacationRequestStatus.PENDING) {
            throw new IllegalStateException("Esta solicitud ya fue gestionada anteriormente.");
        }

        if (approve) {
            request.setStatus(VacationRequestStatus.APPROVED);

            long approvedDays = ChronoUnit.DAYS.between(request.getStart(), request.getEnd()) + 1;
            UserEntity empleado = request.getEmpleado();


            if (approvedDays > empleado.getVacationDaysAvailbles()) {
                throw new IllegalArgumentException("El empleado ya no cuenta con suficientes días disponibles.");
            }

            empleado.setVacationDaysAvailbles(empleado.getVacationDaysAvailbles() - approvedDays);

        } else {
            request.setStatus(VacationRequestStatus.DENIED);
        }
    }
}