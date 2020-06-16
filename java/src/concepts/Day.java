package concepts;

public enum Day {
	SUN, MON, TUE, WED, THU, FRI, SAT;
	
	private Day() {
		System.out.println("In constructor with : " + this.toString()) ;
		
	}
	
	int value;
	
	private Day(int v) {
		this.value = v;
	}
	
	public void whoAreYou() {
		System.out.println("I'm a day of the week");
	}

}
