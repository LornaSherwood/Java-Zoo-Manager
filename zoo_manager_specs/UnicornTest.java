import static org.junit.Assert.*;
import org.junit.*;
import zoo_manager.*;
import java.util.*;


public class UnicornTest {
  Unicorn unicorn;
  Food food;


  @Before
  public void before(){
    unicorn = new Unicorn("Pointy", Gender.F, 5, 1, Diet.VEGETARIAN, EnclosureType.FOREST); 
    food = new Food("forbs", Diet.VEGETARIAN);
    
  }
  // to test inheritence from Animal class
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
  //end of testing inheritience

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

  
}