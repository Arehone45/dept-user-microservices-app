package net.deptuserapp.userservice.controller;

import lombok.AllArgsConstructor;
import net.deptuserapp.userservice.dto.ResponseDto;
import net.deptuserapp.userservice.entity.User;
import net.deptuserapp.userservice.repository.UserRepository;
import net.deptuserapp.userservice.service.serviceimpl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-app")
@AllArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserServiceImpl userService;

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user){

        User savedUser = userService.saveUser(user);

        return new ResponseEntity<>(savedUser, HttpStatus.ACCEPTED);
    }

    @GetMapping("/getUserDetails/{id}")
    public ResponseEntity<ResponseDto> getUser(@PathVariable("id") Long userId) {

        ResponseDto responseDto = userService.getUserDetails(userId);

        return ResponseEntity.ok(responseDto);
    }
}
