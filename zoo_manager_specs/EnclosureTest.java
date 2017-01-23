import static org.junit.Assert.*;
import org.junit.*;
import zoo_manager.*;
import behaviours.*;
import java.util.*;



public class EnclosureTest {
  Enclosure enclosure;
  Enclosure enclosure2;
  Unicorn unicorn;
  Unicorn unicorn2;
  


  @Before
  public void before(){
    enclosure = new Enclosure("Soaring Heights", "Aerial", 100);
    enclosure2 = new Enclosure("Magic Glade", "Land", 30);
    unicorn = new Unicorn("Pointy", 'F', 5, 1, "vegetarian", "forest");
    unicorn2 = new Unicorn("Blunty", 'M', 6, 0, "vegetarian", "forest");
  }

  @Test
  public void canGetName(){
    assertEquals("Soaring Heights", enclosure.getName());
  }

  @Test
  public void canGetEnvironment(){
    assertEquals("Aerial", enclosure.getEnvironment());
  }

  @Test
  public void canGetMaxSpaceValue(){
    assertEquals(100, enclosure.getMaxSpaceValue());
  }

  @Test public void canGetAnimals(){
    enclosure2.addAnimal(unicorn);
    enclosure2.addAnimal(unicorn2);
    ArrayList<Livable> animals = enclosure2.getAnimals();
    assertEquals(unicorn, animals.get(0));
    assertEquals(unicorn2, animals.get(1));
  }

  @Test
  public void animalsStartEmpty(){
    assertEquals(0, enclosure.countAnimals());
  }

  @Test
  public void canAddAnimal(){
    enclosure.addAnimal(unicorn);
    assertEquals(1, enclosure.countAnimals());
  }

  @Test
  public void canGetSpareCapacity(){
    enclosure2.addAnimal(unicorn);
    enclosure2.addAnimal(unicorn2);
    assertEquals(19, enclosure2.getSpareCapacity());
  }

}