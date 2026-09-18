package service.serviceImpl;

import model.Role;
import model.UserEntity;
import repository.UserRepository;
import service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity registerUser(String email, String password, String name, String surname, Long vacationDays, Role role) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("Ya existe un usuario registrado con el correo: " + email);
        }

        if (vacationDays < 0) {
            throw new IllegalArgumentException("Los días de vacaciones no pueden ser negativos.");
        }

        UserEntity newUser = new UserEntity(null, email, password, name, surname, vacationDays, vacationDays, role);
        return userRepository.save(newUser);
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
}