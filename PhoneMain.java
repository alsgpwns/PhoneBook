import java.util.Scanner;

public class PhoneMain {

	private static final int INSERT_PHONE_INFO=1; 		// 상수로 준 이유 : 가독성을 높이기 위해서
	private static final int SEARCH_PHONE_INFO=2;
	private static final int DELETE_PHONE_INFO=3;
	private static final int SHOW_ALL_PHONE_INFO=4;
	private static final int QUIT_PHONE_INFO=5;
	
	public static void main(String[] args) {
		
		int menu=0;		
		PhoneBookUI pbUI = new PhoneBookUI();
		Scanner sc = PhoneBookUI.sc;
		
		while(true)
		{
			pbUI.printMenu();
			menu = sc.nextInt();
			sc.nextLine();
			switch(menu)
			{
			case INSERT_PHONE_INFO:
				pbUI.inputPhoneInfo();
				break;
			case SEARCH_PHONE_INFO:
				pbUI.searchPhoneInfoByName();
				break;
			case DELETE_PHONE_INFO:
				pbUI.deletePhoneInfoByPhoneNumber();
				break;
			case SHOW_ALL_PHONE_INFO:
				pbUI.printAllPhoneInfo();
				break;
			case QUIT_PHONE_INFO:
				pbUI.quitProgram();
				return;				
			}
		}
	}
}