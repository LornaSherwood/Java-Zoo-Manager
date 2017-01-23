import static org.junit.Assert.*;
import org.junit.*;
import zoo_manager.*;
import java.util.*;

public class ManagerTest {
  Manager manager;
  Unicorn unicorn;
  Unicorn unicorn2;
  Food forbs;
  Food fairies;
  Enclosure enclosure;
  Enclosure enclosure2;
  Enclosure enclosure3;
  Enclosure enclosure4;

  @Before
  public void before(){
    manager = new Manager();
    unicorn = new Unicorn("Pointy", 'F', 5, 1, "vegetarian", "forest"); 
    unicorn2 = new Unicorn("Blunty", 'M', 6, 0, "vegetarian", "forest");
    forbs = new Food("forbs", "vegetarian");
    fairies = new Food("fairies", "meat");
    enclosure = new Enclosure("Magic Glade", "forest", 100);
    enclosure2 = new Enclosure("Soaring Heights", "aerial", 100);
    enclosure3 = new Enclosure("Magic Glade", "forest", 4);
    enclosure4 = new Enclosure("Magic Glade", "forest", 100);
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

  @Test
  public void canRemoveAnimalFromEnclosure(){
    manager.addAnimal(unicorn);
    manager.getEnclosure(enclosure);
    manager.addAnimalToEnclosure(unicorn, enclosure);
    manager.removeAnimalFromEnclosure(unicorn, enclosure);
    assertEquals(1, manager.countAnimals());
    assertEquals(0, enclosure.countAnimals());
  }

  @Test
  public void canRemoveAnimalFromEnclosureMessage(){
    manager.addAnimal(unicorn);
    manager.getEnclosure(enclosure);
    manager.addAnimalToEnclosure(unicorn, enclosure);
    String message = manager.removeAnimalFromEnclosure(unicorn, enclosure);
    assertEquals("Pointy has been removed", message);
  }

  @Test
  public void cannotRemoveAnimalIfNotInEnclosure(){
    manager.addAnimal(unicorn);
    manager.addAnimal(unicorn2);
    manager.getEnclosure(enclosure);
    manager.getEnclosure(enclosure4);
    manager.addAnimalToEnclosure(unicorn, enclosure);
    manager.addAnimalToEnclosure(unicorn2, enclosure4);
    manager.removeAnimalFromEnclosure(unicorn, enclosure4);
    assertEquals(0, manager.countAnimals());
    assertEquals(1, enclosure.countAnimals());
    assertEquals(1, enclosure4.countAnimals());
  }

  @Test 
    public void cannotRemoveAnimalIfNotInEnclosureMessage(){
      manager.addAnimal(unicorn);
      manager.addAnimal(unicorn2);
      manager.getEnclosure(enclosure);
      manager.getEnclosure(enclosure4);
      manager.addAnimalToEnclosure(unicorn, enclosure);
      manager.addAnimalToEnclosure(unicorn2, enclosure4);
    String message = manager.removeAnimalFromEnclosure(unicorn, enclosure4);
    assertEquals("Pointy is not in that enclosure", message);
  }

  @Test
  public void canFeedAnimalWithManager(){
    manager.addAnimal(unicorn);
    manager.getFood(forbs);
    manager.feedAnimal(unicorn);
    assertEquals(1, unicorn.countFood());
  }

  @Test
  public void cannotFeedAnimalIfNoSuitableFood(){
    manager.addAnimal(unicorn);
    manager.getFood(fairies);
    manager.feedAnimal(unicorn);
    assertEquals(0, unicorn.countFood());
  }

  @Test
  public void canFeedAnimalInEnclosure(){
    manager.addAnimal(unicorn);
    manager.getEnclosure(enclosure);
    manager.addAnimalToEnclosure(unicorn, enclosure);
    manager.getFood(forbs);
    manager.getFood(fairies);
    manager.feedAnimal(unicorn);
    assertEquals(1, unicorn.countFood());




  }

  
}