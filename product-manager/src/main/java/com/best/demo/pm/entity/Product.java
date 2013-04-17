package com.best.demo.pm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="prod_id")
	private int prodId;

	@Column(name="base_type_id")
	private int baseTypeId;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="minimum_amount")
	private int minimumAmount;

	@Column(name="oper_id")
	private int operId;

	@Column(name="prod_code")
	private String prodCode;

	@Column(name="prod_name")
	private String prodName;

	private String remark;

	@Column(name="spec_id")
	private int specId;

	private byte state;

	@Column(name="unit_type_id")
	private int unitTypeId;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	//bi-directional one-to-one association to ProdOrdRel
	@OneToOne(mappedBy="product")
	private ProdOrdRel prodOrdRel;

    public Product() {
    	this(null, null);
    }

	public Product(String prodCode, String prodName) {
		this.prodCode = prodCode;
		this.prodName = prodName;
	}

	public Product(int prodId) {
		this.prodId = prodId;
	}

	public int getProdId() {
		return this.prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public int getBaseTypeId() {
		return this.baseTypeId;
	}

	public void setBaseTypeId(int baseTypeId) {
		this.baseTypeId = baseTypeId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getMinimumAmount() {
		return this.minimumAmount;
	}

	public void setMinimumAmount(int minimumAmount) {
		this.minimumAmount = minimumAmount;
	}

	public int getOperId() {
		return this.operId;
	}

	public void setOperId(int operId) {
		this.operId = operId;
	}

	public String getProdCode() {
		return this.prodCode;
	}

	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	public String getProdName() {
		return this.prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getSpecId() {
		return this.specId;
	}

	public void setSpecId(int specId) {
		this.specId = specId;
	}

	public byte getState() {
		return this.state;
	}

	public void setState(byte state) {
		this.state = state;
	}

	public int getUnitTypeId() {
		return this.unitTypeId;
	}

	public void setUnitTypeId(int unitTypeId) {
		this.unitTypeId = unitTypeId;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public ProdOrdRel getProdOrdRel() {
		return this.prodOrdRel;
	}

	public void setProdOrdRel(ProdOrdRel prodOrdRel) {
		this.prodOrdRel = prodOrdRel;
	}
	
}