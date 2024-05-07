package kr.co.brunch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.brunch.domain.DayOfWeek;
import kr.co.brunch.domain.Magazine;

public interface MagazineRepository extends JpaRepository<Magazine, Long> {
	@EntityGraph(attributePaths = {"user", "articleSet"})
	List<Magazine> findByDayOf(DayOfWeek dayOf);
}
