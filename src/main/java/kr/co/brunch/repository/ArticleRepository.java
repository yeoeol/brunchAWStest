package kr.co.brunch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.brunch.domain.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
