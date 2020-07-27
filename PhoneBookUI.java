import java.util.Scanner;

public class PhoneBookUI {
	private PhoneBook pb;
	public static Scanner sc = new Scanner(System.in);
	
	public PhoneBookUI()
	{
		this.pb = PhoneBook.getPhoneBook(100);
	}
	
	public void printMenu()
	{
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 모든 데이터 보기");
		System.out.println("5. 프로그램 종료");
		System.out.println("선택 : ");
	}
	
	public void inputPhoneInfo()
	{
		String name, phoneNumber, birthday;
		boolean result;
		
		System.out.println("데이터 입력을 시작합니다.");
		System.out.println("이름 : ");
		name = sc.nextLine();
		System.out.println("전화번호 : ");
		phoneNumber = sc.nextLine();
		System.out.println("생년월일 : ");
		birthday = sc.nextLine();		
		result = pb.insertPhoneInfo(name, phoneNumber, birthday);
		if(result == false)
			System.out.println("더이상 데이터를 저장할 수 없습니다.");
		else System.out.println("데이터 입력이 완료되었습니다.");
	}
	
	public void searchPhoneInfoByName()
	{
		String name;
		System.out.println("검색하시고자 하는 이름을 입력해 주세요.");
		name = sc.nextLine();
		System.out.println("사용자 검색을 시작합니다.");
		if( !pb.searchPhoneInfoByName(name)) System.out.println("찾으시는 사용자가 없습니다.");
	}
	
	public void deletePhoneInfoByPhoneNumber()
	{
		String phoneNumber;
		System.out.println("삭제하시고자 하는 전화번호를 입력해 주세요.");
		phoneNumber = sc.nextLine();
		boolean result = pb.deletePhoneInfoByPhoneNumber(phoneNumber);
		if(result) System.out.println("삭제가 완료되었습니다.");
		else System.out.println("삭제하시고자 하는 전화번호 정보가 없습니다.");
	}
	
	public void printAllPhoneInfo()
	{
		System.out.println("모든 사용자 정보를 출력합니다.");
		pb.printAllPhoneInfo();
	}
	
	public void quitProgram()
	{
		System.out.println("프로그램을 종료합니다.");
		sc.close();
	}
}