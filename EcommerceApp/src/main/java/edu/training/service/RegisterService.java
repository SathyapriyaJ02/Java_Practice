package edu.training.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import edu.training.model.Dao;
import edu.training.model.Product;
import edu.training.model.Register;

public class RegisterService 
{
	static Dao d = new Dao();
	 
	static PreparedStatement ps;
	public void addUser(Register r,String approvalStatus)
	{
		
		Connection con = d.getConnection();
		try
		{
			String ApprovalStatus = approvalStatus;
			 ps = con.prepareStatement("insert into userregisteration values(?,?,?,?,?,?,?)");
			 ps.setString(1,r.getName());
			 ps.setDate(2,r.getDateOfBirth());
			 ps.setString(3,r.getPhoneNumber());
			 ps.setString(4,r.getAddress());
			 ps.setString(5,r.getEmail());
			 ps.setString(6,r.getPassword());
			 ps.setString(7,ApprovalStatus);
			 ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public List<Register> viewUser() throws SQLException, ParseException
	{
		Connection con = d.getConnection();
		List<Register> list = new ArrayList();
		ps = con.prepareStatement("select * from userregisteration");
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			list.add(new Register(rs.getString(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
		}
		return list;
		
	}
	
	public void approvalStatus(String userEmail, String status)
	{
		Connection con = d.getConnection();
		    try {
		    	//System.out.println("Updating email: " + userEmail + " with status: " + status);

		        ps = con.prepareStatement("UPDATE userregisteration SET approval_status=? where email=?");

		        ps.setString(1, status);

		        ps.setString(2, userEmail);

		        int rowsUpdated = ps.executeUpdate();

		        

		        if (rowsUpdated > 0) {

		            System.out.println("Approval status updated successfully.");

		        } else {

		            System.out.println("No rows updated.");

		        }

		    } catch (SQLException e) {

		        e.printStackTrace();

		        System.out.println("SQL Exception: " + e.getMessage());

		    } catch (Exception e) {

		        e.printStackTrace();

		        System.out.println("Error updating approval status: " + e.getMessage());

		    }

		}
	
}
