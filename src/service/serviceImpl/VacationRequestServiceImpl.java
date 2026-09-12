package service.serviceImpl;

import enums.VacationRequestStatus;
import model.UserEntity;
import model.VacationRequest;
import repository.VacationRepository;
import service.VacationRequestService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class VacationRequestServiceImpl implements VacationRequestService {

    private VacationRepository vacationRepository;

    @Override
    public VacationRequest generateRequest(UserEntity empleado, LocalDate start, LocalDate end, UserEntity supervisor) {

        //if userEsta logueado

        VacationRequest request = new VacationRequest();

        if(empleado.getVacationDaysAvailbles()>0){

            request = new VacationRequest(empleado,start,end,supervisor);
            request.setStatus(VacationRequestStatus.PENDING);

            vacationRepository.addToList(request);

            Long cantDays = ChronoUnit.DAYS.between(end,start);

            if(cantDays >= empleado.getVacationDaysAvailbles()){
                 vacationRepository.findByUser(empleado);

                request.setSupervisor(supervisor);
                request.setStatus(VacationRequestStatus.GENERATED);
                System.out.println("Request exitoso");

            }else{
                throw new RuntimeException("no tiene dias suficientes");
            }

        }else{
            throw new RuntimeException("no tiene dias disponibles de vacaciones");
        }

        return request;
    }
}
