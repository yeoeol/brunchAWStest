package kr.co.brunch.domain;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "user_no")
	private Long userNo;

	private String userId;
	private String userName;

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private Set<Magazine> magazineSet = new HashSet<>();

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private Set<Article> articleSet = new HashSet<>();
}
