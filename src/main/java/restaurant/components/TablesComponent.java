package restaurant.components;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TablesComponent {

    // create map for tables of restaurant
    private Map<Integer, List<Integer>> myRestaurant = new HashMap<>();

    // create list for table orders
    private List<Integer> table1 = new ArrayList<>();
    private List<Integer> table2 = new ArrayList<>();
    private List<Integer> table3 = new ArrayList<>();
    private List<Integer> table4 = new ArrayList<>();
    private List<Integer> table5 = new ArrayList<>();
    private List<Integer> table6 = new ArrayList<>();

    // define constructors
    public TablesComponent() {
        myRestaurant.put(1, table1);
        myRestaurant.put(2, table2);
        myRestaurant.put(3, table3);
        myRestaurant.put(4, table4);
        myRestaurant.put(5, table5);
        myRestaurant.put(6, table6);

    }

    public TablesComponent(Map<Integer, List<Integer>> myRestaurant) {
        this.myRestaurant = myRestaurant;
    }

    // define getters and setters
    public Map<Integer, List<Integer>> getMyRestaurant() {
        return myRestaurant;
    }

    public void setMyRestaurant(Map<Integer, List<Integer>> myRestaurant) {
        this.myRestaurant = myRestaurant;
    }

    public List<Integer> getTable1() {
        return table1;
    }

    public void setTable1(List<Integer> table1) {
        this.table1 = table1;
    }

    public List<Integer> getTable2() {
        return table2;
    }

    public void setTable2(List<Integer> table2) {
        this.table2 = table2;
    }

    public List<Integer> getTable3() {
        return table3;
    }

    public void setTable3(List<Integer> table3) {
        this.table3 = table3;
    }

    public List<Integer> getTable4() {
        return table4;
    }

    public void setTable4(List<Integer> table4) {
        this.table4 = table4;
    }

    public List<Integer> getTable5() {
        return table5;
    }

    public void setTable5(List<Integer> table5) {
        this.table5 = table5;
    }

    public List<Integer> getTable6() {
        return table6;
    }

    public void setTable6(List<Integer> table6) {
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
