package kr.co.brunch.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Magazine {

	@Id
	@GeneratedValue
	@Column(name = "magazine_no")
	private Long magazineNo;

	private String magazineTitle;

	@Enumerated(EnumType.STRING)
	private SerialStatus serialStatus;

	@Enumerated(EnumType.STRING)
	private DayOfWeek dayOf;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_no")
	private User user;

	@OneToMany(mappedBy = "magazine")
	private Set<Article> articleSet = new HashSet<>();

	//==연관관계 메서드==//
	public void setUser(User user) {
		this.user = user;
		user.getMagazineSet().add(this);
	}
}
