import static org.junit.Assert.*;
import org.junit.*;
import zoo_manager.*;


public class UnicornTest {
  Unicorn unicorn;

  @Before
  public void before(){
    unicorn = new Unicorn("Pointy", 'F', 5, 1, "vegetarian"); 
  }

  @Test
  public void canGetName(){
    assertEquals("Pointy", unicorn.getName());
  }

  @Test
  public void canGetGender(){
    assertEquals('F', unicorn.getGender());
  }

  @Test
  public void canGetSpaceValue(){
    assertEquals(5, unicorn.getSpaceValue());
  }

  @Test
  public void canGetOffspringValue() {
    assertEquals(1, unicorn.getOffspringValue());
  }

  @Test
  public void canGetDiet() {
    assertEquals("vegetarian", unicorn.getDiet());
  }
}