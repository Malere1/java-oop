package ng.ourChemo.data.repositories;

import ng.ourChemo.data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository{

    private int count;
    private final List<User> users = new ArrayList<>();
    private long idCounter = 1;




    @Override
    public User save(User user) {
        if(user.getId() == null){
            user.setId(idCounter);
            idCounter++;
            users.add(user);
        }
        else {
            int index = users.indexOf(user);
            if(index != -1){
                users.set(index, user);
            }
            else{
                users.add(user);
            }
        }
        return user;
    }


    private void updateExisting(User user) {
        deleteById(user.getId());
        users.add(user);
    }



    @Override
    public void deleteById(Long id) {
        users.removeIf(user -> user.getId().equals(id));

    }

    @Override
    public void delete(User user) {
        if(user != null){
            users.remove(user);
        }

    }

    @Override
    public void deleteAll() {
        users.clear();

    }

    @Override
    public long count() {
        return users.size();
    }

    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(id);

        int index = users.indexOf(user);
        if(index != -1){
            return users.get(index);
        }
        return null;
    }

    @Override
    public List<User> findAllById(Long id) {
        return new ArrayList<>(users);
    }


    @Override
    public boolean existsById(Long id) {
        User user = new User();
        user.setId(id);
        return users.contains(user);

    }


}



