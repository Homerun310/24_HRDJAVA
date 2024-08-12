package day05;
import java.util.ArrayList;
import java.util.Scanner;
public class SchoolApp {

	public static void main(String[] args) {
		
		Person person;
		ArrayList<Person> personlist=new ArrayList<Person>();
		person=new Student("20213","자바", "홍길동",20);
		personlist.add(person);
		personlist.add(new Staff("20213","HRD", "홍길동",20));
		personlist.add(new Teacher("20213","네트워크", "홍교사",20));
		/*
		for(Person p: personlist) {
			
				p.printAll();
			if(p instanceof Student)
				System.out.println(((Student)p).getId());
			else if(p instanceof Teacher) {
				System.out.println(((Teacher)p).getId());
			}
		}
		
		*/
		
		
		
		
	}

}
