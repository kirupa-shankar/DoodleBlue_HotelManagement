package com.doodleblue.task.response;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterHotelUserResponse {

	private List<ResponseMessage> fieldErrorResponse;
}