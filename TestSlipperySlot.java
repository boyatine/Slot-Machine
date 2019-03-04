import static org.junit.Assert.*;
import org.junit.Test;

public class TestSlipperySlot {
	SlipperySlot mySlotMachine = new SlipperySlot();
	int payoff;

	@Test
	public void noPay() {
		// Tests a case that does not hit any rewards
		int[] values = {3, 5, 7, 11, 13};
		payoff = mySlotMachine.payOff(values);
		
		int expected = 0;
		
		assertEquals(payoff, expected);
	}
	
	@Test
	public void rule8() {
		// Tests single case of rule 8
		int[] values = {8, 7, 3, 6, 5};
		payoff = mySlotMachine.payOff(values);
		
		int expected = 3;
		
		assertEquals(payoff, expected);
	}
	
	@Test
	public void rule8Multi() {
		// Tests multiple cases of rule 8, reward once
		int[] values = {8, 7, 3, 6, 32};
		payoff = mySlotMachine.payOff(values);
		
		int expected = 3;
		
		assertEquals(payoff, expected);
	}
	
	@Test
	public void rule7() {
		// Tests single case of rule 7 + single rule 8
		int[] values = {8, 7, 3, 6, 42};
		payoff = mySlotMachine.payOff(values);
		
		int expected = 2 + 3;
		
		assertEquals(payoff, expected);
	}

	@Test
	public void rule7Multi() {
		// Tests multiple cases of rule 7, reward once, rule 5 applies
		int[] values = {8, 7, 42, 32, 42};
		payoff = mySlotMachine.payOff(values);
		
		int expected = 2 + 3 + 10;
		
		assertEquals(payoff, expected);
	}
	
	@Test
	public void rule6() {
		// Tests single case of rule 6
		int[] values = {49, 3, 5, 6, 7};
		payoff = mySlotMachine.payOff(values);
		
		int expected = 7;
		
		assertEquals(payoff, expected);
	}
	
	@Test
	public void rule6Multi() {
		// Tests multiple cases of rule 6, reward once
		int[] values = {49, 9, 25, 36, 3};
		payoff = mySlotMachine.payOff(values);
		
		int expected = 7;
		
		assertEquals(payoff, expected);
	}
	
	@Test
	public void rule5() {
		// Tests single case of rule 5
		int[] values = {31, 31, 3, 17, 23};
		payoff = mySlotMachine.payOff(values);
		
		int expected = 10;
		
		assertEquals(payoff, expected);
	}
	
	@Test
	public void rule5Multi() {
		// Tests multiple cases of rule 5, reward once
		int[] values = {31, 31, 3, 3, 17};
		payoff = mySlotMachine.payOff(values);
		
		int expected = 10;
		
		assertEquals(payoff, expected);
		// ERROR: Should return 10, returns 0
	}
	
	@Test
	public void rule4() {
		// Tests rule 4
		int[] values = {31, 31, 31, 17, 23};
		payoff = mySlotMachine.payOff(values);
		
		int expected = 100;
		
		assertEquals(payoff, expected);
		// ERROR: Should return 100, returns 0
	}
	
	@Test
	public void rule3() {
		// Tests rule 3
		int[] values = {31, 31, 31, 17, 17};
		payoff = mySlotMachine.payOff(values);
		
		int expected = 5000;
		
		assertEquals(payoff, expected);
	}
	
	@Test
	public void rule2() {
		// Tests rule 2
		int[] values = {31, 31, 31, 31, 23};
		payoff = mySlotMachine.payOff(values);
		
		int expected = 10000;
		
		assertEquals(payoff, expected);
		// ERROR: Should return 10000, returns 1000
	}
	
	@Test
	public void rule1() {
		// Tests rule 1
		int[] values = {31, 31, 31, 31, 31};
		payoff = mySlotMachine.payOff(values);
		
		int expected = 1000000;
		
		assertEquals(payoff, expected);
	}


	@Test
	public void multiRules8765() {
		// Tests rules 8, 7, 6, 5 simultaneously 
		int[] values = {4, 42, 42, 3, 5};
		payoff = mySlotMachine.payOff(values);
	
		int expected = 3 + 2 + 7 + 10;
	
		assertEquals(payoff, expected);
	}
	
	@Test
	public void multiRules8764() {
		// Tests rules 8, 7, 6, 4 simultaneously 
		int[] values = {4, 42, 42, 42, 5};
		payoff = mySlotMachine.payOff(values);
	
		int expected = 3 + 2 + 7 + 100;
	
		assertEquals(payoff, expected);
	}
	
	@Test
	public void multiRules8763() {
		// Tests rules 8, 7, 6, 3 simultaneously 
		int[] values = {4, 42, 42, 42, 4};
		payoff = mySlotMachine.payOff(values);
	
		int expected = 3 + 2 + 7 + 5000;
	
		assertEquals(payoff, expected);
	}	
	
	@Test
	public void multiRules8762() {
		// Tests rules 8, 7, 6, 2 simultaneously 
		int[] values = {4, 42, 42, 42, 42};
		payoff = mySlotMachine.payOff(values);
	
		int expected = 3 + 2 + 7 + 10000;
	
		assertEquals(payoff, expected);
	}
	
	@Test
	public void multiRules861() {
		// Tests rules 8, 6, 1 simultaneously 
		int[] values = {4, 4, 4, 4, 4};
		payoff = mySlotMachine.payOff(values);
	
		int expected = 3 + 7 + 1000000;
	
		assertEquals(payoff, expected);
	}
	
	@Test
	public void multiRules71() {
		// Tests rules 7, 1 simultaneously 
		int[] values = {42, 42, 42, 42, 42};
		payoff = mySlotMachine.payOff(values);
	
		int expected = 2 + 1000000;
	
		assertEquals(payoff, expected);
	}
}

