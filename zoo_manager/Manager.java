package zoo_manager;
import behaviours.*;
import java.util.*;

public class Manager{
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

  public String removeAnimalFromEnclosure(Livable animal, Exhibitable enclosure){
    if (enclosure.getAnimals().contains(animal)){
      int position = enclosure.getAnimals().indexOf(animal);
      Livable animalToRemove = enclosure.getAnimals().remove(position);
      animals.add(animalToRemove);
      return animal.getName() + " has been removed";
    }
    else
      return animal.getName() + " is not in that enclosure";
  }

  public String feedAnimal(Livable animal){
    String diet = animal.getDiet(); //get diet of animal
    for (Edible food : foods){
        if (food.getCategory() == diet || diet == "omnivore"){ //if vege food == vege diet
          animal.eatFood(food); //give food to animal
          return animal.getName() + "has been fed";
        }
    }
    return "There is no suitable food for " + animal.getName();
  }

  public ArrayList<String> feedAllAnimalsInEnclosure(Exhibitable enclosure){
    ArrayList<String> results = new ArrayList<String>(); //create array list
    for (Livable animal : enclosure.getAnimals()){ //for each animal in the enclosure
      String feedMessage = feedAnimal(animal); //get result of feeding
      results.add(feedMessage); //add result to array list
    }
    return results;
  }

  public void getEnclosureFeedingResults(Exhibitable enclosure){
    ArrayList<String> results = feedAllAnimalsInEnclosure(enclosure);
    for (String message : results){
      System.out.println(message); 
    }
  }

  
}