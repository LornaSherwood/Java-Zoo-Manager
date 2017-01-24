import static org.junit.Assert.*;
import org.junit.*;
import zoo_manager.*;
import java.util.*;
import org.mockito.*;
import static org.mockito.Mockito.*;

public class ManagerTest {
  Manager manager;
  Unicorn unicorn;
  Unicorn unicorn2;
  Unicorn unicornSick;
  Kelpie kelpie;
  Kelpie kelpie2;
  Food forbs;
  Food nutRoast;
  Food fairies;
  Enclosure enclosure;
  Enclosure enclosure2;
  Enclosure enclosure3;
  Enclosure enclosure4;
  Enclosure enclosure5;
  Random stubRandom;

  @Before
  public void before(){
    
    stubRandom = mock(Random.class);
    manager = new Manager();
    unicorn = new Unicorn("Pointy", Gender.F, 5, 1, Diet.VEGETARIAN, EnclosureType.FOREST, HealthStatus.HEALTHY, stubRandom); 
    unicorn2 = new Unicorn("Blunty", Gender.M, 6, 0, Diet.VEGETARIAN, EnclosureType.FOREST, HealthStatus.HEALTHY, stubRandom);
    unicornSick = new Unicorn("Blunty", Gender.M, 6, 0, Diet.VEGETARIAN, EnclosureType.FOREST, HealthStatus.SICK);
    kelpie = new Kelpie("Vaila", Gender.F, 10, 2, Diet.OMNIVORE, EnclosureType.WATER, HealthStatus.HEALTHY);
    kelpie2 = new Kelpie("Veila", Gender.M, 10, 0, Diet.OMNIVORE, EnclosureType.WATER, HealthStatus.HEALTHY);
    forbs = new Food("forbs", Diet.VEGETARIAN);
    nutRoast = new Food("nutRoast", Diet.VEGETARIAN);
    fairies = new Food("fairies", Diet.CARNIVORE);
    enclosure = new Enclosure("Magic Glade", EnclosureType.FOREST, 100);
    enclosure2 = new Enclosure("Soaring Heights", EnclosureType.AERIAL, 100);
    enclosure3 = new Enclosure("Magic Glade", EnclosureType.FOREST, 4);
    enclosure4 = new Enclosure("Magic Glade", EnclosureType.FOREST, 100);
    enclosure5 = new Enclosure("Dark Depths", EnclosureType.WATER, 100);
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
  public void canRemoveFood(){
    manager.getFood(forbs);
    manager.removeFood(forbs);
    assertEquals(0, manager.countFood());
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
  public void canAddAnimaltoRightEnclosureUnicorn(){
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
  public void cannotAddAnimalToWrongEnclosureUnicorn(){
    manager.addAnimal(unicorn);
    manager.getEnclosure(enclosure2);
    manager.addAnimalToEnclosure(unicorn, enclosure2);
    assertEquals(1, manager.countAnimals());
    assertEquals(0, enclosure2.countAnimals());
  }

  @Test
  public void canAddAnimaltoRightEnclosureKelpie(){
    manager.addAnimal(kelpie);
    manager.getEnclosure(enclosure5);
    manager.addAnimalToEnclosure(kelpie, enclosure5);
    assertEquals(0, manager.countAnimals());
    assertEquals(1, enclosure5.countAnimals());
  }

  @Test 
  public void cannotAddAnimalToWrongEnclosureKelpie(){
    manager.addAnimal(kelpie);
    manager.getEnclosure(enclosure2);
    manager.addAnimalToEnclosure(kelpie, enclosure2);
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
  public void canFeedAnimalInEnclosureOneItem(){
    manager.addAnimal(unicorn);
    manager.getEnclosure(enclosure);
    manager.addAnimalToEnclosure(unicorn, enclosure);
    manager.getFood(forbs);
    manager.getFood(nutRoast);
    manager.feedAnimal(unicorn);
    assertEquals(1, unicorn.countFood());
  }

  @Test
  public void canFeedAllAnimalsInEnclosureVegetarian(){
    manager.addAnimal(unicorn);
    manager.addAnimal(unicorn2);
    manager.getEnclosure(enclosure);
    manager.addAnimalToEnclosure(unicorn, enclosure);
    manager.addAnimalToEnclosure(unicorn2, enclosure);
    manager.getFood(forbs);
    manager.getFood(forbs);
    manager.feedAllAnimalsInEnclosure(enclosure);
    assertEquals(1, unicorn.countFood());
    assertEquals(1, unicorn2.countFood());
    assertEquals(0, manager.countFood());
  }

  @Test
  public void canFeedAllAnimalsInEnclosureOmnivore(){
    manager.addAnimal(kelpie);
    manager.addAnimal(kelpie2);
    manager.getEnclosure(enclosure5);
    manager.addAnimalToEnclosure(kelpie, enclosure5);
    manager.addAnimalToEnclosure(kelpie2, enclosure5);
    manager.getFood(nutRoast);
    manager.getFood(fairies);
    manager.feedAllAnimalsInEnclosure(enclosure5);
    assertEquals(1, kelpie.countFood());
    assertEquals(1, kelpie2.countFood());
    assertEquals(0, manager.countFood());
  }

  @Test
  public void canCheckForSickAnimalsHealthy(){
    when(stubRandom.nextInt(10)).thenReturn(1); // mockito
    manager.addAnimal(unicorn);
    manager.addAnimal(unicorn2);
    manager.getEnclosure(enclosure);
    manager.addAnimalToEnclosure(unicorn, enclosure);
    manager.addAnimalToEnclosure(unicorn2, enclosure);
    int numberSick = manager.checkForSickAnimals(enclosure);
    assertEquals(0, numberSick);
  }

  @Test
  public void canCheckForSickAnimalsSick(){
    when(stubRandom.nextInt(10)).thenReturn(8); // mockito
    manager.addAnimal(unicorn);
    manager.addAnimal(unicorn2);
    manager.getEnclosure(enclosure);
    manager.addAnimalToEnclosure(unicorn, enclosure);
    manager.addAnimalToEnclosure(unicorn2, enclosure);
    int numberSick = manager.checkForSickAnimals(enclosure);
    assertEquals(2, numberSick);  
  }

  @Test
  public void canRemoveSickAnimals(){
    manager.addAnimal(unicornSick);
    manager.addAnimal(unicorn);
    manager.getEnclosure(enclosure);
    manager.addAnimalToEnclosure(unicornSick, enclosure);
    manager.addAnimalToEnclosure(unicorn, enclosure);
    manager.removeSickAnimals(enclosure);
    assertEquals(1, enclosure.countAnimals());
    assertEquals(1, manager.countSickAnimals());
  }
  
}