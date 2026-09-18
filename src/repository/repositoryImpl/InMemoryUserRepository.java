package repository.repositoryImpl;

import model.UserEntity;
import repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryUserRepository implements UserRepository {

    private final List<UserEntity> database = new ArrayList<>();
    private Long idCounter = 1L;

    @Override
    public UserEntity save(UserEntity user) {
        if (user.getId() == null) {
            user.setId(idCounter++);
        } else {
            database.removeIf(u -> u.getId().equals(user.getId()));
        }
        database.add(user);
        return user;
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        return database.stream().filter(u -> u.getId().equals(id)).findFirst();
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return database.stream().filter(u -> u.getEmail().equalsIgnoreCase(email)).findFirst();
    }

    @Override
    public List<UserEntity> findAll() {
        return new ArrayList<>(database);
    }

    @Override
    public void delete(Long id) {
        database.removeIf(u -> u.getId().equals(id));
    }
}