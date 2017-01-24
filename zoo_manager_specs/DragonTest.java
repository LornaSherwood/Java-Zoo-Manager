import static org.junit.Assert.*;
import org.junit.*;
import zoo_manager.*;
import java.util.*;


public class DragonTest {
  Dragon dragon;

  @Before
  public void before(){
    dragon = new Dragon("Puff", Gender.F, 50, 4, Diet.CARNIVORE, EnclosureType.AERIAL, HealthStatus.HEALTHY);  
  }

  @Test
  public void canFly(){
    assertEquals("Beats its massive wings", dragon.fly());
  }

  @Test
  public void canBreatheFire(){
    assertEquals("Burns everything in reach", dragon.breatheFire());
  }

}