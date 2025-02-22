package demo.com;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AppTest {

    // mvn -DargLine="-Dwebdriver.chrome.driver=C:\chromedriver\chromedriver.exe" test
    @Test
    public void testGoogleSearch() throws InterruptedException {
        final WebDriver driver = new ChromeDriver();
        // 本来であれば作成したWebサービスのURLを指定するが、ドメインを取得していないため
        // Googleへアクセスできることを確認する
        driver.get("http://www.google.com");

        Thread.sleep(10); 
        final WebElement searchBox = driver.findElement(By.name("q"));  // 検索用のtextboxを検索
        searchBox.sendKeys("ChromeDriver"); // "ChromeDriver"と入力
        searchBox.submit();                               // 検索
        Thread.sleep(10);

        driver.quit();
    }
}
