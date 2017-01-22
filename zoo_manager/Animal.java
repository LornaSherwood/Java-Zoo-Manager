package zoo_manager;
import behaviours.*;

public abstract class Animal {

  private String name;
  private char gender;
  private int spaceValue;
  private int offspringValue;
  private String diet;
  private String enclosureType;

  public Animal(String name, char gender, int spaceValue, int offspringValue, String diet, String enclosureType){

  this.name = name;
  this.gender = gender;
  this.spaceValue = spaceValue;
  this.offspringValue = offspringValue;
  this.diet = diet;
  this.enclosureType = enclosureType;
  }

  public String getName(){
    return this.name;
  }

  public char getGender(){
    return this.gender;
  }

  public int getSpaceValue(){
    return this.spaceValue;
  }

  public int getOffspringValue(){
    return this.offspringValue;
  }

  public String getDiet(){
    return this.diet;
  }

  public String getEnclosureType(){
    return this.enclosureType;
  }

}