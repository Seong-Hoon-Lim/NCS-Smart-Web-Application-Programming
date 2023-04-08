package boardTest;

import com.example.sample_mamber_servlet.dao.BoardDAO;
import com.example.sample_mamber_servlet.dao.MemberDAO;
import com.example.sample_mamber_servlet.dto.BoardDTO;
import com.example.sample_mamber_servlet.dto.MemberDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

@Log4j2
public class BoardTest {

    @Test
    public void saveBoardTest() throws SQLException, ClassNotFoundException {
        BoardDAO boardDAO = BoardDAO.getInstance();

        for (int i = 0; i < 200; i++) {
            BoardDTO boardDTO = new BoardDTO();

            boardDTO.setId("Spring");
            boardDTO.setName("name-" + i);
            boardDTO.setSubject("test" + i);
            boardDTO.setContent("test" + i);
            java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy/MM/dd(HH:mm:ss)");
            String registerDay = formatter.format(new java.util.Date());
            boardDTO.setRegistDay(registerDay);
            boardDTO.setHit(0);
            boardDTO.setId("Spring");
            boardDAO.saveBoard(boardDTO);

        }

    }

    @Test
    public void saveMemberTest() throws SQLException, ClassNotFoundException {
        MemberDAO memberDAO = MemberDAO.getInstance();

        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setId("Spring");
        memberDTO.setPassword("1111");
        memberDTO.setName("가길동");
        memberDTO.setGender("남");
        memberDTO.setBirth("1990/01/21");
        memberDTO.setMail("spring@gmail.com");
        memberDTO.setPhone("01033110011");
        memberDTO.setZipcode("13536");
        memberDTO.setAddress01("경기 성남시 분당구 판교역로 4 (백현동)");
        memberDTO.setAddress02("가나타운 101동 101호");
        memberDTO.setRegistDay("2023-04-07 18:04:43");
        memberDAO.saveMember(memberDTO);


    }
}
