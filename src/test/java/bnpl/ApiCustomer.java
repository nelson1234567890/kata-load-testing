package bnpl;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

import static io.gatling.javaapi.core.CoreDsl.StringBody;
import static io.gatling.javaapi.core.CoreDsl.atOnceUsers;
import static io.gatling.javaapi.core.CoreDsl.nothingFor;
import static io.gatling.javaapi.core.CoreDsl.rampUsers;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.http.HttpDsl.http;

public class ApiCustomer extends Simulation {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiCustomer.class.getName());

    private String content = "Content-Type";
    private String application = "application/json";
    private String channel = "X-channel";
    private String identNum = "X-CustIdentNum";
    private String custIdentType = "X-CustIdentType";
    private String ipAddres = "X-IPAddr";
    private String ipAddresVal = "127.0.0.1";
    private String xName = "X-Name";
    private String xNameValue = "AliadosEcommerce";
    private String request = "X-RqUID";
    private String requestVal = "7395c4e9-89ed-4599-b059-1679ae0775a6";
    private String journey = "X-journey";
    private String identNumber = "x-IdentificationNumber";
    private String identType = "x-IdentificationType";
    private String xAccesToken = "X-AccessToken";
    private String accessToken =
            "eyJhbGciOiJSUzI1NiJ9.eyJpZGVudGl0eVR5cGUiOiAiQyIsICJpZGVudGl0eU51bWJlciI6IjEwMDAxMTcyMTciLCAiZGF0ZWluaXRpYWwiOiIyMDI1LTAxLTEwIDE3OjA1OjM4In0.AcziqCQxc_ukA-gSbBuBX-Y1ezh5qdcIF56y5R20AtlE_tY-lP1sxO6ZXAFdFDOVf_vtGQKRJBnPv4kG3Tu2ro2bSCQJaOPHHrFj3Z7UP7KYSWe-2zUB-zirdWCEbb8B5BEoq3FvAVIyToMWJHH6ERQTJNGVEjv9KUFHXQT-C2o";

    private HttpProtocolBuilder httpProtocol = http
            .baseUrl("https://api-bnpl.labdigbdbstgae.com");

    private Map<CharSequence, String> customer = Map.ofEntries(
            Map.entry(content, application),
            Map.entry(channel, "Web"),
            Map.entry(identNum, "1000117217"),
            Map.entry(custIdentType, "CC"),
            Map.entry(ipAddres, ipAddresVal),
            Map.entry(xName, xNameValue),
            Map.entry(request, requestVal),
            Map.entry(xAccesToken, accessToken)
    );

    private Map<CharSequence, String> prevalidation = Map.ofEntries(
            Map.entry(content, application),
            Map.entry(channel, "Web"),
            Map.entry(ipAddres, ipAddresVal),
            Map.entry(request, requestVal),
            Map.entry(journey, "Checkout"),
            Map.entry(identNumber, "4084069"),
            Map.entry(identType, "CC")
    );

    private ScenarioBuilder scn = scenario("Customer Manager")
            .exec(
                    http("getCustomer")
                            .get("/ecommerce-customer-mngr/V1/Utilities/customer")
                            .headers(customer)

            )
            .pause(1)
            .exec(
                    http("putCustomer")
                            .put("/ecommerce-customer-mngr/V1/Utilities/customer")
                            .headers(customer)
                            .body(StringBody("""
                                        {
                                            "Customer": {
                                                "Email": "bdbnelson@gmail.com",
                                                "Phone": "3012523698",
                                                "City": "Bogota",
                                                "SecondName": "fernando",
                                                "LastName": "rojas",
                                                "MiddleName": "fernando",
                                                "FirstName": "nelson",
                                                "Job": "Asa",
                                                "IsClient": true,
                                                "Income": 2000000.01,
                                                "BirthDt": "1960-06-02",
                                                "Gender": "M",
                                                "ethnicGroupName": "Prefiero no responder",
                                                "ethnicGroupCode": "1000007"
                                            }
                                        }
                                    """))
            )
            .pause(1)
            .exec(
                    http("preValidation")
                            .post("/ecommerce-customer-mngr/V1/Utilities/customer/prevalidation")
                            .headers(prevalidation)
                            .body(StringBody("""
                                        {
                                            "amount": 1500000,
                                            "paymentReference": "abc123-payment-ref-xyz963",
                                            "hasCeropayPlus": false
                                        }
                                    """))
            )
            .pause(1);

    public ApiCustomer() throws IOException {
        setUp(
                scn.injectOpen(
                        nothingFor(5),
                        rampUsers(20).during(15)
                ).protocols(httpProtocol)
        );
    }
}
