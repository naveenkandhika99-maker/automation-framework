\# Selenium TestNG Automation Framework



A test automation framework for an e-commerce web application, built with Java, Selenium WebDriver, TestNG and Maven, using the Page Object Model.



Application under test: https://rahulshettyacademy.com/client



\## Tech stack

\- Java 17

\- Selenium WebDriver 4

\- TestNG

\- Maven

\- Extent Reports

\- Git and GitHub



\## Features

\- Page Object Model: each page has its own class with locators and actions

\- Parent class for common waits and navigation (inheritance)

\- BaseTest for browser setup and teardown

\- Test data and URL kept in a config.properties file, not in the code

\- Explicit waits (WebDriverWait), no Thread.sleep

\- TestNG groups (smoke, regression)

\- TestNG listener that takes a screenshot on test failure

\- HTML report with Extent Reports



\## Test flow

Login, add a product to the cart, verify the product in the cart, checkout, select the country, place the order and verify the confirmation message.



\## Project structure
    src/test/java

&#x20;     abstarctpac   parent class with shared waits

&#x20;     base          BaseTest (browser setup and teardown)

&#x20;     framewrk      page classes (Landing, Product catalogue, Cart, Checkout, Confirmation)

&#x20;     listeners     TestListener (screenshot on failure, report)

&#x20;     tests         SubmitOrderTest

&#x20;     utils         ConfigReader, ScreenshotUtil, ExtentManager

&#x20;   src/test/resources

&#x20;     config.properties.example

&#x20;   testng.xml

&#x20;   pom.xml



\## How to run

1\. Clone the repository.

2\. Create `src/test/resources/config.properties`. Copy `config.properties.example` and fill in a practice account registered on the site above.

3\. In Eclipse, right-click `testng.xml`, choose Run As, then TestNG Suite.

4\. Open `reports/index.html` to see the report. Failure screenshots are saved in the `screenshots` folder.



\## Author

Naveen

