import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    private BankAccount myAccount;

    @BeforeEach
    public void setUp() {
        myAccount = new BankAccount("Adamu divine", 7055, 100);
    }

    @Test
    public void IHaveAnAccountBalanceIs100IDeposit200BalanceIs300() {
        myAccount.deposit(200);

        assertEquals(300, myAccount.getBalance(7055));
    }

    @Test
    public void IHaveAnAccountWhenIInputWrongPinGetBalanceThrowsException() {
        myAccount.deposit(200);

        assertThrows(IllegalArgumentException.class,
                () -> myAccount.getBalance(1234));
    }

    @Test
    public void IHaveAnAccountIDepositMinus50_ThrowsException_BalanceRemains100() {
        assertThrows(IllegalArgumentException.class,
                () -> myAccount.deposit(-50));

        assertEquals(100, myAccount.getBalance(7055));
    }

    @Test
    public void IWithdraw100WithCorrectPinBalanceBecomes300() {
        myAccount.deposit(300);

        assertEquals(400, myAccount.getBalance(7055));

        myAccount.withdraw(100, 7055);

        assertEquals(300, myAccount.getBalance(7055));
    }

    @Test
    public void IWithdrawNegativeAmountThrowsException_BalanceRemains400() {
        myAccount.deposit(300);

        assertEquals(400, myAccount.getBalance(7055));

        assertThrows(IllegalArgumentException;
                () -> myAccount.withdraw(-100, 7055));

        assertEquals(400, myAccount.getBalance(7055));
    }
}
