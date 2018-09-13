package com.training.ata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.ata.bean.DriverBean;
import com.training.ata.dao.DriverBeanDAO;
import com.training.ata.exception.ATAException;

@Service
@Transactional
public class DriverServiceImpl implements DriverService
{
	@Autowired
	DriverBeanDAO dao;

	@Override
	public List<DriverBean> getDriver() throws ATAException {
		return dao.getDriver();
	}

	@Override
	public List<DriverBean> addDriver(DriverBean driver) throws ATAException {
		return dao.addDriver(driver);
	}

}
