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
    private String xAccesToken = "X-AccessToken";
    private String accessToken = "eyJhbGciOiJSUzI1NiJ9.eyJpZGVudGl0eVR5cGUiOiAiQyIsICJpZGVudGl0eU51bWJlciI6IjEwMDAxMTcyMTciLCAiZGF0ZWluaXRpYWwiOiIyMDI1LTAxLTEwIDE2OjIyOjE3In0.Bol0ua7t3kSyQ2pflTrEL9dhqM32k03pDD5LipoQwZthDM3GTEBo2IoRH2jHouVKWO0KULQEWtK20Zw8q0nMCgZJERS2zapTaMM060r6vanNXFDn2Lzc-C5A5hYG29OP-JOO9cQciLLmp8biuRP4c7Cgi4B7rzz31BcFZTDmIbI";

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

    private ScenarioBuilder scn = scenario("Customer Manager")
            .exec(
                    http("customer")
                            .get("/ecommerce-customer-mngr/V1/Utilities/customer")
                            .headers(customer)

            )
            .pause(1)
            .exec(
                    http("customer")
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
            .pause(1);

    public ApiCustomer() throws IOException {
        setUp(
                scn.injectOpen(
                        //nothingFor(5),
                        //rampUsers(20).during(15)
                        atOnceUsers(1)
                ).protocols(httpProtocol)
        );
    }
}
