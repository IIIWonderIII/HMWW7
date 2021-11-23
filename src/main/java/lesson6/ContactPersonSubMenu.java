package lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactPersonSubMenu extends BaseView {

    public ContactPersonSubMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Контактные лица']")
    public WebElement counterpartiesMenuItem;

    @Step("Клик на пункт подменю 'Контактные лица'")
    public void goToContactAllPage() {
        counterpartiesMenuItem.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(ContactPersonAllPage.createContactXpathLocator)));
    }
}
