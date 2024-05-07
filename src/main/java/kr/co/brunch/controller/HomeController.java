package kr.co.brunch.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.brunch.domain.DayOfWeek;
import kr.co.brunch.domain.Magazine;
import kr.co.brunch.dto.ResponseDto;
import kr.co.brunch.dto.SerialResponseDto;
import kr.co.brunch.dto.WeekContent;
import kr.co.brunch.dto.WeekListDto;
import kr.co.brunch.repository.MagazineRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HomeController {

	private final MagazineRepository magazineRepository;

	@GetMapping("/posts/week")
	public ResponseDto users() {
		List<Magazine> mondayList = magazineRepository.findByDayOf(DayOfWeek.MONDAY);
		List<Magazine> tuesdayList = magazineRepository.findByDayOf(DayOfWeek.TUESDAY);

		List<SerialResponseDto> mondaySerialUpdateMagazineResponseList = new ArrayList<>();
		for (Magazine magazine : mondayList) {
			mondaySerialUpdateMagazineResponseList.add(new SerialResponseDto(magazine));
		}

		List<SerialResponseDto> tuesdaySerialUpdateMagazineResponseList = new ArrayList<>();
		for (Magazine magazine : tuesdayList) {
			tuesdaySerialUpdateMagazineResponseList.add(new SerialResponseDto(magazine));
		}

		List<WeekContent> weekContentList = new ArrayList<>();

		WeekContent monday = new WeekContent(DayOfWeek.MONDAY.toString(), mondaySerialUpdateMagazineResponseList, null,
			null);
		WeekContent tuesday = new WeekContent(DayOfWeek.TUESDAY.toString(), tuesdaySerialUpdateMagazineResponseList,
			null, null);

		weekContentList.add(monday);
		weekContentList.add(tuesday);

		WeekListDto weekListDto = new WeekListDto(weekContentList);    // data

		return ResponseDto.response(weekListDto);
	}
}
