import java.util.*;

public class UserInterface extends abc{
	public static Employee newEmployee()
	{
		Scanner sc = new Scanner(System.in); 
		System.out.println("Onboard new Employee, Please enter the details:");
		System.out.println("Enter name:");
		String name = sc.nextLine();
		System.out.println("Enter new id:");
		String id = sc.nextLine();
		System.out.println("Enter phone number");
		String phn = sc.nextLine();
		System.out.println("Enter domain speciality:");
		String domainSpeciality = sc.nextLine();
		System.out.println("Enter certification (comma separated):");
		String[] certificates = sc.nextLine().split(",");
		System.out.println("Enter the years of experience");
		String experience = sc.nextLine();
		Employee newEmployee = new Employee(name,id,domainSpeciality,certificates,experience);
		return newEmployee;
	}

	public static Project newProject()
	{
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter project Id:");
		String projectId = sc.nextLine();
		System.out.println("Enter project Name:");			
		String projectName = sc.nextLine();
		System.out.println("Enter roles (separated by commas):");
		String[] roles = sc.nextLine().split(",");
		
		//int[] numPerRoles = new int[roles.length];
		String[] certificates = new String[100];
		for(int i = 0; i<roles.length;i++)
		{
			int count = 0;
			System.out.println("How many employees requred for role "+roles[i]);
			try
			{
				int numPerRoles = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter certificates required(Comma separated)");
				certificates = sc.nextLine().split(",");
			
				ArrayList<Employee> employeesWithCertificates = rm.searchEmployeeWithoutProject(certificates);
				System.out.println("Employee(s) added");
				for(Employee e : employeesWithCertificates){		
					if(e.projectId == null)
					{
						e.projectId = projectId;
						count++;
						System.out.println(e.toString());
					}
					if(count == numPerRoles){break;}
				}
				System.out.println("Total added "+count);
				System.out.println("Employees Remain "+(numPerRoles-count));
			}
			catch(InputMismatchException e){
				System.out.println("No of employees must be Integer");
				i--;
				sc.nextLine();
			}
		}


		Project project = new Project(projectId,projectName,roles,certificates);
		return project;
	}

}