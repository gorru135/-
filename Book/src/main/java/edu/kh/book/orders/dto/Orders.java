package edu.kh.book.orders.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Orders {

	private int memberNo;
	private String memberName;
	private int bookNo;
	private String bookTitle;
	private String address;
	private String orderDate;
	private int quantity;
	private String status;
	private int price;
}
