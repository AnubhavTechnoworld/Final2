package com.training.ata.service;

import java.util.List;

import com.training.ata.bean.ProfileBean;
import com.training.ata.exception.ATAException;

public interface ProfileService
{
	List<ProfileBean> getProfile() throws ATAException;
	List<ProfileBean> addProfile(ProfileBean profile) throws ATAException;

}
