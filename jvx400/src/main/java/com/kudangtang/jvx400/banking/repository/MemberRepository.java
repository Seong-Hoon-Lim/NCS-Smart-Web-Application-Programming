package com.kudangtang.jvx400.banking.repository;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import com.kudangtang.jvx400.banking.domain.Member;
import com.kudangtang.jvx400.banking.dto.MemberDto;
import com.kudangtang.jvx400.config.MemberRowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class MemberRepository {
	private JdbcTemplate jdbcTemplate;
	
	public MemberRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void addMember(MemberDto member) {
		String sql = "INSERT INTO Member (userId, passwd, name, ssn, email, phone)"
				+ " VALUES (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
								throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, member.getUserId());
				pstmt.setString(2, member.getPasswd());
				pstmt.setString(3, member.getName());
				pstmt.setString(4, member.getSsn());
				pstmt.setString(5, member.getEmail());
				pstmt.setString(6, member.getPhone());

				return pstmt;
			}
		});
	}
	
	public Member findMemberByUserId(String userId) {
		String sql = "SELECT * FROM Member "
						+ " WHERE userId = ?";
		return jdbcTemplate.queryForObject(sql, new MemberRowMapper(), userId);
	
				
	}
				
				
				
				
				
}
