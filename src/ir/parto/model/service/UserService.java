package ir.parto.model.service;

import ir.parto.model.entity.User;
import ir.parto.model.repository.UserRepository;

import java.util.List;

public class UserService {
    UserRepository userRepository = new UserRepository();

    public User addUser(User user){
        return userRepository.insertUser(user);
    }

    public User updateUser(User user){
        return userRepository.updateUser(user);
    }

    public List<User> removeUser(User user) {
        return userRepository.deleteUser(user);
    }

    public List<User> findAllUser() {
        return userRepository.selectUser();
    }

    public User findUser(User user){
        return userRepository.selectOneUser(user);
    }

}
