package com.example.SpringBootCrud.Controller;

import com.example.SpringBootCrud.Model.User;
import com.example.SpringBootCrud.Service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users/")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    UserService _userService;

    UserController(UserService userService){
        _userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> AddUser(@RequestBody User user) throws  Exception{
        User _user = _userService.AddUser(user);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(user);
        System.out.println("ADDED USER ::"+jsonString);
        return ResponseEntity.ok(_user);
    }

    @GetMapping
    public List<User> GetAllUsers(){
        List<User> _user = _userService.GetAllUsers();
        return _user;
    }

    @GetMapping("{Id}")
    public ResponseEntity<User> GetUserById(@PathVariable("Id") BigInteger Id) throws Exception{
        return _userService.GetUserById(Id);
    }

    @DeleteMapping("{Id}")
    public String DeleteUser(@PathVariable("Id") BigInteger Id){
       return _userService.DeleteUser(Id);
    }

    @PutMapping("{Id}")
    public ResponseEntity<User> UpdateUser(@PathVariable("Id") BigInteger Id,@RequestBody User user) throws  Exception{
        return _userService.UpdateUser(Id,user);
    }

    @GetMapping("TestApi")
    public String TestApi(){
        return "API WORKING";
    }

    //    @PostMapping
    //    public ResponseEntity<List<User>> AddAllUsers(@RequestBody List<User> users){
    //        List<User> _user = _userService.AddAllUsers(users);
    //        return ResponseEntity.ok(_user);
    //    }

}
