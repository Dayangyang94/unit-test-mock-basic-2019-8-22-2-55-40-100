package cashregister;

public class SubPurchase extends Purchase {
	
	public SubPurchase() {
		super(new Item[0]);
	}
	@Override
	  public String asString() {
      return "test product\t1.0\n";
    }

}
