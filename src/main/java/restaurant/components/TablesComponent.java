package restaurant.components;

import org.springframework.stereotype.Component;
import restaurant.Entity.Dish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TablesComponent {

    private Map<Integer, List<Dish>> myRestaurant = new HashMap<>();

    // todo change this
    private List<Dish> table1 = new ArrayList<>();
    private List<Dish> table2 = new ArrayList<>();
    private List<Dish> table3 = new ArrayList<>();
    private List<Dish> table4 = new ArrayList<>();
    private List<Dish> table5 = new ArrayList<>();
    private List<Dish> table6 = new ArrayList<>();

    public TablesComponent() {
        myRestaurant.put(1, table1);
        myRestaurant.put(2, table2);
        myRestaurant.put(3, table3);
        myRestaurant.put(4, table4);
        myRestaurant.put(5, table5);
        myRestaurant.put(6, table6);

    }

    public TablesComponent(Map<Integer, List<Dish>> myRestaurant) {
        this.myRestaurant = myRestaurant;
    }

    public Map<Integer, List<Dish>> getMyRestaurant() {
        return myRestaurant;
    }

    public List<Dish> getMyRestaurant(int nrOfTable) {
        return myRestaurant.get(nrOfTable);
    }

    public void setMyRestaurant(Map<Integer, List<Dish>> myRestaurant) {
        this.myRestaurant = myRestaurant;
    }

    public void setMyRestaurant(int numberOfTable, List<Dish> order) {
        this.myRestaurant.put(numberOfTable, order);
    }

    @Override
    public String toString() {
        return "Tables{" +
                "myRestaurant=" + myRestaurant +
                ", table1=" + table1 +
                ", table2=" + table2 +
                ", table3=" + table3 +
                ", table4=" + table4 +
                ", table5=" + table5 +
                ", table6=" + table6 +
                '}';
    }
}
