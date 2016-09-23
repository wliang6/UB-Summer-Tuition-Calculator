package UBTuitionCalculator;

/**
 * ProjectPortfolio
 * @author Winnie Sep 22, 2016
 * Fees.java
 * The purpose of this small summer tuition calculator is to implement 
 * the MVC (Model-View-Controller) architectural pattern. 
 * Model - transitioning the data to object classes and making a UML diagram to show the design of the UI
 * View - what the user visualizes; particularly the user interface (UI)
 * Controller - the code and logic behind the program; links the model and the view together
 * 
 * The interface allows a typical undergraduate student from University at Buffalo
 * to input their name, resident status, and # credits they are taking. 
 * The estimated cost is then displayed to them on the interface. 
 */



//*******MY MODEL********
public class Fees { 
	
	final static double NYS_TUITION= 270.00;
	final static double NON_NYS_TUITION = 898.00;
	final static double COMPREHENSIVE_FEE = 74.06;
	final static double ACADEMIC_EXCELLENCE_FEE = 15.63;
	final static double ACTIVITY_FEE = 17.52;
	final static double TRANSCRIPT_FEE = 5.00;
	
	
	private static String name;
	private static boolean nysResident;
	private static int credits; //how many credits they are taking
	
	public Fees(String nam, boolean resident, int credit){
		name = setName(nam);
		nysResident = resident;
		credits = setCredits(credit);
	}


	private String setName(String name) {
		name = name.toLowerCase();
		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		return name;
		
	}
	
	private int setCredits(int credit) {
		if(credit < 0){
			credit = 0;
		}
		return credit;
	}
	
	public static double calculateFee(){
		double total = 0.0;
		if(nysResident){
			if(credits < 1){
				total = 0.0;
			}else{
				total = (NYS_TUITION + COMPREHENSIVE_FEE + ACADEMIC_EXCELLENCE_FEE) * credits + ACTIVITY_FEE + TRANSCRIPT_FEE;
			}
		} else{
			if(credits < 1){
				total = 0.0;
			}else{
				total = (NON_NYS_TUITION + COMPREHENSIVE_FEE + ACADEMIC_EXCELLENCE_FEE) * credits + ACTIVITY_FEE + TRANSCRIPT_FEE;
			}
		}
		return total;
		
	}
}
