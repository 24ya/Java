package assignment;

public class Member implements Manage { //4. 다형성 인터페이스(Member 구현 클래스와 Manager 구현 클래스로 다형성 실현)
	String[] grades= {"신규","인헌","화랑","충무","을지","태극"}; //6. 참조타입 배열 사용
	String Name;
	int NationNo;
	String Nationality;
	String Email;
	int Grade=0;
	
	public Member(String Name,int NationNo,String Email) {
		this.Name=Name;
		this.NationNo=NationNo;
		this.Email=Email;
	}
	

	public void UpGrade() {
		if (this.Grade<5) {this.Grade+=1; System.out.println(grades[this.Grade]+"등급으로 승급했습니다.");}
		else{System.out.println("이미 최고등급입니다.");}
	}

	public void DownGrade() {
		if (this.Grade>0) {this.Grade-=1; System.out.println(grades[this.Grade]+"등급으로 강등했습니다.");}
		else{System.out.println("이미 최하등급입니다.");}
	}
	
	public String ReturnGrade() {return grades[this.Grade];}
	public String ReturnName() {return this.Name;}
	public String ReturnNationality() {return this.Nationality;}
	public String ReturnEmail() {return this.Email;}
	public String ReturnInfo() {return"-";}

}