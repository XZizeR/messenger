package com.nick.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class Event {
	private int reporterId;
	private Date timestamp;
	private int metricId;
	private int metricValue;
	private String message;

	public Event(int reporterId, Date timestamp, int metricId, int metricValue, String message) {
		super();
		this.reporterId = reporterId;
		this.timestamp = timestamp;
		this.metricId = metricId;
		this.metricValue = metricValue;
		this.message = message;
	}

	public int getReporterId() {
		return reporterId;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public int getMetricId() {
		return metricId;
	}

	public int getMetricValue() {
		return metricValue;
	}

	public void setMetricValue(int metricValue) {
		this.metricValue = metricValue;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		final StringBuffer stringBuffer = new StringBuffer("Event{");
		stringBuffer.append("reporterId='").append(reporterId).append('\'');
		stringBuffer.append(", timestamp='").append(timestamp).append('\'');
		stringBuffer.append(", metricId='").append(metricId).append('\'');
		stringBuffer.append(", metricValue='").append(metricValue).append('\'');
		stringBuffer.append(", message='").append(message).append('\'');
		stringBuffer.append('}');
		return stringBuffer.toString();
	}
	
	

}
