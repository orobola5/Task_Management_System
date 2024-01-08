package com.love.Task_Management_System.repository;

import com.love.Task_Management_System.model.TaskRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRecordRepository extends JpaRepository<TaskRecord,Long> {
    @Query("SELECT t FROM TaskRecord t WHERE t.user=:id")
    List<TaskRecord> getTaskRecordByUser(@Param("id") long user);

    List<TaskRecord> findByProgramAndUser(long program, long user);

    TaskRecord findByProgramAndUserAndTask(long program, long user, long task);
}
