package restaurant.service;

import restaurant.Entity.Summary;

import java.time.LocalDate;
import java.util.List;

public interface SummaryService {

    List<Summary> getListOfSummary();

    void updateSummary(int numberOfTable);

    List<Integer> getListOfYears();

    List<Integer> getListOfMonths(Integer year);

    List<Integer> getListOfDays(Integer year, Integer month);

    List<LocalDate> getYears();

}
