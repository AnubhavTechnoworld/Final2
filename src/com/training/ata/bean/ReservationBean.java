package com.training.ata.bean;

public class ReservationBean {
	public String reservationId;
	private String userID;
	private String routeId;
	private String bookingDate;
	private String journeyDate;
	private String vehicleID;
	private String driverID;
	private String bookingStatus;
	private double totalFare;
	private String dropingPoint;
	private String dropPoint;
	public String getReservationId() {
		return reservationId;
	}
	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getRouteId() {
		return routeId;
	}
	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}
	public String getVehicleID() {
		return vehicleID;
	}
	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}
	public String getDriverID() {
		return driverID;
	}
	public void setDriverID(String driverID) {
		this.driverID = driverID;
	}
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public double getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}
	public String getDropingPoint() {
		return dropingPoint;
	}
	public void setDropingPoint(String dropingPoint) {
		this.dropingPoint = dropingPoint;
	}
	public String getDropPoint() {
		return dropPoint;
	}
	public void setDropPoint(String dropPoint) {
		this.dropPoint = dropPoint;
	}
	

}