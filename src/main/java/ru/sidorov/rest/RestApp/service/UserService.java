package ru.sidorov.rest.RestApp.service;

import ru.sidorov.rest.RestApp.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findOne(Long id);
    boolean save(User user);
    void update(Long id, User updateUser);
    void delete(Long id);


}
