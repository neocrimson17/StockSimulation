package stocksimulation.tests;
import edu.ycp.cs320.stocksimulation.shared.*;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import edu.ycp.cs320.stocksimulation.shared.Money;

public class CashTransactionTest {
	
	private Money money;
	private CashTransaction cashTransaction;
	

	/**
	 *  Tests setMoney and getMoney
	 */
	@Test
	public void testSetMoney() {
		
		BigDecimal val = new BigDecimal("5000");
		money = new Money( val );
		
		cashTransaction.setMoney(money); // Causes error
		
		assertEquals(new BigDecimal("5000"), cashTransaction.getMoney());
	}

}
