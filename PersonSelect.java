package day09;

import java.io.IOException;


//  1. JDBC 드라이버 로드
//  2. 데이터 베이스 연결


import java.sql.*;
import java.util.ArrayList;

public class PersonSelect {
	public static void main(String[] args) {
		Connection con = null;
		Statement st=null;
		ResultSet rs=null;
		try {
			// 1. 드라이버 로딩...
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. 데이터 베이스 연결...
			String url = "jdbc:mysql://localhost:3306/contants";
			String id = "root";
			String pwd = "1234";
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("DB 연결성공");

			//String sql2="select name, phone from person";
			//이름이 홍길동과 같은 사람의 모든 열의 정보를 검색해서 출력하기
			String sql2=" select *from person ";
			
			st=con.createStatement();
			rs=st.executeQuery(sql2);
			
			// 4. 데이터 조회 명령 sql 실행하기
			
			String email="";
			String phone="";
			String name="";
			Person person= null;
			ArrayList<Person> arrlist=new ArrayList<Person>(); 
			while(rs.next()) {
				name=rs.getString("name");				
				phone=rs.getString("phone");
				email=rs.getString("email");
				person= new Person(name, phone, email);
				arrlist.add(person);
			}
			for(Person p : arrlist){
				System.out.println("이름: "+p.getName());
				System.out.println("전화번호: "+p.getPhone());
				System.out.println("메일: "+p.getEmail());
			}
				
			
			
			
		} catch (Exception e) {
			System.out.println("드라이버 로딩 실패");
		}finally {
			try {
				con.close();
				rs.close();
				st.close();
				System.out.println("연결 끊기");
			}catch(SQLException es){
				
			}
		}
		
	}

}
