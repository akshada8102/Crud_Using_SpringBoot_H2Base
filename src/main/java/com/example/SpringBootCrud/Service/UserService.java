package com.example.SpringBootCrud.Service;

import com.example.SpringBootCrud.Model.User;
import com.example.SpringBootCrud.Repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository _userRepository;

    public UserService(UserRepository userRepository){
        this._userRepository = userRepository;
    }

   public User AddUser(User user){
       Optional<User>  _user = _userRepository.findByUserName(user.getUserName());
        if(_user.isPresent()){
            System.out.println("User Already Exist");
            return user;
        }
        return _userRepository.save(user);
   }

   public List<User> AddAllUsers(List<User> users){
        return _userRepository.saveAll(users);
    }

    public List<User> GetAllUsers(){
        List<User> _user=new ArrayList<>();
        _userRepository.findAll().forEach(_user::add);
        return _user;
    }

    public ResponseEntity<User> GetUserById(BigInteger Id) throws  Exception{
        if(_userRepository.findById(Id).isPresent()){
            return ResponseEntity.ok(_userRepository.findById(Id).get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public String DeleteUser(BigInteger Id){
        _userRepository.deleteById(Id);
        return "RECORD DELETED SUCCESSFULLY";
    }

    public ResponseEntity<User> UpdateUser(BigInteger Id,User user){
        Optional<User> _user = _userRepository.findById(Id);
        if(_user.isPresent()) {
            User users=_user.get();
            users.setUserName(user.getUserName());
            users.setUserPassword(user.getUserPassword());
            _userRepository.save(users);
            return new ResponseEntity<>(users,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
