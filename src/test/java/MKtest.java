import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class MKtest {

    private static AndroidDriver driver;
    private String info1;

    @BeforeSuite
    public void init() throws MalformedURLException {
        DesiredCapabilities ds = new DesiredCapabilities();
        ds.setCapability("deviceName", "66J5T19117002161");
        ds.setCapability("platformName", "Android");
        ds.setCapability("platformVersion", "10");
        ds.setCapability("appPackage", "cn.com.open.mooc");
        ds.setCapability("appActivity", "com.imooc.component.imoocmain.splash.MCSplashActivity");
        ds.setCapability("sessionOverride", true);
        ds.setCapability("noReset", false);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), ds);
    }

    @Test
    public void test() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id("cn.com.open.mooc:id/negativeBtn")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("cn.com.open.mooc:id/left_icon")).click();
        driver.findElement(By.id("cn.com.open.mooc:id/iv_cancel")).click();
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;

        AndroidTouchAction androidTouchAction = new AndroidTouchAction(driver);
        for (int i = 0; i < 5; i++) {
            List<MobileElement> list = (List<MobileElement>) driver.findElementsByXPath("//*");
            System.out.println(list.size()+"               ");
            String info = list.get(list.size() - 1).getAttribute("text");
            System.out.println("滑动前========="+info);
            androidTouchAction.press(PointOption.point(width / 2, height / 2)).moveTo(PointOption.point(width / 2, height / 5)).release().perform();
            Thread.sleep(5000);
            List<MobileElement> list1 = (List<MobileElement>) driver.findElementsByXPath("//*");
            String info1 = list.get(list.size() - 1).getAttribute("text");
            System.out.println("滑动后========="+info1);
            if(info.equals(info1)){
                System.out.println("已经到底部了");
                break;
            }
        }


    }

    @AfterSuite
    public void end() {

        driver.quit();

    }


}
