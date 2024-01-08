package com.love.Task_Management_System.repository;

import com.love.Task_Management_System.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
    List<Project> findByAdmin(long admin);
}
