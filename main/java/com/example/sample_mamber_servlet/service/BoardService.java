package com.example.sample_mamber_servlet.service;

import com.example.sample_mamber_servlet.dao.BoardDAO;
import com.example.sample_mamber_servlet.dto.BoardDTO;
import lombok.extern.log4j.Log4j2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@Log4j2
public class BoardService {

    private static final int LISTCOUNT = 5; //한페이지에 노출 할 게시물의 수

    private static BoardService instance;

    private BoardService() {

    }

    public static BoardService getInstance() {
        if (instance == null) {
            instance = new BoardService();
        }
        return instance;
    }

    /*
    게시판 입력 양식 저장 기능
     */
    public boolean saveBoard(HttpServletRequest request)
            throws SQLException, ClassNotFoundException {
        log.info("saveBoard()...");
        BoardDAO boardDAO = BoardDAO.getInstance();

        BoardDTO boardDTO = new BoardDTO();

        HttpSession session = request.getSession();
        boardDTO.setId((String) session.getAttribute("sessionMemberId"));   //세션에 저장된 아이디 사용.
        boardDTO.setName(request.getParameter("name"));
        boardDTO.setSubject(request.getParameter("subject"));
        boardDTO.setContent(request.getParameter("content"));

        /*
        디버깅을 위해 출력
         */
        log.info(boardDTO.getName());
        log.info(boardDTO.getSubject());
        log.info(boardDTO.getContent());
        
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy/MM/dd(HH:mm:ss)");
        String registerDay = formatter.format(new java.util.Date());

        boardDTO.setHit(0); //조회수
        boardDTO.setRegistDay(registerDay);  //등록일
        boardDTO.setIp(request.getRemoteAddr());    //접근 IP

        return boardDAO.saveBoard(boardDTO);

    }

    /**
     * 게시판 글목록 조회(페이징 처리 기능)
     * @param request
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void getList(HttpServletRequest request)
            throws SQLException, ClassNotFoundException {
        BoardDAO boardDAO = BoardDAO.getInstance();
        List<BoardDTO> boardList;   //게시물을 담는 리스트

        int pageNum = 1;    //페이지 번호
        int limit = LISTCOUNT;  //페이지당 노출될 게시물 수

        if (request.getParameter("pageNum") != null) {  //전달되는 페이지 번호가 있으면
            pageNum = Integer.parseInt(request.getParameter("pageNum"));
        }

            String items = request.getParameter("items");   //검색 필드.
            String text = request.getParameter("text");   //검색어.

            int totalRecord = boardDAO.findListCount(items, text);  //전체 게시물 수
            boardList = boardDAO.findList(pageNum, limit, items, text); //현재 페이지에 해당하는 게시물 목록

            int totalPage;  //전체 페이지 수

            /*
            전체 페이지 계산
            현 메소드에서 페이징 처리에 가장 중요한 로직
             */
            if (totalRecord % limit == 0) { //전체 게시물의 숫자가 페이지당 게시물의 배수이면
                totalPage = totalRecord / limit;
                Math.floor(totalPage);  //Math.floor() : 주어진 숫자와 같거나 작은 정수 중에서 가장 큰 수를 반환
            }
            else {
                totalPage = totalRecord / limit;
                Math.floor(totalPage);
                totalPage = totalPage + 1;  //배수가 아니면 + 1 ex. 전체게시물이 51개이고 페이지당 노출되는 게시물의 수가 10개이면 6페이지
            }

            /*
             view 에 전달할 값들
             */
            request.setAttribute("limit", limit);   //페이지당 노출될 게시물 수
            request.setAttribute("pageNum", pageNum);   //현재 페이지
            request.setAttribute("totalPage", totalPage);   //전체 페이지 수
            request.setAttribute("totalRecord", totalRecord);   //전체 기시물 수
            request.setAttribute("boardList", boardList);   //현재 페이지에 해당하는 게시물 목록

            request.setAttribute("items", items);   //검색 필드.
            request.setAttribute("text", text); //검색어.

    }
    
    
}
