package behaviours;
import java.util.*;

public interface Livable {

  String getDiet();
  void eatFood(Edible food);
  int getSpaceValue();
  String getEnclosureType();
  String getName();


}