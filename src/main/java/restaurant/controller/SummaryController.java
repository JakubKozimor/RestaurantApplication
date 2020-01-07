package restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import restaurant.entity.Summary;
import restaurant.service.SummaryService;

import java.util.List;

@Controller
@RequestMapping("/summary")
public class SummaryController {

    @Autowired
    SummaryService summaryService;

    @GetMapping("/getAllYears")
    public String getAllYears(Model model) {
        List<Integer> listOfYears = summaryService.getListOfYears();
        model.addAttribute("years", listOfYears);
        return "/summary/years-list";
    }

    @GetMapping("/getMonths")
    public String getMonths(@RequestParam("year") int year, Model model) {
        List<Integer> listOfMonths = summaryService.getListOfMonths(year);
        model.addAttribute("months", listOfMonths);
        model.addAttribute("year", year);
        return "/summary/months-list";
    }

    @GetMapping("/getDays")
    public String getDays(@RequestParam("year") int year, @RequestParam("month") int month, Model model) {
        List<Integer> listOfDays = summaryService.getListOfDays(year, month);
        model.addAttribute("days", listOfDays);
        model.addAttribute("year", year);
        model.addAttribute("month", month);
        return "/summary/days-list";
    }

    @GetMapping("/getSummary")
    public String getSummary(@RequestParam("year") int year, @RequestParam("month") int month,
                             @RequestParam("day") int day, Model model) {
        List<Summary> summaryOfDay = summaryService.getSummaryOfDay(year, month, day);
        model.addAttribute("summaryOfDay", summaryOfDay);
        return "/summary/summary-of-day";
    }
}
