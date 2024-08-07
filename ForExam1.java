package day02;

public class ForExam1 {

	public static void main(String[] args) {
		//for(초기식; 조건식; 증감식){ 반복 수행문 }
		
		int a;
		int b;
		int result;
		
		for(a=1; a<=9; a++) {
			
			System.out.println("##"+a+"단##");
			
			for(b=1; b<=9; b++) {
			
				result=b*a;
			
				System.out.println(a+"*"+b+"="+result);
			}
			
			System.out.println();
		}
		

	}
	
}
