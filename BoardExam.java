package day10;
import java.sql.*;
import java.io.*;
import java.sql.SQLException;
import java.util.Scanner;

public class BoardExam {
	private Scanner scan = new Scanner(System.in);
	DataModel dm=null;
	
	//생성자
	public BoardExam() {
		dm=new DataModel();
	}

	public void mainMenu() throws SQLException {
		
		System.out.println("------------------------------------------------------");
		System.out.println("메인메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
		System.out.print("메뉴선택: ");
		String menuNo = scan.nextLine();
		System.out.println();
		
		switch(menuNo) {
		case "1":
			dm.create();
			break;

		case "2":
			dm.read();
			break;
			
		case "3":
			dm.clear();
			break;
			
		case "4":
			dm.exit();
			break;
		}
		

		
	}
	
	
	
	
	
	
	public static void main(String[] args) throws SQLException {
		BoardExam bexam=new BoardExam();
		bexam.mainMenu();

	
	}

}
