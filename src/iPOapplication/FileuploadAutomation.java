package iPOapplication;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class FileuploadAutomation {

    public static void main(String[] args) {
        // Set the path to your WebDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hachn\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        // Maximize the browser window
        driver.manage().window().maximize();

        // Open the login page
        driver.get("https://bsec-ipo-test.tappware.com/login");
        
        // Perform login
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("passwordInput"));
        WebElement loginButton = driver.findElement(By.id("kt_sign_in_submit"));
        
        usernameField.sendKeys("info@automation.com");
        passwordField.sendKeys("Tapp@1000");
        loginButton.click();
        
        // Wait for redirection after login
        try {
            Thread.sleep(20000); // Wait for 20 seconds (adjust as needed)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        
        // Navigate to the desired page after login
        driver.get("https://bsec-ipo-test.tappware.com/ipo-application/process");
        
        // Wait for the page to load and the "Next" button to be clickable
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"stepDiv7\"]/div/div[1]/span")));
        nextButton.click();
        
        // Pause to allow the page to load
        try {
            Thread.sleep(5000); // Adjust the sleep time as necessary
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Find all elements matching the edit button's XPath
        List<WebElement> editButtons = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"requirements-table\"]/tbody/tr/td[6]/span/i")));

        // Random number generator
        Random random = new Random();

        // Initialize the starting ID
        int id = 31;

        // JavaScript Executor for scrolling
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Iterate over the edit buttons and perform actions
        for (int i = 0; i < 512; i++) {
            // Skip IDs 32, 33, 37, and 38
            if (id == 32 || id == 33) {
                id = 34; // Jump to 34 after 31
            } if (id == 37 || id == 38) {
                id = 39; // Jump to 39 after 36
            } if (id == 219 || id == 220) {
            	id = 221; // Jump to 221 after 218
            }

            if (i < editButtons.size()) {
                editButtons.get(i).click(); // Click the edit button

                // Construct the XPath for the input field and save button dynamically
                String inputFieldXPath = String.format("//*[@id=\"page-no-input-%d\"]", id);
                String saveButtonXPath = String.format("//*[@id=\"submit-popover-content-%d\"]/button[3]", id);

                // Wait for the input field to be visible and interactable
                WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputFieldXPath)));
                inputField.clear(); // Clear any pre-existing data in the field
                
                // Generate a random number between 1 and 50
                int randomValue = random.nextInt(300) + 1;
                inputField.sendKeys(String.valueOf(randomValue)); // Enter the random value

                // Click the save button
                WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(saveButtonXPath)));
                saveButton.click();

                // Wait for the save action to complete
                wait.until(ExpectedConditions.invisibilityOf(saveButton));

                // Pause to ensure the save operation completes
                try {
                    Thread.sleep(3000); // Adjust the pause time as necessary
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Scroll down to the next element
                js.executeScript("window.scrollBy(0, 300);"); // Adjust the scroll value as necessary
            } else {
                System.out.println("Edit button not found for index: " + i);
            }

            // Increment the ID
            id++;
        }
        
        // Process additional requirements with random values
        List<WebElement> additionalRequirementsButtons = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"additional_requirements\"]/tbody/tr/td[4]/span[2]/i")));
        int addId = 511;

        for (int i = 0; i < additionalRequirementsButtons.size(); i++) {
            if (i < additionalRequirementsButtons.size()) {
                additionalRequirementsButtons.get(i).click(); // Click the edit button

                // Construct the XPath for the input field and save button dynamically
                String inputFieldXPath = String.format("//*[@id=\"page-no-input-%d\"]", addId);
                String saveButtonXPath = String.format("//*[@id=\"submit-popover-content-%d\"]/button[3]", addId);

                // Wait for the input field to be visible and interactable
                WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputFieldXPath)));
                inputField.clear(); // Clear any pre-existing data in the field
                
                // Generate a random number between 1 and 50
                int randomValue = random.nextInt(50) + 1;
                inputField.sendKeys(String.valueOf(randomValue)); // Enter the random value

                // Click the save button
                WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(saveButtonXPath)));
                saveButton.click();

                // Wait for the save action to complete
                wait.until(ExpectedConditions.invisibilityOf(saveButton));

                // Pause to ensure the save operation completes
                try {
                    Thread.sleep(3000); // Adjust the pause time as necessary
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Scroll down to the next element
                js.executeScript("window.scrollBy(0, 300);"); // Adjust the scroll value as necessary
            } else {
                System.out.println("Additional requirement button not found for index: " + i);
            }

            // Increment the ID
            addId++;
        }

        // Process extra requirements with random values
        List<WebElement> extraRequirementsButtons = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"additional_document\"]/tbody/tr/td[3]/span[2]/i")));
        int extraId = 518;

        for (int i = 0; i < extraRequirementsButtons.size(); i++) {
            if (i < extraRequirementsButtons.size()) {
                extraRequirementsButtons.get(i).click(); // Click the edit button

                // Construct the XPath for the input field and save button dynamically
                String inputFieldXPath = String.format("//*[@id=\"page-no-input-%d\"]", extraId);
                String saveButtonXPath = String.format("//*[@id=\"submit-popover-content-%d\"]/button[3]", extraId);

                // Wait for the input field to be visible and interactable
                WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputFieldXPath)));
                inputField.clear(); // Clear any pre-existing data in the field
                
                // Generate a random number between 1 and 50
                int randomValue = random.nextInt(50) + 1;
                inputField.sendKeys(String.valueOf(randomValue)); // Enter the random value

                // Click the save button
                WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(saveButtonXPath)));
                saveButton.click();

                // Wait for the save action to complete
                wait.until(ExpectedConditions.invisibilityOf(saveButton));

                // Pause to ensure the save operation completes
                try {
                    Thread.sleep(3000); // Adjust the pause time as necessary
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Scroll down to the next element
                js.executeScript("window.scrollBy(0, 300);"); // Adjust the scroll value as necessary
            } else {
                System.out.println("Extra requirement button not found for index: " + i);
            }

            // Increment the ID
            extraId++;
        }

        // Close the browser (optional)
        // driver.quit();
    }
}
