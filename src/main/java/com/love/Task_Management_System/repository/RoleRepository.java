package com.love.Task_Management_System.repository;

import com.love.Task_Management_System.model.RoleName;
import com.love.Task_Management_System.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Roles,Long> {
    List<Roles> findByName(RoleName roleName);
}
