package com.vastika.uis.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity // Class name ko table banauxa
@Table(name = "tbl_role") // table ma given name use garxa
@Data // replacement for getter and setter
public class Role {
	
	@Id // primary key generate garxa
	@GeneratedValue(strategy = GenerationType.AUTO) // auto generate ko lagi
	private int id;
	private String roleName;

}