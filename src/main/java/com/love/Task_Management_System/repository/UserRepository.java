package com.love.Task_Management_System.repository;

import com.love.Task_Management_System.model.Project;
import com.love.Task_Management_System.resource.UserResource;
import com.love.Task_Management_System.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    @Query("select u from Users u where u.username = :name order by u.id desc")
    List<Users> filterByName(@Param("name") String name);

//    Boolean existsByName(String userName);
//
//    Boolean existsByEmail(String email);

    @Query("SELECT u.id FROM Users u WHERE u.username=:name")
    long getIdByUsername(@Param("name") String name);
    public static final String FIND_USER = "SELECT id, firstName, lastName, email, password FROM users";

    @Query(value = FIND_USER, nativeQuery = true)
    List<UserResource> findAllUsers();

    @Query("select u from Users u where u.email = :email order by u.id desc")
    List<Users> filterByEmail(@Param("email") String email);

    @Query("select u from Users u where u.phone = :phone order by u.id desc")
    List<Users> filterByPhone(@Param("phone") String phone);
    @Query("SELECT u.projects FROM Users u WHERE u.id = :userId")
    List<Project> findProjectById(Long userId);
}
