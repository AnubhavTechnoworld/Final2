package com.training.ata.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ATA_TBL_user_CREDENTIALS")
public class CredentialsBean 
{
	@Id
	
		private String userID;
		private String password;
		private String usertype;
		private int loginStatus;
		
		
		public String getUserID() {
			return userID;
		}
		public void setUserID(String userID) {
			this.userID = userID;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getUsertype() {
			return usertype;
		}
		public void setUsertype(String usertype) {
			this.usertype = usertype;
		}
		public int getLoginStatus() {
			return loginStatus;
		}
		public void setLoginStatus(int loginStatus) {
			this.loginStatus = loginStatus;
		}
		@Override
		public String toString() {
			return "CredentialsBean [userID=" + userID + ", password=" + password + ", usertype=" + usertype
					+ ", loginStatus=" + loginStatus + "]";
		}
		
		

}