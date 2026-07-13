package ng.ourChemo.data.repositories;

import ng.ourChemo.data.models.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserRepositoryTest {

    @Test
    public void repositoryByShouldBeEmptyTest() {
        UserRepository userRepository = new UserRepositoryImpl();
        assertEquals(0, userRepository.count());
    }

    @Test
    public void saveNewUser_countIsOneTest(){
        UserRepository userRepository = new UserRepositoryImpl();
        userRepository.save(new User());
        assertEquals(1, userRepository.count());
    }

    @Test
    public void saveNewUser_findByIdReturnUserTest(){
        UserRepository userRepository = new UserRepositoryImpl();
        User user = new User();
        User savedUser = userRepository.save(user);
        User foundUser = userRepository.findById(savedUser.getId());
        assertEquals(savedUser.getFullName(), foundUser.getFullName());
        assertEquals(savedUser.getUsername(), foundUser.getUsername());

    }

    @Test
    public void findAllByIdTest() {
        UserRepository userRepository = new UserRepositoryImpl();
        User firstUser = new User();
        User secondUser = new User();
        userRepository.save(firstUser);
        userRepository.save(secondUser);
        List<User> allUsers = userRepository.findAllById(firstUser.getId());
        assertEquals(2, allUsers.size());

    }

    @Test
    public void updateUser_findByIdReturnUpdatedUserTest(){
        UserRepository userRepository = new UserRepositoryImpl();
        User user = new User();
        user.setFullName("original Name");
        user.setUsername("originalusername");
        User savedUser = userRepository.save(user);
        assertEquals(1, userRepository.count());
        User updatedUser = userRepository.findById(savedUser.getId());
        assertEquals(savedUser.getFullName(), updatedUser.getFullName());
        assertEquals(savedUser.getUsername(), updatedUser.getUsername());

    }


    @Test
    public void deleteUserTest() {
        UserRepository userRepository = new UserRepositoryImpl();
        User deleteUser = new User();
        userRepository.save(deleteUser);
        assertEquals(1, userRepository.count());
        userRepository.delete(deleteUser);
        assertEquals(0, userRepository.count());
    }

    @Test
    public void deleteUserByIdTest() {
        UserRepository userRepository = new UserRepositoryImpl();
        User deleteUser = new User();
        User savedUser = userRepository.save(deleteUser);
        assertEquals(1, userRepository.count());
        userRepository.deleteById(savedUser.getId());
        assertEquals(0, userRepository.count());
    }

    @Test
    public void userExistsByIdTest() {
        UserRepository userRepository = new UserRepositoryImpl();
        User user = new User();
        userRepository.save(user);
        boolean exists = userRepository.existsById(user.getId());
        assertTrue(exists);
    }


    @Test
    public void deleteAllUsersTest() {
        UserRepository userRepository = new UserRepositoryImpl();
        User firstUser = new User();
        User secondUser = new User();
        userRepository.save(firstUser);
        userRepository.save(secondUser);
        assertEquals(2, userRepository.count());
        userRepository.deleteAll();
        assertEquals(0, userRepository.count());
    }




}
