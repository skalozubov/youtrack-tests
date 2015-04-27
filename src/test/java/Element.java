import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class Element {
    protected By by;

    public WebElement element() {
        return ConfigurationManager.getDriver().findElement(by);
    }
}
