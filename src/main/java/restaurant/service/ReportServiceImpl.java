package restaurant.service;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import restaurant.Entity.Summary;
import restaurant.dao.SummaryRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    SummaryRepository summaryRepository;

    @Override
    public String exportReport() throws FileNotFoundException, JRException {
        String path = "C:\\Users\\Jakub\\Desktop\\reports";
        List<Summary> summary = summaryRepository.findAll();
        File file = ResourceUtils.getFile("classpath:report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(summary);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("created by", "Java Techie");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint,path+"\\summary.pdf");
        return "report generated in path : " + path;
    }
}
