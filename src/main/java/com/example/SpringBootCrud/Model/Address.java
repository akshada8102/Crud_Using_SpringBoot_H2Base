package com.example.SpringBootCrud.Model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Transactional
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "addressId")
    public Long addressId;
    public String city;
    public String addressType;

    // for bidirectional one to one mapping
    //@OneToOne(mappedBy = "address")
    //private Employee employee;

    @ManyToOne
    @JoinColumn(name = "fk_emp_id")
    public Employee employee;

}