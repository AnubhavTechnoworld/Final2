package com.training.ata.util;

import com.training.ata.bean.CredentialsBean;

public interface Authentication {
	
	default boolean authenticate(CredentialsBean credentialsBean) {
		return (Boolean) null;
	}
	
	default String authorize(String userID) {
		return null;
	}
	
	default boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus) {
		return (Boolean) null;
	}


}
