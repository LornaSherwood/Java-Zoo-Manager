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
  Kelpie kelpieSick;
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
    kelpieSick = new Kelpie("Veila", Gender.M, 10, 0, Diet.OMNIVORE, EnclosureType.WATER, HealthStatus.SICK);
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
  public void canAddUnicorntoRightEnclosure(){
    manager.getAnimal(unicorn);
    manager.getEnclosure(enclosure);
    manager.addAnimalToEnclosure(unicorn, enclosure);
    assertEquals(1, enclosure.countAnimals());
  }

  @Test
  public void canAddKelpietoRightEnclosure(){
    manager.getAnimal(kelpie);
    manager.getEnclosure(enclosure5);
    manager.addAnimalToEnclosure(kelpie, enclosure5);
    assertEquals(1, enclosure5.countAnimals());
  }

  @Test
  public void addingUnicorntoRightEnclosureRemovesFromManager(){
    manager.getAnimal(unicorn);
    manager.getEnclosure(enclosure);
    manager.addAnimalToEnclosure(unicorn, enclosure);
    assertEquals(0, manager.countAnimals());
  }

  @Test
  public void addingKelpietoRightEnclosureRemovesFromManager(){
    manager.getAnimal(kelpie);
    manager.getEnclosure(enclosure5);
    manager.addAnimalToEnclosure(kelpie, enclosure5);
    assertEquals(0, manager.countAnimals());
  }

  public void canAddUnicorntoRightEnclosureMessage(){
    manager.getAnimal(unicorn);
    manager.getEnclosure(enclosure);
    String message = manager.addAnimalToEnclosure(unicorn, enclosure);
    assertEquals("Pointy has been added", message);
  }

  @Test
  public void canAddKelpietoRightEnclosureMessage(){
    manager.getAnimal(kelpie);
    manager.getEnclosure(enclosure5);
    String message = manager.addAnimalToEnclosure(kelpie, enclosure5);
    assertEquals("Vaila has been added", message);
  }

  @Test 
  public void cannotAddAnimalToWrongEnclosureUnicorn(){
    manager.getAnimal(unicorn);
    manager.getEnclosure(enclosure2);
    manager.addAnimalToEnclosure(unicorn, enclosure2);
    assertEquals(0, enclosure2.countAnimals());
  }

  @Test 
  public void cannotAddAnimalToWrongEnclosureUnicornStaysWithManager(){
    manager.getAnimal(unicorn);
    manager.getEnclosure(enclosure2);
    manager.addAnimalToEnclosure(unicorn, enclosure2);
    assertEquals(1, manager.countAnimals());
  }

  @Test 
  public void cannotAddAnimalToWrongEnclosureKelpie(){
    manager.getAnimal(kelpie);
    manager.getEnclosure(enclosure2);
    manager.addAnimalToEnclosure(kelpie, enclosure2);
    assertEquals(0, enclosure2.countAnimals());
  }

  @Test 
  public void cannotAddAnimalToWrongEnclosureKelpieStaysWithManager(){
    manager.getAnimal(kelpie);
    manager.getEnclosure(enclosure2);
    manager.addAnimalToEnclosure(kelpie, enclosure2);
    assertEquals(1, manager.countAnimals());
  }

  @Test
  public void cannotAddAnimalToWrongEnclosureMessage(){
    manager.getAnimal(unicorn);
    manager.getEnclosure(enclosure2);
    String message = manager.addAnimalToEnclosure(unicorn, enclosure2);
    assertEquals("Pointy is not suited to that enclosure", message);
  }

  @Test
  public void cannotAddAnimalToEnclosureIfFull(){
    manager.getAnimal(unicorn);
    manager.getEnclosure(enclosure3);
    String message = manager.addAnimalToEnclosure(unicorn, enclosure3);
    assertEquals("There is not enough space to add Pointy", message);
  }

  @Test
  public void canRemoveAnimalFromEnclosure(){
    manager.getAnimal(unicorn);
    manager.getEnclosure(enclosure);
    manager.addAnimalToEnclosure(unicorn, enclosure);
    manager.removeAnimalFromEnclosure(unicorn, enclosure);
    assertEquals(1, manager.countAnimals());
    assertEquals(0, enclosure.countAnimals());
  }

  @Test
  public void removingAnimalFromEnclosureMovesToManager(){
    manager.getAnimal(unicorn);
    manager.getEnclosure(enclosure);
    manager.addAnimalToEnclosure(unicorn, enclosure);
    manager.removeAnimalFromEnclosure(unicorn, enclosure);
    assertEquals(1, manager.countAnimals());
  }

  @Test
  public void removingAnimalFromEnclosureReturnsMessage(){
    manager.getAnimal(unicorn);
    manager.getEnclosure(enclosure);
    manager.addAnimalToEnclosure(unicorn, enclosure);
    String message = manager.removeAnimalFromEnclosure(unicorn, enclosure);
    assertEquals("Pointy has been removed", message);
  }

  @Test
  public void cannotRemoveAnimalIfNotInEnclosure(){
    manager.getAnimal(unicorn);
    manager.getAnimal(unicorn2);
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
    manager.getAnimal(unicorn);
    manager.getAnimal(unicorn2);
    manager.getEnclosure(enclosure);
    manager.getEnclosure(enclosure4);
    manager.addAnimalToEnclosure(unicorn, enclosure);
    manager.addAnimalToEnclosure(unicorn2, enclosure4);
    String message = manager.removeAnimalFromEnclosure(unicorn, enclosure4);
    assertEquals("Pointy is not in that enclosure", message);
  }

  @Test
  public void canFeedAnimalWithManager(){
    manager.getAnimal(unicorn);
    manager.getFood(forbs);
    manager.feedAnimal(unicorn);
    assertEquals(1, unicorn.countFood());
  }

  @Test
  public void cannotFeedAnimalIfNoSuitableFood(){
    manager.getAnimal(unicorn);
    manager.getFood(fairies);
    manager.feedAnimal(unicorn);
    assertEquals(0, unicorn.countFood());
  }

  @Test
  public void canFeedAnimalInEnclosureOneItem(){
    manager.getAnimal(unicorn);
    manager.getEnclosure(enclosure);
    manager.addAnimalToEnclosure(unicorn, enclosure);
    manager.getFood(forbs);
    manager.getFood(nutRoast);
    manager.feedAnimal(unicorn);
    assertEquals(1, unicorn.countFood());
  }

  @Test
  public void canFeedAllAnimalsInEnclosureVegetarian(){
    manager.getAnimal(unicorn);
    manager.getAnimal(unicorn2);
    manager.getEnclosure(enclosure);
    manager.addAnimalToEnclosure(unicorn, enclosure);
    manager.addAnimalToEnclosure(unicorn2, enclosure);
    manager.getFood(forbs);
    manager.getFood(forbs);
    manager.feedAllAnimalsInEnclosure(enclosure);
    assertEquals(1, unicorn.countFood());
    assertEquals(1, unicorn2.countFood());
  }

  @Test
  public void feedingAllAnimalsInEnclosureRemovesFoodFromManager(){
    manager.getAnimal(unicorn);
    manager.getAnimal(unicorn2);
    manager.getEnclosure(enclosure);
    manager.addAnimalToEnclosure(unicorn, enclosure);
    manager.addAnimalToEnclosure(unicorn2, enclosure);
    manager.getFood(forbs);
    manager.getFood(forbs);
    manager.feedAllAnimalsInEnclosure(enclosure);
    assertEquals(0, manager.countFood());
  }

  @Test
  public void canFeedAllAnimalsInEnclosureOmnivore(){
    manager.getAnimal(kelpie);
    manager.getAnimal(kelpie2);
    manager.getEnclosure(enclosure5);
    manager.addAnimalToEnclosure(kelpie, enclosure5);
    manager.addAnimalToEnclosure(kelpie2, enclosure5);
    manager.getFood(forbs);
    manager.getFood(nutRoast);
    manager.getFood(fairies);
    manager.feedAllAnimalsInEnclosure(enclosure5);
    assertEquals(1, kelpie.countFood());
    assertEquals(1, kelpie2.countFood());
  }

  @Test
  public void feedAllAnimalsInEnclosureManagerFeedDepleted(){
    manager.getAnimal(kelpie);
    manager.getAnimal(kelpie2);
    manager.getEnclosure(enclosure5);
    manager.addAnimalToEnclosure(kelpie, enclosure5);
    manager.addAnimalToEnclosure(kelpie2, enclosure5);
    manager.getFood(forbs);
    manager.getFood(nutRoast);
    manager.getFood(fairies);
    manager.feedAllAnimalsInEnclosure(enclosure5);
    assertEquals(1, manager.countFood());
  }

  @Test
  public void canCheckForSickAnimalsHealthy(){
    when(stubRandom.nextInt(10)).thenReturn(1); // mockito
    manager.getAnimal(unicorn);
    manager.getAnimal(unicorn2);
    manager.getEnclosure(enclosure);
    manager.addAnimalToEnclosure(unicorn, enclosure);
    manager.addAnimalToEnclosure(unicorn2, enclosure);
    int numberSick = manager.checkForSickAnimals(enclosure);
    assertEquals(0, numberSick);
  }

  @Test
  public void canCheckForSickAnimalsSick(){
    when(stubRandom.nextInt(10)).thenReturn(8); // mockito
    manager.getAnimal(unicorn);
    manager.getAnimal(unicorn2);
    manager.getEnclosure(enclosure);
    manager.addAnimalToEnclosure(unicorn, enclosure);
    manager.addAnimalToEnclosure(unicorn2, enclosure);
    int numberSick = manager.checkForSickAnimals(enclosure);
    assertEquals(2, numberSick);  
  }

  @Test
  public void canRemoveSickAnimalsFromEnclosure(){
    manager.getAnimal(unicornSick);
    manager.getAnimal(unicorn);
    manager.getEnclosure(enclosure);
    manager.addAnimalToEnclosure(unicornSick, enclosure);
    manager.addAnimalToEnclosure(unicorn, enclosure);
    manager.removeSickAnimals(enclosure);
    assertEquals(1, enclosure.countAnimals());
    assertEquals(1, manager.countSickAnimals());
  }

  @Test
  public void removedSickAnimalsGoToManager(){
    manager.getAnimal(unicornSick);
    manager.getAnimal(unicorn);
    manager.getEnclosure(enclosure);
    manager.addAnimalToEnclosure(unicornSick, enclosure);
    manager.addAnimalToEnclosure(unicorn, enclosure);
    manager.removeSickAnimals(enclosure);
    assertEquals(1, manager.countSickAnimals());
  }

  @Test
  public void showAnimalRecoveredRemovesFromSick(){
    manager.getAnimal(unicornSick);
    manager.getEnclosure(enclosure);
    manager.addAnimalToEnclosure(unicornSick, enclosure);
    manager.removeSickAnimals(enclosure);
    manager.showAnimalRecovered(unicornSick);
    assertEquals(0, manager.countSickAnimals());
  }

  @Test
  public void showAnimalRecoveredAddsToHealthy(){
    manager.getAnimal(unicornSick);
    manager.getEnclosure(enclosure);
    manager.addAnimalToEnclosure(unicornSick, enclosure);
    manager.removeSickAnimals(enclosure);
    manager.showAnimalRecovered(unicornSick);
    assertEquals(1, manager.countAnimals());
  }

  
}