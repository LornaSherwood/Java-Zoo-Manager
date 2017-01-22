import static org.junit.Assert.*;
import org.junit.*;
import zoo_manager.*;



public class FoodTest {
  Food food;


  @Before
  public void before(){
    food = new Food("forbs", "vegetarian"); 
  }

  @Test
  public void canGetName(){
    assertEquals("forbs", food.getName());
  }

  @Test
  public void canGetCategory(){
    assertEquals("vegetarian", food.getCategory());
  }

}
