package com.kudangtang.jv300.mod010;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.kudangtang.jv300.mod010.dao.DataSource;

@WebListener
public class InitializeJdbc implements ServletContextListener {
	private static final String JDBC_FILE_PATH = "/WEB-INF/classes/jdbc.properties";
	
	/**
	 * 서버가 Start up 될 때 실행될 메소드
	 */
	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("contextInitialized is called");
		/**
		 * context 는 webapp 밑의 경로 전체를 포함해서 지칭한다
		 * scope 는 그 context 를 저장 담는 것을 지칭한다
		 */
		ServletContext context = event.getServletContext();		
		InputStream is = null;
		BufferedReader reader = null;
		Map<String, String> jdbcMap = new HashMap<String, String>();		
		try {
			/**
			 * Properties 클래스를 활용하는 방법
			 * properties 파일만을 읽는 목적이 있는 클래스
			 * Map 형태로 받아오지만, Map 과 다르게 문자만 받을 수 있음
			 */
//			Properties prop = new Properties();
//			prop.load(is);
			is = context.getResourceAsStream(JDBC_FILE_PATH);
			/**
			 * BufferedReader 는 바이트 단위 이므로 캐릭터 단위로 읽기 위해
			 * new InputStreamReader(is) 로 필터를 씌운 것과 같다.
			 * 
			 */
			reader = new BufferedReader(new InputStreamReader(is));
			String record = null;
			
			while ((record = reader.readLine()) != null) {
				String[] fields = record.split("=");	//"=" 기준으로 문자열 자르기
				jdbcMap.put(fields[0], fields[1]);	//jdbcMap 에 key, value 담기
			}
			//jdbcMap 에 담긴 값 가져오기 (map객체.get("key"))
			String jdbcDriver = jdbcMap.get("jdbc.driver");
			String jdbcURL = jdbcMap.get("jdbc.url");
			String userName = jdbcMap.get("jdbc.username");
			String password = jdbcMap.get("jdbc.password");
			
			//Properties 에 값 담아 가져오기
//			String jdbcDriver =prop.getProperty("jdbc.driver");
//			String jdbcURL = prop.getProperty("jdbc.url");
//			String userName = prop.getProperty("jdbc.username");
//			String password = prop.getProperty("jdbc.password");
			
			System.out.println("jdbcDriver=" + jdbcDriver);
			System.out.println("jdbcURL=" + jdbcURL);
			System.out.println("userName=" + userName);
			System.out.println("password=" + password);
			
			/**
			 * DataSource 객체가 생성되면서 아래 과정의 내부의 메소드가 동작됨
			 * 클래스를 로딩하면서 jdbcDriver 를 연결
			 * jdbc.properties 의 값들로 Connection 을 생성
			 */
			DataSource dataSource = new DataSource(jdbcDriver, jdbcURL, 
												userName, password);
			/**
			 * 서버가 동작되는 동안 계속 유지 되도록 context에 가져옴
			 */
			context.setAttribute("dataSource", dataSource);

		}		
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 서버가 Shut down 될 때 실행될 메소드
	 */
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("contextDestroyed is called");
			
	}
	

}
