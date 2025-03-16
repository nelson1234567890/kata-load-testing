package testApisLoad;

import com.feeder.JsonUtils;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import java.io.IOException;
import java.util.Map;

import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.core.CoreDsl.constantUsersPerSec;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.core.CoreDsl.StringBody;
import static io.gatling.javaapi.http.HttpDsl.status;

public class OpenModel extends Simulation {


    private String content = "Content-Type";
    private String aplication = "application/json";

    private HttpProtocolBuilder httpProtocol = http
            .baseUrl("https://fakestoreapi.com");

    private Map<CharSequence, String> headersProduct = Map.ofEntries(
            Map.entry(content, aplication)
    );

    String bodyPostProduct = JsonUtils.readJsonFile("src/test/resources/data/postProduct.json");
    String bodyPutProduct = JsonUtils.readJsonFile("src/test/resources/data/putProduct.json");
    private ScenarioBuilder scn = scenario("ProductOpenModel")
            .exec(
                    http("getProduct")
                            .get("/products/1")
                            .headers(headersProduct)
                            .check(status().is(200))
            )
            .pause(1)
            .exec(
                    http("postProduct")
                            .post("/products")
                            .headers(headersProduct)
                            .body(StringBody(bodyPostProduct))
                            .check(status().is(200))
            )
            .pause(1)
            .exec(
                    http("putProduct")
                            .put("/products/4")
                            .headers(headersProduct)
                            .body(StringBody(bodyPutProduct))
                            .check(status().is(200))
            )
            .pause(1)
            .exec(
                    http("deleteProduct")
                            .delete("/products/3")
                            .check(status().is(200))
            )
            ;

    public OpenModel() throws IOException {
        setUp(
                scn.injectOpen(
                        constantUsersPerSec(3).during(30)
                ).protocols(httpProtocol)
        );
    }
}
