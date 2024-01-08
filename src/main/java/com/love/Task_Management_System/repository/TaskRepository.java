package com.love.Task_Management_System.repository;


import com.love.Task_Management_System.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Tasks,Long> {
    @Query(value="Select * from task order by due_date desc",nativeQuery = true)
    public List<Tasks> getAllTaskDueDateDesc();
}
