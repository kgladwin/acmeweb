package com.acmeweb.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Product {
	
	String customerId;
	String productName;
	String domain;
	String duration;
	String durationType;
	String startDate;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getDurationType() {
		return durationType;
	}
	public void setDurationType(String durationType) {
		this.durationType = durationType;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	private Date startDateAsDate;

    public Date getStartDateAsDate() {
        if (startDateAsDate != null) {
            return startDateAsDate;
        }
        try {
        	SimpleDateFormat SDF = new SimpleDateFormat("MM/dd/yyyy");
            startDateAsDate = (Date) SDF.parseObject(startDate);
            return startDateAsDate;
        } catch (Exception e) {
            return null;
        }
    }
	
}
