package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import manager.User;

public class UserDao {

	/* Function to insert user detail (row) into User Table(DB) */
	public static void insertUserToDB(User us) {
		Connection con = null;
		try {
			con = ConnectionProvider.createConnection();
			String q = "insert into user(iduser, name, contactNum,email,userLogIn,password,address) values(?,?,?,?,?,?,?)";
			PreparedStatement pstm = null;

			pstm = con.prepareStatement(q);

			pstm.setNString(1, us.getUserId());
			pstm.setNString(2, us.getName());
			pstm.setNString(3, us.getContactNum());
			pstm.setNString(4, us.getEmail());
			pstm.setNString(5, us.getLogOnName());
			pstm.setNString(6, us.getPassword());
			pstm.setNString(7, us.getAddress());
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static boolean userExits(String currentLogInUser) {
		Connection con = null;
		try {
			con = ConnectionProvider.createConnection();
			String q = "select * from user where userlogIn = ?";
			PreparedStatement pstm = null;
			pstm = con.prepareStatement(q);
			pstm.setNString(1, currentLogInUser);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	public static boolean checkCredentials(String currentLogInUser, String currentPassword) {
		Connection con = null;
		try {
			con = ConnectionProvider.createConnection();
			String q = "select * from user where userlogIn = ? and password = ?";
			PreparedStatement pstm = null;
			pstm = con.prepareStatement(q);

			pstm.setNString(1, currentLogInUser);
			pstm.setNString(2, currentPassword);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
}
