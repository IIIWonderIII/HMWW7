package lesson6;

import org.openqa.selenium.WebDriver;

public class MainPage extends BaseView {
    public NavigationBar navigationMenu;

    public MainPage(WebDriver driver) {
        super(driver);
        navigationMenu = new NavigationBar(driver);

    }
}