package com.rock.ShoppingApplication.Model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "Products")
public class Product implements Serializable {

	private static final long serialVersionUID = -1000119078147252957L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private Long id;

	@Column(name = "Name", length = 255, nullable = false)
	@Length(min = 3, message = "*Name must have at least 5 characters")
	private String name;

	@Lob
	@Column(name = "Image", length = Integer.MAX_VALUE, nullable = true)
	private byte[] image;

    @Column(name = "quantity", nullable = false)
	@Min(value = 0, message = "*Quantity has to be non negative number")
	private Integer quantity;

	@Column(name = "actualprice", nullable = false)
	@DecimalMin(value = "0.00", message = "*Price has to be non negative number")
	private BigDecimal actualprice;
	
	@Column(name = "discountedprice", nullable = false)
	@DecimalMin(value = "0.00", message = "*Price has to be non negative number")
	private BigDecimal discountedprice;
	
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Create_Date", nullable = false)
	private Date createDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getActualprice() {
		return actualprice;
	}

	public void setActualprice(BigDecimal actualprice) {
		this.actualprice = actualprice;
	}

	public BigDecimal getDiscountedprice() {
		return discountedprice;
	}

	public void setDiscountedprice(BigDecimal discountedprice) {
		this.discountedprice = discountedprice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
