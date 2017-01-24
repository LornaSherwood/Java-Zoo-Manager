import static org.junit.Assert.*;
import org.junit.*;
import zoo_manager.*;
import java.util.*;
import org.mockito.*;
import static org.mockito.Mockito.*;


public class UnicornTest {
  Unicorn unicorn;
  Food food;
  Random stubRandom;

  @Before
  public void before(){
    stubRandom = mock(Random.class);
    unicorn = new Unicorn("Pointy", Gender.F, 5, 1, Diet.VEGETARIAN, EnclosureType.FOREST, HealthStatus.HEALTHY, stubRandom); 
    food = new Food("forbs", Diet.VEGETARIAN);
    
  }

  @Test
  public void canGetName(){
    assertEquals("Pointy", unicorn.getName());
  }

  @Test
  public void canGetGender(){
    assertEquals(Gender.F, unicorn.getGender());
  }

  @Test
  public void canGetSpaceValue(){
    assertEquals(5, unicorn.getSpaceValue());
  }

  @Test
  public void canGetOffspringValue() {
    assertEquals(1, unicorn.getOffspringValue());
  }

  @Test
  public void canGetDiet() {
    assertEquals(Diet.VEGETARIAN, unicorn.getDiet());
  }

  @Test
  public void canGetEnclosureType(){
    assertEquals(EnclosureType.FOREST, unicorn.getEnclosureType());
  }

  @Test
  public void canGetHealthStatus(){
    assertEquals(HealthStatus.HEALTHY, unicorn.getHealthStatus());
  }

  @Test
  public void canSetHealthStatus(){
    unicorn.setHealthStatus(HealthStatus.SICK);
    assertEquals(HealthStatus.SICK, unicorn.getHealthStatus());
  }

  @Test
  public void canRun() {
    assertEquals("Trots gracefully across the ground", unicorn.run());
  }

  @Test
  public void foodEatenStartsEmpty(){
    assertEquals(0, unicorn.countFood());
  }

  @Test 
  public void canEatFood(){
    unicorn.eatFood(food);
    assertEquals(1, unicorn.countFood());
  }

  @Test
  public void canEatFoodIfMatchesDiet(){
    boolean eatFood = unicorn.eatFoodIfMatchesDiet(food);
    assertEquals(true, eatFood);
    assertEquals(1, unicorn.countFood());
  }

  @Test
  public void canNotGetSick(){
    when(stubRandom.nextInt(10)).thenReturn(1); // mockito
    unicorn.getSick();
    assertEquals(HealthStatus.HEALTHY, unicorn.getHealthStatus());
  }

  @Test
  public void canGetSick(){
    when(stubRandom.nextInt(10)).thenReturn(8); // mockito
    unicorn.getSick();
    assertEquals(HealthStatus.SICK, unicorn.getHealthStatus());

  }
  
}

