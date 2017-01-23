package zoo_manager;
import behaviours.*;
import java.util.*;

public abstract class Animal {

  private String name;
  private Gender gender;
  private int spaceValue;
  private int offspringValue;
  private Diet diet;
  private EnclosureType enclosureType;
  public ArrayList<Edible> foodEaten;

  public Animal(String name, Gender gender, int spaceValue, int offspringValue, Diet diet, EnclosureType enclosureType){

  this.name = name;
  this.gender = gender;
  this.spaceValue = spaceValue;
  this.offspringValue = offspringValue;
  this.diet = diet;
  this.enclosureType = enclosureType;
  this.foodEaten = new ArrayList<Edible>();
  }

  public String getName(){
    return this.name;
  }

  public Gender getGender(){
    return this.gender;
  }

  public int getSpaceValue(){
    return this.spaceValue;
  }

  public int getOffspringValue(){
    return this.offspringValue;
  }

  public Diet getDiet(){
    return this.diet;
  }

  public EnclosureType getEnclosureType(){
    return this.enclosureType;
  }

  public int countFood(){
    return foodEaten.size();
  }

  public void eatFood(Edible food){
    foodEaten.add(food);
  }

}