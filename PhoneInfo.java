import java.util.Scanner;

class PhoneInfo
{
	private String name, phoneNumber,birthday;

	public void PhoneInfo(String name, String phoneNumber, String birthday )
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;

	}

	/*public Info(String name, String phoneNumber, String birthday )
	{
		this(name, phoneNumber, null);
	}*/

	public void set()
	{

		Scanner sc=new Scanner(System.in);


		System.out.print("�̸�: ");
		String name= sc.nextLine();

		System.out.print("��ȭ��ȣ: ");
		String phoneNumber= sc.nextLine();

		System.out.print("�������: ");
		String birthday= sc.nextLine();

		PhoneInfo(name, phoneNumber, birthday);
	}

	
	public void result()
	{
		System.out.println("�̸�: " +name+ ", ��ȭ��ȣ: " +phoneNumber+ ", �������"+birthday);
	}

	

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);

		PhoneInfo p1 = new PhoneInfo();
		p1.set();
		p1.result();
	}

}