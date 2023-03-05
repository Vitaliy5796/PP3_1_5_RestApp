package ru.sidorov.rest.RestApp.service;

import ru.sidorov.rest.RestApp.models.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    void addRole(Role role);
}
