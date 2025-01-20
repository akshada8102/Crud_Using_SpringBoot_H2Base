package com.example.SpringBootCrud.Controller;

import com.example.SpringBootCrud.Model.User;
import com.example.SpringBootCrud.Service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users/")
public class UserController {

    UserService _userService;

    UserController(UserService userService){
        _userService = userService;
    }

    @PostMapping("AddUser")
    public ResponseEntity<User> AddUser(@RequestBody User user) throws  Exception{
        User _user = _userService.AddUser(user);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(user);
        System.out.println("ADDED USER ::"+jsonString);
        return ResponseEntity.ok(_user);
    }

    @PostMapping("AddAllUsers")
    public ResponseEntity<List<User>> AddAllUsers(@RequestBody List<User> users){
        List<User> _user = _userService.AddAllUsers(users);
        return ResponseEntity.ok(_user);
    }

    @GetMapping("GetAllUsers")
    public List<User> GetAllUsers(){
        List<User> _user = _userService.GetAllUsers();
        return _user;
    }

    @GetMapping("GetUserById")
    public ResponseEntity<User> GetUserById(@RequestParam BigInteger Id) throws Exception{
        return _userService.GetUserById(Id);
    }

    @DeleteMapping("DeleteUser")
    public String DeleteUser(BigInteger Id){
       return _userService.DeleteUser(Id);
    }

    @GetMapping("TestApi")
    public String TestApi(){
        return "API WORKING";
    }

    @PutMapping("UpdateUser")
    public ResponseEntity<User> UpdateUser(@RequestParam BigInteger Id,@RequestBody User user) throws  Exception{
        return _userService.UpdateUser(Id,user);
    }

}
