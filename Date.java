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
					
		}else {
			
			getMonthName(month);
			System.out.println("Los meses para acabar el año: "+getMonthToEndYear(month));
			//getMonthToEndYear(month);
			//System.out.println("Holaaa "+getMonthToEndYear(month).toString());
			getSeason(month);
			System.out.println("La estacion es: "+getSeason(month));
			//getMonthsWithSameNumberOfDays(month);
			System.out.println(getMonthsWithSameNumberOfDays(month));
			
			//System.out.println("Las fechas para acbar el mes son: "+datesUntilEndTheMonth(day, month, year).toString());
			
			System.out.println("Las fechas que han pasado desde el primer del año son: "+getDatesSinceFirstDayOfYear(this.day, this.month, this.year));
		
			System.out.println("El número de intentos para generar una fecha igual es: "+getNumberOfAttempts());
		}
				
				
		return dayTrue && monthTrue;
		
	}
	public int getNumberOfAttempts() {
		// TODO Auto-generated method stub
		
		int numberOfAttempts = 0;
		
		int day, month, year;
		
		
		do {
			
			day = (int) (Math.random() * 31) + 1;
			
			month = (int) (Math.random()*31) + 1;
			
			year = (int) (Math.random() *31) + 1 ;
			
			numberOfAttempts++;
			
		}while(day != this.day && month != this.month && year != this.year);
		
		
		return numberOfAttempts;
	}

	public int getDatesSinceFirstDayOfYear(int day, int month, int year) {
		// TODO Auto-generated method stub
		
		int days = 0;
		
		for(int i = 0; i < day; i++ ) {
			
			for(int j = 0; j < month; j++) {
				
				days++;
				
			}
			
		}
		
		
		return days;
	}

	public Date datesUntilEndTheMonth(int day, int month, int year) {
		
		Date dateMonth = null;
		
		if(day+1<comprobarNumberDaysMonth(month)) {
		
		for(int i = day; i<comprobarNumberDaysMonth(month); i++) {
			
				try {
					dateMonth = new Date(i, month, year);
				} catch (DateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		
		}
		
		return dateMonth;
	
	}
	public String getMonthsWithSameNumberOfDays(int month) {
		// TODO Auto-generated method stub
		String mesesConMismoNumeroDias = " , ";
		
		int cont = 1;
		
		String nuevaCadena  = "Meses con mismo número de días: ";

			//nuevaCadena = nuevaCadena.concat(monthToEndTheYear.concat(getMonthName(i)));
			
		while(cont <= 12) {
			
			if(comprobarNumberDaysMonth(month) == comprobarNumberDaysMonth(cont)&&(cont!=month)) {
					
					nuevaCadena = nuevaCadena.concat(mesesConMismoNumeroDias).concat(getMonthName(cont));
					//System.out.println("Holita "+getMonthName(cont).toString());
							
			}
			cont++;
		}
			
		return nuevaCadena;
		
	}

	public String getMonthName(int month) {
		// TO DO Auto-generated method stub
		
		String monthName = null;
		
		switch(month) {
		
			case 1:
			
				monthName = "Enero";
				break;
			
			case 2:
			
				monthName = "Febrero";
				break;
			
			case 3:
			
				monthName = "Marzo";
				break;
			
			case 4:
			
				monthName = "Abril";
				break;
			
			case 5:
			
				monthName = "Mayo";
				break;
			
			case 6:
			
				monthName = "Junio";
				break;
			
			case 7:
			
				monthName = "Julio";
				break;
			
			case 8:
			
				monthName = "Agosto";
				break;
				
			case 9:
			
				monthName = "Septiembre";
				break;
			
			case 10:
			
				monthName = "Octubre";
				break;
			
			case 11:
			
				monthName = "Noviembre";
				break;
			
			case 12:
		
				monthName = "Diciembre";
				break;
		
			}	
		
		return monthName;
			
	}

	public int comprobarNumberDaysMonth(int month) {
	
		//System.out.println("A comprobar los días de este mes... "+ month);
		
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
	
	public boolean isSame(Date other) {
		
		if((isSameDay(other.day, this.day) && (isSameMonth(other.month, this.month) == true) && (isSameYear(this.year, other.year)==true))) {
			
			return true;
			
		}else {
			
			return false;
			
		}
		
			
	}
	
	private boolean isSameDay(int day, int day2) {
		// TO DO Auto-generated method stub
		
		if(day == day2) {
			
			return true;
			
		}else {
		
		return false;
	
		}

	}	
	private boolean isSameMonth(int month, int month2) {
		// TO DO Auto-generated method stub
		
		if(month== month2) {
			
			return true;
			
		}else {
		
			return false;
		
		}
		
	}

	private boolean isSameYear(int year, int year2) {
		// TO DO Auto-generated method stub
		
		if(this.year == year2) {
			
			return true;
			
		}else {
		
			return false;
	
		}

	}	
	
	public String getMonthToEndYear(int month) {
		
		String monthToEndTheYear= " , ";
		
		if(month != 12 && month+2 < 12) {
		
			String nuevaCadena  = getMonthName(month+1);
		
			for(int i = month+2; i <= 12; i++) {
			
				nuevaCadena = nuevaCadena.concat(monthToEndTheYear.concat(getMonthName(i)));
		
			}
		
		return nuevaCadena;
		
		}	else {
			
			return "Diciembre, es el último mes.";
			
		}
		
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
