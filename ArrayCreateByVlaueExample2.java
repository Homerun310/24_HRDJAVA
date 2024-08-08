package day03;

public class ArrayCreateByVlaueExample2 {

	public static void main(String[] args) {
		
	//2차원 배열 생성
		int[][] scores = {{80, 90, 96},{76, 88}};
		
		
	//배열의 길이
	System.out.println("1차원 배열 길이(반의 수): "+ scores.length);
	System.out.println("2차원 배열 길이(첫 번째 반의 학생 수): " +scores[0].length );
	System.out.println("2차원 배열 길이(두 번째 반의 학생 수): "+ scores[1].length);
	
	//첫번째 반의 세번째 학생 점수 읽기
	System.out.println("scores[0][2]: "+ scores[0][2]);
	
	//두번째 반의 두번째 학생 점수 읽기
	System.out.println("scores[1][1]: "+scores[1][1]);
	
	//첫번째 반의 평균점수 구하기
	int class1sum=0;
	for(int i=0; i<scores[0].length; i++) {
		class1sum +=scores[0][i];
	}
	double class1avg=(double)class1sum/scores[0].length;
	System.out.println("첫번째 반의 평균점수: "+ class1avg);
	
	//두번째 반의 평균점수 구하기
	int class2sum=0;
	for(int i=0; i<scores[1].length; i++) {
		class2sum +=scores[1][i];
	}
	double class2avg=(double)class2sum/scores[1].length;
	System.out.println("두번째 반의 평균점수: "+ class2avg);
	
	//전체 학생의 평균 점수 구하기
	int totalstudent=0;
	int totalsum=0;
	for(int i=0; i<scores.length; i++) {  //반의 수만큼 반복
		totalstudent +=scores[i].length; //반의 학생수 합산
		for(int k=0; k<scores[i].length; k++) {	//해당 반의 학생 수만큼 반복
			totalsum += scores[i][k];			//학생 점수 합산
		}
		
	double totalavg=(double)totalsum/totalstudent;
	System.out.println("전체 학생의 평균점수: "+ totalavg);
	}
	
		
	}

}
