import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumTest {
    private static AndroidDriver driver;

    @BeforeMethod
    public void init() throws MalformedURLException, InterruptedException {
        DesiredCapabilities ds = new DesiredCapabilities();
        ds.setCapability("deviceName", "66J5T19117002161");
        ds.setCapability("platformName", "Android");
        ds.setCapability("platformVersion", "10");
        ds.setCapability("appPackage", "cn.com.open.mooc");
        ds.setCapability("appActivity", "com.imooc.component.imoocmain.index.MCMainActivity");
//        ds.setCapability("appPackage", "com.hxd.writemall");
//        ds.setCapability("appActivity", "com.hxd.writemall.function.main.WelcomeActivity");
        ds.setCapability("sessionOverride", true);
        ds.setCapability("noReset", true);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), ds);

    }

    @Test
    public void test() throws InterruptedException {
//        List<WebElement> list = (List<WebElement>) driver.findElementByClassName("android.widget.Button");
//        list.get(12).click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        WebElement main = webDriverWait.until(new ExpectedCondition<WebElement>() {
            @NullableDecl
            public WebElement apply(@NullableDecl WebDriver driver) {
                return driver.findElement(By.id("cn.com.open.mooc:id/lav"));
            }
        });
//        driver.findElement(By.xpath("//*[@text='00']")).click();
//        driver.findElementByAccessibilityId("乘").click();
//        driver.findElement(By.id("digit_6")).click();
//        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"2\")").click();
//        driver.findElementById("com.coloros.calculator:id/eq").click();


//        driver.findElementById("cn.com.open.mooc:id/lav").click();
        int x= driver.manage().window().getSize().width;
        int y=driver.manage().window().getSize().height;
        AndroidTouchAction androidTouchAction=new AndroidTouchAction(driver);
        Thread.sleep(1000);
        System.out.println(x+"==============="+y);
        androidTouchAction.press(PointOption.point(x*9/10,y*2150/2163)).release().perform();
//        driver.findElement(By.xpath("//*[@text='账号']")).click();
        Thread.sleep(2000);
        driver.findElementById("cn.com.open.mooc:id/tvLoginNow").click();
        driver.findElementById("cn.com.open.mooc:id/WeiboLogin").click();
        Thread.sleep(5000);
    }

//    @Test
//    public void test1() throws InterruptedException {
//
//        TouchAction touchAction = new TouchAction(driver);
//        touchAction.tap(PointOption.point(100, 200));
//        AndroidTouchAction androidTouchAction = new AndroidTouchAction(driver);
//        androidTouchAction.longPress(LongPressOptions.longPressOptions().withDuration(Duration.ofSeconds(2)));
//        WebElement element = driver.findElementById("com.coloros.calculator:id/eq");
//        androidTouchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(element)).withTapsCount(2));
//    }

    @AfterMethod
    public void end() {
        driver.quit();

    }
}
