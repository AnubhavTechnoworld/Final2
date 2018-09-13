package com.training.ata.service;

import java.util.List;


import com.training.ata.bean.VehicleBean;
import com.training.ata.exception.ATAException;

public interface Vehicle 

{
	List<VehicleBean> getVehicle() throws ATAException;
	List<VehicleBean> addVehicle(VehicleBean emp) throws ATAException;
	List<VehicleBean> viewVehicle(VehicleBean emp) throws ATAException;
}
