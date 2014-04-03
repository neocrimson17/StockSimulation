package stocksimulation.tests;
import java.math.BigDecimal;

import edu.ycp.cs320.stocksimulation.shared.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class MoneyTest {

	@Test
	public void testGetMoney() {
		
		BigDecimal val = new BigDecimal("5000");
		Money test = new Money(val);
		
		assertEquals("Money: Failed to create", val, test.getAmount());
	}
	
	@Test
	public void testSubtract(){
		
		// Sets amount1 to $5000
		BigDecimal val = new BigDecimal("5000");
		Money amount1 = new Money(val);
		
		// Sets amount2 to $3000
		BigDecimal val2 = new BigDecimal("3000");
		Money amount2 = new Money(val2);
		
		amount1.subtract(amount2);
		
		assertEquals("Money: Failed to subtract", "5000", amount1.getAmount());
		
	}

}
