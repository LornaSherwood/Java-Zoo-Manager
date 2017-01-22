package zoo_manager;
import behaviours.*;
import java.util.*;

public class Enclosure {
  private String name;
  private String environment;
  private int maxSpaceValue;

  private ArrayList<Livable> animals;


  public Enclosure(String name, String environment, int maxSpaceValue){
    this.name = name;
    this.environment = environment;
    this.maxSpaceValue = maxSpaceValue;
    animals = new ArrayList<Livable>();
  }

  public String getName(){
    return this.name;
  }

  public String getEnvironment(){
    return this.environment;
  }

  public int getMaxSpaceValue(){
    return this.maxSpaceValue;
  }

}