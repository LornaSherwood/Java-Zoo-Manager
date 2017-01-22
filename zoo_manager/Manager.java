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

  public void addAnimal(Livable animal){
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

  public String addAnimalToEnclosure(Livable animal, Exhibitable enclosure){
    String animalEnclosure = animal.getEnclosureType();
    String enclosureEnvironment = enclosure.getEnvironment();
    if (animal.getSpaceValue() <= enclosure.getSpareCapacity()){
      if (animalEnclosure == enclosureEnvironment){
          int position = animals.indexOf(animal);
          Livable animalToAdd = animals.remove(position);
          enclosure.addAnimal(animalToAdd);
          return animalToAdd.getName() + "has been added";
      }
      else
        return animal.getName() + " is not suited to that enclosure";
    }
    else
      return "There is not enough space to add " + animal.getName();
  }

}