package starter.ui.dashboard;

import org.openqa.selenium.By;

public class DashboardPage {
    public static LeftMenu LEFT_MENU;
    public static By CREDIT_AVAILABLE = By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div[2]/div/div/div/div[2]/div[2]");
    public static By TOTAL_BALANCE = By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div[2]/div/div/div/div[1]/div[2]/span[1]");
    public static By ADD_COUNT = By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div[1]/a[1]/span");
    public static By MAKE_PAYMENT = By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div[1]/a[2]/span");
    public static By DUE_TODAY = By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div[2]/div/div/div/div[3]/div[2]");
    public static By TABLE_CONTAINER = By.xpath("/html/body/div/div[3]/div[2]/div/div/div[2]/div/div/table");


}
