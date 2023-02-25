package com.kudangtang.jv300.mod010.dao;
import com.kudangtang.jv300.mod010.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class UserDao {			
	private DataSource dataSource;
			
	public UserDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	/**
	 * User 정보를 DB 에 저장하는 메소드
	 * @param user
	 */
	public void saveUser(User user) {
		String sql = "INSERT INTO ModUser(userId, passwd, userName, birthDate, email)"
						+ "VALUES(?, ?, ?, ?, ?)";
		try (Connection con = dataSource.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getPasswd());
			pstmt.setString(3, user.getUserName());
			pstmt.setDate(4, new Date(user.getBirthDate().getTime()));
			pstmt.setString(5, user.getEmail());		
			pstmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * User 정보를 DB에서 찾는 메소드
	 * @return
	 */
	public List<User> findUserList() {
		
		String sql = "SELECT * FROM ModUser";
		List<User> list = new ArrayList<>();
		User user = null;
		
		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				user = new User();
				user.setUserId(rs.getString("userId"));
				user.setUserName(rs.getString("userName"));
				user.setBirthDate(rs.getDate("birthDate"));
				user.setEmail(rs.getString("email"));
				user.setRegDate(rs.getTimestamp("regDate"));
				list.add(user);
			}
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
