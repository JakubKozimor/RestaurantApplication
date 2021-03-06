package restaurant.service;

import restaurant.entity.Summary;

import java.util.List;

public interface SummaryService {

    void updateSummary(int numberOfTable);

    List<Integer> getListOfYears();

    List<Integer> getListOfMonths(Integer year);

    List<Integer> getListOfDays(Integer year, Integer month);

    List<Summary> getSummaryOfDay(int year, int month, int day);
}
