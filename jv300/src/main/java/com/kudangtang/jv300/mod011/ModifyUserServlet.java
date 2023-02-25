package com.kudangtang.jv300.mod011;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod011/modify_user.do")
public class ModifyUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;
	
	public void init() {
		userService = new UserService((DataSource)getServletContext()
				.getAttribute("dataSource11"));		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//폼 파라메타 얻기
		String passwd = request.getParameter("passwd");
		String birthDate = request.getParameter("birthDate");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String email = email1 + "@" + email2;
		String[] concerns = request.getParameterValues("concerns");
		
//		//폼데이터 유효성검증
//		List<String> errorMsgs = new ArrayList<>();
//		validateEmpy(userId, "userId", errorMsgs);
//		validateEmpy(passwd, "passwd", errorMsgs);
//		validateEmpy(userName, "userName", errorMsgs);
//		validateEmpy(email1, "emali", errorMsgs);
		RequestDispatcher rd = null;
//		if (!errorMsgs.isEmpty()) {
//			request.setAttribute("errorMsgs", errorMsgs);
//			rd = request.getRequestDispatcher("add_user.jsp");
//			rd.forward(request, response);
//			return;
//		}
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date date;
		try {
			date = format.parse(birthDate);
		}
		catch (ParseException e) {
			Calendar cal = Calendar.getInstance();
			cal.set(1900, 0, 1);	//값이 없을 경우 null 값을 생성하지 않기 위해 임의로 값 세팅
			date = cal.getTime();
		}
		/**
		 * User 객체를 캡슐화 한 것 
		 */
		User user = new User();
		user.setPasswd(passwd);
		user.setBirthDate(date);
		user.setEmail(email);				
		user.setConcerns(concerns);
		
		//비즈니스 서비스 호출
		userService.modifyUser(user);
		
		//Next View 결정
		request.setAttribute("user", user);
		rd = request.getRequestDispatcher("modifyuser_success.jsp");
		rd.forward(request, response);
	}	
	
//	private void validateEmpy(String value, String param, List<String> errorMsg) {
//		if (value == null || value.length() == 0) {
//			errorMsg.add(param + " is required.");
//		}
//	}
      
}
