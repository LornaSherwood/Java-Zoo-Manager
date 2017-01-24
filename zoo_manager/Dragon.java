package zoo_manager;
import behaviours.*;
import java.util.*;

public class Dragon extends Animal implements Livable{

  public Dragon(String name, Gender gender, int spaceValue, int offspringValue, Diet diet, EnclosureType enclosureType, HealthStatus healthStatus) {

    super(name, gender, spaceValue, offspringValue, diet, enclosureType, healthStatus);
  }

  public String fly() {
    return "Beats its massive wings";
  }

  public String breatheFire(){
    return "Burns everything in reach";
  }

}