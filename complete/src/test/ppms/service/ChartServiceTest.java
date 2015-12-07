package ppms.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ppms.MocksCollector;
import ppms.domain.NutritionalSupplement;
import ppms.domain.Person;
import ppms.domain.UsedSupplement;

public class ChartServiceTest {

  private final MocksCollector mocksCollector = new MocksCollector();

  @Mock
  private PersonService personServiceMock;

  @Mock
  private ChartService chartServiceMock;

  private ChartService chartService;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    chartService = new ChartService();
    chartService.setPersonService(personServiceMock);
  }

  @After
  public void tearDown() {
    verifyNoMoreInteractions(mocksCollector.getMocks());
  }

  @Test()
  public void getAllPeopleCountUsingThisBrandTest() {
    when(personServiceMock.findAll()).thenReturn(getPersonList());

    assertEquals(1, chartService.getAllPeopleCountUsingThisBrand("brand1"));
    verify(personServiceMock).findAll();
  }

  private List<Person> getPersonList() {
    Person person1 = new Person();
    Person person2 = new Person();
    NutritionalSupplement nutritionalSupplement1 = new NutritionalSupplement("name", "brand1", 1, "g", 1);
    NutritionalSupplement nutritionalSupplement2 = new NutritionalSupplement("name", "brand2", 1, "g", 1);
    UsedSupplement usedSupplement1 = new UsedSupplement(nutritionalSupplement1, person1);
    UsedSupplement usedSupplement2 = new UsedSupplement(nutritionalSupplement2, person2);
    person1.setUsedSupplementsList(Arrays.asList(usedSupplement1));
    person2.setUsedSupplementsList(Arrays.asList(usedSupplement2));
    return Arrays.asList(person1, person2);
  }
}
