package es.unileon.prg.date;

public class Date {

	private int day;
	
	private int month;
	
	private int year;

	public Date(int day, int month, int year) throws DateException{
		
		setDate(day, month, year);
	
	}	
	
	public void setDate(int day, int month, int year) throws DateException {
		
		this.day = day;
		/*System.out.println("Holaaa");*/
		
		this.month = month;
		
		this.year = year;
		if(comprobarDate(this.day,this.month,this.year));
		
	}
	/*
	public void setMonth(int month) {
		
		this.month = month;
		
	}
	
	public void setYear(int year) {
		
		this.year = year;
		
	}
	*/
	public boolean comprobarDate(int day, int month, int year) throws DateException {
		
		System.out.println("Recibida");
		
		boolean dayTrue = false;
		
		boolean monthTrue = false;
		
		System.out.println("this.month "+this.month);
		
		if(this.month < 1 || this.month > 12) {	
			
			throw new DateException("Month "+this.month+ " no es válido. Los meses válidos son de 1-12");

		}else if(this.day < 1 || this.day > comprobarNumberDaysMonth(month) ) {
					
			throw new DateException("Day "+day+ " no es válido para este mes "+ month+ ". Los días válidos dependen del mes");
					
		}
				
				
		return dayTrue && monthTrue;
		
	}
	
	public int comprobarNumberDaysMonth(int month) {
	
		System.out.println("A comprobar los días de este mes... "+ month);
		int numberOfDays = 0 ;
		
		switch(month) {
		
			case 2:
				numberOfDays = 28;
				break;
				
			case 1:
				
			case 3:
				
			case 5:
				
			case 7:
				
			case 8:
				
			case 10:
				
			case 12:
				
				numberOfDays = 31;
				break;
				
			case 4:
				
			case 6:
				
			case 9:
				
			case 11:
				
				numberOfDays = 30;
				
				break;
			
		
		}
		
		
		return numberOfDays;
		
	}
	
	public String getSeason(int month) {
		
		String season = null;
		
		switch(month) {
			
		case 1:
			
		case 2:
			
		case 12:
			
			season = "Invierno";
			
			break;
			
		case 3:
			
		case 4:
			
		case 5:
			
			season = "Primavera";
		
			break;
			
		case 6:
			
		case 7:
			
		case 8:
			
			season = "Verano";
			
			break;
			
		case 9:
			
		case 10:
			
		case 11:
			
			season = "Otoño";
			
			break;
		
		}
		
		return season;
	
	}
	
	@Override
	public String toString() {
		
		return this.day + "/" + this.month + "/" + this.year;
	
	}

}
