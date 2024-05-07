package kr.co.brunch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.brunch.domain.CommentUser;

public interface CommentUserRepository extends JpaRepository<CommentUser, Long> {
}
