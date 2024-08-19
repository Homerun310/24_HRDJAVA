package day09;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;



public class BoardSelectExam {
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
			String sql2=" select * from boards where bwriter= ? ";
			PreparedStatement st = con.prepareStatement(sql2);
			
			st.setString(1,"winter");
			ResultSet rs=st.executeQuery() ;
			
			while(rs.next()) {
				System.out.println("데이터 조회 성공!!");
				int bno=rs.getInt("bno");
				String btitle=rs.getString("btitle");
				String bcontent=rs.getString("bcontent");
				String bwriter=rs.getString("bwriter");
				String d=rs.getDate("bdate").toString();
				String bfilename=rs.getString("bfilename");
				String bfiledata=null;
				Blob blob=rs.getBlob("bfiledata");
				InputStream is=blob.getBinaryStream();
				OutputStream os=new FileOutputStream("C:\\Users\\COMPUTER\\eclipse-workspace\\JavaOOP\\src\\day09\\snow.jpg");
				is.transferTo(os);
				System.out.println("번호: "+bno);
				System.out.println("제목: "+btitle);
				System.out.println("내용: "+bcontent);
				System.out.println("작성자: "+bwriter);
				System.out.println("작성일: "+d);
				System.out.println("파일이름: "+bfilename);
				
				
				os.flush();
				os.close();
				is.close();
	
			}
		
			rs.close();
			st.close();
			
		
			
			
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
