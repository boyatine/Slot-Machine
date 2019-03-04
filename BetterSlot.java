import java.util.Arrays;

public class BetterSlot {
	private int max = 50, min = 1, size = 5;

	public BetterSlot() {
		
	}
	
	public int[] pullTheLever() {
		int[] numbers = new int[size];
		
		for( int i = 0; i < 5; i++ )
			numbers[i] = (int)(Math.random() * ( ( max - min ) + 1 ) ) + min;
		
		return numbers;
	}
	
	public int payOff(int[] m) {
		
		Arrays.sort(m);
		
		int pay = 0;
		int one = m[0], two = m[1], three = m[2], four = m[3], five = m[4];
	
		// rule 8
		if( rule8(one) || rule8(two) || rule8(three) || rule8(four)|| rule8(five) )
			pay += 3;
		
		// rule 7
		if( rule7(one) || rule7(two) || rule7(three) || rule7(four)|| rule7(five) )
			pay += 2;
		
		// rule 6
		if( rule6(one) || rule6(two) || rule6(three) || rule6(four)|| rule6(five) )
			pay += 7;
		
		// rule 1 (must be checked first before rules 2, 3, 4, 5)
		if( one == two && two == three && three == four && four == five )
			pay += 1000000;
		
		// rule 2 (must be checked before rules 3, 4, 5)
		else if( ( one == two && two == three && three == four ) 
				|| ( two == three && three == four && four == five ) )
			pay += 10000;
		
		// rule 3 (must be checked before rules 4, 5)
		else if( ( one == two && two == three && four == five )
				|| ( one == two && three == four && four == five ) )
			pay += 5000;
		
		// rule 4 (must be checked before rule 5)
		else if( ( one == two && two == three ) || ( three == four && four == five ) || ( two == three && three == four ) )
			pay += 100;
		
		// rule 5
		else if( ( one == two || two == three || three == four || four == five ) )
			pay += 10;		
		
		return pay;
	}
	
	private boolean rule8(int n) {
		if ( n % 2 != 0 && n != 1 )
			return false;
		else {
			for ( int i = 0; i <= n; i++ )
				if (Math.pow(2, i) == n)
					return true;    	
			return false;
		}
	}
	
	private boolean rule7(int n) {
		return( n == 42 );
	}

	private boolean rule6(int n) {
		double rt = Math.sqrt(n);
		return( rt - Math.floor(rt) == 0 );
	}
}
