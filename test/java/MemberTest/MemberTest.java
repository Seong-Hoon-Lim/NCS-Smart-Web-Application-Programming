package MemberTest;

import com.example.sample_mamber_servlet.dao.MemberDAO;
import com.example.sample_mamber_servlet.dto.MemberDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

@Log4j2
public class MemberTest {

    @Test
    public void saveMemberTest() throws SQLException, ClassNotFoundException {
        MemberDAO memberDAO = MemberDAO.getInstance();

        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setId("Spring5");
        memberDTO.setPassword("1111");
        memberDTO.setName("마길동");
        memberDTO.setGender("남");
        memberDTO.setBirth("1990/01/21");
        memberDTO.setMail("spring5@gmail.com");
        memberDTO.setPhone("01033110011");
        memberDTO.setZipcode("13536");
        memberDTO.setAddress01("경기 성남시 분당구 판교역로 4 (백현동)");
        memberDTO.setAddress01("가나타운 101동 101호");
        memberDTO.setRegistDay("2023-04-07 18:04:43");
        memberDAO.saveMember(memberDTO);


    }

}
