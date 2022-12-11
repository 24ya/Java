package assignment;

public class Manager implements Manage { //4. 다형성 인터페이스(Member 구현 클래스와 Manager 구현 클래스로 다형성 실현)
	ManagerGrade Grade =ManagerGrade.일반;
	public void UpGrade() {this.Grade=ManagerGrade.이사야;}
	public void DownGrade() {this.Grade=ManagerGrade.일반;}
	public ManagerGrade ReturnGrade() {return this.Grade;}
}
