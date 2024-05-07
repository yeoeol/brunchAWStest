package kr.co.brunch.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Article {

	@Id
	@GeneratedValue
	@Column(name = "article_no")
	private Long articleNo;

	private String articleTitle;
	private String articleSubTitle;
	private String articleContentSummary;

	private int publishTime;
	private int donationCommentCount;
	private int donationTotalAmount;
	private int likeCount;

	@OneToMany(mappedBy = "article")
	private Set<CommentUser> donationCommentList = new HashSet<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_no")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "magazine_no")
	private Magazine magazine;

}
