package assignment;

public class News {
	String[] News={"","","",""}; //6. 참조 타입 배열 사용
	public String GetNews(int N) {
		return News[N-1];
	}
	public void InputNews(int N,String write) {
		this.News[N-1]=write;
	}
}
