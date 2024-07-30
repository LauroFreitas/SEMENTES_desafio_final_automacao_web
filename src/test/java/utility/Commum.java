package utility;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Random;

public class Commum {
    WebDriver driver;

    WebDriverWait globalWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public void sendKeys(WebElement element, String msg) {
        try {
            globalWait.until(ExpectedConditions.elementToBeClickable(element));
            element.sendKeys(msg);
        } catch (TimeoutException e) {
            throw new AssertionError("Erro ao acessar o elemento");
        }
    }

    public void click(WebElement element) {
        try {
            globalWait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();

        } catch (TimeoutException e) {
            throw new AssertionError("Erro ao acessar o elemento");
        }
    }

    public void Wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String randomString(int length) {
        String caracteres = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(caracteres.length());
            sb.append(caracteres.charAt(index));
        }

        return sb.toString();
    }
}
