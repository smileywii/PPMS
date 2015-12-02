package ppms.controller;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ppms.controller.PersonController;

public class PersonControllerTest {

  PersonController personController;

  @Before
  public void setUp() {
    personController = new PersonController();
  }

  @Test
  public void shoulReturnFalseWhenIdisNegative() {
    assertFalse(personController.idIsPositive(-1));
  }

  @Test
  public void shoulReturnTrueWhenIdisPositive() {
    assertTrue(personController.idIsPositive(1));
  }
}
