package cashregister;


import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CashRegisterTest {


    @Test
    public void should_print_the_real_purchase_when_call_process() {
        //given
        Printer printer = mock(Printer.class);
        CashRegister cashRegister = new CashRegister(printer);
        Purchase purchase = new Purchase(new Item[0]);

        //when
        cashRegister.process(purchase);

        //then
        verify(printer).print("");
    }

    @Test
    public void should_print_the_stub_purchase_when_call_process() {
        //given
        Printer printer = mock(Printer.class);
        CashRegister cashRegister = new CashRegister(printer);
        Purchase purchase = mock(Purchase.class);
        when(purchase.asString()).thenReturn("anything return by purchase");

        //when
        cashRegister.process(purchase);

        //then
        verify(printer).print("anything return by purchase");
    }

    @Test
    public void should_verify_with_process_call_with_mockito() {
        //given
        Printer printer = mock(Printer.class);
        CashRegister cashRegister = new CashRegister(printer);
        Purchase purchase = mock(Purchase.class);
        when(purchase.asString()).thenReturn("anything return by purchase");

        //when
        cashRegister.process(purchase);

        //then
        verify(purchase).asString();
    }

}
