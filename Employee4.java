 import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

abstract class Employee 
{
		String name, desig;
		int age, sal;
		public Employee() 
		{
			try
			{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("\n Enter Name ");
			name = br.readLine();
			System.out.print("\nEnter Age : ");
			age = Integer.parseInt(br.readLine());
			}
			catch(Exception e)
			{

			}
		}
	
		public void display()
		{
			System.out.println("Name is :"+name);
			System.out.println("Age is :"+age);
			System.out.println("Salary is :"+sal);
			System.out.println("Designation is :"+desig);
		}

		public abstract void raiseSalary();
}
final class Clerk extends Employee 
{
		public Clerk() 
		{
			desig = "Clerk";
			sal = 3000;
		}
		public void raiseSalary() 
		{
			sal += 10000;
		}
	
}
final class Manager extends Employee 
{
		public Manager() 
		{
			desig = "Manager";
			sal = 4000;
		}
		public void raiseSalary() 
		{
			sal += 20000;
		}
}
final class Programmer extends Employee 
{
	public Programmer() 
	{
		desig = "Programmer";
		sal = 9000;
	}
	public void raiseSalary() 
	{
		sal += 50000;
	}
}
 class Employee4
{	
	public static void main(String[] args) 
	{
		try 
		{
			File file = new File("D:/JAVA1/mahi.txt");
			file.createNewFile();
			PrintWriter writer = new PrintWriter(new FileOutputStream(file,true));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Employee> employee = new ArrayList<Employee>();
		int outerMenuChoice = 0, innerMenuChoice = 0;
	
		do {
				System.out.print("\n\n1.CREATE\n2.DISPLAY\n3.RAISESALARY\n4.EXIT\nENTER YOUR CHOICE: ");
				outerMenuChoice = Integer.parseInt(br.readLine());
				switch(outerMenuChoice) 
				{
				case 1: 
					{
					do 
					{
							System.out.print("\n\n1.CLERK\n2.MANAGER\n3.PROGRAMMER\n4.EXIT\nENTER YOUR CHOICE: ");
							innerMenuChoice = Integer.parseInt(br.readLine());
							Employee emp = null;
							switch(innerMenuChoice) 
							{
								case 1: emp = new Clerk();
								break;
								case 2: emp = new Manager();
						        break;
								case 3: emp = new Programmer();
								break;
								case 4: break;
								default: System.out.print("\n\ninvalid entry...!");
						        break;
							}
							if(innerMenuChoice == 1 || innerMenuChoice == 2 || innerMenuChoice == 3) 
							{
								boolean existing = false;
								for( Employee k : employee) 
								{
									if(k.name.equals(emp.name) && k.age == emp.age) 
									{
										System.out.print("\nRecord already exists...");
										existing = true;
										break;
									}
								}
								if(!existing) 
								{
									employee.add(emp);
									writer.println("__");
									writer.println("Name is :"+emp.name);
									writer.println("Age is :"+emp.age);
									writer.println("Sal is :"+emp.sal);
									writer.println("Desig is :"+emp.desig);
									writer.println("__");
									writer.flush();

								}
							 }
					}	while(innerMenuChoice != 4);
						break;
					}
				case 2: 
					{
					if(employee.size() == 0) 
						{
							System.out.print("\n\nNorecords found.....?");
							break;
						}
					for(Employee e:employee)e.display();
					break;
					}
				case 3: 
					{
					if(employee.size() == 0) 
						{
							System.out.print("\n\nNorecords found.....?");
							break;
						}
					for(Employee e:employee) e.raiseSalary();
							System.out.print("\n\nSalary raised...");
							break;
					}
				case 4: System.out.print("\nExiting....!");
						break;
				default: System.out.print("\nInvalid choice....$");
				
				}
		}	while(outerMenuChoice != 4);
			
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}