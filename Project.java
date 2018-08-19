import java.util.*;
class Project{
	
	//////////////////Instance Variables//////////////
	String projectId;
	String projectName;
	// String startDate;
	// String timePeriod;
	int numberOfEmployee;
	String[] roles;
	String[] certificates;
	ArrayList<Employee> employee;

	Map<String,Integer> mapOfCertificationsToAvailable;
	Map<String,Integer> mapOfCertificationsToUnavailable;

 	///////////////Constructors////////////////////////
	public Project(String projectId,String projectName, String[] roles, String[] certificates,ArrayList<Employee> employee,int numberOfEmployee,Map<String,Integer> mapOfCertificationsToAvailable,Map<String,Integer> mapOfCertificationsToUnavailable)
	{
		this.projectId =projectId;
		this.projectName =projectName;
		this.numberOfEmployee =numberOfEmployee;
		this.roles =roles;
		this.certificates =certificates;
		this.employee = employee;
		this.mapOfCertificationsToAvailable=mapOfCertificationsToAvailable;
		this.mapOfCertificationsToUnavailable=mapOfCertificationsToUnavailable;
	}


	@Override
	public String toString(){
		String certificatesList = ""+projectId+"\t"+projectName+"\t"+numberOfEmployee+"\t"+employee+"\t";

		for(int i= 0; i<roles.length;i++){
			certificatesList += roles[i]+",";
		}
		certificatesList += "\t";
		for(int i=0;i<certificates.length;i++)
		{
			certificatesList += certificates[i]+",";
		}
		return certificatesList;
	}

}