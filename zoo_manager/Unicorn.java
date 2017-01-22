package zoo_manager;
import behaviours.*;
import java.util.*;

public class Unicorn extends Animal{

  private ArrayList<Edible> foodEaten;

  public Unicorn(String name, char gender, int spaceValue, int offspringValue, String diet) {

    super(name, gender, spaceValue, offspringValue, diet);
    this.foodEaten = new ArrayList<Edible>();

  }

}