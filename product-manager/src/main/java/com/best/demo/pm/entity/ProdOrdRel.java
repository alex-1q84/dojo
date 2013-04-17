package com.best.demo.pm.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the prod_ord_rel database table.
 * 
 */
@Entity
@Table(name="prod_ord_rel")
public class ProdOrdRel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rel_id")
	private int relId;

	@Column(name="minimum_amount")
	private int minimumAmount;

	@Column(name="amount")
	private int amount;
	
	private int money;

	@Column(name="prod_price")
	private int prodPrice;

	private String remark;

	@Column(name="sheet_code")
	private String sheetCode;

	@Column(name="unit_type_id")
	private int unitTypeId;

	//bi-directional one-to-one association to Product
	@OneToOne
	@JoinColumn(name="prod_id")
	private Product product;

	//bi-directional many-to-one association to ProdOrd
    @ManyToOne
	@JoinColumn(name="ord_id")
	private ProdOrd prodOrd;

    public ProdOrdRel() {
    }

	public int getRelId() {
		return this.relId;
	}

	public void setRelId(int relId) {
		this.relId = relId;
	}

	public int getMinimumAmount() {
		return this.minimumAmount;
	}

	public void setMinimumAmount(int minimumAmount) {
		this.minimumAmount = minimumAmount;
	}

	public int getMoney() {
		return this.money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getProdPrice() {
		return this.prodPrice;
	}

	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSheetCode() {
		return this.sheetCode;
	}

	public void setSheetCode(String sheetCode) {
		this.sheetCode = sheetCode;
	}

	public int getUnitTypeId() {
		return this.unitTypeId;
	}

	public void setUnitTypeId(int unitTypeId) {
		this.unitTypeId = unitTypeId;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public ProdOrd getProdOrd() {
		return this.prodOrd;
	}

	public void setProdOrd(ProdOrd prodOrd) {
		this.prodOrd = prodOrd;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}