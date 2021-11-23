package lesson6;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

@Story("CRM Geekbrains")
public class PageObjectCrmTest extends BaseCrmTest{

    @Test
    @Description("Проверка авторизации и создания нового проекта")
    @Feature("Создание проекта")
    @TmsLink("5678")
    @DisplayName("Создание проекта")
    @Flaky
    void PageObjectCrmLoginAndCreateProjectTest() {
        driver.get("https://crm.geekbrains.space/");
        new LoginPageCrm(driver)
                .fillInputLogin("Applanatest1")
                .fillInputPassword("Student2020!")
                .clickLoginButton()
                .navigationMenu.openNavigationBarItem("Проекты");

        new ProjectSubMenu(driver).goToProjectsAllPage();

        new ProjectAllPage(driver)

                .createProject()
                .fillName("Russkih")
                .selectOrganization()
                .fillOrganization("12323142342134")
                .optionOrganization()
                .selectProjectPriority("Низкий")
                .selectProjectFinanceSource("Внутреннее")
                .selectProjectBusinessUnit("Research & Development")
                .selectProjectCurator("Applanatest Applanatest Applanatest")
                .selectProjectRp("Applanatest Applanatest Applanatest")
                .selectProjectAdministrator("Applanatest Applanatest Applanatest")
                .selectProjectManager("Амелин Владимир")
                .fillConfigManagement("TestTest")
                .buttonSaveAndClose.click();

        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//div[contains(text(),'Загрузка')]")));

        Assertions.assertEquals("Это значение уже используется.",
                new CreateProjectPage(driver).validationFailed.getText());
    }

    @Test
    @Flaky
    @TmsLink("1234")
    @Description("Проверка авторизации и создания контактного лица")
    @Feature("Создание контактного лица")
    @DisplayName("Создание контактного лица")
    void PageObjectCrmLoginAndCreateContactTest() {
        driver.get("https://crm.geekbrains.space/");
        new LoginPageCrm(driver)
                .fillInputLogin("Applanatest1")
                .fillInputPassword("Student2020!")
                .clickLoginButton()
                .navigationMenu.openNavigationBarItem("Контрагенты");

        new ContactPersonSubMenu(driver).goToContactAllPage();

        new ContactPersonAllPage(driver)

                .createContact()
                .fillContactLastName("Russkih")
                .fillContactFirstName("Anastacia")
                .fillContactMiddleName("Victorovna")
                .selectOrganization()
                .fillOrganization("12323142342134")
                .optionOrganization()
                .fillContactJobTitle("tester")
                .selectContactStatus("Активный")
                .buttonSaveAndClose.click();

        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//div[contains(text(),'Загрузка')]")));

        assertThat(new CreateContactPersonPage(driver).contactSavedSuccessfullyElement, isDisplayed());
    }
}