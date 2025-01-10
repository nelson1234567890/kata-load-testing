package bnpl;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;


import static io.gatling.javaapi.core.CoreDsl.atOnceUsers;
import static io.gatling.javaapi.core.CoreDsl.bodyString;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;


public class ApiCustomer extends Simulation {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiCustomer.class.getName());

    private String content = "Content-Type";
    private String aplication = "application/json";
    private String channel = "X-channel";
    private String identNum = "X-CustIdentNum";
    private String custIdentType = "X-CustIdentType";
    private String ipAddres = "X-IPAddr";
    private String ipAddresVal = "127.0.0.1";
    private String xName = "X-Name";
    private String xNameValue = "AliadosEcommerce";
    private String request = "X-RqUID";
    private String requestVal = "3e4f32c2-82be-405a-8213-695789068032";
    private String xAccesToken = "X-AccessToken";
    private String accessToken = "eyJhbGciOiJSUzI1NiJ9.eyJpZGVudGl0eVR5cGUiOiAiQyIsICJpZGVudGl0eU51bWJlciI6IjEwMDAxMTcyMTciLCAiZGF0ZWluaXRpYWwiOiIyMDI1LTAxLTEwIDEyOjQ1OjM5In0.QEHORrgTUga8UxG0cBlP_xI3bSY22IxYkAgicPE5AiXFVDbOvM-L-FCw8Qc6Ay7tCRbU5jnZLWYEvOvvZX4Tochr6CUQ5RR5T3Ci81HTJP68UjqRu3xAj5GByZ27qGyH5I38aWCLzwZf5Dqhy4Ag3wBWSA6nMDiQGb8SdM9GiBQ";


    private HttpProtocolBuilder httpProtocol = http
            .baseUrl("https://api-bnpl.labdigbdbstgae.com");


    private Map<CharSequence, String> getCustomer = Map.ofEntries(
            Map.entry(content, aplication),
            Map.entry(channel, "Web"),
            Map.entry(identNum, "1000117217"),
            Map.entry(custIdentType, "CC"),
            Map.entry(ipAddres, ipAddresVal),
            Map.entry(xName, xNameValue),
            Map.entry(request,requestVal),
            Map.entry("X-AccessToken","eyJhbGciOiJSUzI1NiJ9.eyJpZGVudGl0eVR5cGUiOiAiQyIsICJpZGVudGl0eU51bWJlciI6IjEwMDAxMTcyMTciLCAiZGF0ZWluaXRpYWwiOiIyMDI1LTAxLTEwIDEyOjUwOjE4In0.E4vm2_5b64cKse0LYUJkJAw4Jx8UnnH9hqeJ_j1Gn_uQp9Av83D_-wYZe4E5V4V6BEaZPynIVHbAFkg2ujuAQ3kPpaulgA3u6-GLWdvivI7tpUaSm-rPsaSOz-plAWgD7r-rLhc0MHSIK5BBXL4IvcTwVxl-gzgKm-6Ldd6QZI0")
    );

    private ScenarioBuilder scn = scenario("Customer mngr")
            .exec(
                    http("customer")
                            .get("/ecommerce-customer-mngr/V1/Utilities/customer")
                            .headers(getCustomer)
                            .check(status().is(200))
                            .check(bodyString().saveAs("responseBody")))
            .exec(session -> {
                LOGGER.info(session.getString("responseBody"));
                return session;
            })
            .pause(1);

    public ApiCustomer() throws IOException {
        setUp(
                scn.injectOpen(
//                        nothingFor(10),
//                        rampUsers(5).during(15)

                        atOnceUsers(1)
                ).protocols(httpProtocol)
        );
    }
}
