package com.doodleblue.task.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterHotelUserRequest {

	@Email(message = "Enter your valid email")
	@NotBlank(message = "Enter your valid email")
	private String email;

	@NotBlank(message = "Password should contain alteast 8 characters")
	@Size(min = 8, message = "Password should contain alteast 8 characters")
	private String password;

	@NotBlank(message = "Enter your Role")
	private String role;
}