package ua.com.foxminded;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Gerti on 01.04.2017.
 */
public class Foxminded extends BaseTest{

    @Test
    public void testFoxmindedWeb() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("lst-ib")).clear();
        driver.findElement(By.id("lst-ib")).sendKeys("foxminded");
        driver.findElement(By.id("_fZl")).click();
        //driver.findElement(By.xpath("//div[@id='rso']/div/div/div/div/h3/a")).click(); //to click at the first link from search result
        driver.findElement(By.linkText("Foxminded")).click();
        assertTrue(driver.findElement(By.cssSelector("img[alt=\"foxminded logo\"]")).isDisplayed());
        assertEquals("Главная", driver.getTitle());
        System.out.printf(driver.getTitle());
    }
}
