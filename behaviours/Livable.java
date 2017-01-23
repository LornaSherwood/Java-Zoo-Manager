package behaviours;
import zoo_manager.*;
import java.util.*;

public interface Livable {

  Diet getDiet();
  void eatFood(Edible food);
  int getSpaceValue();
  EnclosureType getEnclosureType();
  String getName();


}