package advanced_programming.uge4_linkedstak;

public class StakTest {

	public static void main(String[] args) {
		//Stak<Integer> stak;
		Stak<String> stak;
		
		//stak = new LinkedStakImpl<Integer>();
		//stak = new StakImpl<Integer>();

		stak = new LinkedStakImpl<String>();
		//stak = new StakImpl<String>();
		
		pushAndShow(stak);
		System.out.println("------------");
		stak = new StakImpl<String>();
		pushAndShow(stak);	
	}

	private static void pushAndShow(Stak<String> stak) {
		
//		Integer y = new Integer(3);
//		stak.push(new Integer(1));
//		stak.push(new Integer(2));
//		stak.push(y);
		stak.push("mærkelig ");
		stak.push("sætning");
		
		stak.show();
	}
}
