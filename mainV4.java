//MAIN CLASS
//Created by: Sohum Guha
//Created on: Decmeber
//Date last modified: Jan 20, 2023
//Main class with static methods to be incorperated in the main().
//Main class uses canadaStats class, vaccinationStats class, and globalStats class

package COVID;
import java.io.*;
import java.text.Normalizer;
import java.util.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.io.FileWriter;

public class mainV4 {
	// Constant Varibales for both URL used to farm covid data of GLOBAL and
	// CANADA(provincial)
	private static final String WHO_COVID_URL = "https://covid19.who.int/WHO-COVID-19-global-table-data.csv";
	private static final String CAN_COVID_URL = "https://health-infobase.canada.ca/src/data/covidLive/covid19-download.csv";
	private static final String WHO_VACCINATION_STATS = "https://raw.githubusercontent.com/owid/covid-19-data/master/public/data/vaccinations/vaccinations.csv";
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		// main() contains the skeleton on the Main Menu and the sub Menu. This main
		// menu skeleton will call othr methods to ultimately complete my program
		String userChoice = "";
		boolean subMenuTerminate = true;
		boolean mainMenuTerminate = false;
		// main menu screen and sub menu screen can be easily be manipualted
		// Incorporated methods that returns boolean values, which will determine
		// weather or not the main menu or one of the sub menus will appear.
		do {
			clrscr();
			userChoice = mainMenu();
			switch (userChoice) {

			case "1":

				do {
					subMenuTerminate = displayGlobalCovidResults();
				} while (subMenuTerminate == false);
				break;

			case "2":

				do {
					subMenuTerminate = displayCanadaCovidResults();
				} while (subMenuTerminate == false);
				break;

			case "3":

				do {
					subMenuTerminate = displayVaccinationStats();
				} while (subMenuTerminate == false);
				break;

			case "4":

				do {
					subMenuTerminate = doSelfScreening();
				} while (subMenuTerminate == false);
				break;

			case "5":

				do {
					subMenuTerminate = displayTravelAdvisory();
				} while (subMenuTerminate == false);
				break;

			case "6":

				System.out.println("Thank you for using this program!\n\nStay Safe!");
				mainMenuTerminate = true;
				break;

			default:
				System.out.println("Invalid Input");

			}
		} while (!mainMenuTerminate);

	}

	//////////////////// END OF main()////////////////////////////////////

	public static String mainMenu() {

    //Main menu skeleton
		String userSelection = "";
		System.out.println("===============================");
		System.out.println("COVID-19 INFORMATION CENTRE");
		System.out.println("===============================");
		System.out.println("(1) Global Covid Results");
		System.out.println("(2) Canada Covid Results");
		System.out.println("(3) Global Vaccination Stats");
		System.out.println("(4) Self Screening");
		System.out.println("(5) Travel Advisory");
		System.out.println("(6) Exit Program");
		System.out.println("\n~Enter the number corresponding to your selection~");
		userSelection = scan.nextLine();
    //trim user input 
		return userSelection.trim();

	}


    ////////////GLOBAL STATS///////////////
	public static boolean displayGlobalCovidResults() {
		// Array List of globalStats class objects
		ArrayList<globalStats> whoList = new ArrayList<globalStats>();
	
		String userSelection = "";
		clrscr();
		System.out.println("(1) Global Covid Results\n=====================================\n\nLoading Live Data from World Health Organization (WHO) dataset.......\n\n");

		String countryName = "";
		try {

			// populate the Arraylist with the data from csv
			populateArrayListWHO(whoList);

			// ask for user Input trough method
      //acceptUserInput() will display a reccomended country selection based on if there is a partial match with user input and country form the file (Did you mean...)
      //Will help narrow down choice
			countryName = acceptUserInput(whoList);

			//Will show statsitcs collected from .csv file in a formatted output
			showFormattedDetailsWHO(countryName, whoList);


		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("\nDo you want to go back or look for another country?\n\nENTER (1) to GO BACK\nENTER (ANY KEY) TO LOOK FOR ANOTHER COUNTRY");

    //user will select if he wants to go back to main menu or look for another country 
		userSelection = scan.nextLine();
    //trim user selection
    userSelection = userSelection.trim();

    //if statement based on user slection
		if (userSelection.equals("1")) {
			return true;
		}

    else {
			return false;
		}

	}

  ////////////CANADA PROVINCIAL STATS///////////////
	public static boolean displayCanadaCovidResults() {

		String userSelection = "";
		clrscr();
		System.out.println("(2) Canada Covid Results\n=====================================\n\nLoading Live Data from the Government of Canada dataset.......\n\n");

		// ArrayList for canadaStats objects
		ArrayList<canadaStats> canList = new ArrayList<canadaStats>();


		String provinceName = "";
		try {

      //populate the Arraylist with the data from csv
			populateArrayListCan(canList);

      //ask for user Input
      //Since there are only 12 provinces I didn't find the need to add a reccomended list (Did you mean...)
      //Only matches will be considered valid
			provinceName = acceptUserInputCan(canList);


      //Will show statsitcs collected from .csv file in a formatted output
			showFormattedDetailsCan(provinceName, canList);
		

		} catch (Exception e) {
			System.out.println(e);
		}
		// System.out.println(details);

		System.out.println("\nDo you want to go back or look for another province?\n\nENTER (1) to GO BACK\nENTER (ANY KEY) TO LOOK FOR ANOTHER PROVINCE");
		userSelection = scan.nextLine();
    //trim user selection
    userSelection = userSelection.trim();

		if (userSelection.equals("1")) {
			return true;
		}

		else {
			return false;
		}

	}

	public static boolean displayVaccinationStats() {

		String userSelection = "";
		clrscr();
		System.out.println("(3) Global Vaccination Stats\n=====================================\n\nLoading Live Data from World Helath Organization (WHO).......\n\n");

		// ArrayList for Vaccination Stats
		ArrayList<vaccinationStats> vaccineList = new ArrayList<vaccinationStats>();

		///////// GLOBAL VACCINATION STATS///////////////

		String countryName = "";
		String details = "";
		String year = "";
		int totalCases = 0;
		boolean exit = false;

		try {
			// populate the arrayList for vaccineStats from csv
			populateVaccineList(vaccineList);
			countryName = acceptUserInputVax(vaccineList);

			// Display total number of cases for a country
			showFormattedDetailsVax(countryName, vaccineList);

		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("\nDo you want to go back or look for another country?\n\nENTER (1) to GO BACK\nENTER (ANY KEY) TO LOOK FOR ANOTHER COUNTRY");
		userSelection = scan.nextLine();
    //trim user selection
    userSelection = userSelection.trim();

		if (userSelection.equals("1")) {
			return true;
		}

	   else {
			return false;
		}

	}

  ///////////// SELF SCREENING ////////////

	public static boolean doSelfScreening() {

		String userSelection = "";
		clrscr();
		System.out.println("(4) Self Screening\n=====================================\n");
		
		//Call Self screening method:
		slefScreening();

		System.out.println("\nDo you want to go back to main menu or retake the self screening test??\n\nENTER (1) to GO BACK\nENTER (ANY KEY) TO RETAKE SELF SCREENING TEST");
		userSelection = scan.nextLine();
    //trim user selection
    userSelection = userSelection.trim();

		if (userSelection.equals("1")) {
			return true;
		}
    
    else {
			return false;
		}

	}

  ////////////// TRAVEL ADVISORY //////////////

	public static boolean displayTravelAdvisory() {

		String userSelection = "";
		clrscr();
		System.out.println("(5) Travel Advisory\n=====================================\n\nLoading Live Data from World Helath Organization (WHO).......\n\nResults will be based on \"Cases Reported in Last 7 days per 100k population\"\n\n");

		// Call travel advisory method
		travelAdvisoryWHO();

		System.out.println("\nDo you want to go back or look for another country?\n\nENTER (1) to GO BACK\nENTER (ANY KEY) TO LOOK FOR ANOTHER COUNTRY");
		userSelection = scan.nextLine();
    //trim user selection
    userSelection = userSelection.trim();

		if (userSelection.equals("1")) {
			return true;
		}

		else if (userSelection.equals("2")) {
			return false;
		} else {
			System.out.println("INVALID INPUT");
			return false;
		}
	}


  ///////////////////////////// END OF METHODS THAT HAVE A DIRECT LINKAGE WITH THE MAIN MENU SKELETON///////////////////////////////



  
	///// method to handle French characters
	public static String removeFrenchChars(String string) {
    //Java StringBuilder class is used to create mutable (modifiable) String. 
		StringBuilder sb = new StringBuilder(string.length());
    //Normlaizer class is used to handle handle unicode character sets suhc as french characters
		string = Normalizer.normalize(string, Normalizer.Form.NFD);
    //for each loop reads and ignore each french character
		for (char c : string.toCharArray()) {
			if (c <= '\u007F')
				sb.append(c);
		}
		return sb.toString();
	}


  
	///// Method to read csv data from URL and populate array list
	public static void populateArrayListWHO(ArrayList<globalStats> covidList) {

		try {
			// Read the CSV file from the WHO Official website
			URL url = new URL(WHO_COVID_URL);

      //Buffered Reader to access and read .csv file form URL
			BufferedReader input = new BufferedReader(new InputStreamReader(url.openStream()));

			try {
				String line = null;
				line = input.readLine();

				while ((line = input.readLine()) != null) {

          //Using split() to break the record into individual column values
					String[] attributes = line.split(",");
          
          // creating WhoCovid Class object
					globalStats whoStat = new globalStats(); 

          //Using set methods to assign values to class attributes 
					whoStat.setCountryName(attributes[0]);
					whoStat.setWhoRegion(attributes[1]);
					whoStat.setTotalCases(attributes[2]);
					whoStat.setTotalCasesPer100K(attributes[3]);
					whoStat.setCasesReportedLast7days(attributes[4]);
					whoStat.setCasesReportedLast7daysPer100K(attributes[5]);
					whoStat.setCasesReportedLast24hrs(attributes[6]);
					whoStat.setTotalDeaths(attributes[7]);
					whoStat.setTotalDeathsPer100K(attributes[8]);
					whoStat.setDeathsReportedLast7days(attributes[9]);
					whoStat.setDeathsReportedLast7daysPer100K(attributes[10]);
					whoStat.setDeathsReportedLast24hrs(attributes[11]);

          //add the record to the covidList ArrayList
					covidList.add(whoStat);

				}
			} finally {
				// The finally block always executes when the try block exits.
				// This ensures that the finally block is executed even if an unexpected
				// exception occurs.
				input.close();
			}
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}// end of populateArrayList()

	////// CANADA PROVINCIAL STATS
	// Method reads csv data from government of Canada website and stores the data
	////// in an Array List
	public static void populateArrayListCan(ArrayList<canadaStats> covidList) {


		try {

			// Read the CSV file from the Canada Official website
			URL url = new URL(CAN_COVID_URL);

      //Buffered Reader to access and read .csv file form URL
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

			try {
				String line = null;
				// This will read the heading row only and not match with user input
				line = reader.readLine();

				while ((line = reader.readLine()) != null) {
          
          
          //Using split() to break the record into individual column values
					String[] attributes = line.split(",");

					// Handling of lines without any value in the last column
					if (attributes.length < 23) {
						line = line.concat("0.0");
						attributes = line.split(",");
					}

					// creating WhoCovid Class object
					canadaStats canStat = new canadaStats(); 
          
					//Using set methods to assign values to class attributes 
					canStat.setPruid(attributes[0]);
					canStat.setPrname(attributes[1]);
					canStat.setPrnameFR(attributes[2]);
					canStat.setDate(attributes[3]);
					canStat.setReporting_week(attributes[4]);
					canStat.setReporting_year(attributes[5]);
					canStat.setUpdate(attributes[6]);
					canStat.setTotalcases(attributes[7]);
					canStat.setNumtotal_last7(attributes[8]);
					canStat.setRatecases_total(attributes[9]);
					canStat.setNumdeaths(attributes[10]);
					canStat.setNumdeaths_last7(attributes[11]);
					canStat.setRatedeaths(attributes[12]);
					canStat.setRatecases_last7(attributes[13]);
					canStat.setRatedeaths_last7(attributes[14]);
					canStat.setNumtotal_last14(attributes[15]);
					canStat.setNumdeaths_last14(attributes[16]);
					canStat.setRatetotal_last14(attributes[17]);
					canStat.setRatedeaths_last14(attributes[18]);
					canStat.setAvgcases_last7(attributes[19]);
					canStat.setAvgincidence_last7(attributes[20]);
					canStat.setAvgdeaths_last7(attributes[21]);
					canStat.setAvgratedeaths_last7(attributes[22]);

          //add the record to the covidList ArrayList
					covidList.add(canStat);

				}
			} finally {
				// The finally block always executes when the try block exits.
				// This ensures that the finally block is executed even if an unexpected
				// exception occurs.
				reader.close();
			}
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}// end of populateArrayListCan()

	// method to populate vaccineArrayList
	public static void populateVaccineList(ArrayList<vaccinationStats> vaccineLis) {


		try {
			// Read the CSV file from the WHO Official website
			URL url = new URL(WHO_VACCINATION_STATS);
       //Buffered Reader to access and read .csv file form URL
			BufferedReader input = new BufferedReader(new InputStreamReader(url.openStream()));
		

			try {
				String line = null;
				line = input.readLine();
				
				// Handling of lines without any value in the last column
				while ((line = input.readLine()) != null) {
					String[] attributes = line.split(",");
    
					if (attributes.length < 16) {
						line = line.concat("0.0");

						attributes = line.split(",");
					}
          
          // creating vaccineStats Class object
					vaccinationStats vaxStat = new vaccinationStats();

					vaxStat.setCountry(attributes[0]);
					vaxStat.setCountryCode(attributes[1]);
					vaxStat.setDate(attributes[2]);
					vaxStat.setTotalVaccinations(attributes[3]);
					vaxStat.setPeopleVaccinated(attributes[4]);
					vaxStat.setPeopleFullyVaccinated(attributes[5]);
					vaxStat.setTotalBoosters(attributes[6]);
					vaxStat.setDailyVaccinationsRaw(attributes[7]);
					vaxStat.setDailyVaccinations(attributes[8]);
					vaxStat.setTotalVaccinationsPer100(attributes[9]);
					vaxStat.setPeopleVaccinatedPer100(attributes[10]);
					vaxStat.setPeopleFullyVaccinatedPer100(attributes[11]);
					vaxStat.setTotalBoostersPer100(attributes[12]);
					vaxStat.setDailyVaccinationsPerMil(attributes[13]);
					vaxStat.setDailyPeopleVaccinated(attributes[14]);
					vaxStat.setDailyPeopleVaccinatedPer100(attributes[15]);

          //add the record to the covidList ArrayList
					vaccineLis.add(vaxStat);

					// System.out.println(str);
				} // end of while
			} finally {
				// The finally block always executes when the try block exits.
				// This ensures that the finally block is executed even if an unexpected
				// exception occurs.
				input.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}//end of populateVaccineList array

	
		
		/////////////////METHODS FOR GLOBAL, CANADA, AND VACCINATION TO SHOW STATS COLLECTED FROM .CSV FILE IN A FORMATTED OUTPUT


  //show formatted details WHO
	public static void showFormattedDetailsWHO(String country, ArrayList<globalStats> whoList) {
		boolean found = false;
		globalStats cStat;
		String ctry = ""; // store code from ArrayList
		 
		for (int i = 0; i < whoList.size(); i++) {
			cStat = whoList.get(i);
			
			// GET COUNTRY NAME WITHOUT SPECIAL CHARACTERS
			ctry = removeFrenchChars(cStat.getCountryName());

      //if country inputed by user matches with country on file
			if (ctry.toUpperCase().contains(country.toUpperCase())) {
				System.out.println("\nCOVID-19 Statistics:-");
				System.out.println("\t" + ctry.toUpperCase());
				System.out.println("\tWHO Region                              :" + cStat.getWhoRegion());
				System.out.println("\tTotal Cases                             :" + cStat.getTotalCases());
				System.out.println("\tTotal Cases per 100K                    :" + cStat.getTotalCasesPer100K());
				System.out.println("\tCases Reported in Last 7 days           :" + cStat.getCasesReportedLast7days());
				System.out.println(
						"\tCases Reported in Last 7 days Per 100K  :" + cStat.getCasesReportedLast7daysPer100K());
				System.out.println("\tCases Reported in Last 24 hrs           :" + cStat.getCasesReportedLast24hrs());
				System.out.println("\tTotal Deaths                            :" + cStat.getTotalDeaths());
				System.out.println("\tTotal Deaths per 100K                   :" + cStat.getTotalDeathsPer100K());
				System.out.println("\tDeaths Reported in Last 7 days          :" + cStat.getDeathsReportedLast7days());
				System.out.println(
						"\tDeaths Reported in Last 7 days Per 100K :" + cStat.getDeathsReportedLast7daysPer100K());
				System.out.println("\tDeaths Reported in Last 24hrs           :" + cStat.getDeathsReportedLast24hrs());
				found = true;
				break;

			}
		}
		if (!found) {
			System.out.println("Country not Found! Please enter  Valid Country Name.");
		}
	}// end of showFromatedDetailsWHO()
		

	// CANADA (PROVINCE) DISPLAY
	public static void showFormattedDetailsCan(String province, ArrayList<canadaStats> canList) {
		boolean found = false;
		canadaStats pStat;
		canadaStats lastStat = new canadaStats();
		String prov = ""; // store code from ArrayList
		for (int i = 0; i < canList.size(); i++) {
			pStat = canList.get(i);

			prov = pStat.getPrname(); // store code from ArrayList
			
			if (prov.toUpperCase().contains(province.toUpperCase())) {
				lastStat = pStat;

				prov = pStat.getPrname(); // store code from ArrayList
				found = true;

			}
    
		}
    //if country inputed by user doesn't match with country on file
		if (!found) {
			System.out.println("Province Not Found! Please Enter Valid Province Name.");

		}

		else if (found) {

			System.out.println("\nCOVID-19 Statistics:-");
			System.out.println("\t" + lastStat.getPrname().toUpperCase());

			System.out.println("\tTotal Cases                             :" + lastStat.getTotalcases());
			System.out.println("\tTotal Cases per 100K                    :" + lastStat.getRatecases_total());
			System.out.println("\tTotal Cases in Last 7 days              :" + lastStat.getNumtotal_last7());
			System.out.println("\tCases Reported in Last 7 days Per 100K  :" + lastStat.getRatecases_last7());
			System.out.println("\tAverage Cases in the Last 7 days        :" + lastStat.getAvgcases_last7());
			System.out.println("\tTotal Deaths                            :" + lastStat.getNumdeaths());
			System.out.println("\tTotal Deaths per 100K                   :" + lastStat.getRatecases_total());
			System.out.println("\tDeaths Reported in Last 7 days          :" + lastStat.getNumdeaths_last7());
			System.out.println("\tDeaths Reported in Last 7 days Per 100K :" + lastStat.getRatedeaths_last7());
			System.out.println("\tAverage Deaths in Last 7 days           :" + lastStat.getAvgdeaths_last7());
		}

	}// end of showFromatedDetails()
		// overloaded/////////////////////////////////////////////////////////

  
  // DISPLAY VAX STATS
	public static void showFormattedDetailsVax(String country, ArrayList<vaccinationStats> vaxList) {
		boolean found = false;
		vaccinationStats vStat;
		vaccinationStats lastStat = new vaccinationStats();
		String ctry = ""; // store code from ArrayList
		
		for (int i = 0; i < vaxList.size(); i++) {
			vStat = vaxList.get(i);

			ctry = vStat.getCountry(); // store code from ArrayList
		
			if (ctry.toUpperCase().contains(country.toUpperCase())) {
				lastStat = vStat;

				ctry = vStat.getCountry(); // store code from ArrayList
				found = true;

				// return cStat.toString();
			}

		}
    //if country inputed by user matches with country on file
		if (!found) {
			System.out.println("Province Not Found! Please Enter Valid Country Name.");

		}

		else if (found) {

			System.out.println("\nCOVID-19 Statistics:-");
			System.out.println("\t" + lastStat.getCountry().toUpperCase());
			System.out.println("\tTotal Vaccinations                                   :" + lastStat.getTotalVaccinations());
			System.out.println("\tTotal People Vaccinated (1 or 2 doses)               :" + lastStat.getPeopleVaccinated());
			System.out.println("\tTotal People Fully Vaccinated                        :" + lastStat.getPeopleFullyVaccinated());
			System.out.println("\tTotal People Vaccinated with a Booster Dose          :" + lastStat.getTotalBoosters());
			System.out.println("\tTotal People Vaccinated per 100                      :" + lastStat.getTotalVaccinationsPer100());
			System.out.println("\tTotal People Vaccinated (1 or 2 doses) per 100       :" + lastStat.getPeopleVaccinatedPer100());
			System.out.println("\tTotal People Fully Vaccinated per 100                :"+ lastStat.getPeopleFullyVaccinatedPer100());
			System.out.println("\tTotal People Vaccinated with a Booster Dose per 100  :" + lastStat.getTotalBoostersPer100());

		}

	}// end of showFormattedDetailsVax()

	
	/// Ask for user input that will be used for WHO COVID STATS
	/// /////////////////////////////////////////////////////////////
	public static String acceptUserInput(ArrayList<globalStats> whoList) {
		// Scanner input = new Scanner(System.in);
		String userChoice = "";
		int matchCount = 0;

		System.out.println("Please enter Country name:");
		userChoice = scan.nextLine();
    //trim userChoice
    userChoice = userChoice.trim();

		do {

			matchCount = getMatchingCountry(userChoice, whoList);

			if (matchCount > 1) {
				// System.out.println("Your input does not match with any countires from our
				// datbase\n\nDID YOU MEAN:\n" );
				System.out.println("Please enter an exact match:");
				userChoice = scan.nextLine();
        //trim userChoice
        userChoice = userChoice.trim();
				// userChoice=getMatchingCountry(userChoice, whoList);

			} else if (matchCount==0){
        System.out.println("\nCountry not found! \nPlease enter a valid country name :");
				userChoice = scan.nextLine();
        //trim userChoice
        userChoice = userChoice.trim();
      }
			
		} while (matchCount != 1);

		return userChoice;
	}// end of acceptUserInput()

  
		// ////////////////////////////////////////////////////////

	/// Ask for user input for Canada (provincial) Stats
	/// /////////////////////////////////////////////////////////////
	

	public static String acceptUserInputCan(ArrayList<canadaStats> provList) {
		// Scanner input = new Scanner(System.in);
		String userChoice = "";
		int matchCount = 0;

		System.out.println("Please enter Province name:");
		userChoice = scan.nextLine();
    //trim userChoice
    userChoice = userChoice.trim();
    

		do {

			matchCount = getMatchingProvince(userChoice, provList);
      
      //if there are more than 1 partial match
			if (matchCount > 1) {
				System.out.println("Please enter an exact match:");
				userChoice = scan.nextLine();
				// userChoice=getMatchingCountry(userChoice, whoList);

			}else if (matchCount==0){
        System.out.println("Province not found! \nPlease enter a valid Province name :");
				userChoice = scan.nextLine();
        //trim userChoice
        userChoice = userChoice.trim();
      }
			// else if(matchCount==1) {
			// return userChoice;
			// }
		} while (matchCount != 1);

		return userChoice;
	}// end of acceptUserInput()

  
	/// Ask for user input for Vaccination Stats
	/// /////////////////////////////////////////////////////////////
	public static String acceptUserInputVax(ArrayList<vaccinationStats> vaccineList) {
		// Scanner input = new Scanner(System.in);
		String userChoice = "";
		int matchCount = 0;

		System.out.println("Please enter Country name:");
		userChoice = scan.nextLine();
    //trim userChoice
    userChoice = userChoice.trim();

		do {

			matchCount = getMatchingCountryVax(userChoice, vaccineList);

			if (matchCount > 1) {
				//if there are more than 1 partial match
				System.out.println("Please enter an exact match:");
				userChoice = scan.nextLine();
        //trim userChoice
        userChoice = userChoice.trim();
				// userChoice=getMatchingCountry(userChoice, whoList);

        //if no matches...
			}else if (matchCount==0){
        System.out.println("Country not found! \n Please enter a valid country name :");
				userChoice = scan.nextLine();
        //trim userChoice
        userChoice = userChoice.trim();
      }
			
		} while (matchCount != 1);

		return userChoice;
	}// end of acceptUserInput()

	

	// CLEAR SCREEN
	public final static void clrscr() {
		System.out.print("\033[H\033[2J");
	}


	// Method that will be called under displayTravelAdvisory()
	// This method will determine and output the risk level of the country the user
	// is planning to visit
	// Will make decision based on total cases per 100K in the last 7 days
	public static void travelAdvisoryWHO() {

		// CONSTANTS for risk levels
		// These risk classification are based on CDC
		// These values are the max cases for each metric
		final int INSIGNIFICANT_RISK = 30;
		final int VERY_LOW_RISK = 141;
		final int LOW_RISK = 348;
		final int MODERATE_RISK = 1852;
		final int HIGH_RISK = 6680;
		// A country to be in "very high risk" should be GREATER than 6680
		final int VERY_HIGH_RISK = 6680;

		// integer variable to store string value and later covert it into a integer
		// value
		double casesReportedLast7daysPer100K = 0;

		// Array list for travel advisory
		ArrayList<globalStats> whoList = new ArrayList<globalStats>();
		// call populate arrayListMethodWHO() to populate this array list with the data
		// from csv file
		populateArrayListWHO(whoList);
		// variables
    //int matchCount;
		String countryName="";
		// ask for user input
		System.out.println("Which country are you planning to travel to? ");
		//////////////////////////
    //////////////
    //userChoice = scan.nextLine();
    
    countryName = acceptUserInput(whoList);  //????

    
		globalStats cStat;
		String ctry = ""; // store code from ArrayList
		// System.out.println(whoList.size());
		// This for loop will read the populated array list and looks for the country
		// match to user input
		for (int i = 0; i < whoList.size(); i++) {
			cStat = whoList.get(i);
			// ctry = cStat.getCountryName(); // store code from ArrayList
			// GET COUNTRY NAME WITHOUT SPECIAL CHARACTERS
			ctry = removeFrenchChars(cStat.getCountryName());

			// System.out.println(code+" "+cStat.getCumulativeCases());
			if (ctry.toUpperCase().contains(countryName.toUpperCase())) {

        try{
				casesReportedLast7daysPer100K = Double.parseDouble(cStat.getCasesReportedLast7daysPer100K());
        }
        catch(NumberFormatException e){
          System.out.println(e);
        }
        System.out.println("\n--------------------------------------------------");
				System.out.println("| Cases Reported in Last 7 days Per 100K: " + casesReportedLast7daysPer100K+" |");
        System.out.println("--------------------------------------------------");

				// return cStat.toString();
			} // end of if
		} // end of for loop

		if (casesReportedLast7daysPer100K <= INSIGNIFICANT_RISK) {
			System.out.println("\nInsignificant Risk of COVID-19!");
		}

		else if (casesReportedLast7daysPer100K > INSIGNIFICANT_RISK && casesReportedLast7daysPer100K <= VERY_LOW_RISK) {
			System.out.println("\nVery Low Risk of COVID-19!");
		}

		else if (casesReportedLast7daysPer100K > VERY_LOW_RISK && casesReportedLast7daysPer100K <= LOW_RISK) {
			System.out.println("\nLow Risk of COVID-19!");
		}

		else if (casesReportedLast7daysPer100K > LOW_RISK && casesReportedLast7daysPer100K <= MODERATE_RISK) {
			System.out.println("\nModerate Risk of COVID 19!");
		}

		else if (casesReportedLast7daysPer100K > MODERATE_RISK && casesReportedLast7daysPer100K <= HIGH_RISK) {
			System.out.println("\nHigh Risk of COVID-19!");
		}

		else if (casesReportedLast7daysPer100K > VERY_HIGH_RISK) {
			System.out.println("\nVery High Risk of COVID-19!");
		}

	}

	// Get matching province method will display a "Did you mean list" if the user
	// doesn't fully input the province name. This will narrow down the user
	// selection
	public static int getMatchingCountry(String country, ArrayList<globalStats> whoList) {
		int totalMatches = 0;
		ArrayList<String> didYouMeanList = new ArrayList<String>();
		String userChoice = "";
		boolean found = false;
		globalStats cStat;
		globalStats lastStat = new globalStats();
		String ctry = "";
		// int count=0;

		for (int i = 0; i < whoList.size(); i++) {
			cStat = whoList.get(i);

			ctry = cStat.getCountryName(); // store code from ArrayList
			// System.out.println(prov+" "+pStat.getTotalcases());
			if (ctry.equalsIgnoreCase(country)) {
				return 1;
			} else if (ctry.toUpperCase().contains(country.toUpperCase())) {
				// found="Y";
				// count=cStat.getTotalCases();
				lastStat = cStat;
				ctry = cStat.getCountryName(); // store code from ArrayList
				totalMatches++;
				didYouMeanList.add(ctry);
				// return cStat.toString();
			} // end of if inside loop

		} // end of loop

		// If statements for ........................
		if (totalMatches > 1) {
			System.out.println("Your input does not match with any countires from our datbase\n\nDID YOU MEAN:\n");
			System.out.println(didYouMeanList);
			// System.out.println("Please enter an exact match:");
			// userChoice=scan.next();
			didYouMeanList.clear();
			// userChoice=getMatchingCountry(userChoice, whoList);

		}
		/*
		 * else if(totalMatches==1) { return userChoice;
		 * 
		 * 
		 * }
		 */

		// RETRUN AN INVALID INPUT
		return totalMatches;

	}// end of getMatchingCountry()



  public static int getMatchingProvince(String province, ArrayList<canadaStats> provList) {
		int totalMatches = 0;
		//ArrayList<String> didYouMeanList = new ArrayList<String>();
		String userChoice = "";
		canadaStats pStat;
		String prov = "";
		int count=0;

		for (int i = 0; i < provList.size(); i++) {
			pStat = provList.get(i);

			prov = pStat.getPrname(); // store code from ArrayList
			if (prov.trim().equalsIgnoreCase(province.trim())) {
				count=1;
        break;
			} else {
        count= 0;
      }
		} // end of loop
   return count;
	}// end of getMatchingProvince()

	////// Get matching province method will display a "Did you mean list" if the
	////// user doesn't fully input the province name. This will narrow down the
	////// user selection
	// This will be used for the Vaccination Stats

	public static int getMatchingCountryVax(String country, ArrayList<vaccinationStats> vaccineList) {
		int totalMatches = 0;
    
		ArrayList<String> didYouMeanList = new ArrayList<String>();
		String userChoice = "";
		boolean newCtry = true;
		vaccinationStats cStat;
		vaccinationStats lastStat = new vaccinationStats();
		String ctry = "";
    String lastCtry="";
		Set<String> set;// int count=0;

		for (int i = 0; i < vaccineList.size(); i++) {
			cStat = vaccineList.get(i);
      //System.out.println(" getMatchingCountryVax ");
			ctry = cStat.getCountry(); // store code from ArrayList
      ctry=ctry.trim();
			// System.out.println(prov+" "+pStat.getTotalcases());
			if (ctry.trim().equalsIgnoreCase(country.trim())) {
				return 1;
			} else if (ctry.toUpperCase().contains(country.trim().toUpperCase())) {
				// found="Y";
				// count=cStat.getTotalCases();
        lastCtry=lastStat.getCountry();
				lastStat = cStat;
				ctry = cStat.getCountry(); // store code from ArrayList
				totalMatches++;
        
        didYouMeanList.add(ctry);
        //newCtry=false;
        //if (ctry.toUpperCase().contains(country.trim().toUpperCase()) && !newCtry) {
          //break;
        //}
				
				// return cStat.toString();
			} // end of if inside loop

		} // end of loop

		// If statements for ........................
		if (totalMatches > 1) {
      
			System.out.println("Your input does not match with any countires from our datbase\n\nDID YOU MEAN:\n");
      set= new HashSet<>(didYouMeanList);
      didYouMeanList.clear();
      didYouMeanList.addAll(set);
			System.out.println(didYouMeanList);
			// System.out.println("Please enter an exact match:");
			// userChoice=scan.next();
			didYouMeanList.clear();
			// userChoice=getMatchingCountry(userChoice, whoList);

		}
   // System.out.println(" getMatchingCountryVax End");
		return totalMatches;

	}// end of getMatchingCountryVax()

	// functions that determines the risk factor of the user to have covid-19
	// the report of the screening will be outputted in a file
	public static void slefScreening() {

		// series of questions asking the user about symptoms, vaccinations info, travel
		// history

		// travel history
		String travel = "";
		System.out.println("\n\nWelcome to COVID-19 Self Screening!\n\n\nPlease answer these following questions to determine your risk of being infected with COVID-19");
		System.out.println("----------------------------------------------------------------------------------");
		while (!travel.equalsIgnoreCase("yes") && !travel.equalsIgnoreCase("no")) {
			System.out.print("\nHave you recently traveled to a high-risk area? (yes/no) ");
			travel = scan.nextLine();
      //trim travel
      travel = travel.trim();
			if (!travel.equalsIgnoreCase("yes") && !travel.equalsIgnoreCase("no")) {
				System.out.println("\nInvalid input. Please enter 'yes' or 'no'.");
			}
		}

		// contact history
		String contact = "";
		while (!contact.equalsIgnoreCase("yes") && !contact.equalsIgnoreCase("no")) {
			System.out.print("\nHave you been in close contact with someone who has COVID-19? (yes/no) ");
			contact = scan.nextLine();
      //trim contact
      contact = contact.trim();
			if (!contact.equalsIgnoreCase("yes") && !contact.equalsIgnoreCase("no")) {
				System.out.println("\nInvalid input. Please enter 'yes' or 'no'.");
			}
		}

		// symptoms
		String symptoms = "";
		while (!symptoms.equalsIgnoreCase("yes") && !symptoms.equalsIgnoreCase("no")) {
			System.out.print("\nDo you have any symptoms of COVID-19, such as a fever, cough, or difficulty breathing? (yes/no) ");
			symptoms = scan.nextLine();
      //trim symtoms
      symptoms = symptoms.trim();
    
			if (!symptoms.equalsIgnoreCase("yes") && !symptoms.equalsIgnoreCase("no")) {
				System.out.println("\nInvalid input. Please enter 'yes' or 'no'.");
			}
		}

		// underlying conditions
		String underlyingConditions = "";
		while (!underlyingConditions.equalsIgnoreCase("yes") && !underlyingConditions.equalsIgnoreCase("no")) {
			System.out.print("\nDo you have any underlying health conditions that put you at higher risk for COVID-19 complications? (yes/no) ");
			underlyingConditions = scan.nextLine();
      //trim underlyingConditions
      underlyingConditions = underlyingConditions.trim();
      
			if (!underlyingConditions.equalsIgnoreCase("yes") && !underlyingConditions.equalsIgnoreCase("no")) {
				System.out.println("\nInvalid input. Please enter 'yes' or 'no'.");
			}
		}

		// vaccination history
		String vaccination = "";
		while (!vaccination.equalsIgnoreCase("yes") && !vaccination.equalsIgnoreCase("no")) {
			System.out.print("\nHave you been fully vaccinated against COVID-19? (yes/no) ");
			vaccination = scan.nextLine();
      //trim vacciantion
      vaccination = vaccination.trim();
      
			if (!vaccination.equalsIgnoreCase("yes") && !vaccination.equalsIgnoreCase("no")) {
				System.out.println("\nInvalid input. Please enter 'yes' or 'no'.");
			}
		}

		// last date vaccinated
		// using built in java class: LocalDate
		// LocalDate class is an immuteable class that represents date with default
		// format of yyyy-mm-dd.
		LocalDate lastTest = LocalDate.MIN;
		while (lastTest.equals(LocalDate.MIN)) {
			try {
				System.out.print("\nEnter the date of your last COVID-19 test (yyyy-mm-dd): ");
				lastTest = LocalDate.parse(scan.nextLine());

			} catch (DateTimeParseException e) {
				System.out.println("\nInvalid date format. Please enter a date in the format 'yyyy-mm-dd'.");
			}
		}

		// age of person doing self screening
		int age = 0;
		while (age <= 0) {
			System.out.print("\nEnter your age: ");
			try {
				age = scan.nextInt();
				scan.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid input. Please enter a valid age.");
				scan.nextLine();
			}
		}

		// calculate risk factor
		int riskFactor = 0;
		if (travel.equalsIgnoreCase("yes")) {
			riskFactor++;
		}
		if (contact.equalsIgnoreCase("yes")) {
			riskFactor++;
		}
		if (symptoms.equalsIgnoreCase("yes")) {
			riskFactor++;
		}
		if (underlyingConditions.equalsIgnoreCase("yes")) {
			riskFactor++;
		}
		if (vaccination.equalsIgnoreCase("no")) {
			riskFactor++;
		}
		if (LocalDate.now().minusDays(14).isAfter(lastTest)) {
			riskFactor++;
		}
		if (age > 65) {
			riskFactor++;
		}

		// output risk factor levels and additional information/advice
		String riskLevel = "";
		if (riskFactor <=1) {
			riskLevel = "low";
			System.out.println("\n\nBased on your answers, your risk of having COVID-19 is significantly low.");
			System.out.println(
					"You can carry on with you daily activities and you are safe to travel!");
		} else if (riskFactor == 2) {
			riskLevel = "low";
			System.out.println("\n\nBased on your answers, you may have a low risk of having COVID-19.");
			System.out.println(
					"Please continue to practice social distancing and good hygiene, and monitor your symptoms. You should be safe to travel, but make sure you feel 100% before you decide to do so!");
		} else if (riskFactor <= 3) {
			riskLevel = "moderate";
			System.out.println("\n\nBased on your answers, you may have a moderate risk of having COVID-19.");
			System.out.println(
					"Please consider getting a COVID-19 test and self-quarantine to prevent the spread of the virus.");
		} else {
			riskLevel = "high";
			System.out.println("\n\nBased on your answers, you may have a high risk of having COVID-19.");
			System.out.println(
					"Please contact your healthcare provider immediately and self-quarantine to prevent the spread of the virus.");
		}
		// outputting data to a text file where suer can see a quick summary of their
		// self screening
		try {
			FileWriter fileWriter = new FileWriter("screening_results.txt");
			fileWriter.write("COVID-19 Self-Screening Results" + "\n");
			fileWriter.write("Risk Level: " + riskLevel + "\n");
			fileWriter.write("Travel: " + travel + "\n");
			fileWriter.write("Close Contact: " + contact + "\n");
			fileWriter.write("Symptoms: " + symptoms + "\n");
			fileWriter.write("Underlying Conditions: " + underlyingConditions + "\n");
			fileWriter.write("Vaccination: " + vaccination + "\n");
			fileWriter.write("Last Test: " + lastTest + "\n");
			fileWriter.write("Age: " + age + "\n");
			fileWriter.close();
		} catch (IOException e) {
			System.out.println("Error saving data to file.");
		}

		System.out.println("Thank you for using the COVID-19 self-screening program. Stay safe and take care.");
	}//end of slef screening method

  

}////////////////////////////////////////// end of Main class
