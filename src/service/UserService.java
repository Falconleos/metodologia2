package service;

import model.Role;
import model.UserEntity;
import java.util.List;
import java.util.Optional;

public interface UserService {
    UserEntity registerUser(String email, String password, String name, String surname, Long vacationDays, Role role);
    Optional<UserEntity> findById(Long id);
    Optional<UserEntity> findByEmail(String email);
    List<UserEntity> getAllUsers();
}