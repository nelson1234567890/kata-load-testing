package bnpl;

import com.utilidades.CofigFile;
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

public class ApiCaptcha extends Simulation {


    private String content = "Content-Type";
    private String aplication = "application/json";
    private String request = "X-RqUID";
    private String requestVal = "3e4f32c2-82be-405a-8213-695789068032";
    private CofigFile env = new CofigFile();
    private String xCustomHeaderAeBNPL = env.getProperty("x-custom-header-ae-bnpl");
    private String token = env.getProperty("token");
    private String captchaPayload = "{\"token\":" + token + "}";

    private HttpProtocolBuilder httpProtocol = http
            .baseUrl("https://api-bnpl.labdigbdbstgae.com");

    private Map<CharSequence, String> captcha = Map.ofEntries(
            Map.entry(content, aplication),
            Map.entry(request, requestVal),
            Map.entry("X-CustIdentNum", "1000117217"),
            Map.entry("x-custom-header-ae-bnpl", xCustomHeaderAeBNPL),
            Map.entry("user-agent", "Amazon CloudFront")
    );
    private ScenarioBuilder scn = scenario("machine")
            .exec(
                    http("captcha")
                            .get("/ecommerce-widgets-request-mngr/V1/Utilities/secure/captcha")
                            .headers(captcha)
                            .body(StringBody(captchaPayload))
            );

    public ApiCaptcha() throws IOException {
        setUp(
                scn.injectOpen(
                        nothingFor(5),
                        rampUsers(20).during(15)
                ).protocols(httpProtocol)
        );
    }
}
