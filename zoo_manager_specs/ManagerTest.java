import static org.junit.Assert.*;
import org.junit.*;
import zoo_manager.*;
import java.util.*;

public class ManagerTest {
  Manager manager;
  Unicorn unicorn;
  Food forbs;
  Enclosure enclosure;
  Enclosure enclosure2;
  Enclosure enclosure3;

  @Before
  public void before(){
    manager = new Manager();
    unicorn = new Unicorn("Pointy", 'F', 5, 1, "vegetarian", "forest"); 
    forbs = new Food("forbs", "vegetarian");
    enclosure = new Enclosure("Magic Glade", "forest", 100);
    enclosure2 = new Enclosure("Soaring Heights", "aerial", 100);
    enclosure3 = new Enclosure("Magic Glade", "forest", 4);
  }

  @Test 
  public void animalsStartEmpty(){
    assertEquals(0, manager.countAnimals());
  }

  @Test
  public void canAddAnimal(){
    manager.addAnimal(unicorn);
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
    manager.addAnimal(unicorn);
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

  @Test
  public void canAddAnimaltoRightEnclosure(){
    manager.addAnimal(unicorn);
    manager.getEnclosure(enclosure);
    manager.addAnimalToEnclosure(unicorn, enclosure);
    assertEquals(0, manager.countAnimals());
    assertEquals(1, enclosure.countAnimals());
  }

  public void canAddAnimaltoRightEnclosureMessage(){
    manager.addAnimal(unicorn);
    manager.getEnclosure(enclosure);
    String message = manager.addAnimalToEnclosure(unicorn, enclosure);
    assertEquals("Pointy has been added", message);
  }

  @Test 
  public void cannotAddAnimalToWrongEnclosure(){
    manager.addAnimal(unicorn);
    manager.getEnclosure(enclosure2);
    manager.addAnimalToEnclosure(unicorn, enclosure2);
    assertEquals(1, manager.countAnimals());
    assertEquals(0, enclosure2.countAnimals());
  }

  @Test
  public void cannotAddAnimalToWrongEnclosureMessage(){
    manager.addAnimal(unicorn);
    manager.getEnclosure(enclosure2);
    String message = manager.addAnimalToEnclosure(unicorn, enclosure2);
    assertEquals("Pointy is not suited to that enclosure", message);
  }

  @Test
  public void cannotAddAnimalToEnclosureIfFull(){
    manager.addAnimal(unicorn);
    manager.getEnclosure(enclosure3);
    String message = manager.addAnimalToEnclosure(unicorn, enclosure3);
    assertEquals("There is not enough space to add Pointy", message);
  }

  
}