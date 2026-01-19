package Utils;

import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.Status;  
import java.io.File;

public class ExtendManager {

    static ExtentReports extent;
    static ExtentSparkReporter reporter;
    static ExtentTest logger1;

    static {
        String reportPath = System.getProperty("user.dir") + "/target/Reports";
        File reportDir = new File(reportPath);
        if (!reportDir.exists()) {
            reportDir.mkdirs(); 
        }

        extent = new ExtentReports();
        reporter = new ExtentSparkReporter(reportPath + "/extentReport1.html");
        extent.attachReporter(reporter);
    }

    public static void generateReport() {
        logger1 = extent.createTest("Open Test");

        try {
            ChromeDriver driver = new ChromeDriver();
            driver.get("https://www.google.com/");
            
            driver.manage().window().maximize();
            
            Thread.sleep(2000);  

            logger1.log(Status.PASS, "Application opened successfully");
            
            driver.quit();
        } catch (Exception e) {
            logger1.log(Status.FAIL, "Failed to open the application: " + e.getMessage());
        } finally {
             extent.flush();
        }
    }

    public static void main(String[] args) {
        generateReport();
    }
}
