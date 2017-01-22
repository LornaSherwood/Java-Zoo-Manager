package zoo_manager;
import behaviours.*;
import java.util.*;

public class Manager {
  private ArrayList<Livable> animals;
  private ArrayList<Edible> foods;
  private ArrayList<Exhibitable> enclosures;


  public Manager(){
    
    animals = new ArrayList<Livable>();
    foods = new ArrayList<Edible>();
    enclosures = new ArrayList<Exhibitable>();
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

  public int countEnclosures(){
    return enclosures.size();
  }

  public void getEnclosure(Enclosure enclosure){
    enclosures.add(enclosure);
  }

//   public void addAnimalToEnclosure(Livable animal, Exhibitable enclosure){

//   }

// get animal env
// get enclosure env
// if animal value + animals total values !> encl value
//   if env == env
//     remove animal from manager, add to enclosure
//   else
//     message "can't add"  or delete animal "animal drowned"
// else message "enclosure is full"
}