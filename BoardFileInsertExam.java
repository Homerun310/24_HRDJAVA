package day09;
import java.io.IOException;
import java.sql.*;
import java.io.FileInputStream;



public class BoardFileInsertExam {
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
			
			
			//매개변수화된 sql문 작성
			String sql2=""+"INSERT INTO boards(btitle, bcontent, bwriter, bdate, bfilename, bfiledata)"+" Values(?, ?, ?, now(), ?, ?)";
			PreparedStatement st = con.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
			
			
			//PreparedStatement 얻기 및 값 지정
			st.setString(1,"눈오는 날");
			st.setString(2,"함박눈이 내려요");
			st.setString(3,"winter");
			st.setString(4,"snow.jpg");
			st.setBlob(5, new FileInputStream("C:\\Users\\COMPUTER\\eclipse-workspace\\JavaOOP\\src\\day09\\snow.jpg"));
			
			
			
			
			// 4. 데이터 추가 명령 전송하기
			int result=st.executeUpdate();
			if(result>0) {
				System.out.println("데이터 저장성공");
			}else {
				System.out.println("데이터 저장실패");
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
