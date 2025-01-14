package com.example.SpringBootCrud.Repository;

import com.example.SpringBootCrud.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, BigInteger> {

    List<User> id(BigInteger id);

}
