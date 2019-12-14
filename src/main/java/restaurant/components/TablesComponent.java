package restaurant.components;

import org.springframework.stereotype.Component;
import restaurant.Entity.Dish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TablesComponent {

    // create map for tables of restaurant
    private Map<Integer, List<Dish>> myRestaurant = new HashMap<>();

    // create list for table orders
    private List<Dish> table1 = new ArrayList<>();
    private List<Dish> table2 = new ArrayList<>();
    private List<Dish> table3 = new ArrayList<>();
    private List<Dish> table4 = new ArrayList<>();
    private List<Dish> table5 = new ArrayList<>();
    private List<Dish> table6 = new ArrayList<>();

    // define constructors
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

    // define getters and setters
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

    public List<Dish> getTable1() {
        return table1;
    }

    public void setTable1(List<Dish> table1) {
        this.table1 = table1;
    }

    public List<Dish> getTable2() {
        return table2;
    }

    public void setTable2(List<Dish> table2) {
        this.table2 = table2;
    }

    public List<Dish> getTable3() {
        return table3;
    }

    public void setTable3(List<Dish> table3) {
        this.table3 = table3;
    }

    public List<Dish> getTable4() {
        return table4;
    }

    public void setTable4(List<Dish> table4) {
        this.table4 = table4;
    }

    public List<Dish> getTable5() {
        return table5;
    }

    public void setTable5(List<Dish> table5) {
        this.table5 = table5;
    }

    public List<Dish> getTable6() {
        return table6;
    }

    public void setTable6(List<Dish> table6) {
        this.table6 = table6;
    }

    // define toString
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
