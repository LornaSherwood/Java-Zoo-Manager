import static org.junit.Assert.*;
import org.junit.*;
import zoo_manager.*;
import java.util.*;

public class ManagerTest {
  Manager manager;
  Unicorn unicorn;
  Food forbs;
  Enclosure enclosure;  

  @Before
  public void before(){
    manager = new Manager();
    unicorn = new Unicorn("Pointy", 'F', 5, 1, "vegetarian", "forest"); 
    forbs = new Food("forbs", "vegetarian");
    enclosure = new Enclosure("Soaring Heights", "Aerial", 100);
  }

  @Test 
  public void animalsStartEmpty(){
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

  @Test
  public void enclosuresStartEmpty(){
    assertEquals(0, manager.countEnclosures());
  }

  @Test
  public void canGetEnclosure(){
    manager.getEnclosure(enclosure);
    assertEquals(1, manager.countEnclosures());
  }

  // @Test
  // public void canAddAnimaltoEnclosure(){
  //   manager.getAnimal(unicorn);
  //   manager.getEnclosure(enclosure);
  //   manager.addAnimalToEnclosure(unicorn, enclosure);
  //   assertEquals(0, manager.countAnimals());
  //   assertEquals(1, enclosure.countAnimals());

  // }

  

  
}