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



	public ArrayList<Employee> searchEmployeeWithoutProject(String[] certificationsReqiured)
	{
		ArrayList<Employee> employeeWithCertification = new ArrayList<Employee>();
		for(Employee e: employeeList)
		{
			if(e.projectId == null)	
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
					employeeWithCertification.add(e);
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

	// Report generation in pdf!
	public void generateReport()
	{
		System.out.println("******************************Project Report******************************");
		for(Project project:projectList)
		{
			System.out.println("\t\t\t"+project.projectName+"\t\t\t");
			System.out.println("Project Name: "+project.projectName);
			System.out.println("Project Id: "+project.projectId);
			System.out.println("Project StartDate: "+project.startDate);
			System.out.println("Project Expected Time :"+project.timePeriod);
			System.out.println("Project Number of Employee :"+project.numberOfEmployee);
			System.out.println("Employee and Roles");
			for(String certi:project.certificates)
			{
				System.out.println("\t\tCertified Employee for "+certi+":");
				for(Employee emp:project.employee)
				{
					if (emp.certificates.equals(certi))
					{
						System.out.println("\t\t"+emp.toString());
					}
				}

				System.out.println("\t\tTraining Employee for "+certi+":");
				for(Employee emp:project.employee)
				{
					if (emp.onGoingCertifications.equals(certi))
					{
						System.out.println("\t\t"+emp.toString());
					}
				}
			}
		}
		System.out.println("*************************Certification List*************************");
		HashMap<String,String[]> innerMap = new HashMap<String,String[]>();
		// ArrayList<String> certiList = new ArrayList<String>();
		// ArrayList<String> onGoingCertiList = new ArrayList<String>();
		for (Employee emp:employeeList ) 
			{
			for(String certi:emp.certificates)
				{
					if(!innerMap.containsKey(certi))
					{
						String[] newarrayList = new String[1];
						newarrayList[0] = emp.id;
						innerMap.put(certi,newarrayList);	
					}
					else
					{
						String[] newarrayList = innerMap.get(certi);
						String[] newarrayList1 = new String[newarrayList.length+1];
						for(int i=0;i<newarrayList.length;i++)
							newarrayList1[i] = newarrayList[i];
						newarrayList1[newarrayList.length] = emp.id;
						innerMap.put(certi,newarrayList1);
					}
				}
			}

		for (HashMap.Entry<String, String[]> entry : innerMap.entrySet())
			{
			    System.out.println(entry.getKey());
			    String[] newarrayList = innerMap.get(entry.getKey());
			    for(String str:newarrayList)
			    	System.out.println(str);
			}
	}
}