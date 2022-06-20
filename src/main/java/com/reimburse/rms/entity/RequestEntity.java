package com.reimburse.rms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.reimburse.rms.pojo.RequestPojo;

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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((requestStatus == null) ? 0 : requestStatus.hashCode());
		result = prime * result + requestId;
		result = prime * result + ((requestTime == null) ? 0 : requestTime.hashCode());
		result = prime * result + ((resolvedTime == null) ? 0 : resolvedTime.hashCode());
		result = prime * result + ((requestDescription == null) ? 0 : requestDescription.hashCode());
		result = prime * result + ((requestImageURL == null) ? 0 : requestImageURL.hashCode());
		result = prime * result + requestUserId;
		result = prime * result + (int)requestAmount;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestEntity other = (RequestEntity) obj;
		if (requestStatus == null) {
			if (other.requestStatus != null)
				return false;
		} else if (!requestStatus.equals(other.requestStatus))
			return false;
		if (requestAmount != other.requestAmount)
			return false;
		if (resolvedTime == null) {
			if (other.resolvedTime != null)
				return false;
		} else if (!resolvedTime.equals(other.resolvedTime))
			return false;
		if (requestTime == null) {
			if (other.requestTime != null)
				return false;
		} else if (!requestTime.equals(other.requestTime))
			return false;
		if (requestDescription == null) {
			if (other.requestDescription != null)
				return false;
		} else if (!requestDescription.equals(other.requestDescription))
			return false;
		if (requestImageURL == null) {
			if (other.requestImageURL != null)
				return false;
		} else if (!requestImageURL.equals(other.requestImageURL))
			return false;
		if (requestId != other.requestId)
			return false;
		if (requestUserId != other.requestUserId)
			return false;
		return true;
	}

	
}


