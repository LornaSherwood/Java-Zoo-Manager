package behaviours;
import zoo_manager.*;
import java.util.*;

public interface Exhibitable {

  int getSpareCapacity();
  EnclosureType getEnvironment();
  void addAnimal(Livable animal);
  ArrayList<Livable> getAnimals();

}