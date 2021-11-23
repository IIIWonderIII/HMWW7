package lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactPersonAllPage extends BaseView {
    public ContactPersonAllPage(WebDriver driver) {
        super(driver);
    }

    public static final String createContactXpathLocator = "//a[@title='Создать контактное лицо']";

    @FindBy(xpath = createContactXpathLocator)
    public WebElement createContactButton;

    @Step("Клик на кнопку 'Создать контактное лицо'")
    public CreateContactPersonPage createContact() {
        createContactButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(CreateContactPersonPage.saveAndCloseButtonXpathLocator)));
        return new CreateContactPersonPage(driver);
    }
}
