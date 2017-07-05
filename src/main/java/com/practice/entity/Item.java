package com.practice.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the item database table.
 * 
 */
@Entity
@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ITEM_ID")
	private int itemId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ACTUAL_DELV_DT")
	private Date actualDelvDt;


	@Column(name="AVAIL_CHANGED_BY")
	private String availChangedBy;

	private int availability;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CONTRACT_DELV_DT")
	private Date contractDelvDt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="INSERT_DATE")
	private Date insertDate;

	@Column(name="ITEM_ADDED_BY")
	private String itemAddedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_UPDATED")
	private Date lastUpdated;

	@Column(name="ORDERED_FROM")
	private String orderedFrom;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ORDERED_ON")
	private Date orderedOn;

	@Column(name="UNIQUE_ID")
	private String uniqueId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="USED_ON")
	private Date usedOn;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="PRO_ID")
	private Product product;

	public Item() {
	}

	public int getItemId() {
		return this.itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public Date getActualDelvDt() {
		return this.actualDelvDt;
	}

	public void setActualDelvDt(Date actualDelvDt) {
		this.actualDelvDt = actualDelvDt;
	}

	public String getAvailChangedBy() {
		return this.availChangedBy;
	}

	public void setAvailChangedBy(String availChangedBy) {
		this.availChangedBy = availChangedBy;
	}

	public int getAvailability() {
		return this.availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	public Date getContractDelvDt() {
		return this.contractDelvDt;
	}

	public void setContractDelvDt(Date contractDelvDt) {
		this.contractDelvDt = contractDelvDt;
	}

	public Date getInsertDate() {
		return this.insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public String getItemAddedBy() {
		return this.itemAddedBy;
	}

	public void setItemAddedBy(String itemAddedBy) {
		this.itemAddedBy = itemAddedBy;
	}

	public Date getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getOrderedFrom() {
		return this.orderedFrom;
	}

	public void setOrderedFrom(String orderedFrom) {
		this.orderedFrom = orderedFrom;
	}

	public Date getOrderedOn() {
		return this.orderedOn;
	}

	public void setOrderedOn(Date orderedOn) {
		this.orderedOn = orderedOn;
	}

	public String getUniqueId() {
		return this.uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public Date getUsedOn() {
		return this.usedOn;
	}

	public void setUsedOn(Date usedOn) {
		this.usedOn = usedOn;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}