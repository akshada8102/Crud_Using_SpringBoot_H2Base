package com.example.SpringBootCrud.Model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.net.PasswordAuthentication;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TABLE_USER")
@ToString
public class User {

    @Id
    @GeneratedValue
    public BigInteger id;

    @NonNull
    public String Name;

    @NonNull
    public String Password;

    public void setName(String Name){
        this.Name=Name;
    }

    public void setPassword(String Password){
        this.Password=Password;
    }

    public String getName(){
        return Name;
    }
    public String getPassword(){
        return Password;
    }
}
