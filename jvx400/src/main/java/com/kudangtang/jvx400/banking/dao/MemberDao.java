package com.kudangtang.jvx400.banking.dao;

import javax.sql.DataSource;

import com.kudangtang.jvx400.banking.vo.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component("memberDao")
public class MemberDao {
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void addMember(Member member) {
		String sql = "INSERT INTO Customer (email, passwd, name, ssn, phone)"
				+ " VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
								throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, member.getEmail());
				pstmt.setString(1, member.getPasswd());
				pstmt.setString(1, member.getName());
				pstmt.setString(1, member.getSsn());
				pstmt.setString(1, member.getPhone());

				return pstmt;
			}
		});
	}

}
