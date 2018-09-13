package com.training.ata.dao;

import java.util.List;

import com.training.ata.bean.DriverBean;
import com.training.ata.exception.ATAException;

public interface DriverBeanDAO 
{
	
	List<DriverBean> getDriver() throws ATAException;
	List<DriverBean> addDriver(DriverBean driver) throws ATAException;

}
