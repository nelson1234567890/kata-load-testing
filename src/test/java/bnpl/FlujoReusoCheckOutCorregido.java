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


public class FlujoReusoCheckOutCorregido extends Simulation {


    private String content = "Content-Type";
    private String aplication = "application/json";
    private String request = "X-RqUID";
    private String requestVal = "3e4f32c2-82be-405a-8213-695789068032";
    private String ipAddres = "X-IPAddr";
    private String ipAddresVal = "127.0.0.1";
    private String custID = "X-IdentSerialNum";
    private String custIDType = "X-CustIdentType";


    private HttpProtocolBuilder httpProtocol = http
            .baseUrl("https://api-bnpl.labdigbdbstgae.com");
    private Map<CharSequence, String> allied = Map.ofEntries(
            Map.entry(content, aplication),
            Map.entry(request, requestVal),
            Map.entry("X-alliedToken", "02ab6ea5-54b5-4bcb-b145-fcd442148f57"),
            Map.entry(ipAddres, ipAddresVal),
            Map.entry("X-IdentType", "CC"),
            Map.entry("X-amount", "2000000"),
            Map.entry("X-salepoint", "Punto de venta Bogota"),
            Map.entry("X-sellerId", "21"),
            Map.entry("X-channel", "Web")
    );
    private Map<CharSequence, String> token = Map.ofEntries(
            Map.entry(content, aplication),
            Map.entry(ipAddres, ipAddresVal),
            Map.entry(request, requestVal),
            Map.entry(custID, "123454667"),
            Map.entry(custIDType, "CC")
    );


    private Map<CharSequence, String> bankfees = Map.ofEntries(
            Map.entry(content, aplication),
            Map.entry(ipAddres, ipAddresVal),
            Map.entry(custID, "123454668")
    );

    private Map<CharSequence, String> products = Map.ofEntries(
            Map.entry(content, aplication),
            Map.entry(request, requestVal),
            Map.entry(ipAddres, ipAddresVal),
            Map.entry(custIDType, "CC"),
            Map.entry("X-CustIdentNum", "123454667"),
            Map.entry("X-channel", "Web")
    );


    private Map<CharSequence, String> bankfeeswithcreditcardamount = Map.ofEntries(
            Map.entry(content, aplication),
            Map.entry(ipAddres, ipAddresVal),
            Map.entry(request, requestVal),
            Map.entry(custID, "1000117219"),
            Map.entry("X-Journey", "Checkout")
    );
    private Map<CharSequence, String> closeDigReq = Map.ofEntries(
            Map.entry(content, aplication),
            Map.entry(ipAddres, ipAddresVal),
            Map.entry(custIDType, "CC"),
            Map.entry("X-CustIdentNum", "1000117217"),
            Map.entry("X-IsClient", "NO_CLIENT"),
            Map.entry(request, requestVal),
            Map.entry("X-digRequestId", "111")
    );


    private ScenarioBuilder scn = scenario("Request mngr")
            .exec(
                    http("getAllied")
                            .get("/ecommerce-widgets-request-mngr/V1/Utilities/allied")
                            .headers(allied)
            )
            .pause(1)
            .exec(
                    http("products")
                            .get("/ecommerce-widgets-request-mngr/V1/Utilities/products")
                            .headers(products))
            .pause(1)
            .exec(
                    http("token")
                            .post("/ecommerce-widgets-request-mngr/V1/Utilities/token")
                            .headers(token)
                            .body(StringBody("""
                                    {
                                        "token": "2ada66ea-622c-40f0-a748-f8744b4f8160"
                                    }
                                    """)))


            .pause(1)
            .exec(
                    http("bankfeeswithcreditcardamount")
                            .post("/ecommerce-widgets-request-mngr/V1/Utilities/bankfeeswithcreditcardamount")
                            .headers(bankfeeswithcreditcardamount)
                            .body(StringBody("""
                                    {
                                        "PriceItem": 200000,
                                        "AmountFees": 10
                                    }
                                    """))
            )
            .pause(1)
            .exec(
                    http("bankfees")
                            .post("/ecommerce-widgets-request-mngr/V1/Utilities/bankfees")
                            .headers(bankfees)
                            .body(StringBody("""
                                    {
                                        "PriceItem": 100000
                                    }
                                    """))
            )
            .pause(1)

            .exec(
                    http("digitalRequest/close")
                            .post("/ecommerce-widgets-request-mngr/V1/Utilities/digital-request/close")
                            .headers(closeDigReq)
            );


    public FlujoReusoCheckOutCorregido() throws IOException {
        setUp(
                scn.injectOpen(
                        nothingFor(5),
                        rampUsers(20).during(15)
                ).protocols(httpProtocol)
        );
    }


}

