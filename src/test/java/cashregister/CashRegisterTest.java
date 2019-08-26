package cashregister;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CashRegisterTest {


    @Test
    public void should_print_the_real_purchase_when_call_process() {
        //given
    	Item[] items= {new Item("test product", 1)};
    	Purchase purchase=new Purchase(items);
    	MockPrinter mockprinter=new MockPrinter();
    	CashRegister cashRegister=new CashRegister(mockprinter);
        //when
    	cashRegister.process(purchase);
        //then
    	assertEquals("test product\t1.0\n", mockprinter.getTempText());
    }

    @Test
    public void should_print_the_stub_purchase_when_call_process() {
        //given
        //when
        //then
    }

    @Test
    public void should_verify_with_process_call_with_mockito() {
        //given
        //when
        //then
    }

}
