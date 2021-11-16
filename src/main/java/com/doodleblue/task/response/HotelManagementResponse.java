package com.doodleblue.task.response;

import java.util.Date;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HotelManagementResponse {

	private UUID invoiceNo;

	private String name;

	private String email;

	private String age;

	private String address;

	private String aadharNo;

	private String roomNo;

	private Double amount;

	private Date bookingDate;

	private String message;
}