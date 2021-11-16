package com.doodleblue.task.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomBookingRequest {

	@NotBlank(message = "Enter your Name")
	private String name;

	@Email(message = "Enter your valid Email")
	@NotBlank(message = "Enter your valid email")
	private String email;

	@NotBlank(message = "Enter your Age")
	private String age;

	@NotBlank(message = "Enter your Address")
	private String address;

	@NotBlank(message = "Enter your AadharNo")
	private String aadharNo;

	@NotBlank(message = "Enter your RoomNo")
	private String roomNo;

	@NotNull(message = "Enter your Amount")
	private Double amount;
}