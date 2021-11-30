package proves;

import org.testng.annotations.Test;

import java.text.NumberFormat;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    Account account;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        account = new Account("me",1234,1000f);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void deposit() {
        assertTrue(account.deposit(5000f));
        assertFalse(account.deposit(-5000f));
    }

    @org.junit.jupiter.api.Test
    void withdraw() { //balance = 1000
        assertTrue(account.withdraw(400,5));
        assertFalse(account.withdraw(1001,5));
        assertFalse(account.withdraw(-500,-5));
        assertFalse(account.withdraw(-500,5));
        assertFalse(account.withdraw(500,-5));
    }

    @org.junit.jupiter.api.Test
    void getBalance() {
        assertEquals(1000,account.getBalance());
        assertNotEquals(999,account.getBalance());
    }

    @org.junit.jupiter.api.Test
    void getAccountNumber() {
        assertEquals(1234,account.getAccountNumber());
        assertNotEquals(1111,account.getAccountNumber());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        assertEquals(1234 + "\t" + "me" + "\t" + fmt.format(1000),account.toString());
        assertNotEquals(1234 + "\t" + "you" + "\t" + fmt.format(1000),account.toString());

    }
}