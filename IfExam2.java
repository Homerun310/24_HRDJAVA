package day02;
import java.util.Scanner;
public class IfExam2 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("##로그인 (admin 혹은 임의 아이디) ##");
		System.out.print("# 로그인 아이디 : ");
		
		String id=sc.next();
		
		if(id.equals("admin")) {
		System.out.println("관리자 로그인");	
		}else {
		System.out.println(id+" 로그인");
		}
		
		System.out.println("## 메뉴를 선택하세요(1~2) ##");
		System.out.print("# 메뉴선택 : ");
		
		int menu=sc.nextInt();
		
		if(menu==1 && id.equals("admin")) {
			System.out.println("admin"+" "+menu+"번 선택함");
		}
		else if(menu==2 && id.equals("admin")) {
			System.out.println("admin"+" "+menu+"번 선택함");
		}
		else if((menu==1 || menu==2) && id.equals("guest")) {
			System.out.println("no signal");
		}
		else {
		System.out.println(id+" "+menu+"번 선택함!");
		}
		
	}

}
