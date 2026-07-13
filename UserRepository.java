package ng.ourChemo.data.repositories;

import ng.ourChemo.data.models.User;

import java.util.List;

public interface UserRepository {
    User save (User user);
    void deleteById(Long id);
    void delete(User user);
    void deleteAll();
    long count();
    User findById(Long id);

    List<User> findAllById(Long id);

    boolean existsById(Long id);
}
