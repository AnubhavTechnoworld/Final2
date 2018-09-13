package com.training.ata.service;

import java.util.List;

import com.training.ata.bean.DriverBean;
import com.training.ata.exception.ATAException;

public interface DriverService 
{

	List<DriverBean> getDriver() throws ATAException;
	List<DriverBean> addDriver(DriverBean driver) throws ATAException;

}
