package zoo_manager;
import behaviours.*;
import java.util.*;

public class Kelpie extends Animal implements Livable{

  public Kelpie(String name, Gender gender, int spaceValue, int offspringValue, Diet diet, EnclosureType enclosureType) {

    super(name, gender, spaceValue, offspringValue, diet, enclosureType);
  }

  public String swim() {
    return "Dives into the water and swims away";
  }

  public String catchPrey(){
    return "Pulls its prey into the water to drown";
  }

}