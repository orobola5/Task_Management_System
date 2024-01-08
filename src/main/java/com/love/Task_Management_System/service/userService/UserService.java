package com.love.Task_Management_System.service.userService;

import com.love.Task_Management_System.dto.ApiResponse;
import com.love.Task_Management_System.dto.UserInputDTO;
import com.love.Task_Management_System.exception.UserNotFoundException;
import com.love.Task_Management_System.model.Users;
import com.love.Task_Management_System.resource.UserResource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
     ApiResponse getAllUser() ;
    ApiResponse getUsersByName( String userName) throws UserNotFoundException;
    ApiResponse getUsersByEmail( String email) throws UserNotFoundException;
    ApiResponse getUsersByPhone(String phoneNumber) throws UserNotFoundException;
    ApiResponse updateUser(UserResource u, Long id) throws UserNotFoundException;
    ApiResponse deleteUser(Long userId) throws UserNotFoundException;
    ApiResponse getUserById(Long id) throws UserNotFoundException;
    ApiResponse getAllUserByProject(long programId) throws UserNotFoundException;
   ApiResponse getAllProjectByUser(long uid) throws UserNotFoundException;

    Users getUser(Long uid);
}
