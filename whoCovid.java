package COVID;

public class whoCovid {
	//Class to capture data from https://covid19.who.int/data
	//declare field from the field that are actually in the website
	private String countryName;
	private String whoRegion;
	private int cumulativeCases;
	private long casesPerThousand;
	private int casesLastWeek;
	private long casesLastWeekPer1000;
	private int newCasesLastDay;
	private int cumulativeDeaths;
	private long deathsPerThousand;
	private int deathsLastWeek;
	private long deathsLastWeekPer1000;
	private int newDeathsLastDay;
	
	//constructor
	public whoCovid(){
		countryName="";
		whoRegion="";
		cumulativeCases=0;
		casesPerThousand=0;
		casesLastWeek=0;
		casesLastWeekPer1000=0;
		newCasesLastDay=0;
		cumulativeDeaths=0;
		deathsPerThousand=0;
		deathsLastWeek=0;
	    deathsLastWeekPer1000=0;
		newDeathsLastDay=0;
		
	}
	
	//overloading constructor
	public whoCovid(String countryName, String whoRegion, int cumulativeCases, long casesPerThousand, int casesLastWeek, long casesLastWeekPer1000, int newCasesLastDay, int cumulativeDeaths, long deathsPerThousand, int deathsLastWeek, long deathsLastWeekPer1000, int newDeathsLastDay) {
		this.countryName=countryName;
		this.whoRegion=whoRegion;
		this.cumulativeCases=cumulativeCases;
		this.casesPerThousand=casesPerThousand;
		this.casesLastWeek=casesLastWeek;
		this.casesLastWeekPer1000=casesLastWeekPer1000;
		this.newCasesLastDay=newCasesLastDay;
		this.cumulativeDeaths=cumulativeDeaths;
		this.deathsPerThousand=deathsPerThousand;
		this.deathsLastWeek=deathsLastWeek;
	    this.deathsLastWeekPer1000=deathsLastWeekPer1000;
		this.newDeathsLastDay=newDeathsLastDay;
	}
	
	//Set methods
	
	public void setCountryName(String countryName) {
		this.countryName=countryName;
	}
	
	public void setWhoRegion(String whoRegion) {
		this.whoRegion=whoRegion;
	}
	
	public void setCumulativeCases(String cumulativeCases) {
		this.cumulativeCases=Integer.parseInt(cumulativeCases.trim());
	}
	
	public void setcasesPerThousand(String casesPerThousand) {
		this.casesPerThousand=Long.parseLong(casesPerThousand.trim());
	}
	
	public void setCasesLastWeek(String casesLastWeek) {
		this.casesLastWeek=Integer.parseInt(casesLastWeek.trim());
	}
	
	public void setCasesLastWeekPer1000(String casesLastWeekPer1000) {
		this.casesLastWeekPer1000=Long.parseLong(casesLastWeekPer1000.trim());
	}
	
	public void setNewCasesLastDay(String newCasesLastDay) {
		this.newCasesLastDay=Integer.parseInt(newCasesLastDay.trim());
	}
	
	public void setCumulativeDeaths(String cumulativeDeaths) {
		this.cumulativeDeaths=Integer.parseInt(cumulativeDeaths.trim());
	}
	
	public void setDeathsPerThousand(String deathsPerThousand) {
		this.deathsPerThousand=Long.parseLong(deathsPerThousand.trim());
	}
	
	public void setDeathsLastWeek(String deathsLastWeek) {
		this.deathsLastWeek=Integer.parseInt(deathsLastWeek.trim());
	}
	
	public void setDeathsLastWeekPer1000(String deathsLastWeekPer1000) {
		this.deathsLastWeekPer1000=Long.parseLong(deathsLastWeekPer1000.trim());
	}
	
	public void setNewDeathsLastDay(String newDeathsLastDay) {
		this.newDeathsLastDay=Integer.parseInt(newDeathsLastDay.trim());
	}
	
	//Get Methods
	
	public String getCountryName(){
		return this.countryName;
	}
	private String getWhoRegion(){
		return this.whoRegion;
	}
	int getCumulativeCases(){
		return this.cumulativeCases;
	}
	private long getCasesPerThousand(){
		return this.casesPerThousand;
	}
	private int getCasesLastWeek(){
		return this.casesLastWeek;
	}
	private long getCasesLastWeekPer1000(){
		return this.casesLastWeekPer1000;
	}
	private int getNewCasesLastDay(){
		return this.newCasesLastDay;
	}
	private int getCumulativeDeaths(){
		return this.cumulativeDeaths;
	}
	private long getDeathsPerThousand(){
		return this.deathsPerThousand;
	}
	private int getDeathsLastWeek(){
		return this.deathsLastWeek;
	}
	private long getDeathsLastWeekPer1000(){
		return this.deathsLastWeekPer1000;
	}
	private int getNewDeathsLastDay(){
		return this.newDeathsLastDay;
	}
	
	
	
	
	
	
	
	

}
