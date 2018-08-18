class Employee
{
	String id;
	String name;
	String domainSpeciality;
	String[] certificates;
	String experience;
	String projectId;

	public Employee(String name,String id,String domainSpeciality,String[] certificates,String experience)
	{
		this.id = id;
		this.name = name;
		this.domainSpeciality = domainSpeciality;
		this.certificates = certificates;
		this.experience = experience;
		
	}

	@Override
	public String toString(){
		String certificatesList = ""+id+"\t"+name+"\t"+domainSpeciality+"\t";
		for(int i=0;i<certificates.length;i++)
			certificatesList += certificates[i]+",";
		certificatesList += "\t"+projectId;
		return certificatesList;
	}

	
}