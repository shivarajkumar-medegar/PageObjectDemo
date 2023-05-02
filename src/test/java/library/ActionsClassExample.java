package library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassExample {
         WebDriver driver;

        public ActionsClassExample(WebDriver driver) {
            this.driver = driver;
        }

        // Method to perform a hover over an element
        public void hoverOverElement(WebElement element) {
            Actions actions = new Actions(driver);
            actions.moveToElement(element).build().perform();
        }

        // Method to click and hold an element
        public void clickAndHold(WebElement element) {
            Actions actions = new Actions(driver);
            actions.clickAndHold(element).build().perform();
        }

        // Method to drag and drop an element
        public void dragAndDrop(WebElement source, WebElement target) {
            Actions actions = new Actions(driver);
            actions.dragAndDrop(source, target).build().perform();
        }

        // Method to double click an element
        public void doubleClick(WebElement element) {
            Actions actions = new Actions(driver);
            actions.doubleClick(element).build().perform();
        }

        // Method to right click an element
        public void rightClick(WebElement element) {
            Actions actions = new Actions(driver);
            actions.contextClick(element).build().perform();
        }

        // Method to move an element by an offset
        public void moveByOffset(int x, int y) {
            Actions actions = new Actions(driver);
            actions.moveByOffset(x, y).build().perform();
        }
    }

