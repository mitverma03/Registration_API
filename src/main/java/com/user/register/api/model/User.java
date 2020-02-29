package com.user.register.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private long userId;
	
	@Column(name = "user_name")
	@NotNull(message = "User name should not be null.")
	private String userName;
	
	@Column(name = "email_id", unique = true)
	@NotNull(message = "email should not be null.")
	@Email(message = "invalid email format.")
	private String email;
	
	@Column(name = "mobile")
	@NotNull(message = "mobile number should not be null.")
	private String mobile;
	
	@Column(name = "pincode")
	@NotNull(message = "pincode should not be null.")
	private String pincode;
	
}
