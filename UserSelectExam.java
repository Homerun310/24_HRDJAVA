package day09;

import java.io.IOException;

/**
 /*1. JDBC 드라이버 로드
 * 2. 데이터 베이스 연결
 *  
 */

import java.sql.*;


public class UserSelectExam {
	public static void main(String[] args) {
		Connection con = null;
		
		try {
			// 1. 드라이버 로딩...
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. 데이터 베이스 연결...
			String url = "jdbc:mysql://localhost:3306/contants";
			String id = "root";
			String pwd = "1234";
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("DB 연결성공");
			
			
//			 3. SQL문을 실행 하기 위한 Statement, PreparedStatement 객체생성
//			String sql="INSERT INTO person Values('홍','010-456-789','hong');";
//		    Statement st=con.createStatement();
			String sql2="select * from users where userid= ?";
			PreparedStatement st = con.prepareStatement(sql2);
			st.setString(1, "hng123");
			ResultSet rs=st.executeQuery();
			
			
			
			if(rs.next()) {
				System.out.println("데이터 조회 성공");
				String username=rs.getString("username");
				int userage=rs.getInt("userage");
				System.out.println("이름: "+username);
				System.out.println("나이: "+userage);
			}else {
				System.out.println("데이터 조회실패");
			}
		
			
			
						
		} catch (Exception e) {
			System.out.println("드라이버 로딩 실패");
		}finally {
			try {
				con.close();
				System.out.println("연결 끊기");
			}catch(SQLException es){
				
			}
		}
		
	}

}
