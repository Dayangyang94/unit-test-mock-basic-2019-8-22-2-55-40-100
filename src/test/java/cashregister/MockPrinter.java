package cashregister;

public class MockPrinter extends Printer {
	private String tempText="";
	public String getTempText() {
		return tempText;
	}
	@Override
	public void print(String printThis) {
		super.print(printThis);
		tempText=printThis;
	}
}
