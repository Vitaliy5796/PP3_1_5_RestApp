package ru.sidorov.rest.RestApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sidorov.rest.RestApp.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
