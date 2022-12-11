/*

객체지향 프로그래밍 평가과제 (배점 25점)
학과: 컴퓨터전자시스템공학부
학번: 202002436
이름: 이사야

과제 주제: 한류 뉴스 안내 및 한류사랑회원 가입 및 관리 프로그램

*/

package assignment;
import java.util.*;
import java.io.File;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;



public class Main {
	
	
	public static void main(String args[]) {
		int pw=990222;
		Scanner sc= new Scanner(System.in); //스캐너 생성
		System.out.println("**********************\n\\ 한류 뉴스 안내 프로그램 /\n**********************\n");
		Map<Integer,Manage> members = new Hashtable<>(); // 7. 컬렉션 프레임워크 사용 (회원번호-회원을 저장하기 위한 객체)
		Manage mg; //3. 인터페이스 구현
		News NEWS=new News(); //뉴스 정보를 저장할 뉴스 객체 생성
		
		
		
		while (true) {
			System.out.println("\n메뉴를 선택하세요.\n\n1.한류 소식 확인\n2.한류 사랑 멤버 가입하기\n3.종료하기");
			String A=sc.next();
			try{                   // 4. 예외처리 (사용자로부터 숫자를 입력받았는지 확인하기 위해 예외처리) (모든 입력에 대한 예외처리를 해서 맨 처음 예외처리에만 주석 표시합니다.)
				Integer.parseInt(A);
			} catch(NumberFormatException e) {
				System.out.println("잘못된 입력입니다. 숫자만 입력하세요.\n");
				continue;
			}
			int A1=Integer.parseInt(A);
			
			
			
			//한류 소식 확인
			if(A1==1) {				
				System.out.println("\n뉴스 메뉴를 선택하세요.\n1.연예\n2.스포츠\n3.정치\n4.IT/과학");
				String A2=sc.next();
				try{
					Integer.parseInt(A2);
				} catch(NumberFormatException e) {
					System.out.println("잘못된 입력입니다. 초기 화면으로 돌아갑니다.\n");
					continue;
				}
				int NewsNo=Integer.parseInt(A2);
				if (NewsNo==1) {
					String Printer=NEWS.GetNews(1);
					if (Printer=="") {System.out.println("최신 뉴스가 없습니다.");}
					else{System.out.println(Printer);}
					System.out.println("\n더 많은 연예 뉴스 정보는\nhttps://entertain.naver.com/home");
				}
				else if(NewsNo==2) {
					String Printer=NEWS.GetNews(2);
					if (Printer=="") {System.out.println("최신 뉴스가 없습니다.");}
					else{System.out.println(Printer);}
					System.out.println("\n더 많은 스포츠 뉴스 정보는\nhttps://sports.news.naver.com/index");
				}
				else if(NewsNo==3) {
					String Printer=NEWS.GetNews(3);
					if (Printer=="") {System.out.println("최신 뉴스가 없습니다.");}
					else{System.out.println(Printer);}
					System.out.println("\n더 많은 정치 뉴스 정보는\nhttps://news.naver.com/main/main.naver?mode=LSD&mid=shm&sid1=100");
				}
				else if(NewsNo==4) {
					String Printer=NEWS.GetNews(4);
					if (Printer=="") {System.out.println("최신 뉴스가 없습니다.");}
					else{System.out.println(Printer);}
					System.out.println("\n더 많은 IT/과학 뉴스 정보는\nhttps://news.naver.com/main/main.naver?mode=LSD&mid=shm&sid1=105");
				}
				else {System.out.println("잘못된 입력입니다. 초기 화면으로 돌아갑니다.\n");}
			}
			
			
			
			
			//한류사랑 회원가입 (외국인과 한국인을 분류해 정보를 수집한 후 각각 Map에 저장)
			else if (A1==2) {
				System.out.println("\n한류사랑회원에 가입하시면 최신 뉴스를 이메일로 보내드립니다!!\n\n이름을 입력하세요.");
				String name = sc.next();
				System.out.println("이메일읍 입력하세요.(example@hankook.com)");
				String email = sc.next();
				System.out.println("한국인은 1, 외국인은 2를 입력하세요.");
				String A3  = sc.next();
				try{
					Integer.parseInt(A3);
				} catch(NumberFormatException e) {
					System.out.println("잘못된 입력입니다. 초기 화면으로 돌아갑니다.\n");
					continue;
				}
				int nation  = Integer.parseInt(A3);
				int MemberCode=members.size()+10000001; //한국인은 1부터 외국인은 2부터 시작하도록 회원번호 발급
				
				
				//한국인 회원가입
				if (nation==1){
					mg=new KoreanMember(name,nation,email);
					members.put(MemberCode, mg);
					}
				
				
				//외국인 회원가입
				else if (nation==2) {
					System.out.println("국적을 한글 또는 영어로 입력하여주세요.");
					String nationality = sc.next();
					System.out.println("한국에 방문한 적이 있습니까? (있으면 1,없으면 0)");
					String A4=sc.next();
					try{
						Integer.parseInt(A4);
					} catch(NumberFormatException e) {
						System.out.println("잘못된 입력입니다. 초기 화면으로 돌아갑니다.\n");
						continue;
					}
					int BeenKorea=Integer.parseInt(A4);
					if (BeenKorea!=0&&BeenKorea!=1) {
						System.out.println("잘못된 입력입니다. 초기 화면으로 돌아갑니다.\n");
						continue;
					}
					mg=new ForeignMember(name,nation,nationality,BeenKorea,email);
					MemberCode+=10000000;
					members.put(MemberCode, mg);
					}
				else {
					System.out.println("잘못된 입력입니다. 초기 화면으로 돌아갑니다.\n");
					continue;
				}
				System.out.println("축하합니다! 가입이 완료되었습니다!\n앞으로도 한류에 많은 관심 부탁드립니다!!!\n회원번호: "+MemberCode);
			}
			
			
			
			//프로그램 종료
			else if (A1==3) {
				System.out.println("종료합니다.");
				break;
			}
			
			
			
			
			//관리자 모드
			else if (A1==4) {
				
				//관리자 검증 절차
				mg=new Manager();
				System.out.println("비밀번호를 입력하세요.");
				String PWInput=sc.next();
				try{
					Integer.parseInt(PWInput);
				} catch(NumberFormatException e) {
					System.out.println("일반 사용자는 이용할 수 없는 메뉴입니다.\n");
					continue;
				}
				int Password=Integer.parseInt(PWInput);
				if (Password==pw) {mg.UpGrade();}
				Manager TestManager=(Manager) mg; //5. 다형성 강제 타입 변환
				
				
				
				//관리자 모드 진입
				if (TestManager.ReturnGrade()==ManagerGrade.이사야) {
					System.out.println("관리자 모드입니다.\n");
					System.out.println("1.회원 등급 관리\n2.회원 명단 출력\n3.뉴스 업데이트");
					String A5=sc.next();
					try{
						Integer.parseInt(A5);
					} catch(NumberFormatException e) {
						System.out.println("잘못된 입력입니다. 초기 화면으로 돌아갑니다.\n");
						continue;
					}
					int ManageMenu=Integer.parseInt(A5);
					
					
					
					//회원 등급 관리
					if (ManageMenu==1) {
						System.out.println("관리할 회원 번호를 입력하세요.");
						String A6=sc.next();
						try{
							Integer.parseInt(A6);
						} catch(NumberFormatException e) {
							System.out.println("잘못된 형식입니다. 초기 화면으로 돌아갑니다.\n");
							continue;
						}
						int FindNo=Integer.parseInt(A6);
						if(members.containsKey(FindNo)) {
							Manage Edit=members.get(FindNo);
							System.out.println("등급 상승은 1,등급 하락은 2를 입력하세요.");
							String A7=sc.next();
							try{
								Integer.parseInt(A7);
							} catch(NumberFormatException e) {
								System.out.println("잘못된 입력입니다. 초기 화면으로 돌아갑니다.\n");
								continue;
							}
							int SelectUpDown=Integer.parseInt(A7);
							if(SelectUpDown==1) {
								Edit.UpGrade();
							}
							else if (SelectUpDown==2) {
								Edit.DownGrade();
							}
							else {
								System.out.println("잘못된 입력입니다. 초기 화면으로 돌아갑니다.\n");
								continue;
							}
						}
						else {
							System.out.println("해당하는 멤버가 없습니다. 초기 화면으로 돌아갑니다.\n");
							continue;
						}
					}
					
					
					
					
					//회원 명단 출력
					//8. 파일 출력 사용
					else if (ManageMenu==2) {
						File file=new File("C:\\\\Users\\\\Owner\\\\Documents\\\\Assignment\\\\MemberList\\\\MemberList.txt");
						if(file.exists()==false) { //경로나 파일 없을 경우 생성
							try {
								new File("C:\\\\Users\\\\Owner\\\\Documents\\\\Assignment\\\\MemberList").mkdirs();
								file.createNewFile();
							}catch(Exception e){
								e.getStackTrace();
							}
						}
						try {
							OutputStream output = new FileOutputStream("C:\\\\Users\\\\Owner\\\\Documents\\\\Assignment\\\\MemberList\\\\MemberList.txt");
							String str=("회원번호      /      등급      /      이름      /      국적      /           이메일           / 한국 방문 여부(외국인)\n");
							byte[] by=str.getBytes();
						    output.write(by);
						    Set<Integer> TotalMember= members.keySet();
							for (int Membercode:TotalMember) {
								str="\n";
								Manage NowPerson=members.get(Membercode);
								Member NP=(Member) NowPerson;
								String MC=String.valueOf(Membercode);
								str+=MC+"   /       ";
								str+=NP.ReturnGrade()+"     /    ";
								str+=NP.ReturnName()+"     /    ";
								str+=NP.ReturnNationality()+"     /        ";
								str+=NP.ReturnEmail()+"     /        ";
								str+=NP.ReturnInfo();
								by=str.getBytes();
								output.write(by);	
							}
							output.close();
						} catch(Exception e){
							e.getStackTrace();
						}
					}
					
					
					
					
					//뉴스 불러오기
					//8. 파일 입력 사용
					//경로나 파일 없을 경우 생성
					else if (ManageMenu==3) {
						File SportFile=new File("C:\\\\Users\\\\Owner\\\\Documents\\\\Assignment\\\\News\\\\Sports.txt");
						if(SportFile.exists()==false) {
							try {   
								new File("C:\\\\Users\\\\Owner\\\\Documents\\\\Assignment\\\\News").mkdirs();
								SportFile.createNewFile();
							}catch(Exception e){
								e.getStackTrace();
							}
						}
						File EntertainFile=new File("C:\\\\Users\\\\Owner\\\\Documents\\\\Assignment\\\\News\\\\Entertain.txt");
						if(EntertainFile.exists()==false) {
							try {
								new File("C:\\\\Users\\\\Owner\\\\Documents\\\\Assignment\\\\News").mkdirs();
								EntertainFile.createNewFile();
							}catch(Exception e){
								e.getStackTrace();
							}
						}
						File PoliticsFile=new File("C:\\\\Users\\\\Owner\\\\Documents\\\\Assignment\\\\News\\\\Politics.txt");
						if(PoliticsFile.exists()==false) {
							try {
								new File("C:\\\\Users\\\\Owner\\\\Documents\\\\Assignment\\\\News").mkdirs();
								PoliticsFile.createNewFile();
							}catch(Exception e){
								e.getStackTrace();
							}
						}
						File ITFile=new File("C:\\\\Users\\\\Owner\\\\Documents\\\\Assignment\\\\News\\\\IT.txt");
						if(ITFile.exists()==false) {
							try {
								new File("C:\\\\Users\\\\Owner\\\\Documents\\\\Assignment\\\\News").mkdirs();
								ITFile.createNewFile();
							}catch(Exception e){
								e.getStackTrace();
							}
						}
						
						
						
						//선택한 뉴스 파일에서 뉴스를 읽어와서 뉴스 객체에 저장
						System.out.println("업데이트 할 뉴스 메뉴를 선택하세요.\n1.연예\n2.스포츠\n3.정치\n4.IT/과학");
						String A8=sc.next();
						try{
							Integer.parseInt(A8);
						} catch(NumberFormatException e) {
							System.out.println("잘못된 입력입니다. 초기 화면으로 돌아갑니다.\n");
							continue;
						}
						int UpdateMenu=Integer.parseInt(A8);
						if (UpdateMenu==1) {
							try {
								FileInputStream fileStream = new FileInputStream("C:\\\\Users\\\\Owner\\\\Documents\\\\Assignment\\\\News\\\\Entertain.txt");
								byte readBuffer[] = new byte[fileStream.available()];
								String article="";
								if(EntertainFile.length()!=0) {
									while (fileStream.read(readBuffer) != -1) {article+=(new String(readBuffer,"UTF-8"));};
						        	NEWS.InputNews(2, article);
						        	fileStream.close();
								}
							}
							catch(Exception e) {
								System.out.println(e.getMessage());
							}
						}
						else if (UpdateMenu==2) {
							try {
								FileInputStream fileStream = new FileInputStream("C:\\\\Users\\\\Owner\\\\Documents\\\\Assignment\\\\News\\\\Sports.txt");
								byte readBuffer[] = new byte[fileStream.available()];
								String article="";
								if(SportFile.length()!=0) {
									while (fileStream.read(readBuffer) != -1) {article+=(new String(readBuffer,"UTF-8"));};
						        	NEWS.InputNews(2, article);
						        	fileStream.close();
								}
							}
							catch(Exception e) {
								System.out.println(e.getMessage());
							}
						}
						else if (UpdateMenu==3) {
							try {
								FileInputStream fileStream = new FileInputStream("C:\\\\Users\\\\Owner\\\\Documents\\\\Assignment\\\\News\\\\Politics.txt");
								byte readBuffer[] = new byte[fileStream.available()];
								String article="";
								if(PoliticsFile.length()!=0) {
									while (fileStream.read(readBuffer) != -1) {article+=(new String(readBuffer,"UTF-8"));};
						        	NEWS.InputNews(2, article);
						        	fileStream.close();
								}
							}
							catch(Exception e) {
								System.out.println(e.getMessage());
							}
						}
						else if (UpdateMenu==4) {
							try {
								FileInputStream fileStream = new FileInputStream("C:\\\\Users\\\\Owner\\\\Documents\\\\Assignment\\\\News\\\\IT.txt");
								byte readBuffer[] = new byte[fileStream.available()];
								String article="";
								if(ITFile.length()!=0) {
									while (fileStream.read(readBuffer) != -1) {article+=(new String(readBuffer,"UTF-8"));};
						        	NEWS.InputNews(2, article);
						        	fileStream.close();
								}
							}
							catch(Exception e) {
								System.out.println(e.getMessage());
							}
						}
						else {
							System.out.println("없는 메뉴입니다. 초기 화면으로 돌아갑니다.\n");
							continue;
						}
	
						
					}
					else {
						System.out.println("잘못된 입력입니다. 초기 화면으로 돌아갑니다.\n");
						continue;
					}
				}
				else {
					mg.DownGrade();
					System.out.println("일반 사용자는 이용할 수 없는 메뉴입니다.\n");
					}
				
			}
			else {
				System.out.println("없는 메뉴입니다. 다시 입력하세요.\n");
				continue;
			}
		
		}
	
	sc.close();
	}
	
}
