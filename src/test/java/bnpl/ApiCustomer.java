package bnpl;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import java.io.IOException;
import java.util.Map;


import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.core.CoreDsl.StringBody;
import static io.gatling.javaapi.core.CoreDsl.nothingFor;
import static io.gatling.javaapi.core.CoreDsl.rampUsers;
import static io.gatling.javaapi.http.HttpDsl.http;


public class ApiCustomer extends Simulation {


    private String content = "Content-Type";
    private String aplication = "application/json";
    private String channel = "X-channel";
    private String identNum = "X-CustIdentNum";
    private String custIdentType = "X-CustIdentType";
    private String ipAddres = "X-IPAddr";
    private String ipAddresVal = "127.0.0.1";
    private String request = "X-RqUID";
    private String requestVal = "3e4f32c2-82be-405a-8213-695789068032";
    private String accessToken = "eyJhbGciOiJSUzI1NiJ9.eyJpZGVudGl0eVR5cGUiOiAiQyIsICJpZGVudGl0eU51bWJlciI6IjEwMDAxMTcyMTciLCAiZGF0ZWluaXRpYWwiOiIyMDI1LTAxLTA5IDE2OjQ3OjQ0In0.GlMBCfsc-7e7rd2FByuMI25_p9lOssk_owjqHo9sfsg01PRrvHEpX474UaUX2YpMjKGPlPj198vyCPop7td_8Qeikvh1SZal2GEaIjSdVpxgQ7BYKdI4p7hJgIOoeiC5Ii_Ii9t4ovbMu4WAy48zX-neeteNvMElZwbW3iWmpcs";

    private String custID = "X-IdentSerialNum";
    private String custIDType = "X-CustIdentType";
    private String cusIdenNum = "X-CustIdentNum";

    private HttpProtocolBuilder httpProtocol = http
            .baseUrl("https://api-bnpl.labdigbdbstgae.com");


    private Map<CharSequence, String> getCustomer = Map.ofEntries(
            Map.entry(content, aplication),
            Map.entry(channel, "Web"),
            Map.entry(identNum, "1000117217"),
            Map.entry(custIdentType, "CC"),
            Map.entry(ipAddres, ipAddresVal),
            Map.entry("X-Name", "AliadosEcommerce"),
            Map.entry(request,requestVal),
            Map.entry("X-AccessToken",accessToken)
    );

    private ScenarioBuilder scn = scenario("Customer mngr")
            .exec(
                    http("getCustomer")
                            .get("/ecommerce-customer-mngr/V1/Utilities/customer")
                            .headers(getCustomer))
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
