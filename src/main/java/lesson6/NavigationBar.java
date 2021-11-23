package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;

import java.util.List;

public class NavigationBar extends BaseView {

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul[@class='nav nav-multilevel main-menu']/li")
    public List<WebElement> navigationBarItems;

    @Step("Открытие выпадающего меню")
    public void openNavigationBarItem(String menuName) {
        Actions actions = new Actions(driver);
        actions.moveToElement(navigationBarItems.stream()
                .filter(element -> element.getText().equals(menuName))
                .findFirst().get()).perform();
    }
}
