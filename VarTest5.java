package day01;
/**
 * 4칙연산과 나머지연산을 하는 간단한 계산기 예제
 */
import java.util.Scanner;
public class VarTest5 {

	public static void main(String[] args) {
		// 4칙 연산을 입력받아 저장하는변수 선언
		// 2개 정수 입력 받아 저장하는 변수 선언
		// "+", 더하기면 덧셈 "-", 빼기면 뺏셈

	
	Scanner sc=new Scanner(System.in);
	
	int result=0;
	
	System.out.print("첫번째 수: ");
	int x=sc.nextInt();
	System.out.print("두번째 수: ");
	int y=sc.nextInt();
	System.out.print("타입입력: ");
	String type=sc.next();
	
	if(type.equals("+")) {
		result=x+y;
	}
	else if(type.equals("-")) {
		result=x-y;
	}
	else if(type.equals("*")) {
		result=x*y;
	}
	else if(type.equals("/")) {
		result=x/y;
	}
	
	System.out.println("정답: "+result);
}
}
