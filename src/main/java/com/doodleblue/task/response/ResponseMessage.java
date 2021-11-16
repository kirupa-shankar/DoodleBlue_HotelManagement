package com.doodleblue.task.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseMessage {

	private String message;
}