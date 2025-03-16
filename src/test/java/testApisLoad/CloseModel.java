package testApisLoad;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import java.io.IOException;
import java.util.Map;

import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.core.CoreDsl.constantConcurrentUsers;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.core.CoreDsl.StringBody;
import static io.gatling.javaapi.http.HttpDsl.status;
import com.feeder.JsonUtils;

public class CloseModel extends Simulation {


    private String content = "Content-Type";
    private String aplication = "application/json";

    private HttpProtocolBuilder httpProtocol = http
            .baseUrl("https://fakestoreapi.com");

    private Map<CharSequence, String> headersUser = Map.ofEntries(
            Map.entry(content, aplication)
    );

    String bodyPostUser = JsonUtils.readJsonFile("src/test/resources/data/postUser.json");
    String bodyPutUser = JsonUtils.readJsonFile("src/test/resources/data/putUser.json");

    private ScenarioBuilder scn = scenario("userCloseModel")
            .exec(
                    http("getUser")
                            .get("/users")
                            .headers(headersUser)
                            .check(status().is(200))
            )
            .pause(1)
            .exec(
                    http("postUser")
                            .post("/users")
                            .headers(headersUser)
                            .body(StringBody(bodyPostUser))
                            .check(status().is(200))
            )
            .pause(1)
            .exec(
                    http("putUser")
                            .put("/users/4")
                            .headers(headersUser)
                            .body(StringBody(bodyPutUser))
                            .check(status().is(200))
            )
            .pause(1)
            .exec(
                    http("deleteUsers")
                            .delete("/users/3")
                            .check(status().is(200))
            )
            ;

    public CloseModel() throws IOException {
        setUp(
                scn.injectClosed(
                        constantConcurrentUsers(2).during(10)
                ).protocols(httpProtocol)
        );
    }
}
