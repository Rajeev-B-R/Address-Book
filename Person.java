import java.util.*;

class Person 
{

	private String name,address,state,city;
	private int zipCode;
	private long phnNmbr;

	Person(String name,long phnNmbr, String address, String city, String state, int zipCode)
	{

		this.name=name;
		this.phnNmbr=phnNmbr;
		this.address=address;
		this.city=city;
		this.state=state;
		this.zipCode=zipCode;
	}

	public static Comparator<Person> personzipCode = new Comparator<Person>() 
	{
		public int compare(Person person1, Person person2) 
		{
	   		return person1.getZipCode()-person2.getZipCode();
		}
	};

	public static Comparator<Person> personName = new Comparator<Person>()
	{
		public int compare(Person person1, Person person2)
		{
		   return person1.getName().toUpperCase().compareTo(person2.getName().toUpperCase());
		}
	};

	public void setName(String name)
	{
		this.name=name;
	}
	
	public void setAddress(String address)
	{
		this.address=address;
	}
	
	public void setState(String state)
	{
		this.state=state;
	}
	
	public void setCity(String city)
	{
		this.city=city;
	}
	
	public void setPhnNmbr(long phnNmbr)
	{
		this.phnNmbr=phnNmbr;
	}
	
	public void setZipCode(int zipCode)
	{
		this.zipCode=zipCode;
	}
	
	public int getZipCode()
	{
		return zipCode;
	}
	public long getPhnNmbr()
	{
		return phnNmbr;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getState()
	{
		return state;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public String toString()
	{
		return "\t\tName: "+name+"\n\t\tAddress: "+address+"\n\t\tCity: "+city+"\n\t\tState: "+state+"\n\t\tPin Code: "+zipCode+"\n\t\tMobile No: "+phnNmbr;
	}
}

class AddressBook 
{
	static Scanner s = new Scanner(System.in);
	
	static void showMenu()
	{
		System.out.println("\n\t1. Add Person\n\t2. Edit Person\n\t3. Delete Person\n\t4. View Person\n\t5. View Address Book\n\t6. View : sorted by Zip\n\t7. View : sorted by Name\n\t8. Exit\n\n");
	}
	
	static Person searchPerson(ArrayList<Person> adrsbk)
	{

		System.out.println("Enter phone number of the person : \t");
		long number=Long.parseLong(s.nextLine());
		
		for(Person person : adrsbk)
		{
			if(person.getPhnNmbr()==number)
				return person;
		}

		return null;
	}

	static int getChoice()
	{
		System.out.println("Enter a choice : \t");
		int choice = Integer.parseInt(s.nextLine());
		return choice;
	}
	
	static Person AddPerson()
	{
		String name,address,state,city;
		int zipCode;
		long phnNmbr;
		
		System.out.println("Enter Name : \t");
		name=s.nextLine();
		
		System.out.println("Enter Phone Number : \t");
		phnNmbr=Long.parseLong(s.nextLine());
		
		System.out.println("Enter Address : \t");
		address=s.nextLine();
		
		System.out.println("Enter City : \t");
		city=s.nextLine();
		
		System.out.println("Enter State : \t");
		state=s.nextLine();
		
		System.out.println("Enter Pin Code : \t");
		zipCode=Integer.parseInt(s.nextLine());

		return new Person(name,phnNmbr,address,city,state,zipCode);
	}

	static void editPerson(ArrayList<Person> adrsbk)
	{
		String name,address,state,city;
		int zipCode;
		long phnNmbr;
		
		Person person = searchPerson(adrsbk);
		if(person!=null)
		{
			System.out.println("Enter Name : \t");
			name=s.nextLine();
			
			System.out.println("Enter Phone Number : \t");
			phnNmbr=Long.parseLong(s.nextLine());
			
			System.out.println("Enter Address : \t");
			address=s.nextLine();
			
			System.out.println("Enter City : \t");
			city=s.nextLine();
			
			System.out.println("Enter State : \t");
			state=s.nextLine();
			
			System.out.println("Enter Pin Code : \t");
			zipCode=Integer.parseInt(s.nextLine());
			
			person.setName(name);
			person.setPhnNmbr(phnNmbr);
			person.setAddress(address);
			person.setCity(city);
			person.setState(state);
			person.setZipCode(zipCode);
		
			System.out.println("\n\t*********Edited*********\n");
		}
		else
			System.out.println("\n\t*********No such entry exists*********\n");

	}

	static void deletePerson(ArrayList<Person> adrsbk)
	{
		boolean flag=false;
		System.out.println("Enter phone number of the person to be deleted : \t");
		long number=Long.parseLong(s.nextLine());
		Iterator itr = adrsbk.iterator(); 
        while (itr.hasNext()) 
        { 
            Person obj = (Person)itr.next(); 
            if (obj.getPhnNmbr() == number) 
            {   
            	itr.remove();
            	flag=true;
            	break;
            } 
        } 
        if(flag)
	        System.out.println("\n\t*********Deleted*********\n");
		else
			System.out.println("\n\t*********No such entry exists*********\n");	
	}
	
	static void viewPerson(ArrayList<Person> adrsbk)
	{
		Person search = searchPerson(adrsbk);
		if(search!=null)
			System.out.println(search);
		else
			System.out.println("\n\t*********No such entry exists*********\n");

	}
	
	static void viewAll(ArrayList<Person> adrsbk)
	{
		if(adrsbk.size()==0)
		{
			System.out.println("\n\t*********Address book is empty*********");
			return ;
		}
		for(Person person : adrsbk)
		{
			System.out.println("\n"+person+"\n");
		}	
	}

	public static void main(String[] args)
	{	
		ArrayList<Person> addressBook = new ArrayList<>();
		
		while(true)
		{
			System.out.println("\n\n\t****************************");
			System.out.println("\t\tAddress Book");
			System.out.println("\t****************************\n");
			showMenu();
			int choice=getChoice();
		
			switch(choice)
			{
				case 1: addressBook.add(AddPerson());
						break;
				case 2:	editPerson(addressBook);
						break;
				case 3: deletePerson(addressBook);
						break;
				case 4:	viewPerson(addressBook);
						break;
				case 5: viewAll(addressBook);
						break;
				case 6: Collections.sort(addressBook, Person.personzipCode);
						viewAll(addressBook);
						break;
				case 7: Collections.sort(addressBook, Person.personName);
						viewAll(addressBook);
						break;
				case 8: System.exit(0);
						break;
				default: System.out.println("Invalid Choice!");
						break;
			}
		}
	}
}
