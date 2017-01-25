package behaviours;
import zoo_manager.*;
import java.util.*;

public interface Livable {

  Diet getDiet();
  void eatFood(Edible food);
  int getSpaceValue();
  EnclosureType getEnclosureType();
  String getName();
  boolean eatFoodIfMatchesDiet(Edible food);
  void getSick();
  HealthStatus getHealthStatus();
  void setHealthStatus(HealthStatus healthStatus);
  void sleep();

}