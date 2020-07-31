import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumConn {

    private static AndroidDriver driver;
    //    private static AppiumDriver driver;
    public static void main(String[] args) throws MalformedURLException {


        DesiredCapabilities ds = new DesiredCapabilities();
        ds.setCapability("deviceName", "ee1e0c25");
        ds.setCapability("platformName", "Android");
        ds.setCapability("platformVersion", "10.0.0");
        ds.setCapability("appPackages", "com.hxd.writemall");
        ds.setCapability("appActivity", ".function.main.MainActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), ds);


    }


    @Test
    //启动和关闭appium-server

    public void startAndKillAppium() throws IOException, InterruptedException {
        //启动appium-server
        String startAppium = "cmd /c start appium -a 127.0.0.1 -p 4723 -g E:\\appium.log --local-timezone --log-timestamp";
        //Runtime.getRuntime().exec() 执行cmd命令
        Runtime.getRuntime().exec(startAppium);

        Thread.sleep(2000);
        //关闭appium-server和命令行窗口，因为appium-server是用nodejs写的，可以直接关闭node就关闭了appium-server
        String KillNode = "taskkill /F /IM node.exe";
        String killCmd = "taskkill /F /IM cmd.exe";
        Runtime.getRuntime().exec(KillNode);
        Runtime.getRuntime().exec(killCmd);
    }


}
