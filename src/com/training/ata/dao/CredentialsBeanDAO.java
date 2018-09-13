package com.training.ata.dao;

import java.util.ArrayList;

import com.training.ata.bean.CredentialsBean;
import com.training.ata.bean.DriverBean;
import com.training.ata.bean.RouteBean;

public interface CredentialsBeanDAO {
	
	default CredentialsBean findByID(CredentialsBean cb)
		{
			return cb;
			
		}
		
		default String createVehicle(CredentialsBean cb) {
			return null;
		}

		default int deleteVehicle(ArrayList<CredentialsBean> cb )
		{
			return 0;
		}
		default boolean updateVehicle(CredentialsBean vb)
		{
			return false;
		}
		default ArrayList<CredentialsBean> findAll()
		{
			return null;
			
		}

				

}
