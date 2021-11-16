package com.doodleblue.task.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Index;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@Table(name = "hotel_room_booking_history", indexes = { @Index(columnList = "booked_on", unique = false) })
public class HotelRoomBookingHistory {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "Age")
	private String age;

	@Column(name = "address")
	private String address;

	@Column(name = "aadhar_no")
	private String aadharNo;

	@Column(name = "room_no")
	private String roomNo;

	@Column(name = "amount")
	private Double amount;

	@Column(name = "booked_on")
	private Date bookedOn;
}