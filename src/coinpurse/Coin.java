package coinpurse;
/**
 * A coin with a monetary value and currency.
 */
public class Coin implements Comparable<Coin> {
	/** Value of the coin. */
    private final double value;
    /** The currency, of course. */
    private final String currency;
    
    /**
     * A coin with given value using the default currency.
     * @param value
     */
    public Coin( double value, String currency ) {
        this.value = value;
        this.currency = currency;
    }

    public double getValue( ) { return value; } 
    
    public String getCurrency() { return currency; }
    
    public boolean equals(Object obj) {
    	if (obj == null) return false;
    	if (obj.getClass() != this.getClass()) return false;
    	Coin coin = (Coin) obj;
    	return this.getValue()==coin.getValue()
    			&& this.getCurrency().equals(coin.getCurrency());
    }
    
    public String toString() { 
    	if (value%1.0 == 0) return String.format("%d-%s Coin", (int)Math.rint(value), currency);
    	return String.format("%.2f-%s Coin", value, currency);
    }
    
    public int compareTo(Coin other) {
    	if (other == null) return -1;
    	// for now, ignore currency
    	return Double.compare(this.getValue(), other.getValue());
    }
}
