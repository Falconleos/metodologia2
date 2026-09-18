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

        // Crear la solicitud
        VacationRequest request = new VacationRequest(empleado, start, end, supervisor);
        vacationRepository.save(request);

        // Descontar días disponibles opcionalmente o manejarlos al aprobar
        return request;
    }

    @Override
    public void approveOrDenyRequest(VacationRequest request, UserEntity supervisor, boolean approve) {
        if (!request.getSupervisor().equals(supervisor)) {
            throw new SecurityException("El supervisor no está autorizado para gestionar esta solicitud.");
        }

        if (approve) {
            request.setStatus(VacationRequestStatus.APPROVED);
        } else {
            request.setStatus(VacationRequestStatus.DENIED);
        }
    }
}