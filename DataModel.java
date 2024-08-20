package day10;

import java.sql.*;
import java.io.*;
import java.util.Scanner;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

public class DataModel {
	// 1. 데이터 베이스 연결..
	// 2. 데이터 입출력 담당 메소드 구현
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	ConnectDB cdb = null;
	Board board = null;
	PreparedStatement pstmt = null;
	Scanner scan = new Scanner(System.in);

	public DataModel() {
		cdb = new ConnectDB();
		con = cdb.getCon();
		if (con != null) {
			System.out.println("연결 성공");
		} else {
			System.out.println("연결 실패");
		}
	}// ---------생성자-----------

	// 데이터 추가 메소드
	public void insertData(Board board) throws SQLException {
		int num = 0;
		this.board = board;
		String sql = "INSERT INTO boards(btitle, bcontent, bwriter, bdate) VALUES(?,?,?,now())";
		pst = con.prepareStatement(sql);
		pst.setString(1, board.getBtitle());
		pst.setString(2, board.getBcontent());
		pst.setString(3, board.getBwriter());

		num = pst.executeUpdate();

		if (num > 0) {

			System.out.println("저장성공");
		} else {
			System.out.println("저장 실패");
		}
	}

	// 게시물 데이터 입력받기
	public void create() throws SQLException {
		Board board = new Board();
		System.out.println("[새 게시물 입력]");
		System.out.print("제목: ");
		board.setBtitle(scan.next());
		System.out.print("내용: ");
		board.setBcontent(scan.next());
		System.out.print("작성자: ");
		board.setBwriter(scan.next());
		////////////////////////
		insertData(board);
		/////////////
		list();

		BoardExam be1 = new BoardExam();
		be1.mainMenu();
	}

	// 데이터 전체 검색 list()
	public void list() throws SQLException {
		System.out.println("[게시물 목록]");
		System.out.println("------------------------------------------------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "title", "content", "writer", "date");
		System.out.println("------------------------------------------------------------------------");

		String sql = "select bno, btitle, bcontent, bwriter, bdate from boards ORDER BY bno DESC";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			Board board = new Board();
			board.setBno(rs.getInt("bno"));
			board.setBtitle(rs.getString("btitle"));
			board.setBcontent(rs.getString("bcontent"));
			board.setBwriter(rs.getString("bwriter"));
			board.setBdate(rs.getDate("bdate"));
			System.out.printf("%-6s%-12s%-16s%-40s\n", board.getBno(), board.getBtitle(), board.getBcontent(),
					board.getBwriter(), board.getBdate());

		}
	}// ---------------list()------------------------------------------

	// 데이터 조건 검색 list()
	public void list(String name) throws SQLException {
		System.out.println("[게시물 목록]");
		System.out.println("------------------------------------------------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "content", "title", "writer", "date");
		System.out.println("------------------------------------------------------------------------");

		String sql = "select bno, bcontent, btitle, bwriter, bdate from boards where bwriter=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, name);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			Board board = new Board();
			board.setBno(rs.getInt("bno"));
			board.setBtitle(rs.getString("btitle"));
			board.setBcontent(rs.getString("bcontent"));
			board.setBwriter(rs.getString("bwriter"));
			board.setBdate(rs.getDate("bdate"));
			System.out.printf("%-6s%-12s%-16s%-40s\n", board.getBno(), board.getBtitle(), board.getBcontent(),
					board.getBwriter(), board.getBdate());

		}

	}// ---------------list(String name)------------------------------

	// 게시물 읽기 메소드 구현하기 bno를 입력받아서 해당 게시물을 읽어오기
	public void read() throws SQLException {
		System.out.println("[게시물 읽기]");
		System.out.print("bno: ");
		int bno = Integer.parseInt(scan.nextLine());
		String sql = "select bno, btitle, bcontent, bwriter, bdate from boards where bno=?";
		pst = con.prepareStatement(sql);
		pst.setInt(1, bno);
		rs = pst.executeQuery();
		while (rs.next()) {
			Board board = new Board();
			board.setBno(rs.getInt("bno"));
			board.setBcontent(rs.getString("bcontent"));
			board.setBtitle(rs.getString("btitle"));
			board.setBwriter(rs.getString("bwriter"));
			board.setBdate(rs.getDate("bdate"));
			System.out.println("------------------------------------------------------------------------");
			System.out.println("번호: " + board.getBno());
			System.out.println("제목: " + board.getBtitle());
			System.out.println("내용: " + board.getBcontent());
			System.out.println("작성자: " + board.getBwriter());
			System.out.println("날짜: " + board.getBdate());

			// 보조 메뉴 출력
			System.out.println("------------------------------------------------------------------------");
			System.out.println("보조메뉴: 1.Update | 2.Delete | 3.List | 4.Exit");
			System.out.print("메뉴 선택:");
			String menuNO = scan.nextLine();
			System.out.println();
			if (menuNO.equals("1")) {
				update(board);
			} else if (menuNO.equals("2")) {
				delete(board);
			} else if (menuNO.equals("3")) {
				list();
			} else if (menuNO.equals("4")) {
				exit();
			}

		}
	}// -------------------read---------------------------------

	// 게시물 수정 기능 메소드 구현
	public void update(Board board) throws SQLException {
		System.out.println("[수정 내용 입력]");
		System.out.print("제목: ");
		board.setBtitle(scan.nextLine());
		System.out.print("내용: ");
		board.setBcontent(scan.nextLine());
		System.out.print("작성자: ");
		board.setBwriter(scan.nextLine());

		// 보조 메뉴 출력
		System.out.println("------------------------------------------------------------------------");
		System.out.println("보조메뉴: 1.OK | 2.Cancel");
		System.out.print("메뉴 선택:");
		String menuNO = scan.nextLine();
		if (menuNO.equals("1")) {

			// 게시물 정보 수정(update)

			String sql = "update boards set btitle=?, bcontent=?, bwriter=? where bno=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, board.getBtitle());
			pst.setString(2, board.getBcontent());
			pst.setString(3, board.getBwriter());
			pst.setInt(4, board.getBno());

			pst.executeUpdate();
			list();
			
			BoardExam be2 = new BoardExam();
			be2.mainMenu();
			
		} else if (menuNO.equals("2")) {
			System.out.println("취소");
			
			BoardExam be3 = new BoardExam();
			be3.mainMenu();
		}
	}// ---------------update---------------------

	// 게시물 정보 삭제 메소드 구현
	public void delete(Board board) throws SQLException {
		System.out.println("------------------------------------------------------------------------");
		System.out.println("삭제하시겠습니까?: 1.OK | 2.Cancel");
		String menuNO = scan.nextLine();
		if (menuNO.equals("1")) {
		String sql = "delete from boards where bno=?";
		pst = con.prepareStatement(sql);
		pst.setInt(1, board.getBno());
		pst.executeUpdate();
		pst.close();
		list();
		} else {
			BoardExam be4 = new BoardExam();
			be4.mainMenu();
		}
		
	}

	// 게시물 정보 전체 삭제 메소드 구현
	public void clear() throws SQLException {
		System.out.println("[게시물 전체 삭제]");
		System.out.println("------------------------------------------------------------------------");
		System.out.println("보조메뉴: 1.OK | 2.Cancel");
		System.out.print("메뉴 선택:");
		String menuNO = scan.nextLine();
		if (menuNO.equals("1")) {
			String sql = "truncate table boards ";
			pst = con.prepareStatement(sql);

			pst.executeUpdate();
			pst.close();
		} else {
			BoardExam be5 = new BoardExam();
			be5.mainMenu();
		}

	}// ------------clear-----------------------------

	// 종료 메소드 구현
	public void exit() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
		System.out.println("**게시판 종료**");
		System.exit(0);
	}

	
	// 메인함수
	public static void main(String[] args) throws SQLException {
		DataModel dm = new DataModel();
		// dm.create();
		dm.read();
	}

}
