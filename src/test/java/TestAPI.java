import io.qameta.allure.Flaky;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAPI {

    @BeforeMethod
    public void setUp() {
        RestAssured.requestSpecification = new RequestSpecBuilder().log(LogDetail.ALL).build();
    }

    @Test(description = "First work with API methods and allure")
    @Flaky
    @Owner("Pechonka Andrii")
    @Severity(SeverityLevel.NORMAL)
    public void workWithPets() {
        new APIMethods().
                postNewPost(DataForTests.ID.getInt(), DataForTests.NAME.getText(), DataForTests.STATUS.getText()).
                changeTheNameInPost(DataForTests.ID.getInt(), DataForTests.NAME_FOR_CHANGE.getText(), DataForTests.STATUS.getText()).
                getName(DataForTests.NAME_FOR_CHANGE.getText(), DataForTests.ID.getInt()).
                deleteThePost(DataForTests.ID.getInt());
    }
}