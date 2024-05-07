package kr.co.brunch.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WeekContent {
	private String dayOfWeek;
	private List<SerialResponseDto> serialUpdateMagazineResponseList;
	private List<SerialResponseDto> serialDonationMagazineResponseList;
	private List<SerialResponseDto> serialLikeMagazineResponseList;
}
