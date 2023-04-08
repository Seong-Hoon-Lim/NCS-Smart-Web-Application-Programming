package com.example.sample_mamber_servlet.dao;

import com.example.sample_mamber_servlet.dto.MemberDTO;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DAO 에서는 복잡한 로직을 처리 하지 않고
 * query 와 관련된 작업처리 와 query 작업 처리시
 * 최소한의 파라미터 만 활용하는 것이 좋음.
 * 복잡한 로직 처리는 service 에서 처리해야 유지보수가 쉬우며
 * 에러 발생 시 명확하게 구분이 가능
 */
@Log4j2
public class MemberDAO {

    /**
     * 메모리의 부하를 줄이도록 싱글톤 패턴으로 구현
     * 한번만 생성되면 계속 사용할 수 있음.
     */
    private static MemberDAO instance;
    
    private MemberDAO() {
        
    }
    
    public static MemberDAO getInstance() {
        if (instance == null) {
            instance = new MemberDAO();
        }
        return instance;
    }

    /**
     * @Cleanup 어노테이션을 활용.
     * try~catch 와 close() 작업 불필요.
     * 코드가 간결 해짐.
     * DB에 id 값이 존재 하는 경우 true.
     * 존재하지 않는 경우 false.
     * @param id
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean isExistId(String id) throws SQLException, ClassNotFoundException {
        String query = "SELECT COUNT(*) AS cnt FROM member WHERE `id` = ?";
        @Cleanup Connection conn = DBConnection.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, id);
        @Cleanup ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            if (rs.getInt(1) == 1) {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    /* 회원가입 처리 */
    public boolean saveMember(MemberDTO memberDTO) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO member VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        @Cleanup Connection conn = DBConnection.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, memberDTO.getId());
        ps.setString(2, memberDTO.getPassword());
        ps.setString(3, memberDTO.getName());
        ps.setString(4, memberDTO.getGender());
        ps.setString(5, memberDTO.getBirth());
        ps.setString(6, memberDTO.getMail());
        ps.setString(7, memberDTO.getPhone());
        ps.setString(8, memberDTO.getZipcode());
        ps.setString(9, memberDTO.getAddress01());
        ps.setString(10, memberDTO.getAddress02());
        ps.setString(11, memberDTO.getRegistDay());
        ps.executeUpdate();

        if (ps != null) {
            return true;
        }
        else {
            return false;
        }
    }

    /* 로그인 처리 */
    public boolean findMemberByIdPassword(String id, String password)
            throws SQLException, ClassNotFoundException {
        log.info("findMemberByIdPassword()...");
        String query = "SELECT * FROM member WHERE id = ? AND password = ?";
        @Cleanup Connection conn = DBConnection.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, id);
        ps.setString(2, password);
        @Cleanup ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return true;
        }
        else {
            return false;
        }


    }

    public String getNameById(String id) throws SQLException, ClassNotFoundException {
        log.info("getName()...");
        String query = "SELECT * FROM member WHERE id = ?";
        String name = null;
        @Cleanup Connection conn = DBConnection.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, id);
        @Cleanup ResultSet rs = ps.executeQuery();

        if (rs.next()) {    //데이터가 있다면 name의 데이터를 가져와서 리턴
            name = rs.getString(3);
            log.info(name);
        }
        return name;
    }

//    /* 회원정보 수정 처리 */
//    public MemberDTO findMemberById(String id) throws SQLException, ClassNotFoundException {
//        log.info("getMemberById()...");
//        log.info("id: " + id);
//        MemberDTO memberDTO = null;
//        String query = "SELECT * FROM member WHERE id = ?";
//        @Cleanup Connection conn = DBConnection.getConnection();
//        @Cleanup PreparedStatement ps = conn.prepareStatement(query);
//        ps.setString(1, id);
//        @Cleanup ResultSet rs = ps.executeQuery();
//
//        if (rs.next()) {    // id 의 데이터가 있다면 memberDTO 객체에 담아 리턴
//            memberDTO = new MemberDTO();    //객체가 있을 때 객체가 생성되고 null 경우 객체 생성되지 않음
//            memberDTO.setId(id);
//            memberDTO.setPassword(rs.getString("password"));
//            memberDTO.setName(rs.getString("name"));
//            memberDTO.setGender(rs.getString("gender"));
//            memberDTO.setBirth(rs.getString("birth"));
//            memberDTO.setMail(rs.getString("mail"));
//            memberDTO.setPhone(rs.getString("phone"));
//            memberDTO.setAddress(rs.getString("address"));
//        }
//        return memberDTO;
//    }
//
//    public boolean updateMember(MemberDTO memberDTO)
//            throws SQLException, ClassNotFoundException {
//        log.info("updateMember()...");
//        String query = "UPDATE member SET password = ?, name = ?, gender = ?, birth = ?, mail = ?, phone = ?, address = ? WHERE id = ?";
//        log.info(query);
//        @Cleanup Connection conn = DBConnection.getConnection();
//        @Cleanup PreparedStatement ps = conn.prepareStatement(query);
//        ps.setString(1, memberDTO.getPassword());
//        ps.setString(2, memberDTO.getName());
//        ps.setString(3, memberDTO.getGender());
//        ps.setString(4, memberDTO.getBirth());
//        ps.setString(5, memberDTO.getMail());
//        ps.setString(6, memberDTO.getPhone());
//        ps.setString(7, memberDTO.getAddress());
//        ps.setString(8, memberDTO.getId());
//        int result = ps.executeUpdate();
//        return result == 1;
//
//    }


}
