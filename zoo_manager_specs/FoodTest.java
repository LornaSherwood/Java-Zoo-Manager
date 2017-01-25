import static org.junit.Assert.*;
import org.junit.*;
import zoo_manager.*;

public class FoodTest {
  Food food;

  @Before
  public void before(){
    food = new Food("forbs", Diet.VEGETARIAN); 
  }

  @Test
  public void canGetName(){
    assertEquals("forbs", food.getName());
  }

  @Test
  public void canGetDiet(){
    assertEquals(Diet.VEGETARIAN, food.getDiet());
  }

}
