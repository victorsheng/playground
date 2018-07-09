import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AccountTest {

  private Account account;

  @Before
  public void before() {
    account = new Account();
  }

  @Test
  public void given20AndMin10_whenWithdraw5_thenSuccess() {
    assertTrue(account.withdraw(5));
  }

  @Test
  public void given20AndMin10_whenWithdraw100_thenFail() {
    assertFalse(account.withdraw(100));
  }
}