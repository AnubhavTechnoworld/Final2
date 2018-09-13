package com.training.ata.dao;

import java.util.List;


import com.training.ata.bean.VehicleBean;
import com.training.ata.exception.ATAException;

public interface VehicleBeanDAO
{
	
	List<VehicleBean> getVehicle() throws ATAException;
	List<VehicleBean> addVehicle(VehicleBean vehicle) throws ATAException;
}
	