package proves;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    Account account;

    @BeforeEach
    void setUp() {
        account = new Account("me",1234,1000f);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void deposit() {
        assertTrue(account.deposit(5000f));
        assertFalse(account.deposit(-5000f));
    }

    @Test
    void withdraw() {
        assertTrue(account.withdraw(400,5));
        assertFalse(account.withdraw(1001,5));
        assertFalse(account.withdraw(-500,-5));
        assertFalse(account.withdraw(-500,5));
        assertFalse(account.withdraw(500,-5));
    }
    @Test
    void addAnnualInterest(){
        float tmp = account.getBalance();
        tmp += tmp * 0.1f;
        account.addAnnualInterest();
        assertEquals(tmp , account.getBalance());
    }

    @Test
    void getBalance() {
        assertEquals(1000,account.getBalance());
        assertNotEquals(999,account.getBalance());
    }

    @Test
    void getAccountNumber() {
        assertEquals(1234,account.getAccountNumber());
        assertNotEquals(1111,account.getAccountNumber());
    }

    @Test
    void testToString() {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        assertEquals(1234 + "\t" + "me" + "\t" + fmt.format(1000),account.toString());
        assertNotEquals(1234 + "\t" + "you" + "\t" + fmt.format(1000),account.toString());
    }

    @Test
    void transfer(){
        Account fooAccount = new Account("foo",1111,1000f);

        assertTrue(account.transfer(fooAccount,1000f));
        assertTrue(new Account("A1",2222,900f).transfer(fooAccount,100f));
        assertFalse(new Account("A2",2223,1000f).transfer(fooAccount,1001f));
        assertFalse(new Account("A3",2224,1000f).transfer(fooAccount,-1000f));
        assertFalse(new Account("A4",2225,1000f).transfer(fooAccount,-1001f));
        assertFalse(new Account("A5",2226,1000f).transfer(fooAccount,0f));
        assertFalse(new Account("A5",2227,0f).transfer(fooAccount,0f));

    }

}