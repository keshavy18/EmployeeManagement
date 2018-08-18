class Project{
	
	//////////////////Instance Variables//////////////
	String projectId;
	String projectName;
	String startDate;
	String timePeriod;
	int numberOfEmployee;
	String[] roles;
	String[] certificates;
	Employee[] employee;

 	///////////////Constructors////////////////////////
	public Project(String projectId,String projectName, String[] roles, String[] certificates)
	{
		this.projectId =projectId;
		this.projectName =projectName;
		this.startDate =startDate;
		this.timePeriod =timePeriod;
		this.numberOfEmployee =numberOfEmployee;
		this.roles =roles;
		this.certificates =certificates;
	}


	@Override
	public String toString(){
		String certificatesList = ""+projectId+"\t"+projectName+"\t"+startDate+"\t"+timePeriod+"\t"+numberOfEmployee+"\t";

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