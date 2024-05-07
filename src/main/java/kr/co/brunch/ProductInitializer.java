package kr.co.brunch;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jakarta.annotation.PostConstruct;
import kr.co.brunch.domain.Article;
import kr.co.brunch.domain.CommentUser;
import kr.co.brunch.domain.DayOfWeek;
import kr.co.brunch.domain.Magazine;
import kr.co.brunch.domain.SerialStatus;
import kr.co.brunch.domain.User;
import kr.co.brunch.repository.ArticleRepository;
import kr.co.brunch.repository.CommentUserRepository;
import kr.co.brunch.repository.MagazineRepository;
import kr.co.brunch.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductInitializer {

	private final InitService initService;

	@PostConstruct
	public void init() {
		initService.dbInit1();
	}

	@Component
	@Transactional
	@RequiredArgsConstructor
	static class InitService {

		private final UserRepository userRepository;
		private final MagazineRepository magazineRepository;
		private final ArticleRepository articleRepository;
		private final CommentUserRepository commentUserRepository;

		public void dbInit1() {
			User user = createUser("행복별바라기");
			User user2 = createUser("mia");
			User user3 = createUser("3333");

			userRepository.save(user);
			userRepository.save(user2);
			userRepository.save(user3);

			Magazine magazine = createMagazine(user, "타인에게 휘둘리지 않는 소통 기술", SerialStatus.ONGOING, DayOfWeek.MONDAY);
			Magazine magazine2 = createMagazine(user2, "유물 말고 사람", SerialStatus.ONGOING, DayOfWeek.MONDAY);
			Magazine magazine3 = createMagazine(user3, "3333", SerialStatus.ONGOING, DayOfWeek.MONDAY);
			magazineRepository.save(magazine);
			magazineRepository.save(magazine2);
			magazineRepository.save(magazine3);

			Article article = createArticle(user, magazine, "협상에서 먹히는 마스크 착용법", "자기주도 대화법 : 1. 협상의 기술",
				"이벤트기획사업 초기에 감정 컨트롤을 하지 못해서 크게 낭패를 본 경험이 있다. 유명 가수들을 초청하는 콘서트를 기획할 때였다. 디자인 작업에 대한 의견 차이가 있었다. 고객사 담당자는 원하는 디자인 콘셉트가 있었는데  우리 회사 디자이너는 전혀 다른 방향으로 정성껏 작업을 해서 보낸 것이다. 담당자는 어이없어했다. 본인이 원하는 콘셉트를 반복해서 이야기했고");
			Article article2 = createArticle(user2, magazine2, "어린이", "아이의 세상을 만들어주는 사람",
				"아이들.   어둡고 컴컴한 전시실. 조명을 받은 유물들이 내는 그림자들은 덩치 큰 괴물 같기도 하다. 아이들의 시선에서 전시실은 어떤 곳일까?   \\\"무서워\\\" 하며 집중한 엄마 손 끌고 나가려는 아이, 지루해서 몸이 베베 꼬이는 아이. 미디어아트에 홀라당 마음이 빼앗겨 움직이지 않는 아이. 작디작은 아이들은 부모님과 주말 나들이로 이곳 박물관에 왔다. 대개의");
			Article article3 = createArticle(user3, magazine3, "3333", "333333",
				"33333333요약");
			articleRepository.save(article);
			articleRepository.save(article2);
			articleRepository.save(article3);

			CommentUser commentUser = createCommentUser(article, "맨손의마술사", "verify", false);
			// CommentUser commentUser2 = createCommentUser(article, "응원 독자", "leave", true);
			commentUserRepository.save(commentUser);
			// commentUserRepository.save(commentUser2);

		}

		private static User createUser(String name) {
			User user = new User();
			String uuid = UUID.randomUUID().toString();
			String subUUID = uuid.substring(0, 4);
			user.setUserId(subUUID);
			user.setUserName(name);
			return user;
		}

		private static Magazine createMagazine(User user, String magazineTitle, SerialStatus serialStatus,
			DayOfWeek day) {
			Magazine magazine = new Magazine();
			magazine.setUser(user);
			magazine.setMagazineTitle(magazineTitle);
			magazine.setSerialStatus(serialStatus);
			magazine.setDayOf(day);
			return magazine;
		}

		private static Article createArticle(User user, Magazine magazine, String articleTitle, String articleSubTitle,
			String articleContentSummary) {
			Article article = new Article();
			article.setArticleTitle(articleTitle);
			article.setArticleSubTitle(articleSubTitle);
			article.setArticleContentSummary(articleContentSummary);
			article.setPublishTime(LocalDateTime.now().getNano());
			article.setDonationCommentCount(0);
			article.setDonationTotalAmount(0);
			article.setLikeCount(0);

			article.setUser(user);
			article.setMagazine(magazine);
			return article;
		}

		private static CommentUser createCommentUser(Article article, String commentUserName, String commentUserStatus,
			boolean anonymousDonation) {
			CommentUser commentUser = new CommentUser();
			commentUser.setCommentUserName(commentUserName);
			commentUser.setCommentUserStatus(commentUserStatus);
			commentUser.setAnonymousDonation(anonymousDonation);
			commentUser.setArticle(article);

			return commentUser;
		}
	}
}
