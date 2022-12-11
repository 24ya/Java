package assignment;

public class ForeignMember extends Member { // 2.클래스 상속 & 5.다형성 상속(한국인 멤버,외국인 멤버 각각 Member class 상속으로 다형성 구현)
	int BeenKorea;
	public ForeignMember(String Name,int NationNo,String Nationality,int BeenKorea,String Email) {
		super(Name,NationNo,Email);
		this.Nationality=Nationality;
		this.BeenKorea=BeenKorea;
	}
	@Override
	public String ReturnInfo(){
		if(this.BeenKorea==1) {return "O";}
		else {return "X";}
		}
}