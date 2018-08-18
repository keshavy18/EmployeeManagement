/*
*@TODO
*Think about global scanner 
*Automatic generation of ID
*Options for domain speciality
*Clear screen
*/


import java.util.*;
public class abc implements Basic{

	
	public static void main(String[] args) {

		System.out.println("Welcome!");
		//Scanner sc = new Scanner(System.in);
		ResourceManeger rm = new ResourceManeger();

		while(true)
		{
			abc cb = new abc();
			//cb.clearScreen();
			System.out.println("Welcome to main menu");
			System.out.println("Enter your choice:");
			System.out.println("1. Onboard new Employee");
			System.out.println("2. Employee List");
			System.out.println("3. New Project");
			System.out.println("4. Project List");
			System.out.println("5. Employee by Id");
			System.out.println("6. Search by certifications");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
				case 1:
					Employee newEmployee = UserInterface.newEmployee();
					if(rm.onBoardNewEmployee(newEmployee))
						System.out.println("Employee onboarded successfully");
					else
						System.out.println("Employee already exists");
					break;
				case 2:
					rm.showEmployeeList();
					break;
				case 3:
					Project project = UserInterface.newProject();
					if(rm.newProject(project))
						System.out.println("Project added to database");
					else 
						System.out.println("Project already exists");
					break;
				case 4:
					rm.showProjectList();
					break;
				case 5:
						System.out.println("Search an Employee by Employee Id");
						Employee searchedById = rm.searchByEmployeeId(sc.nextLine());
						System.out.println(searchedById.toString());
						break;
						//
				case 6:
						System.out.println("Enter comma separated list of certifications to search employees");
						String[] certificationsToSearch =  sc.nextLine().split(",");

						ArrayList<Employee> listOfEmployeeWithCertification = rm.searchEmployeeByCertifications(certificationsToSearch);
						for(Employee e: listOfEmployeeWithCertification){
							System.out.println(e.toString());
						}
						break;
				default:
					System.out.println("Please enter the valid input.");
					break;
			}
		}
	}
}