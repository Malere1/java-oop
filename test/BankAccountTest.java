

       

    
    package bankAccountSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountSystemTest {

    /*
    deposit
    withdrawal
    checkBalance
    transfer
     */

    private BankAccountSystem myBank;
    @BeforeEach
    public void setUp() {
        myBank = new BankAccountSystem();
    }

    @Test
    public void deposit100_balanceIs100() {


        myBank.deposit(100);
        assertEquals(100,myBank.getBalance());
    }

    @Test
    public void deposit100twice_balanceIs200() {

        myBank.deposit(100);
        myBank.deposit(100);
        assertEquals(200,myBank.getBalance());
    }

    @Test
    public void depositNegative500_balanceIs0() {
        myBank.deposit(-500);
        assertEquals(0, myBank.getBalance());
    }

//    @Test
//    public void withdraw200From500_balanceIs300() {
//        myBank.deposit(500);
//        myBank.withdraw(200);
//        assertEquals(300, myBank.getBalance());
//    }

//    @Test
//    public void withdrawNegative300From800_balanceIs800() {
//
//    }






}
