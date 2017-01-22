package zoo_manager;
import behaviours.*;
import java.util.*;

public class Unicorn extends Animal implements Livable{

  public ArrayList<Edible> foodEaten;

  public Unicorn(String name, char gender, int spaceValue, int offspringValue, String diet, String enclosureType) {

    super(name, gender, spaceValue, offspringValue, diet, enclosureType);
    this.foodEaten = new ArrayList<Edible>();

  }

  public String run() {
    return "Trots gracefully across the ground";
  }

  public int countFood(){
    return foodEaten.size();
  }

  public void eatFood(Edible food){
    foodEaten.add(food);
  }



}