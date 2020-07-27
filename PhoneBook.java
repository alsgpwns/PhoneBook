import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;

public class PhoneBook {

	private static PhoneBook pb;
	private HashSet<PhoneInfo> set;
	private Iterator<PhoneInfo> itr;
	private ObjectInputStream objInStream;
	private ObjectOutputStream objOutStream;

	private PhoneBook() 
	{
		loadData();
	}

	public void loadData()
	{
		try {
			objInStream = new ObjectInputStream(new FileInputStream("phoneInfo.data"));
		} catch (FileNotFoundException e) {
			set = new HashSet<PhoneInfo>();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			if(objInStream != null)
				set = (HashSet<PhoneInfo>)objInStream.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			if(objInStream != null)
				objInStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static PhoneBook getPhoneBook()
	{
		if(pb==null)
			pb = new PhoneBook();
		return pb;
	}

	public boolean insertPhoneInfo(PhoneInfo phoneInfo)
	{		
		return set.add(phoneInfo);
	}

	public boolean searchPhoneInfoByName(String name)
	{
		PhoneInfo pInfo = null;
		itr = set.iterator();
		boolean result = false;

		while(itr.hasNext())
		{			
			pInfo = itr.next();
			if(pInfo.getName().equals(name))
			{
				pInfo.printCurrentState();
				result = true;
			}
		}

		return result;
	}

	public boolean deletePhoneInfoByPhoneNumber(String phoneNumber)
	{
		PhoneInfo pInfo = null;
		itr = set.iterator();

		while(itr.hasNext())
		{			
			pInfo = itr.next();
			if(pInfo.getPhoneNumber().equals(phoneNumber))
			{
				itr.remove();
				return true;
			}
		}
		return false;
	}

	public void printAllPhoneInfo()
	{
		itr = set.iterator();
		while(itr.hasNext())
		{
			itr.next().printCurrentState();
		}
	}

	public void quitProgram() {
		if(set.size() == 0) return;
		
		try {
			objOutStream = new ObjectOutputStream(new FileOutputStream("phoneInfo.data"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			objOutStream.writeObject(set);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			objOutStream.close();
		} catch (IOException e1) {
			System.out.println("���� �ݱ� ����");
			e1.printStackTrace();
		}
	}
}