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
		System.out.println("�����ϼ���...");
		System.out.println("1. ������ �Է�");
		System.out.println("2. ������ �˻�");
		System.out.println("3. ������ ����");
		System.out.println("4. ��� ������ ����");
		System.out.println("5. ���α׷� ����");
		System.out.println("���� : ");
	}
	
	public void inputPhoneInfo()
	{
		String name, phoneNumber, birthday;
		boolean result;
		
		System.out.println("������ �Է��� �����մϴ�.");
		System.out.println("�̸� : ");
		name = sc.nextLine();
		System.out.println("��ȭ��ȣ : ");
		phoneNumber = sc.nextLine();
		System.out.println("������� : ");
		birthday = sc.nextLine();		
		result = pb.insertPhoneInfo(name, phoneNumber, birthday);
		if(result == false)
			System.out.println("���̻� �����͸� ������ �� �����ϴ�.");
		else System.out.println("������ �Է��� �Ϸ�Ǿ����ϴ�.");
	}
	
	public void searchPhoneInfoByName()
	{
		String name;
		System.out.println("�˻��Ͻð��� �ϴ� �̸��� �Է��� �ּ���.");
		name = sc.nextLine();
		System.out.println("����� �˻��� �����մϴ�.");
		if( !pb.searchPhoneInfoByName(name)) System.out.println("ã���ô� ����ڰ� �����ϴ�.");
	}
	
	public void deletePhoneInfoByPhoneNumber()
	{
		String phoneNumber;
		System.out.println("�����Ͻð��� �ϴ� ��ȭ��ȣ�� �Է��� �ּ���.");
		phoneNumber = sc.nextLine();
		boolean result = pb.deletePhoneInfoByPhoneNumber(phoneNumber);
		if(result) System.out.println("������ �Ϸ�Ǿ����ϴ�.");
		else System.out.println("�����Ͻð��� �ϴ� ��ȭ��ȣ ������ �����ϴ�.");
	}
	
	public void printAllPhoneInfo()
	{
		System.out.println("��� ����� ������ ����մϴ�.");
		pb.printAllPhoneInfo();
	}
	
	public void quitProgram()
	{
		System.out.println("���α׷��� �����մϴ�.");
		sc.close();
	}
}