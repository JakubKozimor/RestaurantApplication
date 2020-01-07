package restaurant.service;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import restaurant.entity.Summary;
import restaurant.dao.SummaryRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    SummaryRepository summaryRepository;

    @Override
    public void exportReport(int year, int month, int day) throws FileNotFoundException, JRException {
        StringBuilder pathBuilder = new StringBuilder("C:\\Users\\").append(System.getProperty("user.name")).append("\\Downloads");
        String path = pathBuilder.toString();
        List<Summary> summary = summaryRepository.getSummaryOfDay(year, month, day);
        StringBuilder dateParameter = new StringBuilder("").append(day).append("-").append(month).append("-").append(year);
        BigDecimal dailyProfit = getDailyProfit(year, month, day);
        File file = ResourceUtils.getFile("classpath:report/report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(summary);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("dateParameter", dateParameter.toString());
        parameters.put("dailyProfit", dailyProfit);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint,
                path + "\\summary-of-day-" + year + "-" + month + "-" + day + ".pdf");
    }

    public BigDecimal getDailyProfit(int year, int month, int day) {
        BigDecimal preparationPrice = BigDecimal.valueOf(0);
        BigDecimal sellPrice = BigDecimal.valueOf(0);
        List<Summary> summary = summaryRepository.getSummaryOfDay(year, month, day);
        for (Summary tempSummary : summary) {
            preparationPrice = preparationPrice.add(tempSummary.getdish().getPrice_buy_or_preparation());
            sellPrice = sellPrice.add(tempSummary.getdish().getPriceSell());
        }
        BigDecimal result = sellPrice.subtract(preparationPrice);
        return result;
    }
}
