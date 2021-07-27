package com.productdetails.productDetails.entity;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Data
public class Details {
	
	@Id
	private String id;
	private String Name;
	
	@LastModifiedDate
	private Date date;

}
