import static org.junit.Assert.*;
import org.junit.*;
import zoo_manager.*;
import java.util.*;

public class KelpieTest {
  Kelpie kelpie;

  @Before
  public void before(){
    kelpie = new Kelpie("Vaila", Gender.F, 10, 2, Diet.OMNIVORE, EnclosureType.WATER, HealthStatus.HEALTHY);  
  }

  @Test
  public void canSwim(){
    assertEquals("Dives into the water and swims away", kelpie.swim());
  }

  @Test
  public void canCatchPrey(){
    assertEquals("Pulls its prey into the watery depths", kelpie.catchPrey());
  }

}