package cashregister;

public class MockPrinter extends Printer {
	private String tempText="";
	public String getTempText() {
		return tempText;
	}
	public void setTempText(String tempText) {
		this.tempText=tempText;
	}
	@Override
	public void print(String printThis) {
		super.print(printThis);
		tempText=printThis;
	}
}
