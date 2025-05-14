package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() throws IOException {
        if (extent==null){
            SimpleDateFormat time = new SimpleDateFormat("yyyyMMddHHmmss");
            String timestamp = time.format(new Date());
            String repPath = "Reports/SparkReport/SparkReport_"+timestamp+".html";

            ExtentSparkReporter spark = new ExtentSparkReporter(repPath);
//            spark.loadXMLConfig("./src/test/resources/extent-config.xml");
            spark.config().setReportName("Automation Results");
            spark.config().setDocumentTitle("Cucumber Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("OS","Windows");
            extent.setSystemInfo("Tester","Visnu");
        }
        return extent;
    }
}
