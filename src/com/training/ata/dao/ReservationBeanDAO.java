package com.training.ata.dao;

import java.util.ArrayList;

import com.training.ata.bean.ReservationBean;



public interface ReservationBeanDAO {
	
	default ReservationBean findByID(ReservationBean rb)
		{
			return rb;
			
		}
		
		default String createVehicle(ReservationBean rb) {
			return null;
		}

		default int deleteVehicle(ArrayList<ReservationBean> rb )
		{
			return 0;
		}
		default boolean updateVehicle(ReservationBean rb)
		{
			return false;
		}
		

}
