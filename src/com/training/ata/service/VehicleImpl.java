package com.training.ata.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.ata.bean.VehicleBean;
import com.training.ata.dao.VehicleBeanDAO;
import com.training.ata.exception.ATAException;

@Service
@Transactional
public class VehicleImpl implements Vehicle
{

	@Autowired
	VehicleBeanDAO dao;
	
	@Override
	public List<VehicleBean> getVehicle() throws ATAException {
		return dao.getVehicle();
	}
	@Override
	public List<VehicleBean> addVehicle(VehicleBean vehicle) throws ATAException {
		return dao.addVehicle(vehicle);
	}
	@Override
	public List<VehicleBean> viewVehicle(VehicleBean emp) throws ATAException {
		// TODO Auto-generated method stub
		return dao.getVehicle();
	}
	

}
