package edu.kh.book.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Member {
	private int memberNo;
	private String memberName;
	private String memberId;
	private String memberPw;
	private char gender;
	private String memberAdress;
}
