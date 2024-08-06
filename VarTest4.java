package day01;
/*한국식 나이 : 현재 연도 - 출생 연도 + 1
연 나이 : 현재 연도 - 출생 연도
출생 연도를 나타내는 정수 year와 구하려는 나이의 종류를 나타내는 문자열 age_type이 주어질 때 
2030년에 몇 살인지 출력하도록 빈칸을 채워 코드를 완성해 주세요.
age_type이 "Korea"라면 한국식 나이를, "Year"라면 연 나이를 출력합니다.
*/

import java.util.Scanner;

public class VarTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int year=sc.nextInt();
		String age_type=sc.next();
		int answer=0;
		
		
		
		if(age_type.equals("Korea")) {
			answer=2030-year+1;
		}
		
		else if(age_type.equals("Year")) {
			answer=2030-year;
		}
		
		System.out.println(answer);
}

}
