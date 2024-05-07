package kr.co.brunch.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentUserDto {
	private Long no;
	private String userId;
	private Long articleNo;
	private Long commentUserId;
	private String commentUserName;
	private String commentUserStatus;
	private boolean anonymousDonation;
}
