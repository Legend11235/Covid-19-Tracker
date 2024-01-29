package COVID;

public class vaccinationStats {
	
	//Class to capture data from https://covid19.who.int/who-data/vaccination-data.csv
    //declare field from the field that are actually in the website
	private String country;
	private String countryCode;
	private String date;
	private String totalVaccinations;
	private String peopleVaccinated;
	private String peopleFullyVaccinated;
	private String totalBoosters;
	private String dailyVaccinationsRaw;
	private String dailyVaccinations;
	private String totalVaccinationsPer100;
	private String peopleVaccinatedPer100;
	private String peopleFullyVaccinatedPer100;
	private String totalBoostersPer100;
	private String dailyVaccinationsPerMil;
	private String dailyPeopleVaccinated;
	private String dailyPeopleVaccinatedPer100;
	
	
	//Constructor 
	public vaccinationStats(){
		country="";
		countryCode="";
		date="";
		totalVaccinations="";
		peopleVaccinated="";
		peopleFullyVaccinated="";
		totalBoosters="";
		dailyVaccinationsRaw="";
		dailyVaccinations="";
		totalVaccinationsPer100="";
		peopleVaccinatedPer100="";
		peopleFullyVaccinatedPer100="";
		totalBoostersPer100="";
		dailyVaccinationsPerMil="";
		dailyPeopleVaccinated="";
		dailyPeopleVaccinatedPer100="";
	}
	
	
	//Overloading Constructor
	public vaccinationStats(String country, String countryCode, String date, String isoCode, String privat, String totalVaccinations,
			String peopleVaccinated, String peopleFullyVaccinated, String totalBoosters, String dailyVaccinationsRaw,
			String dailyVaccinations, String totalVaccinationsPer100, String peopleVaccinatedPer100,
			String peopleFullyVaccinatedPer100, String totalBoostersPer100, String dailyVaccinatoinsPer100,
			String dailyVaccinationsPerMil, String dailyPeopleVaccinated, String dailyPeopleVaccinatedPer100) {
		super();
		this.country = country;
		this.countryCode = countryCode;
		this.date = date;
		this.totalVaccinations = totalVaccinations;
		this.peopleVaccinated = peopleVaccinated;
		this.peopleFullyVaccinated = peopleFullyVaccinated;
		this.totalBoosters = totalBoosters;
		this.dailyVaccinationsRaw = dailyVaccinationsRaw;
		this.dailyVaccinations = dailyVaccinations;
		this.totalVaccinationsPer100 = totalVaccinationsPer100;
		this.peopleVaccinatedPer100 = peopleVaccinatedPer100;
		this.peopleFullyVaccinatedPer100 = peopleFullyVaccinatedPer100;
		this.totalBoostersPer100 = totalBoostersPer100;
		this.dailyVaccinationsPerMil = dailyVaccinationsPerMil;
		this.dailyPeopleVaccinated = dailyPeopleVaccinated;
		this.dailyPeopleVaccinatedPer100 = dailyPeopleVaccinatedPer100;
	}


	///GETTERS AND SETTERS METHODS
	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getCountryCode() {
		return countryCode;
	}


	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}


	public String getTotalVaccinations() {
		return totalVaccinations;
	}


	public void setTotalVaccinations(String totalVaccinations) {
		this.totalVaccinations = totalVaccinations;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPeopleVaccinated() {
		return peopleVaccinated;
	}


	public void setPeopleVaccinated(String peopleVaccinated) {
		this.peopleVaccinated = peopleVaccinated;
	}


	public String getPeopleFullyVaccinated() {
		return peopleFullyVaccinated;
	}


	public void setPeopleFullyVaccinated(String peopleFullyVaccinated) {
		this.peopleFullyVaccinated = peopleFullyVaccinated;
	}


	public String getTotalBoosters() {
		return totalBoosters;
	}


	public void setTotalBoosters(String totalBoosters) {
		this.totalBoosters = totalBoosters;
	}


	public String getDailyVaccinationsRaw() {
		return dailyVaccinationsRaw;
	}


	public void setDailyVaccinationsRaw(String dailyVaccinationsRaw) {
		this.dailyVaccinationsRaw = dailyVaccinationsRaw;
	}


	public String getDailyVaccinations() {
		return dailyVaccinations;
	}


	public void setDailyVaccinations(String dailyVaccinations) {
		this.dailyVaccinations = dailyVaccinations;
	}


	public String getTotalVaccinationsPer100() {
		return totalVaccinationsPer100;
	}


	public void setTotalVaccinationsPer100(String totalVaccinationsPer100) {
		this.totalVaccinationsPer100 = totalVaccinationsPer100;
	}


	public String getPeopleVaccinatedPer100() {
		return peopleVaccinatedPer100;
	}


	public void setPeopleVaccinatedPer100(String peopleVaccinatedPer100) {
		this.peopleVaccinatedPer100 = peopleVaccinatedPer100;
	}


	public String getPeopleFullyVaccinatedPer100() {
		return peopleFullyVaccinatedPer100;
	}


	public void setPeopleFullyVaccinatedPer100(String peopleFullyVaccinatedPer100) {
		this.peopleFullyVaccinatedPer100 = peopleFullyVaccinatedPer100;
	}


	public String getTotalBoostersPer100() {
		return totalBoostersPer100;
	}


	public void setTotalBoostersPer100(String totalBoostersPer100) {
		this.totalBoostersPer100 = totalBoostersPer100;
	}


	public String getDailyVaccinationsPerMil() {
		return dailyVaccinationsPerMil;
	}


	public void setDailyVaccinationsPerMil(String dailyVaccinationsPerMil) {
		this.dailyVaccinationsPerMil = dailyVaccinationsPerMil;
	}


	public String getDailyPeopleVaccinated() {
		return dailyPeopleVaccinated;
	}


	public void setDailyPeopleVaccinated(String dailyPeopleVaccinated) {
		this.dailyPeopleVaccinated = dailyPeopleVaccinated;
	}


	public String getDailyPeopleVaccinatedPer100() {
		return dailyPeopleVaccinatedPer100;
	}


	public void setDailyPeopleVaccinatedPer100(String dailyPeopleVaccinatedPer100) {
		this.dailyPeopleVaccinatedPer100 = dailyPeopleVaccinatedPer100;
	}
	
	
	

	//TO STRING METHOD
	@Override
	public String toString() {
		return "vaccinationStats [country=" + country + ", countryCode=" + countryCode + ", date=" + date + ", totalVaccinations=" + totalVaccinations + ", peopleVaccinated="
				+ peopleVaccinated + ", peopleFullyVaccinated=" + peopleFullyVaccinated + ", totalBoosters="
				+ totalBoosters + ", dailyVaccinationsRaw=" + dailyVaccinationsRaw + ", dailyVaccinations="
				+ dailyVaccinations + ", totalVaccinationsPer100=" + totalVaccinationsPer100
				+ ", peopleVaccinatedPer100=" + peopleVaccinatedPer100 + ", peopleFullyVaccinatedPer100="
				+ peopleFullyVaccinatedPer100 + ", totalBoostersPer100=" + totalBoostersPer100
				+ ", dailyVaccinatoinsPer100=" + ", dailyVaccinationsPerMil="
				+ dailyVaccinationsPerMil + ", dailyPeopleVaccinated=" + dailyPeopleVaccinated
				+ ", dailyPeopleVaccinatedPer100=" + dailyPeopleVaccinatedPer100 + "]";
	}



	
	
	

	
	
	
}
