package zoo_manager;
import behaviours.*;


public class Food implements Edible{
  private String name;
  private Diet diet;

  public Food(String name, Diet diet){
    this.name = name;
    this.diet = diet;
  }

  public String getName(){
    return this.name;
  }

  public Diet getDiet(){
    return this.diet;
  }



}