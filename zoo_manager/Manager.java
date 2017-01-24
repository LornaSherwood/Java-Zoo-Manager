package zoo_manager;
import behaviours.*;
import java.util.*;

public class Manager{
  private ArrayList<Livable> animals;
  private ArrayList<Livable> sickAnimals;// add sick animals array
  private ArrayList<Edible> foods;
  private ArrayList<Exhibitable> enclosures;
  private Random randomGenerator;

  public Manager(){
    animals = new ArrayList<Livable>();
    sickAnimals = new ArrayList<Livable>();
    foods = new ArrayList<Edible>();
    enclosures = new ArrayList<Exhibitable>();
    this.randomGenerator = new Random();
  }

  public Manager(Random randomGenerator){
    animals = new ArrayList<Livable>();
    foods = new ArrayList<Edible>();
    enclosures = new ArrayList<Exhibitable>();
    this.randomGenerator = randomGenerator;
  }

  public int countAnimals(){
    return animals.size();
  }

  public int countSickAnimals(){
    return sickAnimals.size();
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

  public void removeFood(Edible food){
    foods.remove(food);
  }

  public int countEnclosures(){
    return enclosures.size();
  }

  public void getEnclosure(Enclosure enclosure){
    enclosures.add(enclosure);
  }

  public String addAnimalToEnclosure(Livable animal, Exhibitable enclosure){
    EnclosureType animalEnclosure = animal.getEnclosureType();
    EnclosureType enclosureEnvironment = enclosure.getEnvironment();
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
    //Diet diet = animal.getDiet(); //get diet of animal
    for (Edible food : foods){
        if (animal.eatFoodIfMatchesDiet(food) == true){ //animal checks right diet and eat it
          removeFood(food); //remove food from manager
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
        // remove from manager array
      }
      return results;
  }

  public void getEnclosureFeedingResults(Exhibitable enclosure){
    ArrayList<String> results = feedAllAnimalsInEnclosure(enclosure);
    for (String message : results){
      System.out.println(message); 
    }
  }

  public int checkForSickAnimals(Exhibitable enclosure){
    int sickAnimals = 0;
    for (Livable animal : enclosure.getAnimals()){
      animal.getSick();
      if (animal.getHealthStatus() == HealthStatus.SICK){
        sickAnimals += 1;
      }
    }
    return sickAnimals;
  }

  public void removeSickAnimals(Exhibitable enclosure){
    for(Livable animal : enclosure.getAnimals()){
      if (animal.getHealthStatus() == HealthStatus.SICK){
        sickAnimals.add(animal);
      }
    }
    for (Livable sickAnimal : sickAnimals){
      enclosure.getAnimals().remove(sickAnimal);
    }
  }
 
}




