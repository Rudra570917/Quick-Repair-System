import java.util.*;
	class Main{
		static int grossIncome;
		static	User u[]=new User[1];
		static	Technician[] t=new Technician[12];
		public static void main(String []args)
		{
		Scanner sc=new Scanner(System.in);
			u[0]=new User();
			for (int i=0;i<12;i++)
			{
				t[i]=new Technician();
			}
			Algorithm A=new Algorithm();
			Technician.TechAllDetails();
		while(true)	
		{
			boolean a=true;
			int click=0;
			while(a)
			{
				System.out.println("+------------------------+");
				System.out.println("|1.User Interface        |");
				System.out.println("|------------------------|");
				System.out.println("|2.Technician Interface  |");
				System.out.println("|------------------------|");
				System.out.println("|3.Company Dashboard     |");
				System.out.println("+------------------------+");
				click=sc.nextInt();
				if(click<0 && click>4)
				{
					System.out.println("invalid input");
					a=true;
				}
				else
				{
					a=false;
				}
			}
			if(click==1)
			{
				System.out.println("     +----------------------------------------+");
				System.out.println("     |    WELCOME TO QUICK REPAIR SERVICE     |");
				System.out.println("     +----------------------------------------+");
				int IN=User.UserNumName();
				int al=A.AlgoUser(IN);
				if(al==2)
				{
				continue;
				}
			}
			if(click==2)
			{
				boolean ab=true;
				while(ab)
				{
					System.out.println("+--------------+");
					System.out.println("|  1.Signin    |");
					System.out.println("|--------------|");
					System.out.println("|  2.Signup    |");   
					System.out.println("+--------------+");
					int call=sc.nextInt();
					if(call==1)
					{
						Technician.Signin();
						ab=false;
					}
					else if (call==2)
					{
						Technician.Signup();
						ab=false;
					}
					else
					{
						System.out.println("invalid input");
						System.out.println("!!!!!!!!!!!!!");
						ab=true;
					}
				}
			}
			if(click==3)
			{
				Company();
			}
		}
		}
		static void Company()
		{
			Scanner sc=new Scanner(System.in);
			Algorithm A=new Algorithm();
			distance d=new distance();
			System.out.println("+--------------------------------------------------------------------------+");
			System.out.println("     Gross Income = "+ Main.grossIncome);
			System.out.println("+--------------------------------------------------------------------------+");
			System.out.println("    Total user = "+ Main.u.length);
			System.out.println("    Repeat user = "+User.RepearUser);
			System.out.println("+--------------------------------------------------------------------------+");
			System.out.println("    Total Technician = "+ Main.t.length);
			System.out.println("+--------------------------------------------------------------------------+");
			System.out.println("    Total Location Where We Quick Repair Avaliable = "+ d.loc.length);
			System.out.println("    Total things  = "+ d.Things.length);
			System.out.println("+--------------------------------------------------------------------------+");
			for(int i=0;i<d.Things.length;i++)
			{
				int[] temp;
				temp=A.search(i+1);
				System.out.println("  Total Technician of "+d.Things[i]+" is ="+ temp.length);
			}
			System.out.println("+--------------------------------------------------------------------------+");
			System.out.println("press enter to exit");
			sc.nextLine();
		}
	}
class User extends Main
	{
		static int RepearUser=0;
		int repeatObj=1;
		static int count=0;
		String name;
		String number;
		String Address;
		int location;
		Scanner sc=new Scanner(System.in);

		static void ADDIN()
		{
			User newu[]=new User[u.length+1];
			newu[u.length]=new User();
			for(int i=0;i<u.length;i++)
			{
				newu[i]=new User();
				newu[i]=u[i];
			}
			 u=newu;
		}
		static int UserNumName()
		{
			Scanner sc=new Scanner(System.in);
			int index=0;
			String num="";
			boolean b=true;
			System.out.println("+--------------------------------------------------------------------------+");
			System.out.print("Enter your mobile number:- ");
			do
			{
				num=sc.nextLine();
				for(int j=0;j<num.length();j++)
				{   
					if(!(num.charAt(j)>='0' && num.charAt(j)<='9' && num.length()==10 && num.charAt(0)>='6' && num.charAt(0)<='9'))
					{
						b=true;
						System.out.print("  invalid! Try again:-");
						break;
					}
					else 
					{
					b=false;
					}
				}
			}while (b);
			boolean check=true;
			count++;
			for (int i=0;i<u.length;i++)
			{
				if(num.equals(u[i].number))
				{
					System.out.println("+-----------------------------------------+");
					System.out.println("your name is "+u[i].name);
					System.out.println("+-----------------------------------------+");
					if(u[i].repeatObj==2)
					{
						u[i].repeatObj++;
					}
					if(u[i].repeatObj==1)
					{
						User.RepearUser++;
						u[i].repeatObj++;
					}
					index=i;
					check=false;
					break;
				}
			}
			if(check)
			{
				if(count!=1)
				{
				ADDIN();
				}
				u[u.length-1].number=num;
				u[u.length-1].signup();
				index=u.length-1;
			}
			return index;
		}
		void signup()
		{
			boolean a;
			System.out.println("+------------------------------------+");
			System.out.print("Enter your full name:- ");
			do
			{
				name=sc.nextLine();
				a=true;
			for(int i=0;i<name.length();i++)
			{
				char c=name.charAt(i);
				if(!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || c == ' '))
				{
					a=false;    
					break;
				}
			}
			if(!a)
			{
				System.out.print("Please! Enter valid name:-");
			}
			}while(!a);
		}
	}
class Algorithm extends Main{
		Scanner sc=new Scanner(System.in);
		distance d=new distance();
		int thing;

		void UserInput(User u)
		{
			System.out.println("+------------------------------------------------+");
			System.out.println("|     Select which thing you wants to repair     |");
			System.out.println("+------------------------------------------------+");
			for(int i=0;i<d.Things.length;i++)
			{
				System.out.println((i+1)+"."+d.Things[i]);
			}
			System.out.println("+--------------------------------------------------------------------------+");
			boolean a=true;
		while(a)
		{
			thing=sc.nextInt();
			if(thing>10 || thing<1)
			{
				a=true;
				System.out.println("   ! Enter vaild input:");
			}
			else
			{
				a=false;
			}
		}
		if(u.location<=d.locname.length && u.location>0)
		{
			System.out.println("+--------------------------------------------------------------------------+");
			System.out.println("your area is "+d.locname[u.location-1]);
			System.out.println("your Address "+u.Address);
			System.out.println("+--------------------------------------------------------------------------+");
			System.out.println("1.Continue");
			System.out.println("2.Change Address");
			System.out.println("+--------------------------------------------------------------------------+");
			int temp=sc.nextInt();
			if(temp==2)
			{
				u.location=0;
			}
		}
		if(u.location==0)
		{
			System.out.println("+--------------------------------------------------------------------------+");
			System.out.println(" select your location area");
			System.out.println("+--------------------------------------------------------------------------+");
		for(int i=0;i<d.locname.length;i++)
		{
			System.out.println((i+1)+"."+d.locname[i]);
		}
		boolean b=true;
		while(b)
		{
			u.location=sc.nextInt();
		if(u.location>d.locname.length || u.location<1)
		{
			b=true;
			System.out.println("Enter vaild input:");
		}
		else
		{
			b=false;
		}
		}
		System.out.println("+--------------------------------------------------------------------------+");
		System.out.println("Enter your Address");
		System.out.println("Ex: -'house no,socity name,landmark'");
		System.out.println("+--------------------------------------------------------------------------+");
		sc.nextLine();
		u.Address=sc.nextLine();
		}
		}
		int ThingTechCnt[];
		int Min;
		int indexOfMin;
		int BasePrice;

		int AlgoUser(int I)
		{
			UserInput(u[I]);
			ThingTechCnt=search(thing);
			int[] temp=new int[ThingTechCnt.length];
			for(int i=0;i<ThingTechCnt.length;i++)
			{
			    switch(u[I].location)
				{
				case 1:	temp[i]=d.iskon(t[ThingTechCnt[i]].Add); break;
				case 2: temp[i]=d.nehrunagar(t[ThingTechCnt[i]].Add);	break;
				case 3: temp[i]=d.jhansi(t[ThingTechCnt[i]].Add);break;
				case 4: temp[i]=d.sanand_circle(t[ThingTechCnt[i]].Add);break;
				case 5: temp[i]=d.karnavati(t[ThingTechCnt[i]].Add);break;
				case 6: temp[i]=d.vastrapur(t[ThingTechCnt[i]].Add);break;
				case 7: temp[i]=d.prahladnagar(t[ThingTechCnt[i]].Add);break;
				case 8: temp[i]=d.gurukul(t[ThingTechCnt[i]].Add);break;
				case 9: temp[i]=d.navrangpura(t[ThingTechCnt[i]].Add);break;
				case 10:temp[i]=d.astodiya_darwaja(t[ThingTechCnt[i]].Add);break;
				case 11:temp[i]=d.bapunagar(t[ThingTechCnt[i]].Add);break;
				case 12:temp[i]=d.nikol(t[ThingTechCnt[i]].Add);break;
				}
			}
			int min=temp[0];
			int indexMin=0;
			for(int i=0;i<temp.length;i++)
			{
				if(temp[i]<min)
				{
					min=temp[i];
					indexMin=i;
				}
			}
			indexOfMin=ThingTechCnt[indexMin];
			Min=min;
			System.out.println("+--------------------------------------------------------------------------+");
			System.out.println("You have to pay "+(BasePrice+(Min*3))+" Rs");
			boolean loop=true;
			int OrderOrMenu=0;
			while(loop)
			{
			System.out.println("+--------------------------------------------------------------------------+");
			System.out.println("1.Order Confirm");
			System.out.println("2.Main Menu");
			System.out.println("+--------------------------------------------------------------------------+");
			OrderOrMenu=sc.nextInt();
			if(OrderOrMenu==1)
			{
				loop=false;
				Algorithm.payment(u[I]);
				t[indexOfMin].earning+= BasePrice*0.75 + Min*3;
				Main.grossIncome+=BasePrice*0.25;	
				System.out.println("+--------------------------------------------------------------------------+");
				System.out.println("Technician "+t[indexOfMin].name+" will be arrives in "+(4+(Min*2))+" Min");
				System.out.println("+--------------------------------------------------------------------------+");
				System.out.println("Technician phone number "+t[indexOfMin].num);
				System.out.println("+--------------------------------------------------------------------------+");
				System.out.println("Delivered "+t[indexOfMin].count+" Repair Service on our platform");
				System.out.println("+--------------------------------------------------------------------------+");
				System.out.println("Rating "+String.format("%,.1f",t[indexOfMin].rating)+" Stars");
				System.out.println("+--------------------------------------------------------------------------+");
				System.out.println("Give rating to Technician");
				int rating=Algorithm.rate();
				t[indexOfMin].rating=((t[indexOfMin].rating*t[indexOfMin].count)+rating)/++t[indexOfMin].count;
			}
			else if(OrderOrMenu==2)
			{
				if(u[I].repeatObj==2)
				{
						User.RepearUser--;
						u[I].repeatObj=1;
				}
				return OrderOrMenu;
			}
			else
			{
				System.out.println("enter valid number");
			}
			}
			return OrderOrMenu;
		}
		int[] search(int a)
		{
			int count=0;
			int arr[]=new int[1];
			for (int i=0;i<t.length;i++)
			{
				switch(a)
				{
					case 1:	if(t[i].thing.equals("Fan"))
							{
								if(count>0)
								{
									arr=IndexAdd(arr);}
								arr[count]=i;count++;BasePrice=50;
							}
							break;
					case 2:if(t[i].thing.equals("WashingMachine"))
							{
							if(count>0)
							{
								arr=IndexAdd(arr);
							}
								arr[count]=i;count++;BasePrice=200;
								}
								break;
					case 3:if(t[i].thing.equals("Tv"))
							{
							if(count>0)
							{
								arr=IndexAdd(arr);
							}
								arr[count]=i;count++;BasePrice=250;
							}
							break;
					case 4:if(t[i].thing.equals("AirConditioner"))
							{
							if(count>0)
							{
								arr=IndexAdd(arr);
							}
							arr[count]=i;count++;BasePrice=300;
							}
							break;
					case 5:if(t[i].thing.equals("Refrigerator"))
							{
							if(count>0)
							{
								arr=IndexAdd(arr);
							}
							arr[count]=i;count++;BasePrice=350;
							}
							break;
					case 6:if(t[i].thing.equals("WiringAndSwitchBoard"))
							{
							if(count>0)
							{
								arr=IndexAdd(arr);
							}
								arr[count]=i;count++;BasePrice=50;
						}
						break;
					case 7:if(t[i].thing.equals("Oven"))
							{
							if(count>0)
							{
								arr=IndexAdd(arr);
							}
								arr[count]=i;count++;BasePrice=150;
							}
							break;
					case 8:if(t[i].thing.equals("Chimney"))
							{
							if(count>0)
							{
								arr=IndexAdd(arr);
							}
								arr[count]=i;count++;BasePrice=150;
						}
						break;
					case 9:if(t[i].thing.equals("Stove"))
							{
							if(count>0)
							{
								arr=IndexAdd(arr);
							}
								arr[count]=i;count++;BasePrice=90;
							}
							break;
					case 10:if(t[i].thing.equals("Computer"))
							{
							if(count>0)
							{
								arr=IndexAdd(arr);
							}
								arr[count]=i;count++;BasePrice=400;
							}
							break;
				}
			}
			return arr;
		}
		int[] IndexAdd(int a[])
		{
			int []New=new  int[a.length+1];
			for (int i=0;i<a.length;i++)
			{
				New[i]=a[i];
			}
			return New;
		}
	static void payment(User u)
		{
		Scanner sc=new Scanner(System.in);
		System.out.println("select payment method");
		System.out.println("1.payment after repair");
		System.out.println("2.UPI ID");
		System.out.println("3.credit/debit card");
		boolean a=true;
		while(a)
		{
		int n = sc.nextInt();
		switch(n)
		{
		case 1:
				System.out.println("");
				a=false;
				break;
		case 2:a=false;
		boolean b=true;
		sc.nextLine();
		while(b)
		{
				System.out.println("enter UPI ID");
				String UID = sc.nextLine();
				if(((UID.startsWith(u.name.toLowerCase()))||(UID.startsWith(u.number))) && (UID.endsWith("@oksbi")||UID.endsWith("@ybl")||UID.endsWith("@okaxis")||UID.endsWith("@okicici")||UID.endsWith("@fam")||UID.endsWith("@ptyes")||UID.endsWith("@okhdfc")))	
				{
					System.out.println("OK DONE PAYMENT");
					b=false;
				}
				else 
				{
					System.out.println("enter valid UPI ID");
				}
		}
				break;
		case 3:
		a=false;
		sc.nextLine();
				System.out.println("enter credit/debit card number");
				String num="";
				boolean c = true;
				while(c)
				{
					num = sc.nextLine();
					if (num.length() == 19)
				{
				if((num.charAt(4)==' ') &&( num.charAt(9)==' ') && (num.charAt(14)==' '))
					{
						System.out.println("OK DONE PAYMENT");
						c = false;
					}
				}
				else if(num.length() == 16)
				{ 
				System.out.println("OK DONE PAYMENT");
				c = false;
				}
				else 
				{
					System.out.println("enter valid Card number");
				}
				}
				break;
		default:
				System.out.println("Invalid input");
				break;
			}
		}
	}
		static int rate()
		{
		Scanner sc=new Scanner(System.in);
		boolean b = true;
		boolean a = true;
		int n=0;
		while(b)
		{
			System.out.println("enter your rate number");
			n = sc.nextInt();
		switch(n)
		{
			case 1:while(a)
					{
						System.out.println("+--------------------------------------------------------------------------+");
						System.out.println("your rate is * ");
						System.out.println("1.bad behaviour");
						System.out.println("2.problem not solved ");
						System.out.println("3.late time");
						System.out.println("4.bad service ");
						System.out.println("+--------------------------------------------------------------------------+");
						int ans1 = sc.nextInt();
						if(ans1>0 && ans1<=4)
						{
							System.out.println("we apologize for the all problem you have experinsed from as we will definipely try to fix it");
							a = false;
							b = false;
							break;
							}
						else
						{
							System.out.println("Invalid Input");
							a = true;
						}
					}
					break;
			case 2:
					while(a)
					{
						System.out.println("+--------------------------------------------------------------------------+");
						System.out.println("your rate is ** ");
						System.out.println("1.bad behaviour");
						System.out.println("2.problem not solved ");
						System.out.println("3.late time");
						System.out.println("4.bad service ");
						System.out.println("+--------------------------------------------------------------------------+");
						int ans2 = sc.nextInt();
						if(ans2>0 && ans2<=4)
						{
							System.out.println("we apologize for the all problem you have experinsed from as we will definipely try to fix it");
							a = false;
							b = false;
							break;
						}
						else
						{
						System.out.println("Invalid Input");
						a = true;
						}
						}
						break;
			case 3:
					while(a)
					{
						System.out.println("+--------------------------------------------------------------------------+");
						System.out.println("your rate is *** ");
						System.out.println("1.bad behaviour");
						System.out.println("2.problem not solved ");
						System.out.println("3.late time");
						System.out.println("4.bad service ");
						System.out.println("+--------------------------------------------------------------------------+");
						int ans3 = sc.nextInt();
					if(ans3>0 && ans3<=4)
					{
						System.out.println("we apologize for the all problem you have experinsed from as we will definipely try to fix it");
						a = false;
						b = false;
						break;
					}
					else
					{
						System.out.println("Invalid Input");
						a = true;
					}
					}
					break;
			case 4:while(a)
					{
						System.out.println("+--------------------------------------------------------------------------+");
						System.out.println("your rate is **** ");
						System.out.println("1.good behaviour");
						System.out.println("2.good service ");
						System.out.println("+--------------------------------------------------------------------------+");
						int ans4 = sc.nextInt();
						if(ans4>0 && ans4<=2)
						{
							b = false;
							a = false;
							break;
						}
						else
						{
						System.out.println("Invalid Input");
						a = true;
						}
						}
						break;
			case 5:while(a)
					{
						System.out.println("+--------------------------------------------------------------------------+");
						System.out.println("your rate is ***** ");
						System.out.println("1.good behaviour");
						System.out.println("2.good service ");
						System.out.println("+--------------------------------------------------------------------------+");
						int ans4 = sc.nextInt();
						if(ans4>0 && ans4<=2)
						{
							b = false;
							a = false;
							break;
						}
						else
						{
							System.out.println("Invalid Input");
							a = true;
						}
						}
						break;
			default:
					System.out.println("Invalid input");
					break;
		}
		}
		if(n>0 && n<=5)
		{
			System.out.println("|   _____________________    _____________________   |");
			System.out.println("|  |                     |  |                     |  |");
			System.out.println("|  |   THANK YOU FOR     |  |     HAVE A          |  |");
			System.out.println("|  |   YOUR FEEDBACK     |  |     GOOD DAY        |  |");
			System.out.println("|  |_____________________|  |_____________________|  |");
		}
	return n;
	}
	}
	class Technician extends Main
	{
		String name;
		String num;
		String thing;
		int earning;
		int Add;
		double rating;
		int count;
		
		String AccountNum="";
		String IFSC;
		String Pan;
		
		static void ADDIN()
		{
			Technician newu[]=new Technician[t.length+1];
			newu[t.length]=new Technician();
			for(int i=0;i<t.length;i++)
			{
				newu[i]=new Technician();
				newu[i]=t[i];
			}
			t=newu;
		}
		
		static void Signin(){
		distance d=new distance();
			System.out.println("+-------------+");
			System.out.println("| Signin page |");
			System.out.println("+-------------+");
			Scanner sc=new Scanner(System.in);
					String num="";
			boolean b=true;
			System.out.print("Enter your mobile number:- ");
			do
			{
				num=sc.nextLine();
				for(int j=0;j<num.length();j++)
				{   
					if(!(num.charAt(j)>='0' && num.charAt(j)<='9' && num.length()==10 && num.charAt(0)>='6' && num.charAt(0)<='9'))
					{
						b=true;
						System.out.print("invalid! Try again:-");
					break;
					}
					else
					{
						b=false;
					}
				}
			}
			while (b);
			boolean x=true;
			int Index=0;
			for(int i=0;i<t.length;i++)
			{
				if(num.equals(t[i].num))
				{
					Index=i;
					x=false;	
				}
			}
				if(x)
				{
					System.out.println("This number is not registered");
					Technician.Signup();
					return;
				}
					System.out.println();
					System.out.println(" Hi, "+t[Index].name);
					System.out.println(" your total earnings is "+t[Index].earning);
					System.out.print(" your Rating is, "+String.format("%,.1f",t[Index].rating));
				if(t[Index].rating<3)
				{
				System.out.println(" your rating is poor,try to improve ");
				}
				else
				{
					System.out.println(" your rating is Good");
				}
					System.out.println(" your total service "+ t[Index].count);
					System.out.println(" your location "+ d.locname[t[Index].Add]);
					System.out.println("Technician of "+ t[Index].thing +"s");
				if(t[Index].AccountNum.equals(""))
				{
				System.out.println("your kyc is pending");
				Technician.kyc(t[Index]);
				}
			else
			{
				System.out.println("your kyc is done");
			}
				System.out.println("1.Change location");
				System.out.println("2.exit");
				boolean c=true;
			while(c)
			{
			int y=sc.nextInt();
			if(y==1)
			{
				c=false;
				int location=0;
				System.out.println("Select your location area");
				for(int i=0;i<d.locname.length;i++)
				{
					System.out.println((i+1)+"."+d.locname[i]);
				}
				boolean e=true;
			while(e)
			{
			location=sc.nextInt();
			if(location>d.locname.length || location<1)
			{
				e=true;
				System.out.println("Enter vaild input:");
			}	
			else 
			{
				e=false;
			}
				t[Index].Add=location-1;
				System.out.println("press enter to exit");
				sc.nextLine();
				sc.nextLine();
		}
			}
			else if(y==2)
			{
				c=false;
			}
			else
			{
				System.out.println("enter valid input");
			}
			}
		}
		static void Signup()
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("+-------------+");
			System.out.println("| Signup page |");
			System.out.println("+-------------+");
			String num="";
			boolean b=true;
			System.out.print("Enter your mobile number:- ");
				do
				{
				num=sc.nextLine();
				for(int j=0;j<num.length();j++)
				{   
					if(!(num.charAt(j)>='0' && num.charAt(j)<='9' && num.length()==10 && num.charAt(0)>='6' && num.charAt(0)<='9'))
					{
						b=true;
						System.out.print("invalid! Try again:-");
					break;
					}
					else
					{
						b=false;
					}
				}
			}while (b);
			boolean x=true;
			for(int i=0;i<t.length;i++)
			{
				if(num.equals(t[i].num))
				{
					System.out.println("This number is already registered");
					Technician.Signin();
					x=false;
					return;
				}
			}
			if(x)
			{
					ADDIN();
					}
					t[t.length-1].num=num;
					boolean a;
					System.out.print("Enter your full name:- ");
					String name;
				do 
				{
					name=sc.nextLine();
					a=true;
					for(int i=0;i<name.length();i++)
					{
					char c=name.charAt(i);
					if(!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || c == ' '))
					{
						a=false;    
						break;
				}
			}
			if(!a)
				{
					System.out.print("Please! Enter valid name:-");
				}
			}while(!a);
				t[t.length-1].name=name;
				distance d=new distance();
				int thing=0;
				System.out.println("select which thing you can repair");
				for(int i=0;i<d.Things.length;i++)
				{
					System.out.println((i+1)+"."+d.Things[i]);
				}
				boolean c=true;
				while(c)
				{
					thing=sc.nextInt();
				if(thing>10 || thing<1)
				{
					c=true;
					System.out.println("Enter vaild input:");
				}	
				else
				{
					c=false;
				}
		}
			t[t.length-1].thing=d.Things[thing-1];
			int location=0;
			System.out.println("Select your location area");
			for(int i=0;i<d.locname.length;i++)
			{
				System.out.println((i+1)+"."+d.locname[i]);
			}
			boolean e=true;
			while(e)
			{
				location=sc.nextInt();
				if(location>d.locname.length || location<1)
				{
				e=true;
				System.out.println("Enter vaild input:");
				}
				else
				{
					e=false;
				}
				t[t.length-1].Add=location-1;
			}
				Technician.kyc(t[t.length-1]);
				System.out.println("Signup Process Is Complete");
				Technician.Signin();
	}
	static void kyc(Technician t)
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("1.Complete your kyc");
			System.out.println("2.Remind Me After ");
			int a=0;
			do{
			 a=sc.nextInt();
			if(a==2){
				return;
			}if(!(a==1 || a==2)){
				System.out.println("invalid! Try again");
			}
			}while(!(a==1 || a==2));
			
			while(true)
			{
				System.out.println("Enter your account number:");
				t.AccountNum = sc.next();
				boolean Valid = true;
				for (int i = 0; i < t.AccountNum.length(); i++) 
				{
					if (!(t.AccountNum.charAt(i)>='0' && t.AccountNum.charAt(i)<='9'))
						{
						Valid = false; 
						break;
					}
				} 
					if (t.AccountNum.length() <14 || t.AccountNum.length() > 16)
					{
					Valid = false;
					}
					if (Valid)
					{
					System.out.println("Account number is valid.");
					break; 
					}
					else 
					{
					System.out.println("Invalid account number!  Please try again.");
					}
			}
				while(true)
				{
					System.out.println("Enter your IFSC code:");
					t.IFSC = sc.next();
					boolean Valid1 = true;
					if (t.IFSC.length() != 11) 
					{
						Valid1 = false;
					}
					else 
					{  
					for (int i = 0; i < 4; i++) 
					{
						char c = t.IFSC.charAt(i);
						if (!((c >= 'A' && c <= 'Z'))) 
						{
							Valid1 = false;
							break;
						}
					}
						if (t.IFSC.charAt(4) != '0')
						{
						Valid1 = false;
						}                
					for (int i = 5; i < 11; i++) 
					{
						char c = t.IFSC.charAt(i);
						if (!((c >= 'A' && c <= 'Z')  || (c >= '0' && c <= '9'))) 
						{
							Valid1 = false;
							break;
						}
					}
				}
					if (Valid1)
					{
						System.out.println("IFSC code is valid.");	
						break; 
					} 
				else
					{
						System.out.println("Invalid IFSC code! Please try again.");
					}
			}
					while(true) 
					{
						System.out.println("Enter your PAN number:");
						t.Pan = sc.next();
						boolean valid2 = true;
						if (t.Pan.length() != 10) 
						{
							valid2 = false;
						}
						else 
						{
						for (int i = 0; i < 5; i++) 
						{
							if(i==3){continue;}
						char c = t.Pan.charAt(i);
						if (!(c >= 'A' && c <= 'Z')) 
						{
							valid2 = false;
							break;
						}
						}
						if(!(t.Pan.charAt(3)=='P'))
						{
							valid2 = false; 
						}
					for (int i = 5; i < 9; i++) 
					{
						char c = t.Pan.charAt(i);
						if (!(c >= '0' && c <= '9'))
							{
								valid2 = false;
								break;
						}
					}
					char lastChar = t.Pan.charAt(9);
					if (!(lastChar >= 'A' && lastChar <= 'Z')) 
					{
						valid2 = false;
					}
				}
					if (valid2) 
					{
						System.out.println("PAN number is valid.");
						break;
					}
					else 
					{
						System.out.println("Invalid PAN number!.Please try again.");
					}
				}
						System.out.println(" your kyc is Completed");
	}
	static void TechAllDetails()
		{
			t[0].name="Rameshbhai patel";
			t[1].name="pareshbhai shah";
			t[2].name="hareshbhai donda";
			t[3].name="Nareshbhai chopada";
			t[4].name="Chirag Mehta";
			t[5].name="Bhuro Gandhi";
			t[6].name="Brijesh Patel";
			t[7].name="Krish Savaliya";
			t[8].name="Kashyap virani";
			t[9].name="jayesh Mangukiya";
			t[10].name="Shivang jasani";
			t[11].name="Janardan Solanki";
			
			t[0].num="9638527415";
			t[1].num="8527419636";
			t[2].num="9637418525";
			t[3].num="9876543218";
			t[4].num="9873216547";
			t[5].num="6549873219";
			t[6].num="6543219876";
			t[7].num="9624526925";
			t[8].num="9524578523";
			t[9].num="9099162002";
			t[10].num="9099162005";
			t[11].num="8687269636";
			
			t[0].Add=0;//"Iskon"
			t[1].Add=1;//"Nehrunagar"
			t[2].Add=2;//"jhansi ki rani"
			t[3].Add=3;//"Sanand circle"
			t[4].Add=4;//"Karnavati club"
			t[5].Add=5;//"Vastrapur"
			t[6].Add=6;//"prahlad nagar"
			t[7].Add=7;//"Gurukul"
			t[8].Add=8;//"Navarangpura"
			t[9].Add=9;//"Astodiya darwaja"
			t[10].Add=10;//"Bapunagar"
			t[11].Add=11;//"Nikol"

			t[0].thing="Fan";
			t[1].thing="WashingMachine";
			t[2].thing="Tv";
			t[3].thing="AirConditioner";
			t[4].thing="Refrigerator";
			t[5].thing="WiringAndSwitchBoard";
			t[6].thing="Oven";
			t[7].thing="Chimney";
			t[8].thing="Stove";
			t[9].thing="Computer";
			t[10].thing="AirConditioner";
			t[11].thing="Refrigerator";
			
			t[0].rating=3.5;
			t[1].rating=4;
			t[2].rating=3.5;
			t[3].rating=4.5;
			t[4].rating=4.5;
			t[5].rating=5;
			t[6].rating=5;
			t[7].rating=3.5;
			t[8].rating=4.5;
			t[9].rating=4;
			t[10].rating=4.5;
			t[11].rating=4;
			
			t[0].count=15;
			t[1].count=9;
			t[2].count=50;
			t[3].count=75;
			t[4].count=23;
			t[5].count=57;
			t[6].count=80;
			t[7].count=7;
			t[8].count=3;
			t[9].count=41;
			t[10].count=45;
			t[11].count=38;
		}
	}
class distance
	{
		String Things[]=new String[10];{
		Things[0]="Fan";
		Things[1]="WashingMachine";
		Things[2]="Tv";
		Things[3]="AirConditioner";
		Things[4]="Refrigerator";
		Things[5]="WiringAndSwitchBoard";
		Things[6]="Oven";
		Things[7]="Chimney";
		Things[8]="Stove";
		Things[9]="Computer";
		}

		String locname[]=new String[12];
		int loc[]=new int[12];
		{
		locname[0]="Iscon";
		locname[1]="Nehrunagar";
		locname[2]="Jhansi Ki Rani";
		locname[3]="Sanand Circle";
		locname[4]="Karnavati";
		locname[5]="Vastrapur";
		locname[6]="Prahladnagar";
		locname[7]="Gurukul";
		locname[8]="Navarangpura";
		locname[9]="Astodiya darwaja";
		locname[10]="Bapunagar";
		locname[11]="Nikol";
		}
	/* 	iskon --- 0
		Nehru---1
		jhansi---2
		sanand---3
		karnavati---4
		vastral---5
		prahlad---6
		gurulul---7
		navrangpura---8
		Astodiya darwaja---9
		bapunagar---10
		nikol---11 */
		int iskon(int a)
		{ 
			loc[0]=0;
			loc[1]=5;//Distance from Iscon to Nehrunagar
			loc[2]=4;//Distance from Iscon to Jhansi ki rani
			loc[3]=4;//Distance from Iscon to sanandcircle
			loc[4]=1;//Distance from Iscon to Karnavati
			loc[5]=4;//Distance from Iscon to Vastral
			loc[6]=2;//Distance from Iscon to Prahladnagar
			loc[7]=4;//Distance from Iscon to Gurukul
			loc[8]=8;//Distance from Iscon to Navrangpura
			loc[9]=10;//Distance from Iscon to astodiya darwaja
			loc[10]=16;//Distance from Iscon to Bapunagar
			loc[11]=22;//Distance from Iscon to NIkol
	return loc[a];
		}
		int nehrunagar(int a)
		{
			loc[1]=0;
			loc[0]=5;//Distance from Nehrunagar to Iscon 
			loc[2]=1;//Distance from Nehrunagar to Jhansi ki rani
			loc[3]=8;//Distance from Nehrunagar to sanandcircle
			loc[4]=5;//Distance from Nehrunagar to Karnavati
			loc[5]=3;//Distance from Nehrunagar to Vastral 
			loc[6]=4;//Distance from Nehrunagar to Prahladnagar
			loc[7]=4;//Distance from Nehrunagar to Gurukul
			loc[8]=3;//Distance from Nehrunagar to Navrangpura
			loc[9]=6;//Distance from Nehrunagar to astodiya darwaja
			loc[10]=11;//Distance from Nehrunagar to Bapunagar
			loc[11]=18;//Distance from Nehrunagar to NIkol
	return loc[a];		 
		}
		int jhansi(int a)
		{
			loc[2]=0;
			loc[0]=3;//Distance from Jhansi ki rani to Iscon 
			loc[1]=2;//Distance from Jhansi ki rani to Nehrunagar
			loc[3]=7;//Distance from Jhansi ki rani to sanand circle
			loc[4]=4;//Distance from Jhansi ki rani to Karnavati
			loc[5]=3;//Distance from Jhansi ki rani to Vastral
			loc[6]=4;//Distance from Jhansi ki rani to Prahladnagar
			loc[7]=3;//Distance from Jhansi ki rani to Gurukul
			loc[8]=5;//Distance from Jhansi ki rani to Navrangpura
			loc[9]=7;//Distance from Jhansi ki rani to astodiya darwaja
			loc[10]=13;//Distance from Jhansi ki rani to Bapunagar
			loc[11]=19;//Distance from Jhansi ki rani to NIkol
			return loc[a];
		}
		int sanand_circle(int a)
		{
			loc[3]=0;
			loc[0]=5;//Distance from sanand circle to Iscon 
			loc[1]=8;//Distance from sanand circle to Nehrunagar
			loc[2]=8;//Distance from sanand circle to Jhansi ki rani
			loc[4]=4;//Distance from sanand circle to Karnavati
			loc[5]=9;//Distance from sanand circle to Vastral
			loc[6]=4;//Distance from sanand circle to Prahladnagar
			loc[7]=8;//Distance from sanand circle to Gurukul
			loc[8]=13;//Distance from sanand circle to Navrangpura
			loc[9]=13;//Distance from sanand circle to astodiya darwaja
			loc[10]=21;//Distance from sanand circle to Bapunagar
			loc[11]=25;//Disatnce from sanand circle to NIkol
			return loc[a];
		}
		int karnavati(int a)
		{
			loc[4]=0;
			loc[0]=1;//Distance from Karnavati to Iscon 
			loc[1]=5;//Distance from Karnavati to Nehrunagar
			loc[2]=6;//Distance from Karnavati to Jhansi ki rani
			loc[3]=6;//Distance from Karnavati to sanand circle
			loc[5]=5;//Distance from Karnavati to Vastral
			loc[6]=3;//Distance from Karnavati to Prahladnagar
			loc[7]=5;//Distance from Karnavati to Gurukul
			loc[8]=9;//Distance from Karnavati to Navrangpura
			loc[9]=10;//Distance from Karnavati to loc[9]
			loc[10]=17;//Distance from Karnavati to Bapunagar
			loc[11]=22;//Distance from Karnavati to NIkol
			return loc[a];
		}
		int vastrapur(int a)
		{
			loc[5]=0;
			loc[0]=3;//Distance from Vastral to Iscon 
			loc[1]=3;//Distance from Vastral to Nehrunagar
			loc[4]=4;//Distance from Vastral to Karnavati
			loc[2]=4;//Distance from Vastral to Jhansi ki rani
			loc[3]=8;//Distance from Vastral to sanand circle 
			loc[6]=4;//Distance from Vastral to Prahladnagar
			loc[7]=1;//Distance from Vastral to Gurukul
			loc[8]=5;//Distance from Vastral to Navrangpura
			loc[9]=8;//Distance from Vastral to astodiya darwaja
			loc[10]=15;//Distance from Vastral to Bapunagar
			loc[11]=20;//Distance from Vastral to NIkol
			return loc[a];
		}
		int prahladnagar(int a)
		{
			loc[6]=0;
			loc[0]=2;//Distance from Prahladnagar to Iscon 
			loc[1]=4;//Distance from Prahladnagar to Nehrunagar
			loc[4]=1;//Distance from Prahladnagar to Karnavati
			loc[2]=4;//Distance from Prahladnagar to Jhansi ki rani
			loc[5]=5;//Distance from Prahladnagar to Vastral
			loc[3]=4;//Distance from Prahladnagar to sanand circle
			loc[7]=5;//Distance from Prahladnagar to Gurukul
			loc[8]=8;//Distance from Prahladnagar to Navrangpura
			loc[9]=10;//Distance from Prahladnagar to astodiya darwaja
			loc[10]=16;//Distance from Prahladnagar to Bapunagar
			loc[11]=22;//Disatance from Prahladnagar to NIkol
			return loc[a];
		}
		int gurukul(int a)
		{
			loc[7]=0;
			loc[0]=4;//Distance from Gurukul to Iscon 
			loc[1]=4;//Distance from Gurukul to Nehrunagar
			loc[4]=5;//Distance from Gurukul to Karnavati 
			loc[2]=4;//Distance from Gurukul to Jhansi ki rani
			loc[3]=8;//Distance from Gurukul to sanand circle 
			loc[5]=1;//Distance from Gurukul to Vastral
			loc[6]=6;//Distance from Gurukul to Prahladnagar
			loc[8]=5;//Distance from Gurukul to Navrangpura
			loc[9]=9;//Distance from Gurukul to astodiya darwaja
			loc[10]=15;//Distance from Gurukul to Bapunagar
			loc[11]=20;//Distance from Gurukul to NIkol
			return loc[a];
		}
		int  navrangpura(int a)
		{
			loc[8]=0;
			loc[0]=10;//Distance from Navrangpura to Iscon 
			loc[1]=4;//Distance from Navrangpura to Nehrunagar
			loc[4]=9;//Distance from Navrangpura to Karnavati
			loc[2]=4;//Distance from Navrangpura to Jhansi ki rani
			loc[3]=12;//Distance from Navrangpura to sanand circle
			loc[5]=5;//Distance from Navrangpura to Vastral
			loc[6]=8;//Distance from Navrangpura to Prahladnagar
			loc[7]=4;//Distance from Navrangpura to Gurukul
			loc[9]=5;//Distance from Navrangpura to astodiya darwaja
			loc[10]=9;//Distance from Navrangpura to Bapunagar
			loc[11]=15;//Distance from Navrangpura to NIkol
			return loc[a];
		}
		int astodiya_darwaja(int a)
		{
			loc[9]=0;
			loc[0]=11;//Distance from astodiya darwaja to Iscon 
			loc[1]=6;//Distance from astodiya darwaja to Nehrunagar
			loc[4]=10;//Distance from astodiya darwaja to Karnavati
			loc[2]=6;//Distance from astodiya darwaja to Jhansi ki rani
			loc[3]=13;//Distance from astodiya darwaja to sanand circle
			loc[6]=10;//Distance from astodiya darwaja to Prahladnagar
			loc[5]=7;//Distance from astodiya darwaja to Vastral
			loc[7]=9;//Distance from astodiya darwaja to Gurukul
			loc[8]=5;//Distance from astodiya darwaja to Navrangpura
			loc[10]=8;//Distance from astodiya darwaja to Bapunagar
			loc[11]=12;//Distance from astodiya darwaja to NIkol
			return loc[a];
		}
		int bapunagar(int a)
		{
			loc[10]=0;
			loc[0]=17;//Distance from Bapunagar to Iscon 
			loc[1]=12;//Distance from Bapunagar to Nehrunagar
			loc[4]=18;//Distance from Bapunagar to Karnavati
			loc[2]=12;//Distance from Bapunagar to Jhansi ki rani
			loc[3]=22;//Distance from Bapunagar to sanand circle
			loc[5]=13;//Distance from Bapunagar to Vastral
			loc[6]=14;//Distance from Bapunagar to Prahladnagar
			loc[7]=13;//Distance from Bapunagar to Gurukul
			loc[8]=8;//Distance from Bapunagar to Navrangpura
			loc[9]=6;//Distance from Bapunagar to astodiya darwaja
			loc[11]=5;//Distance from Bapunagar to NIkol
			return loc[a];
		}
		int nikol(int a)
		{
			loc[11]=0;
			loc[0]=23;//Distance from NIkol to Iscon 
			loc[1]=18;//Distance from NIkol to Nehrunagar
			loc[4]=24;//Distance from NIkol to Karnavati
			loc[2]=17;//Distance from NIkol to Jhansi ki rani
			loc[3]=27;//Distance from NIkol to sanand circle
			loc[5]=20;//Distance from NIkol to Vastral
			loc[6]=26;//Distance from NIkol to Prahladnagar
			loc[7]=19;//Distance from NIkol to Gurukul
			loc[8]=14;//Distance from NIkol to Navrangpura
			loc[9]=12;//Distance from NIkol to astodiya darwaja
			loc[10]=5;//Distance from NIkol to Bapunagar
			return loc[a];
		}
	}