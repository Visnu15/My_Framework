package Steps;

import io.cucumber.java.*;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends BaseClass{

    public static Scenario scenario;

    @Before
    public void beforeScenario(Scenario sc){
        scenario = sc;
    }

    @AfterStep
    public static void afterStep(){
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] ss = ts.getScreenshotAs(OutputType.BYTES);
//        scenario.embed(ss, "image/png");
        scenario.attach(ss, "image/png", "Screenshot taken!");
    }

    @After
    public static void tearDown(){
        driver.quit();
    }

    public static void log(String msg){
        scenario.log(msg);
    }







//    @AfterAll
//    public static void reportGen() throws IOException {
//        try {
//            SimpleDateFormat time = new SimpleDateFormat("yyyyMMddHHmmss");
//            String timestamp = time.format(new Date());
//
//            String ActualRepPath = "Reports/SparkReport/SparkReport.html";
//            String DynamicRepPath = "Reports/DynamicSparkReport/SparkReport_"+timestamp+".html";
//
//            File rep = new File(ActualRepPath);
//            if (rep.exists()){
//                Path src = Paths.get(ActualRepPath);
//                Path des = Paths.get(DynamicRepPath);
//                Files.move(src, des);
//                System.out.println("Report generated at " + DynamicRepPath);
//            }
//            else {
//                System.out.println("Dynamic report generation failed!");
//            }
//        } catch (Throwable e) {
//            System.out.println("Dynamic report generation failed!");
//            e.printStackTrace();
//        }
//    }

}
