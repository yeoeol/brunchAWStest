package kr.co.brunch.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WeekListDto {
	private List<WeekContent> list;
}
