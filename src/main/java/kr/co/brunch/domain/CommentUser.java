package kr.co.brunch.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CommentUser {

	@Id
	@GeneratedValue
	@Column(name = "commentUser_id")
	private Long commentUserId;

	@OneToOne(fetch = FetchType.LAZY)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "article_no")
	private Article article;

	private String commentUserName;
	private String commentUserStatus;
	private boolean anonymousDonation;
	private String donationInfo;

	public void setArticle(Article article) {
		this.article = article;
		article.getDonationCommentList().add(this);
	}
}
