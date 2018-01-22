package coinpurse;
import static org.junit.Assert.*
;

import org.junit.Before;
import org.junit.Test;
/**
 * Test of the Coin class.
 *
 * @author  Resident Evil (good testers are evil)
 */
public class CoinTest1 extends junit.framework.TestCase {
	private static final double TOL = 1.0E-6; // tolerance for f.p. comparisons
	private String currency = "Baht";
	/**
	 * Setup any test fixtures.
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link coinpurse.Coin#getValue()}.
	 */
	@Test(timeout=1000)
	public void testGetValue() {
		
		Coin one = new Coin(1, currency);
		Coin coin = new Coin(5.0, currency);
		Coin big = new Coin(1000000, currency);
		assertEquals( 5.0, coin.getValue(), TOL );
		assertEquals( 1.0, one.getValue(), TOL );
		assertEquals( 1000000.0, big.getValue() );
		// do it again to test the value didn't change.
		assertEquals( 5.0, coin.getValue(), TOL );
		assertEquals( 1.0, one.getValue(), TOL );
		assertEquals( 1000000.0, big.getValue() );
	}

	/**
	 * Test the equals method.
	 */
	public void testEquals() {
		String currency = "Baht";
		Coin coin1 = new Coin(10, currency);
		Coin coin2 = new Coin(10, currency);
		Coin coin3 = new Coin(5, currency);
		assertFalse( "Coin can't equal null", coin1.equals(null) );
		// coin.equals(non-coin) should be false
		Double ten = new Double(10);
		assertFalse( "Coin does not equal Double",coin1.equals(ten) );
		// now test with coins
		assertTrue( coin1.equals(coin1) );
		// do it again - test the value didn't change.
		assertTrue( coin2.equals(coin1) );
		// coins with same currency but different value
		assertFalse( coin1.equals(coin3) );
		assertFalse( coin3.equals(coin1) );
		// coins with same value but different currency
		Coin bath = new Coin(10.0, "Bath"); // common misspelling
		assertFalse( coin1.equals(bath) );
	}
	
	/**
	 * test that compareTo orders coins by increasing value
	 */
	/* @Test(timeout=100) */
	public void testCompareTo() {
		String currency = "USD";
		Coin coin1 = new Coin(1, currency);
		Coin coin2 = new Coin(2, currency);
//		assertTrue( coin1.compareTo(null) < 0 );
		assertEquals( 0, coin1.compareTo(coin1) );
		assertTrue( coin1.compareTo(coin2) < 0 );
		assertTrue( coin2.compareTo(coin1) > 0 );
		Coin clone = new Coin(coin1.getValue(), coin1.getCurrency());
		assertEquals( 0, coin1.compareTo(clone) );
		// an extreme case
		Coin max = new Coin(Integer.MAX_VALUE, currency);
		assertTrue( coin1.compareTo(max) < 0 );
		assertTrue( max.compareTo(coin1) > 0 );
	}

	/**
	 * Test that toString() contains the value of the coin
	 */
	public void testToString() {
	    Coin coin = new Coin(123, "Rupee");
	    String s = coin.toString();
	    assertTrue(s.startsWith("123"));
	    assertTrue(s.contains("Rupee"));
	    
	    coin = new Coin(555, "Dragma");
	    s = coin.toString();
	    assertTrue(s.startsWith("555"));
	    assertTrue(s.contains("Dragma"));
	}
}

