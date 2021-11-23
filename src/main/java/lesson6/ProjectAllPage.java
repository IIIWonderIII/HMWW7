package lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectAllPage extends BaseView {
    public ProjectAllPage(WebDriver driver) {
        super(driver);
    }

    public static final String createProjectXpathLocator = "//a[@title='Создать проект']";

    @FindBy(xpath = createProjectXpathLocator)
    public WebElement createProjectButton;

    @Step("Клик на кнопку 'Создать проект'")
    public CreateProjectPage createProject() {
        createProjectButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(CreateProjectPage.saveAndCloseButtonXpathLocator)));
        return new CreateProjectPage(driver);
    }
}
