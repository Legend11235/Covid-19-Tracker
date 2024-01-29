package COVID;

public class whoCovid19 {
	// Class to capture data from https:
	// //covid19.who.int/WHO-COVID-19-global-data.csv
	// declare fields/attributes
	private String countryName;
	private String whoRegion;
	private String totalCases;
	private String totalCasesPer100K;
	private String casesReportedLast7days;
	private String casesReportedLast7daysPer100K;
	private String casesReportedLast24hrs;
	private String totalDeaths;
	private String totalDeathsPer100K;
	private String deathsReportedLast7days;
	private String deathsReportedLast7daysPer100K;
	private String deathsReportedLast24hrs;

	public whoCovid19() {
		countryName = "";
		whoRegion = "";
		totalCases = "";
		totalCasesPer100K = "";
		casesReportedLast7days = "";
		casesReportedLast7daysPer100K = "";
		casesReportedLast24hrs = "";
		totalDeaths = "";
		totalDeathsPer100K = "";
		deathsReportedLast7days = "";
		deathsReportedLast7daysPer100K = "";
		deathsReportedLast24hrs = "";

	}

	public whoCovid19(String countryName, String whoRegion, String totalCases, String totalCasesPer100K,
			String casesReportedLast7days, String casesReportedLast7daysPer100K, String casesReportedLast24hrs,
			String totalDeaths, String totalDeathsPer100K, String deathsReportedLast7days,
			String deathsReportedLast7daysPer100K, String deathsReportedLast24hrs) {
		// super();
		this.countryName = countryName;
		this.whoRegion = whoRegion;
		this.totalCases = totalCases;
		this.totalCasesPer100K = totalCasesPer100K;
		this.casesReportedLast7days = casesReportedLast7days;
		this.casesReportedLast7daysPer100K = casesReportedLast7daysPer100K;
		this.casesReportedLast24hrs = casesReportedLast24hrs;
		this.totalDeaths = totalDeaths;
		this.totalDeathsPer100K = totalDeathsPer100K;
		this.deathsReportedLast7days = deathsReportedLast7days;
		this.deathsReportedLast7daysPer100K = deathsReportedLast7daysPer100K;
		this.deathsReportedLast24hrs = deathsReportedLast24hrs;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getWhoRegion() {
		return whoRegion;
	}

	public void setWhoRegion(String whoRegion) {
		this.whoRegion = whoRegion;
	}

	public String getTotalCases() {
		return totalCases;
	}

	public void setTotalCases(String totalCases) {
		this.totalCases = totalCases;
	}

	public String getTotalCasesPer100K() {
		return totalCasesPer100K;
	}

	public void setTotalCasesPer100K(String totalCasesPer100K) {
		this.totalCasesPer100K = totalCasesPer100K;
	}

	public String getCasesReportedLast7days() {
		return casesReportedLast7days;
	}

	public void setCasesReportedLast7days(String casesReportedLast7days) {
		this.casesReportedLast7days = casesReportedLast7days;
	}

	public String getCasesReportedLast7daysPer100K() {
		return casesReportedLast7daysPer100K;
	}

	public void setCasesReportedLast7daysPer100K(String casesReportedLast7daysPer100K) {
		this.casesReportedLast7daysPer100K = casesReportedLast7daysPer100K;
	}

	public String getCasesReportedLast24hrs() {
		return casesReportedLast24hrs;
	}

	public void setCasesReportedLast24hrs(String casesReportedLast24hrs) {
		this.casesReportedLast24hrs = casesReportedLast24hrs;
	}

	public String getTotalDeaths() {
		return totalDeaths;
	}

	public void setTotalDeaths(String totalDeaths) {
		this.totalDeaths = totalDeaths;
	}

	public String getTotalDeathsPer100K() {
		return totalDeathsPer100K;
	}

	public void setTotalDeathsPer100K(String totalDeathsPer100K) {
		this.totalDeathsPer100K = totalDeathsPer100K;
	}

	public String getDeathsReportedLast7days() {
		return deathsReportedLast7days;
	}

	public void setDeathsReportedLast7days(String deathsReportedLast7days) {
		this.deathsReportedLast7days = deathsReportedLast7days;
	}

	public String getDeathsReportedLast7daysPer100K() {
		return deathsReportedLast7daysPer100K;
	}

	public void setDeathsReportedLast7daysPer100K(String deathsReportedLast7daysPer100K) {
		this.deathsReportedLast7daysPer100K = deathsReportedLast7daysPer100K;
	}

	public String getDeathsReportedLast24hrs() {
		return deathsReportedLast24hrs;
	}

	public void setDeathsReportedLast24hrs(String deathsReportedLast24hrs) {
		this.deathsReportedLast24hrs = deathsReportedLast24hrs;
	}

	@Override
	public String toString() {
		return "WhoCovid19 [countryName=" + countryName + ", whoRegion=" + whoRegion + ", totalCases=" + totalCases
				+ ", totalCasesPer100K=" + totalCasesPer100K + ", casesReportedLast7days=" + casesReportedLast7days
				+ ", casesReportedLast7daysPer100K=" + casesReportedLast7daysPer100K + ", casesReportedLast24hrs="
				+ casesReportedLast24hrs + ", totalDeaths=" + totalDeaths + ", totalDeathsPer100K=" + totalDeathsPer100K
				+ ", deathsReportedLast7days=" + deathsReportedLast7days + ", deathsReportedLast7daysPer100K="
				+ deathsReportedLast7daysPer100K + ", deathsReportedLast24hrs=" + deathsReportedLast24hrs + "]";
	}

}
