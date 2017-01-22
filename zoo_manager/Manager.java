package zoo_manager;
import behaviours.*;
import java.util.*;

public class Manager {
  private ArrayList<Livable> animals;
  private ArrayList<Edible> foods;


  public Manager(){
    
    animals = new ArrayList<Livable>();
    foods = new ArrayList<Edible>();
  }

  public int countAnimals(){
    return animals.size();
  }

  public void getAnimal(Livable animal){
    animals.add(animal);
  }

  public int countFood(){
    return foods.size();
  }

  public void getFood(Edible food){
    foods.add(food);
  }

  public void feedAnimal(Livable animal, Edible forbs){
    
    String diet = animal.getDiet(); //get diet of animal
    String category = forbs.getCategory();
    for (Edible food : foods){
      if (category == diet){ //if vege food == vege diet
        animal.eatFood(forbs); //give food to animal
        return;
      }
    }
  }



}