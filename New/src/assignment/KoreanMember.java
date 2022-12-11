package assignment;

public class KoreanMember extends Member { // 2.클래스 상속 & 5.다형성 상속(한국인 멤버,외국인 멤버 각각 Member class 상속으로 다형성 구현)
	public KoreanMember(String Name,int NationNo,String Email) {
		super(Name,NationNo,Email);
		this.Nationality="Korea";
	}
}