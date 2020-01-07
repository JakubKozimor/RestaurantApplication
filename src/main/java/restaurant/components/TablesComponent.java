package restaurant.components;

import org.springframework.stereotype.Component;
import restaurant.entity.Dish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TablesComponent {

    private Map<Integer, List<Dish>> myRestaurant = new HashMap<>();

    public TablesComponent() {
    }

    public TablesComponent(Map<Integer, List<Dish>> myRestaurant) {
        this.myRestaurant = myRestaurant;
    }

    public Map<Integer, List<Dish>> getMyRestaurant() {
        return myRestaurant;
    }

    public List<Dish> getMyRestaurant(int nrOfTable) {
        if (myRestaurant.get(nrOfTable) == null) {
            return new ArrayList<>();
        } else {
            return myRestaurant.get(nrOfTable);
        }
    }

    public void setMyRestaurant(int numberOfTable, List<Dish> order) {
        this.myRestaurant.put(numberOfTable, order);
    }

    public void addTable(int numberOfTable) {
        this.myRestaurant.put(numberOfTable, new ArrayList<>());
    }

    public void removeTable(int numberOfTable) {
        this.myRestaurant.remove(numberOfTable);
    }
}
