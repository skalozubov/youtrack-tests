import org.openqa.selenium.*;
import org.testng.annotations.*;
import ru.mail.helpers.WebDriverManager;
import ru.mail.pages.LoginPage;
import ru.mail.testdata.TestData;

public class BaseTest {
    protected WebDriver driver;
    public String baseUrl;
    protected TestData testData;
    protected LoginPage loginPage;

    @BeforeClass
    public void setUpClass() {
        System.out.println("Started all tests in class");
        baseUrl = "https://mail.ru/";
    }

    @BeforeMethod
    public void setUp() {
        driver = WebDriverManager.getDriver();
        driver.get(baseUrl);
        testData = new TestData();
        loginPage = new LoginPage();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        WebDriverManager.killDriver();
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("Finished all tests in class");
    }
}
