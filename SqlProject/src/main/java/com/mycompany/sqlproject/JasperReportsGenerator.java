package com.mycompany.sqlproject;

import com.mycompany.sqlproject.Beans.BuildingBean;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class JasperReportsGenerator {
    
    public static void generatePdfReport(ArrayList<BuildingBean> beans) throws JRException {
         try {
            JasperDesign jasperDesign = JRXmlLoader.load("MyLastBlank.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

            HashMap<String, Object> parameters = new HashMap<>();
            parameters.put("Date", new Date());

            JRDataSource dataSource = new JRBeanCollectionDataSource(beans);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

            String pdfOutputPath = "report.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, pdfOutputPath);

        } catch (JRException e) {
            throw new JRException(e);
        }
    }
}
