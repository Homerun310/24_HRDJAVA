package day04;

public class Wizzard extends Novice{
	int mp;
	
	public void fireball() {
		System.out.printf("%s(MP: %d)의 불공격:\n",name,mp);
	}
}
