package repository.repositoryImpl;

import model.VacationRequest;
import model.UserEntity;
import repository.VacationRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryVacationRepository implements VacationRepository {
    private final List<VacationRequest> database = new ArrayList<>();

    @Override
    public void save(VacationRequest request) {
        database.add(request);
    }

    @Override
    public List<VacationRequest> findByEmployee(UserEntity employee) {
        return database.stream()
                .filter(request -> request.getEmpleado().equals(employee))
                .toList();
    }

    @Override
    public List<VacationRequest> findBySupervisor(UserEntity supervisor) {
        return database.stream()
                .filter(request -> request.getSupervisor() != null && request.getSupervisor().equals(supervisor))
                .toList();
    }
}