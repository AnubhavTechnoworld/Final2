package com.training.ata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.ata.bean.ProfileBean;
import com.training.ata.dao.ProfileBeanDAO;
import com.training.ata.exception.ATAException;

@Service
@Transactional
public class ProfileServiceImpl implements ProfileService
{
	@Autowired
	ProfileBeanDAO dao;

	@Override
	public List<ProfileBean> getProfile() throws ATAException {
		return dao.getProfile();
	}

	@Override
	public List<ProfileBean> addProfile(ProfileBean profile) throws ATAException {
		return dao.addProfile(profile);
	}
	

}
