package com.example.SpringBootCrud.Controller;

import com.example.SpringBootCrud.Model.User;
import com.example.SpringBootCrud.Repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class UserController {

    UserRepository _userRepository;

    UserController(UserRepository userRepository){
        _userRepository=userRepository;
    }

    @PostMapping("addSingleUser")
    public ResponseEntity<User> addUser(@RequestBody User user) throws  Exception{
        ObjectMapper Obj = new ObjectMapper();
        User _user=_userRepository.save(user);
        String jsonStr = Obj.writeValueAsString(user);
        System.out.println("USER ::"+jsonStr);
        return ResponseEntity.ok(_user);
    }

    @PostMapping("addAllUser")
    public ResponseEntity<List<User>> addAllUser(@RequestBody List<User> users) throws  Exception{
        List<User> _user=_userRepository.saveAll(users);
        return ResponseEntity.ok(_user);
    }
    @PostMapping("updateUser")
    public ResponseEntity<User> updateUser(@RequestParam BigInteger id,@RequestBody User users) throws  Exception{
        Optional<User> _user=_userRepository.findById(id);
        if(_user.isPresent()) {
            User user=_user.get();
            user.setName(users.getName());
            user.setName(users.getPassword());
            return new ResponseEntity<>(user,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("getAllUsers")
    public List<User> getAllUsers(){
        List<User> _user=new ArrayList<>();
        _userRepository.findAll().forEach(_user::add);
        return _user;
    }

    @GetMapping("getUserById")
    public ResponseEntity<User> getUserById(@RequestParam BigInteger Id){
        Optional<User> _user=_userRepository.findById(Id);
        if(_user.isPresent()){
            return new ResponseEntity<>(_user.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("deleteMapping")
    public String deleteMapping(BigInteger id){
        _userRepository.deleteById(id);
        return "RECORD DELETED SUCCESSFULLY";
    }
    @GetMapping("test")
    public String test(){
        return "WORKING";
    }
}
