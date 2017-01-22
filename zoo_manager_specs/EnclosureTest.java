import static org.junit.Assert.*;
import org.junit.*;
import zoo_manager.*;



public class EnclosureTest {
  Enclosure enclosure;


  @Before
  public void before(){
    enclosure = new Enclosure("Soaring Heights", "Aerial", 100); 
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

}