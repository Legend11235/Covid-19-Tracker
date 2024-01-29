/**
 * 
 */
package Covid;

import java.io.*;
import java.util.*;
/**
 * 
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	//System.out.println("Hello World");
	
	WhoCovid whoStats;
	
	// Array List of WhoCovid class objects
	ArrayList<WhoCovid> whoList=whoList = new ArrayList<WhoCovid>();
	
	//WHO Covid data as csv file
	// https://covid19.who.int/data
	//https://covid19.who.int/WHO-COVID-19-global-data.csv
	// this file will be down loaded using URL class
	//As of now manually downloaded to test
	//String file="C:\\Users\\tarak\\eclipse-workspace\\Files\\WHO-COVID-19-global-data.csv";
	String file="C:\\Users\\tarak\\eclipse-workspace\\Files\\test101.csv";
	File csvFileName=new File(file);
	//System.out.println(csvFileName.getPath()+"\\"+csvFileName.getName());
	
	String countryCode="VN";
	String year="";
	int totalCases=0;
	
	
	try {
		//populate the Arraylist with the data from csv
		populateArrayList(csvFileName,whoList);
		
		//Display total number of cases for a country
		totalCases = getTotalCases(whoList,countryCode);
		
		System.out.println(countryCode+" totalCases :"+totalCases);
	
	}catch(Exception e) 
	{System.out.println(e);	};
	
}/////// end of main() ////////////////////////////////////////////////////////////


/////////
	  public static void populateArrayList(File fileName,ArrayList<WhoCovid> covidList){
		
	    StringBuilder contents = new StringBuilder();
	    
	    try {
	        BufferedReader input =  new BufferedReader(new FileReader(fileName));

	        try {
	            String line = null;
	            line = input.readLine();
	            

			        while (( line = input.readLine()) != null){

			        	String[] attributes = line.split(",");
			        	//System.out.println(attributes[0]+attributes[1]);
			        	WhoCovid whoStat=new WhoCovid(); // creating WhoCovid Class object
		
						whoStat.setDateReported(attributes[0]);
						whoStat.setCountryCode(attributes[1]);
						whoStat.setCountry(attributes[2]);
						whoStat.setWhoRegion(attributes[3]);
						whoStat.setNewCases(attributes[4]);
						whoStat.setCumulativeCases(attributes[5]);
						whoStat.setNewDeaths(attributes[6]);
						whoStat.setCumulativeDeaths(attributes[7]);
						
						covidList.add(whoStat);

						//System.out.println(str);
			        	}
	        	}
	        	finally {
	        		//The finally block always executes when the try block exits. 
	        		//This ensures that the finally block is executed even if an unexpected exception occurs.
	        		input.close();
	        	}
	    	}
	    	catch (IOException ex){
	    		ex.printStackTrace();
	    	}
	}// end of populateArrayList()
	  

	  	public static int getTotalCases(ArrayList<WhoCovid> whoList,String ctryCode)
	  	{
	  		int count=0;
	  		WhoCovid cStat;
	  		String code=""; //store code from ArrayList
	  		//System.out.println(whoList.size());
	  		for(int i=0;i<whoList.size() ;i++)
	  		{
	  			cStat=whoList.get(i);
	  			code=cStat.getCountryCode(); //store code from ArrayList
	  			//System.out.println(code+" "+cStat.getCumulativeCases());
	  			if (code.trim().equalsIgnoreCase(ctryCode.trim()))
	  			{   
	  				//found="Y";
		  			count=cStat.getCumulativeCases();	
	  			}
	  		}
	  		
	  		return count;
	  	} //end of getTotalCases()///////////////////////////////////////////////////////
	  	
	  	public static int getTotalCases(ArrayList<WhoCovid> whoList,int year,String country)
	  	{
	  		int count=0;
	  		
	  		return count;
	  	}//end of getTotalCases()///////////////////////////////////////////////////////
	
}//end of Main