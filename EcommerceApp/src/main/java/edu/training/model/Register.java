package edu.training.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Register 
{
		private String name;
	    private Date dateOfBirth;
	    private String phoneNumber;
	    private String address;
	    private String email;
	    private String password;
	    private String approvalStatus;

	    public Register(String name,Date dateOfBirth, String phoneNumber, String address, String email, String password, String approvalStatus) throws ParseException
	    {
	        this.name = name;
	        this.dateOfBirth = dateOfBirth;
	        this.phoneNumber = phoneNumber;
	        this.address = address;
	        this.email = email;
	        this.password = password;
	        this.approvalStatus = approvalStatus;
	    
	    }

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Date getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		
		public String getApprovalStatus() {
			return approvalStatus;
		}

		public void setApprovalStatus(String approvalStatus) {
			this.approvalStatus = approvalStatus;
		}

		@Override
		public String toString() {
			return "Register [name=" + name + ", dateOfBirth=" + dateOfBirth + ", phoneNumber=" + phoneNumber
					+ ", address=" + address + ", email=" + email + ", password=" + password + ", approvalStatus="
					+ approvalStatus + "]";
		}

		

}
