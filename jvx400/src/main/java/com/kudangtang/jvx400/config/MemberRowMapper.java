package com.kudangtang.jvx400.config;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kudangtang.jvx400.banking.domain.Member;

public class MemberRowMapper implements RowMapper<Member> {

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Member member = new Member(rs.getLong("cid"), rs.getString("userId"),
				rs.getString("passwd"), rs.getString("name"), rs.getString("ssn"),
				rs.getString("email"), rs.getString("phone"), rs.getTimestamp("regDate"));
		return member;
	}
	
}
