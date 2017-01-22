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
    assertEquals(0, manager.countRunners());
  }

  @Test
  public void canGetRunner(){
    manager.getRunner(unicorn);
    assertEquals(1, manager.countRunners());
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
  public void canFeedRunner(){
    manager.getRunner(unicorn);
    manager.getFood(forbs);
    manager.feedRunner(unicorn, forbs);
    assertEquals(1, unicorn.countFood());
  }

  

  
}