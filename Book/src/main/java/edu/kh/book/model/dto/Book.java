package edu.kh.book.model.dto;

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
public class Book {
	
	private int bookNo;//도서 번호
	private String bookTitle;// 도서 제목 
	private String bookAuthor; // 도서 저자
	private int bookPrice; //책 가격
	private String publisher; //출판사 

}
