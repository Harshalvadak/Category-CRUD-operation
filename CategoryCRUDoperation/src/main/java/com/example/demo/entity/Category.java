
package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;

@Entity
@Table(name ="Category")

public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "Category_name")
	private String name;
	@Column(name ="Category_price")
	private int price;
	
	public Category()
	{
		
	}
	
	
	public Category(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", price=" + price + "]";
	}


	public Object getCategory_price() {
		// TODO Auto-generated method stub
		return null;
	}


	public Object getCategory_name() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setCategory_name(Object category_name) {
		// TODO Auto-generated method stub
		
	}
	
	
}
