package com.iktobuka.project_web_app.entities;

import java.time.LocalDate;

public class OfferEntity {

	public enum OfferStatus {
		WAIT_FOR_APPROVING, APPROVED, DECLINED, EXPIRED
	}

	private int id;
	private String offerName;
	private String offerDescription;
	private LocalDate offerCreated;
	private LocalDate offerExpires;
	private double regularPrice;
	private double actionPrice;
	private String imagePath;
	private int availableOffers;
	private int boughtOffers;
	private OfferStatus offerStatus;

	public OfferEntity() {
	}

	public OfferEntity(
			int id, 
			String offerName, 
			String offerDescription,
			LocalDate offerCreated,
			LocalDate offerExpires, 
			double regularPrice, 
			double actionPrice, 
			String imagePath, 
			int availableOffers,
			int boughtOffers, 
			OfferStatus offerStatus
			) {
		this.setId(id);
		this.setOfferName(offerName);
		this.setOfferDescription(offerDescription);
		this.setOfferCreated(offerCreated);
		this.setOfferExpires(offerExpires);
		this.setRegularPrice(regularPrice);
		this.setActionPrice(actionPrice);
		this.setImagePath(imagePath);
		this.setAvailableOffers(availableOffers);
		this.setBoughtOffers(boughtOffers);
		this.setOfferStatus(offerStatus);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public String getOfferDescription() {
		return offerDescription;
	}

	public void setOfferDescription(String offerDescription) {
		this.offerDescription = offerDescription;
	}

	public LocalDate getOfferCreated() {
		return offerCreated;
	}

	public void setOfferCreated(LocalDate offerCreated) {
		this.offerCreated = offerCreated;
	}

	public LocalDate getOfferExpires() {
		return offerExpires;
	}

	public void setOfferExpires(LocalDate offerExpires) {
		this.offerExpires = offerExpires;
	}

	public double getRegularPrice() {
		return regularPrice;
	}

	public void setRegularPrice(double regularPrice) {
		this.regularPrice = regularPrice;
	}

	public double getActionPrice() {
		return actionPrice;
	}

	public void setActionPrice(double actionPrice) {
		this.actionPrice = actionPrice;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getAvailableOffers() {
		return availableOffers;
	}

	public void setAvailableOffers(int availableOffers) {
		this.availableOffers = availableOffers;
	}

	public int getBoughtOffers() {
		return boughtOffers;
	}

	public void setBoughtOffers(int boughtOffers) {
		this.boughtOffers = boughtOffers;
	}

	public OfferStatus getOfferStatus() {
		return offerStatus;
	}

	public void setOfferStatus(OfferStatus offerStatus) {
		this.offerStatus = offerStatus;
	}
}
