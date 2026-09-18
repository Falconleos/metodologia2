package service;

import model.UserEntity;
import model.VacationRequest;
import java.time.LocalDate;

public interface VacationRequestService {
    VacationRequest createRequest(UserEntity empleado, LocalDate start, LocalDate end, UserEntity supervisor);
    void approveOrDenyRequest(VacationRequest request, UserEntity supervisor, boolean approve);
}