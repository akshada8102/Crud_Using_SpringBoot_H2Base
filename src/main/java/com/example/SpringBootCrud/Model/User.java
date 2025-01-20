package com.example.SpringBootCrud.Model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="UserLogin")
@ToString
public class User {

    @Id
    @GeneratedValue
   // @Column(Name = "User_Id")
    public BigInteger userId;

    @NonNull
    public String userName;

    @NonNull
    public String userPassword;

    public void setUserName(String userName){
        this.userName=userName;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserPassword(String userPassword){
        this.userPassword=userPassword;
    }

    public String getUserPassword(){
        return userPassword;
    }

}
