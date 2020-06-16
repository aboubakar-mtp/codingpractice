package concepts;



public class TestEnum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Day day1 = Day.FRI;
		System.out.println(day1);
		day1.whoAreYou();
		
		System.out.println(day1.value);
		
		Day day2 = Day.MON;
		System.out.println(day2.value);

	}

}
