import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LbToKgsTest {
	
CtoFService x = new CtoFService();
	
	long y  = x.LbToKg(1);
	
	long test = (long) 3.45;
	
	
	@Test	
	public void testConversion() {
		//System.out.println("@Test sum(): " + sum + " = " + testSum);
		assertEquals(y,test);
	}


}
