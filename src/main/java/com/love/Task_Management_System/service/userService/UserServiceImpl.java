package com.love.Task_Management_System.service.userService;

import com.love.Task_Management_System.dto.ApiResponse;
import com.love.Task_Management_System.dto.UserInputDTO;
import com.love.Task_Management_System.exception.UserNotFoundException;
import com.love.Task_Management_System.model.Project;
import com.love.Task_Management_System.model.Users;
import com.love.Task_Management_System.repository.ProjectRepository;
import com.love.Task_Management_System.repository.UserRepository;
import com.love.Task_Management_System.resource.ProjectResource;
import com.love.Task_Management_System.resource.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    UserRepository userRepository;



    @Override
    public ApiResponse getAllUser(){
        List<Users> users = userRepository.findAll();

        if (users.isEmpty()) {
            try {
                throw new UserNotFoundException("No users found");
            } catch (UserNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        List<UserResource> userResources = users.stream()
                .map(UserResource::new)  // Assuming UserResource has a constructor that takes a User
                .collect(Collectors.toList());

        return new ApiResponse(true,"All the users found",userResources);

    }


    @Override
    public ApiResponse getUsersByName(String name) throws UserNotFoundException {
        List<Users> users = userRepository.filterByName(name);

        if (users.isEmpty()) {
            throw new UserNotFoundException("No user found with the given name");
        }

        List<UserResource> userResources = users.stream()
                .map(UserResource::new)
                .collect(Collectors.toList());

        return new ApiResponse(true,"user exist",userResources);
    }




    @Override
    public ApiResponse getUsersByEmail(String email) throws UserNotFoundException {
        List<Users> users = userRepository.filterByEmail(email);

        if (users.isEmpty()) {
            throw new UserNotFoundException("No users found with the given email");
        }

        List<UserResource> userResources = users.stream()
                .map(UserResource::new)
                .collect(Collectors.toList());

        return new ApiResponse(true,"user exist",userResources);
    }

    @Override
    public ApiResponse getUsersByPhone(String phoneNumber) throws UserNotFoundException {
        List<Users> users = userRepository.filterByPhone(phoneNumber);

        if (users.isEmpty()) {
            throw new UserNotFoundException("No users found with the given phoneNumber");
        }

        List<UserResource> userResources = users.stream()
                .map(UserResource::new)
                .collect(Collectors.toList());

        return new ApiResponse(true,"user exist",userResources);
    }

    @Override
    public ApiResponse updateUser(UserResource userInputDTO, Long id) throws UserNotFoundException {
        // Retrieve the existing user from the database
        Users existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

        // Update user details based on the input DTO
        existingUser.setUsername(userInputDTO.getUsername());
        existingUser.setFirstName(userInputDTO.getFirstName());
        existingUser.setLastName(userInputDTO.getLastName());
        existingUser.setEmail(userInputDTO.getEmail());
        existingUser.setRoles(userInputDTO.getRoles());
        existingUser.setPhone(userInputDTO.getPhoneNumber());

        // Save the updated user
        Users updatedUser = userRepository.save(existingUser);

        // Convert the updated user to a DTO or resource if needed
        UserResource userResource = new UserResource(updatedUser);

        // Return the updated user as part of the API response
        return new ApiResponse(true,"user updated",userResource);
    }


    @Override
    public ApiResponse deleteUser(Long userId) throws UserNotFoundException {
        // Check if the user exists
        Users userToDelete = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));

        // Perform additional checks or logic if needed before deletion

        // Delete the user
        userRepository.deleteById(userId);

        // Return a success response
        return new ApiResponse(true,"User deleted successfully");
    }


    @Override
    public ApiResponse getUserById(Long id) throws UserNotFoundException {
        Optional<Users> users = userRepository.findById(id);

        if (users.isEmpty()) {
            throw new UserNotFoundException("No user found with the id");
        }

        List<UserResource> userResources = users.stream()
                .map(UserResource::new)
                .collect(Collectors.toList());

        return new ApiResponse(true,"user exist",userResources);
    }

    @Override
    public ApiResponse  getAllUserByProject(long programId) {
        List<UserResource> users = projectRepository.findById(programId)
                .get()
                .getUsers()
                .stream()
                .map(user -> {
                    return new UserResource(user);
                })
                .collect(Collectors.toList());
        return new ApiResponse(true,"user exist",users);
    }

    @Override
    public ApiResponse getAllProjectByUser(long uid) throws UserNotFoundException {
        List<Project> projects = userRepository.findProjectById(uid);

        if (projects.isEmpty()) {
            throw new UserNotFoundException("No project found");
        }

        List<ProjectResource> projectResources= projects.stream()
                .map(ProjectResource::new)  // Assuming UserResource has a constructor that takes a User
                .collect(Collectors.toList());

        return new ApiResponse(true, "All the users found", projectResources);
    }

    @Override
    public Users getUser(Long uid) {
        return userRepository.findById(uid).get();
    }


}
