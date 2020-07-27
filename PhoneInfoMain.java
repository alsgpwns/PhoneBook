import java.util.Scanner;

public class PhoneInfoMain
{
	public static void main(String[] args)
	{
		PhoneInfo info = null;
		Scanner sc = new Scanner(System.in);
		int menu = 0;
		String name = null, phone = null, birth = null;
		PhoneInfo[] infoArr = new PhoneInfo[100];
		int cnt = 0;
		boolean sflag = false;

		while(true)
		{
			System.out.println("�����ϼ���.");
			System.out.println("1. ������ �Է�");
			System.out.println("2. ������ �˻�");
			System.out.println("3. ������ ����");
			System.out.println("4. ��� ������ ����");
			System.out.println("5. ���α׷� ����");
			System.out.print("���� : ");
			menu = sc.nextInt();		// 1 ����
			sc.nextLine();		// ���ۿ� �ִ� ����Ű ���� ���ش�.
			switch(menu)
			{
			case 1:
				System.out.println("������ �Է��� �����մϴ�.");
				System.out.print("�̸� : ");
				name = sc.nextLine();
				System.out.print("��ȭ��ȣ : ");
				phone = sc.nextLine();
				System.out.print("������� : ");
				birth = sc.nextLine();
				info = new PhoneInfo(name, phone, birth);
				infoArr[cnt++] = info;
				System.out.println("������ �Է��� �Ϸ�Ǿ����ϴ�.");
				break;
			case 2:
				System.out.println("�˻��Ͻð��� �ϴ� �̸��� �Է��ϼ���.");
				name = sc.nextLine();
				for(int i=0;i<cnt;i++)
				{
					if(name.compareTo(infoArr[i].getName()) == 0)
					{
						infoArr[i].showPhoneInfo();
						sflag = true;
					}
				}
				if(!sflag) System.out.println("�˻��Ͻð��� �ϴ� ����� �����ϴ�.");
				sflag = false;
				break;
			case 3:
				break;
			case 4:
				for(int i=0;i<cnt;i++)
					infoArr[i].showPhoneInfo();
				break;
			case 5:
				System.out.println("���α׷��� �����մϴ�.");
				return;
			default:	
				System.out.println("�߸� �����ϼ̽��ϴ�.");
			}
		}
	}
}
				











