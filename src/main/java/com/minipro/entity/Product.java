package com.minipro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="prodId")
	private Integer prodId;
	
	@Column(name="prodName")
	private String prodName;
	
	@Column(name="prodDesc")
	private String prodDesc;
	
	@Column(name="quantity")
	private Double quantity;
	
	@Column(name="price")
	private Double price;
}

