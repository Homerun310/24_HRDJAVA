package day03;

public class ArrayCreateByVlaueExample {

	public static void main(String[] args) {
		// 문자열 데이터 4개를 저장할 배열 선언 및 초기화
		String [] season= {"Spring", "Summer", "Fall", "Winter"};
		
		
		for(int i=0; i<=3; i++) {
			System.out.println(season[i]);
		}
		
		season[0]="여름";
		
		for(int i=0; i<=3; i++) {
			System.out.println(season[i]);
		}
		
		
		//이름 문자열 3개를 저장할 배열 선언 및 초기화
		
		String[] names=null;
		
		names=new String[] {"염희균", "김자바", "홍길동"};
		
		
	}

}
