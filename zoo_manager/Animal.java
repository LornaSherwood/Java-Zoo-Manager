package zoo_manager;
import behaviours.*;

public abstract class Animal {

  private String name;
  private char gender;
  private int spaceValue;
  private int offspringValue;
  private String diet;

  public Animal(String name, char gender, int spaceValue, int offspringValue, String diet){

  this.name = name;
  this.gender = gender;
  this.spaceValue = spaceValue;
  this.offspringValue = offspringValue;
  this.diet = diet;
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

}