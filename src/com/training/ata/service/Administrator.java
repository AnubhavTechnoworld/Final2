package com.training.ata.service;

import java.util.ArrayList;
import java.util.Date;

import com.training.ata.bean.DriverBean;
import com.training.ata.bean.ReservationBean;
import com.training.ata.bean.RouteBean;
import com.training.ata.bean.VehicleBean;

public interface Administrator {
	
	default String addVehicle(VehicleBean vehicleBean) {
		return null;
		
	}
	
	default int deleteVehicle(ArrayList<String> vehicleID) {
		return (Integer) null;
	}
	
	
	default VehicleBean viewVehicle(String vehicleID) {
		return null;
		
	}
	
	default boolean modifyVehicle(VehicleBean vehicleBean) {
		return (Boolean) null;
		
	}
	
	default String addDriver(DriverBean driverBean) {
		return null;
		
	}
	
	default int deleteDriver(ArrayList<String> driverID) {
		return (Integer) null;
		
	}
	
	default boolean allotDriver(String reservationID, String driverID) {
		return (Boolean) null;
		
	}
	
	default boolean modifyDriver(DriverBean driverBean) {
		return (Boolean) null;
		
	}
	
	default String addRoute(RouteBean routeBean) {
		return null;
		
	}
	
	default int deleteRoute(ArrayList<String> routeID) {
		return (Integer) null;
		
	}
	
	default RouteBean viewRoute(String routeID) {
		return null;
		
	}
	
	default boolean modifyRoute(RouteBean routeBean) {
		return (Boolean) null;
		
	}
	
	default ArrayList<ReservationBean> viewBookingDetails(Date
	journeyDate,String source, String destination){
		
		return null;
		
	}

	
	}


