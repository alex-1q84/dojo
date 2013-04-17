package com.best.demo.pm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the prod_ord database table.
 * 
 */
@Entity
@Table(name="prod_ord")
public class ProdOrd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ord_id")
	private int ordId;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="auth_date")
	private Date authDate;

	@Column(name="auth_id")
	private int authId;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	private int money;

	@Column(name="oper_id")
	private int operId;

	@Column(name="oper_name")
	private String operName;

	private String remark;

	@Column(name="rep_id")
	private int repId;

	@Column(name="sheet_code")
	private String sheetCode;

	private byte state;

	@Column(name="station_id")
	private int stationId;

	//bi-directional many-to-one association to ProdOrdRel
	@OneToMany(mappedBy="prodOrd")
	private Set<ProdOrdRel> prodOrdRels;

    public ProdOrd() {
    }

	public int getOrdId() {
		return this.ordId;
	}

	public void setOrdId(int ordId) {
		this.ordId = ordId;
	}

	public Date getAuthDate() {
		return this.authDate;
	}

	public void setAuthDate(Date authDate) {
		this.authDate = authDate;
	}

	public int getAuthId() {
		return this.authId;
	}

	public void setAuthId(int authId) {
		this.authId = authId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getMoney() {
		return this.money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getOperId() {
		return this.operId;
	}

	public void setOperId(int operId) {
		this.operId = operId;
	}

	public String getOperName() {
		return this.operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getRepId() {
		return this.repId;
	}

	public void setRepId(int repId) {
		this.repId = repId;
	}

	public String getSheetCode() {
		return this.sheetCode;
	}

	public void setSheetCode(String sheetCode) {
		this.sheetCode = sheetCode;
	}

	public byte getState() {
		return this.state;
	}

	public void setState(byte state) {
		this.state = state;
	}

	public int getStationId() {
		return this.stationId;
	}

	public void setStationId(int stationId) {
		this.stationId = stationId;
	}

	public Set<ProdOrdRel> getProdOrdRels() {
		return this.prodOrdRels;
	}

	public void setProdOrdRels(Set<ProdOrdRel> prodOrdRels) {
		this.prodOrdRels = prodOrdRels;
	}
	
}