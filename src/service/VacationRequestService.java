package service;

import model.UserEntity;
import model.VacationRequest;

import java.time.LocalDate;

public interface VacationRequestService {

    VacationRequest generateRequest(UserEntity emplado, LocalDate start, LocalDate end, UserEntity supervisor);

}
