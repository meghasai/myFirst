import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 */

/**
 * @author meghasai
 *
 */
public class KgsToLbTest {

	
	
	FtoCService x = new FtoCService();
	
	long y  = x.kgToLb(1);
	
	long test = (long) 5.456;
	
	
	@Test	
	public void testConversion() {
		//System.out.println("@Test sum(): " + sum + " = " + testSum);
		assertEquals(y,test);
	}
	
}
