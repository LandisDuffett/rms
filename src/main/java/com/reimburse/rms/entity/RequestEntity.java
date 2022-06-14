package com.reimburse.rms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="requests")
public class RequestEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="request_id")
	private int requestId;
	
	@Column(name="request_userid")
	private int requestUserId;
	
	@Column(name="request_amount", columnDefinition = "NUMERIC(19,0)")
	private double requestAmount;
	
	@Column(name="request_description")
	private String requestDescription;
	
	@Column(name="request_status")
	private String requestStatus;
	
	@Column(name="request_imageURL")
	private String requestImageURL;
	
	@Column(name="request_requesttime")
	private String requestTime;
	
	@Column(name="request_resolvedtime")
	private String resolvedTime;

	public RequestEntity() {
		
	}

	public RequestEntity(int requestId, int requestUserId, double requestAmount, String requestDescription,
			String requestStatus, String requestImagURL, String requestTime, String resolvedTime) {
		super();
		this.requestId = requestId;
		this.requestUserId = requestUserId;
		this.requestAmount = requestAmount;
		this.requestDescription = requestDescription;
		this.requestStatus = requestStatus;
		this.requestImageURL = requestImagURL;
		this.requestTime = requestTime;
		this.resolvedTime = resolvedTime;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getRequestUserId() {
		return requestUserId;
	}

	public void setRequestUserId(int requestUserId) {
		this.requestUserId = requestUserId;
	}

	public double getRequestAmount() {
		return requestAmount;
	}

	public void setRequestAmount(double requestAmount) {
		this.requestAmount = requestAmount;
	}

	public String getRequestDescription() {
		return requestDescription;
	}

	public void setRequestDescription(String requestDescription) {
		this.requestDescription = requestDescription;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public String getRequestImagURL() {
		return requestImageURL;
	}

	public void setRequestImagURL(String requestImagURL) {
		this.requestImageURL = requestImagURL;
	}

	public String getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}

	public String getResolvedTime() {
		return resolvedTime;
	}

	public void setResolvedTime(String resolvedTime) {
		this.resolvedTime = resolvedTime;
	}
	
	
}


