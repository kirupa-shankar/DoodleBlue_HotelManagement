package com.doodleblue.task.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@Table(name = "user_check_in")
public class UserCheckIn {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "user")
	private String user;

	@Column(name = "is_checked_in")
	private Boolean isCheckedIn;

	@Column(name = "created_at")
	private Date createdAt;
}