import java.util.*;

public class UserInterface{
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
		System.out.println("Enter Start Date:");
		String startDate = sc.nextLine();
		System.out.println("Enter Expected finish time:");	
		String timePeriod = sc.nextLine();
		// System.out.println("Enter Number of employees required:");
		// int numberOfEmployee = sc.nextInt();
		// sc.nextLine();
		System.out.println("Enter roles (separated by commas):");
		String[] roles = sc.nextLine().split(",");
		
		int[] numPerRoles = new int[roles.length];

		for(int i = 0; i<roles.length;i++)
		{

			System.out.println("How many employees requred for role "+roles[i]);
			numPerRoles[i] = sc.nextInt();
			sc.nextLine();

		}

		System.out.println("Enter certificates required");
		String[] certificates = sc.nextLine().split(",");
		



		Project project = new Project(projectId,projectName,startDate,timePeriod,roles,certificates);
		return project;
	}

}