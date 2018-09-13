package com.training.ata.dao;

import java.util.List;

import com.training.ata.bean.ProfileBean;
import com.training.ata.exception.ATAException;



public interface ProfileBeanDAO {
	
	List<ProfileBean> getProfile() throws ATAException;
	List<ProfileBean> addProfile(ProfileBean profile) throws ATAException;
}
