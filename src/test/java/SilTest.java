/**
 * Created by m18 on 18.01.2016.
 */

public class SilTest {

private WebDriver driver;
private String baseUrl;
private boolean acceptNextAlert = true;
private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://backendless.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void test68() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.cssSelector("a.contact-form-btn.hidden-xs > span")).click();
        driver.findElement(By.name("your-name")).clear();
        driver.findElement(By.name("your-name")).sendKeys("tttt");
        driver.findElement(By.name("your-company")).clear();
        driver.findElement(By.name("your-company")).sendKeys("ttt");
        driver.findElement(By.name("your-phone")).clear();
        driver.findElement(By.name("your-phone")).sendKeys("tttttt");
        driver.findElement(By.name("your-email")).clear();
        driver.findElement(By.name("your-email")).sendKeys("rtrrrr@gmail.com");
        driver.findElement(By.cssSelector("input.wpcf7-form-control.wpcf7-submit")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
