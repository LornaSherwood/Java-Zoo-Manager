package zoo_manager;
import behaviours.*;
import java.util.*;

public class Unicorn extends Animal implements Runner{

  public ArrayList<Edible> foodEaten;

  public Unicorn(String name, char gender, int spaceValue, int offspringValue, String diet) {

    super(name, gender, spaceValue, offspringValue, diet);
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