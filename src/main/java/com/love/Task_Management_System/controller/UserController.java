package com.love.Task_Management_System.controller;
import com.love.Task_Management_System.dto.ApiResponse;
import com.love.Task_Management_System.exception.UserNotFoundException;
import com.love.Task_Management_System.resource.UserResource;
import com.love.Task_Management_System.service.userService.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService service;
    private static final Logger L = LogManager.getLogger(UserController.class);

    @GetMapping("/getAllUser")
    public ResponseEntity<ApiResponse> getAllUser() throws UserNotFoundException {
        ApiResponse response;

        ApiResponse users = service.getAllUser();
        response = new ApiResponse(true, "All the users found", users);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }



//    @GetMapping("/getAllUser/{pid}")
//    public ResponseEntity<UserResourceList> getAllUserByProject(@PathVariable("pid") Long pid) throws UserNotFoundException {
//        UserResourceList ulr = new UserResourceList();
//        ulr.setUserList(service.getAllUserByProject(pid));
//        return new ResponseEntity<UserResourceList>(ulr, HttpStatus.OK);
//    }
@GetMapping("/getAllUser/{pid}")
public ResponseEntity<ApiResponse> getAllUserByProject(@PathVariable("pid") Long pid) throws UserNotFoundException {
    ApiResponse userList = service.getAllUserByProject(pid);
    System.out.println(userList.getObject()+ "this is me here");
    ApiResponse response = new ApiResponse(true,"Success", userList);
    return new ResponseEntity<>(response, HttpStatus.OK);
}
    @GetMapping("/getUser/{uid}")
    //@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<UserResource> getUserById(@PathVariable("uid") Long uid) {
        UserResource ur = new UserResource();
        BeanUtils.copyProperties(service.getUser(uid), ur);
        return new ResponseEntity<>(ur, HttpStatus.OK);
    }
    @GetMapping("/getUserByUserName")
    //@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<ApiResponse> getUserByUserName(@RequestParam(name = "username") String username) throws UserNotFoundException {
        ApiResponse ur = new ApiResponse();
        BeanUtils.copyProperties(service.getUsersByName(username), ur);
        return new ResponseEntity<>(ur, HttpStatus.OK);
    }
    @GetMapping("/getUserByEmail")
    //@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<ApiResponse> getUserByUserEmail(@RequestParam(name = "email") String email) throws UserNotFoundException {
        ApiResponse ur = new ApiResponse();
        BeanUtils.copyProperties(service.getUsersByEmail(email), ur);
        return new ResponseEntity<>(ur, HttpStatus.OK);
    }

    @GetMapping("/getUserByPhone")
    //@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<ApiResponse> getUserByUserPhone(@RequestParam(name = "phoneNumber") String phoneNumber) throws UserNotFoundException {
        ApiResponse ur = new ApiResponse();
        BeanUtils.copyProperties(service.getUsersByPhone(phoneNumber), ur);
        return new ResponseEntity<>(ur, HttpStatus.OK);
    }

    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<ApiResponse> updateUser(@PathVariable("userId") Long userId, @RequestBody UserResource userResource) throws UserNotFoundException {
        // Code to update the user using the provided userResource object
        ApiResponse updatedUser = service.updateUser(userResource, userId);

        ApiResponse response = new ApiResponse(true,"Success", updatedUser);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{uid}")
    //@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("uid") Long uid) throws UserNotFoundException {
        ApiResponse ur = new ApiResponse();
        BeanUtils.copyProperties(service.deleteUser(uid), ur);
        return new ResponseEntity<>(ur, HttpStatus.OK);
    }



}
