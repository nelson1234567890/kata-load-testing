package bnpl;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;
import com.utilidades.CofigFile;


import java.io.IOException;
import java.util.Map;

import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.core.CoreDsl.nothingFor;
import static io.gatling.javaapi.core.CoreDsl.rampUsers;
import static io.gatling.javaapi.http.HttpDsl.http;

public class ApiMachine extends Simulation {


    private String content = "Content-Type";
    private String aplication = "application/json";
    private CofigFile env = new CofigFile();
    private String xCustomHeaderAe = env.getProperty("x-custom-header-ae");

    private HttpProtocolBuilder httpProtocol = http
            .baseUrl("https://api.labdigbdbstgae.com");

    private Map<CharSequence, String> machine = Map.ofEntries(
            Map.entry(content, aplication),
            Map.entry("x-custom-header-ae", xCustomHeaderAe),
            Map.entry("x-origin-cloudfront", "labdigbdbstgae.com"),
            Map.entry("user-agent", "Amazon CloudFront"),
            Map.entry("host", "api.labdigbdbstgae.com")
    );
    private ScenarioBuilder scn = scenario("machine")
            .exec(
                    http("machine")
                            .get("/validate-machine/V1/Utilities/machine")
                            .headers(machine)
            );

    public ApiMachine() throws IOException {
        setUp(
                scn.injectOpen(
                        nothingFor(5),
                        rampUsers(20).during(15)
                ).protocols(httpProtocol)
        );
    }
}
