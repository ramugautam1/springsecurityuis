package com.vastika.uis.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "tbl_user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name = "user_name")
    @NotEmpty
    @Size(min=3, max=6, message="username must be between 3 and 6 characters!")
    private String userName;
    
    @Pattern(regexp="^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$")
    private String password;
    private String email;

    @Column(name = "mobile_no")
    @Max(value=9999, message="mobile no should not be more than 4 digits.")
    private long mobileNo;

    private String gender;
    private String hobbies;
    
    @NotNull
    private String nationality;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    
    @NotEmpty(message="not null")
    private String comments;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Past(message="DOB must be in the past.")
    private Date dob;
    
    @OneToOne(cascade = CascadeType.MERGE)
    private Role role;

}
