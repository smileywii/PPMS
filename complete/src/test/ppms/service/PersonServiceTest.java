package ppms.service;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ppms.MocksCollector;

public class PersonServiceTest {
  private final MocksCollector mocksCollector = new MocksCollector();

  @Mock
  private PersonService personServiceMock;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @After
  public void tearDown() {
    verifyNoMoreInteractions(mocksCollector.getMocks());
  }

  @Test
  public void testNumberOfPeopleDoingSportAtAge() {
    fail("Not yet implemented");
  }

}
