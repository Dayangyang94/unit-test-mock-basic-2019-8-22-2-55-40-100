package cashregister;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CashRegisterTest {
	private static MockPrinter mockprinter;
	private static CashRegister cashRegister;
	
	@BeforeAll
	public static void setUp() {
		 mockprinter=new MockPrinter();
    	 cashRegister=new CashRegister(mockprinter);
	}
	@BeforeEach
	@Disabled
	public void clearUp() {
		mockprinter.setTempText("");
	}

    @Test
    public void should_print_the_real_purchase_when_call_process() {
        //given
    	Item[] items= {new Item("test product", 1)};
    	Purchase purchase=new Purchase(items);
    	
        //when
    	cashRegister.process(purchase);
        //then
    	assertEquals("test product\t1.0\n", mockprinter.getTempText());
    }

    @Test
    public void should_print_the_stub_purchase_when_call_process() {
        //given
    	SubPurchase subpurchase=new SubPurchase();
        //when
    	cashRegister.process(subpurchase);
        //then
    	assertEquals("test product\t1.0\n", mockprinter.getTempText());
    }

    @Test
    public void should_verify_with_process_call_with_mockito() {
        //given
    	Printer printer=Mockito.mock(Printer.class);//mock
    	Purchase purchase=Mockito.mock(Purchase.class);
    	Mockito.when(purchase.asString()).thenReturn("test product\t1.0\n");
        //when
    	CashRegister cashregister=new CashRegister(printer);
    	cashregister.process(purchase);
        //then
    	Mockito.verify(printer).print("test product\t1.0\n");
    	
    }

}
