package com.kudangtang.jvx400.banking.dao;

import javax.sql.DataSource;

import com.kudangtang.jvx400.banking.domain.Member;
import com.kudangtang.jvx400.banking.dto.MemberDto;
import com.kudangtang.jvx400.config.MemberRowMapper;
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
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void saveMember(MemberDto member) {
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

	public void updateMember(MemberDto member) {
		String sql = "UPDATE Member if(passwd!=NULL AND email==NULL AND phone==NULL) {SET passwd=?}"
				   				 + "elseif(passwd==NULL AND email!=NULL AND phone==NULL) {SET email=?}"
								 + "elseif(passwd==NULL AND email==NULL AND phone!=NULL) {SET phone=?}"
								 + "elseif(passwd!=NULL AND email!=NULL AND phone==NULL) {SET passwd=?, SET email=?}"
								 + "elseif(passwd!=NULL AND email==NULL AND phone!=NULL) {SET passwd=?, SET phone=?}"
								 + "elseif(passwd==NULL AND email!=NULL AND phone!=NULL) {SET email=?, SET phone=?}"
								 + " WHERE userId=?";
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
								throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, member.getPasswd());
				pstmt.setString(2, member.getEmail());
				pstmt.setString(3, member.getPhone());
				pstmt.setString(4, member.getUserId());

			return pstmt;
			}
		});
	}

}
