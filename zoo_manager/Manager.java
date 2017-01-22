package zoo_manager;
import behaviours.*;
import java.util.*;

public class Manager {
  private ArrayList<Runner> runners;
  private ArrayList<Edible> foods;


  public Manager(){
    
    runners = new ArrayList<Runner>();
    foods = new ArrayList<Edible>();
  }

  public int countRunners(){
    return runners.size();
  }

  public void getRunner(Runner runner){
    runners.add(runner);
  }

  public int countFood(){
    return foods.size();
  }

  public void getFood(Edible food){
    foods.add(food);
  }

  public void feedRunner(Runner runner, Edible forbs){
    
    String diet = runner.getDiet(); //get diet of runner
    String category = forbs.getCategory();
    for (Edible food : foods){
      if (category == diet){ //if vege food == vege diet
        runner.eatFood(forbs); //give food to runner
        return;
      }
    }
  }



}