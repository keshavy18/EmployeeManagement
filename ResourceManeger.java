import java.util.*;

public class ResourceManeger implements Basic
{
	// Instance variables
	ArrayList<Employee> employeeList;
	ArrayList<Project> projectList;

	// Constructors
	public ResourceManeger()
	{
		employeeList = new ArrayList<Employee>();
		projectList = new ArrayList<Project>();
	}

	// Methods
	boolean checkEmployeeDuplicate(Employee employee)
	{
		for(Employee emp: employeeList){
			if(emp.id.equals(employee.id)){
				return false;
			}
		}
		return true;
	}

	boolean checkProjectDuplicate(Project project)
	{
		for(Project pro: projectList){
			if(pro.projectId.equals(project.projectId)){
				return false;
			}
		}
		return true;
	}

	public boolean onBoardNewEmployee(Employee employee)
	{
		if(checkEmployeeDuplicate(employee))
		{
			employeeList.add(employee);
			return true;
		}
		return false;
	}

	public boolean newProject(Project project)
	{
		if(checkProjectDuplicate(project))
		{
			projectList.add(project);
			return true;
		}
		return false;
	}

	public void showProjectList()
	{
		if(projectList.size()>0)
		{
			
			for(Project project:projectList)
				System.out.println(project.toString());
		}
		else 
			System.out.println("Oops! You don't have any project yet");

	}

	public void showEmployeeList()
	{
		if(employeeList.size()>0)
		{
			for(Employee employee:employeeList)
				System.out.println(employee.toString());
		}
		else 
			System.out.println("Oops! You haven't onboarded any employees yet");

	}

	public ArrayList<Employee> searchEmployeeByCertifications(String[] certificationsReqiured){
		ArrayList<Employee> employeeWithCertification = new ArrayList<Employee>();
		
		for(Employee e: employeeList)
		{
			int count = 0;
			for(int i=0;i<certificationsReqiured.length;i++)
			{
				String[] certificationsGathered = e.certificates;
				for(int j = 0;j<certificationsGathered.length;j++)
				{
					
					if(certificationsReqiured[i].equals(certificationsGathered[j]))
					{
						count++;
					}

				}
			}	
		
			if(count == certificationsReqiured.length)
			{
				
				employeeWithCertification.add(e);
			}

		}
		
		return employeeWithCertification;
	}



	public ArrayList<Employee> searchEmployeeWithoutProject(String[] certificationsReqiured){
		ArrayList<Employee> employeeWithCertification = new ArrayList<Employee>();
		
		for(Employee e: employeeList)
		{

			if(e.projectId == null)	{
			int count = 0;
			for(int i=0;i<certificationsReqiured.length;i++)
			{
				String[] certificationsGathered = e.certificates;
				for(int j = 0;j<certificationsGathered.length;j++)
				{
					
					if(certificationsReqiured[i].equals(certificationsGathered[j]))
					{
						count++;
					}

				}
			}	
		
			if(count == certificationsReqiured.length)
			{
				
				employeeWithCertification.add(e);
			}

		}



		}
		
		return employeeWithCertification;
	}





	public Employee searchByEmployeeId(String Id){
		

		for(Employee e : employeeList){
			if(e.id.equals(Id))
				return e;
		}

		return null;
	}

	public void addCertificationToEmployee(String employeeId, String certificate){

		Employee employee = searchByEmployeeId(employeeId);

		if(employee==null){
			System.out.println("No employee found\n");
		}
		
		else{

			 ArrayList<String> onGoing = employee.onGoingCertifications;
			
			//System.out.println(onGoing);
			onGoing.add(certificate);

			System.out.println(onGoing);


		}


	}


	public Project searchProjectById(String PId){

		for(Project p:projectList){
			if(p.projectId.equals(PId)){
				return p;
			}
		}

		return null;
	}





}