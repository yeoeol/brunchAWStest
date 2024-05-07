package kr.co.brunch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.brunch.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	@Override
	@EntityGraph(attributePaths = {"magazineSet", "articleSet"})
	Optional<User> findById(Long id);
}
