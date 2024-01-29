package COVID;


//constructor 
public class canadaStats {

	String pruid;
	String prname;
	String prnameFR;
	String date;
	String reporting_week;
	String reporting_year;
	String update;
	String totalcases;
	String numtotal_last7;
	String ratecases_total;
	String numdeaths;
	String numdeaths_last7;
	String ratedeaths;
	String ratecases_last7;
	String ratedeaths_last7;
	String numtotal_last14;
	String numdeaths_last14;
	String ratetotal_last14;
	String ratedeaths_last14;
	String avgcases_last7;
	String avgincidence_last7;
	String avgdeaths_last7;
	String avgratedeaths_last7;
	
	public canadaStats() {
		pruid="";
		prname="";
		prnameFR="";
		date="";
		reporting_week="";
		reporting_year="";
		update="";
		totalcases="";
		numtotal_last7="";
		ratecases_total="";
		numdeaths="";
	    numdeaths_last7="";
		ratedeaths="";
		ratecases_last7="";
		ratedeaths_last7="";
		numtotal_last14="";
		numdeaths_last14="";
		ratetotal_last14="";
		ratedeaths_last14="";
		avgcases_last7="";
		avgincidence_last7="";
		avgdeaths_last7="";
		avgratedeaths_last7="";
		
	}
	
	//overloading constructor 
	public canadaStats(String pruid, String prname, String prnameFR, String date, String reporting_week,
			String reporting_year, String update, String totalcases, String numtotal_last7, String ratecases_total,
			String numdeaths, String numdeaths_last7, String ratedeaths, String ratecases_last7,
			String ratedeaths_last7, String numtotal_last14, String numdeaths_last14, String ratetotal_last14,
			String ratedeaths_last14, String avgcases_last7, String avgincidence_last7, String avgdeaths_last7,
			String avgratedeaths_last7) {
		super();
		this.pruid = pruid;
		this.prname = prname;
		this.prnameFR = prnameFR;
		this.date = date;
		this.reporting_week = reporting_week;
		this.reporting_year = reporting_year;
		this.update = update;
		this.totalcases = totalcases;
		this.numtotal_last7 = numtotal_last7;
		this.ratecases_total = ratecases_total;
		this.numdeaths = numdeaths;
		this.numdeaths_last7 = numdeaths_last7;
		this.ratedeaths = ratedeaths;
		this.ratecases_last7 = ratecases_last7;
		this.ratedeaths_last7 = ratedeaths_last7;
		this.numtotal_last14 = numtotal_last14;
		this.numdeaths_last14 = numdeaths_last14;
		this.ratetotal_last14 = ratetotal_last14;
		this.ratedeaths_last14 = ratedeaths_last14;
		this.avgcases_last7 = avgcases_last7;
		this.avgincidence_last7 = avgincidence_last7;
		this.avgdeaths_last7 = avgdeaths_last7;
		this.avgratedeaths_last7 = avgratedeaths_last7;
	}
	
	//GETTERS AND SETTERS				

	public String getPruid() {
		return pruid;
	}

	public void setPruid(String pruid) {
		this.pruid = pruid;
	}

	public String getPrname() {
		return prname;
			
	}

	public void setPrname(String prname) {
		this.prname = prname;
	}

	public String getPrnameFR() {
		return prnameFR;
	}

	public void setPrnameFR(String prnameFR) {
		this.prnameFR = prnameFR;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getReporting_week() {
		return reporting_week;
	}

	public void setReporting_week(String reporting_week) {
		this.reporting_week = reporting_week;
	}

	public String getReporting_year() {
		return reporting_year;
	}

	public void setReporting_year(String reporting_year) {
		this.reporting_year = reporting_year;
	}

	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}

	public String getTotalcases() {
		return totalcases;
	}

	public void setTotalcases(String totalcases) {
		this.totalcases = totalcases;
	}

	public String getNumtotal_last7() {
		return numtotal_last7;
	}

	public void setNumtotal_last7(String numtotal_last7) {
		this.numtotal_last7 = numtotal_last7;
	}

	public String getRatecases_total() {
		return ratecases_total;
	}

	public void setRatecases_total(String ratecases_total) {
		this.ratecases_total = ratecases_total;
	}

	public String getNumdeaths() {
		return numdeaths;
	}

	public void setNumdeaths(String numdeaths) {
		this.numdeaths = numdeaths;
	}

	public String getNumdeaths_last7() {
		return numdeaths_last7;
	}

	public void setNumdeaths_last7(String numdeaths_last7) {
		this.numdeaths_last7 = numdeaths_last7;
	}

	public String getRatedeaths() {
		return ratedeaths;
	}

	public void setRatedeaths(String ratedeaths) {
		this.ratedeaths = ratedeaths;
	}

	public String getRatecases_last7() {
		return ratecases_last7;
	}

	public void setRatecases_last7(String ratecases_last7) {
		this.ratecases_last7 = ratecases_last7;
	}

	public String getRatedeaths_last7() {
		return ratedeaths_last7;
	}

	public void setRatedeaths_last7(String ratedeaths_last7) {
		this.ratedeaths_last7 = ratedeaths_last7;
	}

	public String getNumtotal_last14() {
		return numtotal_last14;
	}

	public void setNumtotal_last14(String numtotal_last14) {
		this.numtotal_last14 = numtotal_last14;
	}

	public String getNumdeaths_last14() {
		return numdeaths_last14;
	}

	public void setNumdeaths_last14(String numdeaths_last14) {
		this.numdeaths_last14 = numdeaths_last14;
	}

	public String getRatetotal_last14() {
		return ratetotal_last14;
	}

	public void setRatetotal_last14(String ratetotal_last14) {
		this.ratetotal_last14 = ratetotal_last14;
	}

	public String getRatedeaths_last14() {
		return ratedeaths_last14;
	}

	public void setRatedeaths_last14(String ratedeaths_last14) {
		this.ratedeaths_last14 = ratedeaths_last14;
	}

	public String getAvgcases_last7() {
		return avgcases_last7;
	}

	public void setAvgcases_last7(String avgcases_last7) {
		this.avgcases_last7 = avgcases_last7;
	}

	public String getAvgincidence_last7() {
		return avgincidence_last7;
	}

	public void setAvgincidence_last7(String avgincidence_last7) {
		this.avgincidence_last7 = avgincidence_last7;
	}

	public String getAvgdeaths_last7() {
		return avgdeaths_last7;
	}

	public void setAvgdeaths_last7(String avgdeaths_last7) {
		this.avgdeaths_last7 = avgdeaths_last7;
	}

	public String getAvgratedeaths_last7() {
		return avgratedeaths_last7;
	}

	public void setAvgratedeaths_last7(String avgratedeaths_last7) {
		this.avgratedeaths_last7 = avgratedeaths_last7;
	}

	@Override
	public String toString() {
		return "canadaStats [pruid=" + pruid + ", prname=" + prname + ", prnameFR=" + prnameFR + ", date=" + date
				+ ", reporting_week=" + reporting_week + ", reporting_year=" + reporting_year + ", update=" + update
				+ ", totalcases=" + totalcases + ", numtotal_last7=" + numtotal_last7 + ", ratecases_total="
				+ ratecases_total + ", numdeaths=" + numdeaths + ", numdeaths_last7=" + numdeaths_last7
				+ ", ratedeaths=" + ratedeaths + ", ratecases_last7=" + ratecases_last7 + ", ratedeaths_last7="
				+ ratedeaths_last7 + ", numtotal_last14=" + numtotal_last14 + ", numdeaths_last14=" + numdeaths_last14
				+ ", ratetotal_last14=" + ratetotal_last14 + ", ratedeaths_last14=" + ratedeaths_last14
				+ ", avgcases_last7=" + avgcases_last7 + ", avgincidence_last7=" + avgincidence_last7
				+ ", avgdeaths_last7=" + avgdeaths_last7 + ", avgratedeaths_last7=" + avgratedeaths_last7 + "]";
	}
	
	
	
	 

}
