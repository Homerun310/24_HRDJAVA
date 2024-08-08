package day03;

public class ArrayCreateByVlaueExample3 {

	public static void main(String[] args) {
	// 2차원 배열
		
		int [][] scores=new int[2][3];
		
		scores[0][0]=90;
		scores[0][1]=50;
		scores[0][2]=80;

		scores[1][0]=40;
		scores[1][1]=60;
		scores[1][2]=70;
		
		int sum=0;
		double avg=0.0;
		
		
		for(int i=0; i<2; i++) {
			for(int j=0; j<3; j++) {
				sum=sum+scores[i][j];
			}
			
		}
		avg=sum/6;
		
		System.out.println("총점: "+sum+"평균: "+avg);
		
	}

}
