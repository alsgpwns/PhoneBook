
public class PhoneBook {
	
	private static PhoneBook pb;
	private PhoneInfo[] pInfoArr;
	private int numOfPhoneInfo;
	
	private PhoneBook(int size) 
	{
		pInfoArr = new PhoneInfo[size];
	}
	
	public static PhoneBook getPhoneBook(int size)
	{
		if(pb==null)
			pb = new PhoneBook(size);
		return pb;
	}
	
	public boolean insertPhoneInfo(String name, String phoneNumber, String birthday)
	{
		if(numOfPhoneInfo >= pInfoArr.length)
			return false;
		PhoneInfo pInfo = new PhoneInfo(name, phoneNumber, birthday);
		pInfoArr[numOfPhoneInfo++] = pInfo;
		return true;
	}
	
	public boolean searchPhoneInfoByName(String name)
	{
		boolean result = false;
		for(int i=0;i<numOfPhoneInfo;i++)
		{
			if( name.compareTo(pInfoArr[i].getName()) == 0 )
			{
				pInfoArr[i].printCurrentState();
				result = true;
			}
		}
		return result;
	}
	
	public int searchPhoneInfoByPhoneNumber(String phoneNumber)
	{
		for(int i=0;i<numOfPhoneInfo;i++)
		{
			if( phoneNumber.compareTo(pInfoArr[i].getPhoneNumber()) == 0 )
			{
				return i;
			}
		}
		
		return -1;
	}
	
	public boolean deletePhoneInfoByPhoneNumber(String phoneNumber)
	{
		boolean deleteResult = false;
		int searchResult = searchPhoneInfoByPhoneNumber(phoneNumber);
		if( searchResult != -1 )
		{
			for(int i=searchResult;i<numOfPhoneInfo-1;i++)
				pInfoArr[i] = pInfoArr[i+1];
			
			pInfoArr[numOfPhoneInfo-1] = null;
			deleteResult = true;
			numOfPhoneInfo--;
		}
		
		return deleteResult;
	}
	
	public void printAllPhoneInfo()
	{
		for(int i=0;i<numOfPhoneInfo;i++)
			pInfoArr[i].printCurrentState();
		System.out.println();
	}
}