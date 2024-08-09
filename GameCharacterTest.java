package day04;

import java.util.ArrayList;
/**
 * 상속을 이용하여 다음 요구사항(중복코드)을 해결하시오
 * 게임캐릭터의 초기 작업을 위한 초심자(Novice)클래스와
 * 초심자의 다음 직업인 마법사 클래스를 다음과 같이 설계하였다고 가정
 * Wizzard 클래스가 Novice 클래스의 모든 필드와 메소드를 가지고 있고
 * 추가로 마력필드 mp와 불 공격 메소드 fireball()이 더해져 있음
 */

class Knight extends Novice{
	int stamina;
	
	public void slash() {
		System.out.printf("%s(ST: %d)의 슬래시!\n",name, stamina);
	}
}


public class GameCharacterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		Wizzard wiz=new Wizzard();
		wiz.name="간달프";
		wiz.hp=100;
		wiz.mp=100;
		
		
		Knight king=new Knight(); 
		king.name="킹";
		king.hp=200;
		king.stamina=100;
		
		wiz.fireball();
		wiz.punch();
		
		king.slash();
		king.punch();
			
		ArrayList<Novice> gamelist=new ArrayList<Novice>();
		gamelist.add(wiz);
		gamelist.add(king);
		
		for(Novice n: gamelist) {
			
			if(n instanceof Wizzard) {
				((Wizzard)n).fireball();
			}
			if(n instanceof Knight) { 
				((Knight)n).slash();
			}
		}
	}

}
