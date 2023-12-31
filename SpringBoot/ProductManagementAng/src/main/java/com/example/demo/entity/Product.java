package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product 
{
			@Id
			private String product_id;
			private String product_name;
			private String product_description;
			private String product_price;
			private String product_quantity;
			private String category;
			public String getProduct_id() {
				return product_id;
			}
			public void setProduct_id(String product_id) {
				this.product_id = product_id;
			}
			public String getProduct_name() {
				return product_name;
			}
			public void setProduct_name(String product_name) {
				this.product_name = product_name;
			}
			public String getProduct_description() {
				return product_description;
			}
			public void setProduct_description(String product_description) {
				this.product_description = product_description;
			}
			public String getProduct_price() {
				return product_price;
			}
			public void setProduct_price(String product_price) {
				this.product_price = product_price;
			}
			public String getProduct_quantity() {
				return product_quantity;
			}
			public void setProduct_quantity(String product_quantity) {
				this.product_quantity = product_quantity;
			}
			public String getCategory() {
				return category;
			}
			public void setCategory(String category) {
				this.category = category;
			}
			@Override
			public String toString() {
				return "Product [product_id=" + product_id + ", product_name=" + product_name + ", product_description="
						+ product_description + ", product_price=" + product_price + ", product_quantity="
						+ product_quantity + ", category=" + category + "]";
			}
			
			
}

