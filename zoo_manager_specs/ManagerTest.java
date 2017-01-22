import static org.junit.Assert.*;
import org.junit.*;
import zoo_manager.*;
import java.util.*;

public class ManagerTest {
  Manager manager;
  Unicorn unicorn;
  Food forbs;  

  @Before
  public void before(){
    manager = new Manager();
    unicorn = new Unicorn("Pointy", 'F', 5, 1, "vegetarian"); 
    forbs = new Food("forbs", "vegetarian");
  }

  @Test 
  public void runnersStartEmpty(){
    assertEquals(0, manager.countAnimals());
  }

  @Test
  public void canGetAnimal(){
    manager.getAnimal(unicorn);
    assertEquals(1, manager.countAnimals());
  }

  @Test
  public void foodStartsEmpty(){
    assertEquals(0, manager.countFood());
  }

  @Test 
  public void canGetFood(){
    manager.getFood(forbs);
    assertEquals(1, manager.countFood());
  }

  @Test
  public void canFeedAnimal(){
    manager.getAnimal(unicorn);
    manager.getFood(forbs);
    manager.feedAnimal(unicorn, forbs);
    assertEquals(1, unicorn.countFood());
  }

  

  
}