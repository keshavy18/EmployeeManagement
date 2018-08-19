import java.util.*;

class Employee
{
	String id;
	String name;
	String domainSpeciality;
	String[] certificates;
	ArrayList<String> onGoingCertifications;
	String experience;
	String projectId;
	//Project project;

	public Employee(String name,String id,String domainSpeciality,String[] certificates,String experience)
	{
		this.id = id;
		this.name = name;
		this.domainSpeciality = domainSpeciality;
		this.certificates = certificates;
		this.experience = experience;
		this.onGoingCertifications = new ArrayList<String>();
		
	}

	public void appendCertificateArray(String certi)
	{
		String[] certificate = new String[(certificates.length+1)];
		for(int i=0;i<certificates.length;i++)
			certificate[i] = certificates[i];
		certificate[certificates.length] = certi;
		certificates = certificate;
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