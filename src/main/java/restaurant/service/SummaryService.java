package restaurant.service;

import restaurant.Entity.Dish;
import restaurant.Entity.Summary;

import java.util.List;

public interface SummaryService {

    List<Summary> getListOfSummary();

    void updateSummary(int numberOfTable);
}
