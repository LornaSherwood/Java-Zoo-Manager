package zoo_manager;
import behaviours.*;
import java.util.*;

public class Enclosure implements Exhibitable{
  private String name;
  private EnclosureType environment;
  private int maxSpaceValue;
  private ArrayList<Livable> animals;

  public Enclosure(String name, EnclosureType environment, int maxSpaceValue){
    this.name = name;
    this.environment = environment;
    this.maxSpaceValue = maxSpaceValue;
    this.animals = new ArrayList<Livable>();
  }

  public String getName(){
    return this.name;
  }

  public EnclosureType getEnvironment(){
    return this.environment;
  }

  public int getMaxSpaceValue(){
    return this.maxSpaceValue;
  }

  public ArrayList<Livable> getAnimals(){
    return this.animals;
  }

  public int countAnimals(){
    return animals.size();
  }

  public void addAnimal(Livable animal){
    animals.add(animal);
  }

  public int getSpareCapacity(){
    int i = 0;
    for (Livable animal : animals){
      i += animal.getSpaceValue();
    }
    return this.maxSpaceValue - i;
  }

}