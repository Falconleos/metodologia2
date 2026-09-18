package repository;

import model.VacationRequest;
import model.UserEntity;
import java.util.List;

public interface VacationRepository {
    void save(VacationRequest request);
    List<VacationRequest> findByEmployee(UserEntity employee);
    List<VacationRequest> findBySupervisor(UserEntity supervisor);
}