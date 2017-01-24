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
  private HealthStatus healthStatus;
  private ArrayList<Edible> foodEaten;
  private Random randomGenerator;

  public Animal(String name, Gender gender, int spaceValue, int offspringValue, Diet diet, EnclosureType enclosureType, HealthStatus healthStatus){
    this.name = name;
    this.gender = gender;
    this.spaceValue = spaceValue;
    this.offspringValue = offspringValue;
    this.diet = diet;
    this.enclosureType = enclosureType;
    this.healthStatus = healthStatus;
    this.foodEaten = new ArrayList<Edible>();
    this.randomGenerator = new Random();
  }

  public Animal(String name, Gender gender, int spaceValue, int offspringValue, Diet diet, EnclosureType enclosureType, HealthStatus healthStatus, Random randomGenerator){
    this.name = name;
    this.gender = gender;
    this.spaceValue = spaceValue;
    this.offspringValue = offspringValue;
    this.diet = diet;
    this.enclosureType = enclosureType;
    this.healthStatus = healthStatus;
    this.foodEaten = new ArrayList<Edible>();
    this.randomGenerator = randomGenerator;
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

  public HealthStatus getHealthStatus(){
    return this.healthStatus;
  }

  public void setHealthStatus(HealthStatus healthStatus){
    this.healthStatus = healthStatus;
  }

  public int countFood(){
    return foodEaten.size();
  }

  public void eatFood(Edible food){
    foodEaten.add(food);
  }

  public boolean eatFoodIfMatchesDiet(Edible food){
    if (food.getDiet() == getDiet() || getDiet() == Diet.OMNIVORE){
      eatFood(food); 
      return true;
    }
    else
      return false;
  }

  public int chanceOfGettingSick(){ //public because abstract class, needed in subclass
    int number = randomGenerator.nextInt(10) + 1;
    return number;
  }

  public void getSick(){
    int number = chanceOfGettingSick();
    if (number == 9){
      setHealthStatus(HealthStatus.SICK);
    }   
  }



}



