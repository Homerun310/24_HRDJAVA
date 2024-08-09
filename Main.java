package day04;
import java.util.ArrayList;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//클래스 구성요소
		//필드: 객체의 데이터를 저장하는 역할을 한다.
		// 생성자: 기본 생성자, 인자 생성자
		//메소드: 객체가 수행할 동작
		
		
		House house=new House("kim", 4, "대전 동구 용운동"); 
		house.showOwner("hong");
		System.out.println("방의개수: "+house.getRoomNum(4));
		System.out.println("방의 정보: "+house.showInfo());
		house.showingInfo();
		
		//객체, 참조클래스 등을 담아놓는 배열 ArrayList
		ArrayList<House> arrlist=new ArrayList<House>();
		arrlist.add(house);
		arrlist.add(new House("강길동", 2, "대전 서구 갈마동"));
		arrlist.add(new House("이자바", 3, "대전 중구 대흥동"));
		
		for(House house1 : arrlist) {
			house1.showingInfo();
			
		}
	
		
		
		
		
	}

}



// 집 클래스 모델링
//추상화

class House{
	String ownername;
	int roomnum;
	String address;
	
	
	public House() {}
	
	
	//인자 생성자
	public House(String ownername, int roomnum, String address) {
		this.ownername=ownername;
		this.roomnum=roomnum;
		this.address=address;
	}
	
	//반환 없고(주인 이름을 매개변수로 전달 받아 이름)을 같이 출력하는 메소드 showOwner() 정의
	
	void showOwner(String ownername) {
		System.out.println("집주인: "+ownername);
	}
	
	
	//방의 갯수를 반환하는 getRoomNum() 메소드 정의
	int getRoomNum(int roomnum) {
		return roomnum;
	}
	
	
	//모든 멤버 변수의 값을 반환하는 showInfo() 메소드 정의
	String showInfo(){
		String result="집주인 이름: "+ownername+"\n"+"방 개수: "+roomnum+"\n"+"집주소: "+address;
		return result;
		
		}
	
	void showingInfo() {
		System.out.println("집주인 이름: "+ownername+"\n"+"방 개수: "+roomnum+"\n"+"집주소: "+address);
	}
	
}


















