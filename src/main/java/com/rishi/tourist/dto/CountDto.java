package com.rishi.tourist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountDto {

	private Long activeCount;
	
	private Long inactiveCount;
}
