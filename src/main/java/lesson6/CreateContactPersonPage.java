package lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateContactPersonPage extends BaseView {
    public CreateContactPersonPage(WebDriver driver) {
        super(driver);
    }

    public static final String searchOrganizationXpathLocator = "//div[@class='select2-result-label']";
    public static final String saveAndCloseButtonXpathLocator = "//button[contains(text(), 'Сохранить и закрыть')]";

    @FindBy(xpath = "//input[contains(@id, 'crm_contact_lastName')]")
    public WebElement contactLastName;

    @Step("Заполняем поле 'Фамилия'")
    public CreateContactPersonPage fillContactLastName(String lastName) {
        contactLastName.sendKeys(lastName);
        return this;
    }

    @FindBy(xpath = "//input[contains(@id, 'crm_contact_firstName')]")
    public WebElement contactFirstName;

    @Step("Заполняем поле 'Имя'")
    public CreateContactPersonPage fillContactFirstName(String firstName) {
        contactFirstName.sendKeys(firstName);
        return this;
    }

    @FindBy(xpath = "//input[contains(@id, 'crm_contact_middleName')]")
    public WebElement contactMiddleName;

    @Step("Заполняем поле 'Отчество'")
    public CreateContactPersonPage fillContactMiddleName(String middleName) {
        contactMiddleName.sendKeys(middleName);
        return this;
    }

    @FindBy(xpath = "//span[text()='Укажите организацию']")
    public WebElement specifyOrganization;

    @Step("клик на поле 'Укажите организацию'")
    public CreateContactPersonPage selectOrganization() {
        specifyOrganization.click();
        return this;
    }

    @FindBy(xpath = "//div[@id='select2-drop']//input")
    public WebElement searchOrganization;

    @Step("Заполняем поле 'Укажите организацию'")
    public CreateContactPersonPage fillOrganization(String name) {
        searchOrganization.sendKeys(name);
        return this;
    }

    @FindBy(xpath = searchOrganizationXpathLocator)
    public List<WebElement> organizationVars;

    @Step("Ждем появления поля 'Укажите организацию'")
    public CreateContactPersonPage optionOrganization() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(searchOrganizationXpathLocator)));
        organizationVars.get(0).click();
        return this;
    }

    @FindBy(xpath = "//input[contains(@id, 'crm_contact_jobTitle')]")
    public WebElement contactJobTitle;

    @Step("Заполняем поле 'Должность'")
    public CreateContactPersonPage fillContactJobTitle(String jobTitle) {
        contactJobTitle.sendKeys(jobTitle);
        return this;
    }

    @FindBy(xpath = "//select[contains(@id, 'crm_contact_status')]")
    public WebElement contactStatusSelect;

    @Step("Заполняем поле 'Статус'")
    public CreateContactPersonPage selectContactStatus(String contactStatus) {
        new Select(contactStatusSelect).selectByVisibleText(contactStatus);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(), 'Сохранить и закрыть')]")
    public WebElement buttonSaveAndClose;

    @FindBy(xpath = "//*[text()='Контактное лицо сохранено']")
    public WebElement contactSavedSuccessfullyElement;
}
