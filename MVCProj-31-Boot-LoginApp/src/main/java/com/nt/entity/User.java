package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name = "INSTAGRAM")
public class User {
	@Id
	private String username;
	private String password;
}
