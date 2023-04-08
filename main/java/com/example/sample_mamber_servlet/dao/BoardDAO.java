package com.example.sample_mamber_servlet.dao;

import com.example.sample_mamber_servlet.dto.BoardDTO;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class BoardDAO {

    private static BoardDAO instance;

    private BoardDAO() {

    }

    public static BoardDAO getInstance() {
        if (instance == null) {
            instance = new BoardDAO();
        }
        return instance;
    }

    /**
     * 테이블의 컬럼명을 직접 명시하지 않고 테이블명만 명시하는 경우
     * 컬럼 순서대로 지정됨
     *
     * @param boardDTO
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean saveBoard(BoardDTO boardDTO)
            throws SQLException, ClassNotFoundException {
        log.info("saveBoard()...");
        String query = "INSERT INTO board VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
        int result;

        @Cleanup Connection conn = DBConnection.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, boardDTO.getId());
        ps.setString(2, boardDTO.getName());
        ps.setString(3, boardDTO.getSubject());
        ps.setString(4, boardDTO.getContent());
        ps.setString(5, boardDTO.getRegistDay());
        ps.setInt(6, boardDTO.getHit());
        ps.setString(7, boardDTO.getIp());
        result = ps.executeUpdate();

        return result == 1;

    }

    public int findListCount(String items, String text) throws SQLException, ClassNotFoundException {
        log.info("findListCount()...");
        String query;
        if (items == null && text == null) {
            query = "SELECT count(*) FROM board";
        } else {
            query = "SELECT count(*) FROM board WHERE " + items + " LIKE CONCAT('%:" + text + "%')";
        }

        @Cleanup Connection conn = DBConnection.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(query);
        @Cleanup ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getInt(1);
    }

    /*
     최근 게시물 부터 조회
     */
    public List<BoardDTO> findList(int pageNum, int limit, String items, String text)
            throws SQLException, ClassNotFoundException {
        log.info("findList()...");
        int start = (pageNum - 1) * limit;  //ex. 1페이지면 0, 2페이지면 5, 3페이지면 10

        String query;
        if (items == null && text == null) {    //검색이 없는 경우
            query = "SELECT * FROM board ORDER BY num DESC LIMIT " + start + ", " + limit;
        } else {
            query = "SELECT * FROM board WHERE "
                    + items + " LIKE CONCAT('%:" + text + "%)' ORDER BY num DESC LIMIT "
                    + start + ", " + limit;
        }

        List<BoardDTO> list = new ArrayList<BoardDTO>();

        @Cleanup Connection conn = DBConnection.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(query);
        @Cleanup ResultSet rs = ps.executeQuery();

        //rs.absolute() : 특정위치로 이동
        while (rs.next()) {
            BoardDTO board = new BoardDTO();
            board.setNum(rs.getInt("num"));
            board.setId(rs.getString("id"));
            board.setName(rs.getString("name"));
            board.setSubject(rs.getString("subject"));
            board.setContent(rs.getString("content"));
            board.setRegistDay(rs.getString("registDay"));
            board.setHit(rs.getInt("hit"));
            board.setIp(rs.getString("ip"));
            log.info(board); //ToString() 필요
            list.add(board); //리스트에 추가

        }
        return list;
    }



}
