package com.nick.kafka.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Event {
	private int reporterId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
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

	public void setReporterId(int reporterId) {
		this.reporterId = reporterId;
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

	public void setMetricId(int metricId) {
		this.metricId = metricId;
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

}
