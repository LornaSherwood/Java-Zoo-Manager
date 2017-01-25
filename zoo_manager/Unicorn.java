package zoo_manager;
import behaviours.*;
import java.util.*;

public class Unicorn extends Animal implements Livable{

  public Unicorn(String name, Gender gender, int spaceValue, int offspringValue, Diet diet, EnclosureType enclosureType, HealthStatus healthStatus) {
    super(name, gender, spaceValue, offspringValue, diet, enclosureType, healthStatus);
  }

  public Unicorn(String name, Gender gender, int spaceValue, int offspringValue, Diet diet, EnclosureType enclosureType, HealthStatus healthStatus, Random randomGenerator) {
    super(name, gender, spaceValue, offspringValue, diet, enclosureType, healthStatus, randomGenerator);
  }

  public String run() {
    return "Trots gracefully across the ground";
  }

}