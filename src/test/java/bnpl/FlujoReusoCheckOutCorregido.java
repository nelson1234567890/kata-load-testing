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
    private String channel = "X-channel";
    private String cusIdenNum = "X-CustIdentNum";


    private HttpProtocolBuilder httpProtocol = http
            .baseUrl("https://api-bnpl.labdigbdbstgae.com");
    private Map<CharSequence, String> allied = Map.ofEntries(
            Map.entry(content, aplication),
            Map.entry(request, requestVal),
            Map.entry(ipAddres, ipAddresVal),
            Map.entry("X-salePoint", "Kiosco de Financiacion"),
            Map.entry("X-sellerId", "21"),
            Map.entry("X-isProxy", "false"),
            Map.entry(channel, "Web")
    );
    private Map<CharSequence, String> token = Map.ofEntries(
            Map.entry(content, aplication),
            Map.entry(ipAddres, ipAddresVal),
            Map.entry(request, requestVal),
            Map.entry(custID, "123454667"),
            Map.entry(custIDType, "CC")
    );


    private Map<CharSequence, String> products = Map.ofEntries(
            Map.entry(content, aplication),
            Map.entry(request, requestVal),
            Map.entry(ipAddres, ipAddresVal),
            Map.entry(custIDType, "CC"),
            Map.entry(cusIdenNum, "123454667"),
            Map.entry(channel, "Web")
    );

    private Map<CharSequence, String> closeDigReq = Map.ofEntries(
            Map.entry(content, aplication),
            Map.entry(ipAddres, ipAddresVal),
            Map.entry(custIDType, "CC"),
            Map.entry(cusIdenNum, "1000117217"),
            Map.entry("X-IsClient", "NO_CLIENT"),
            Map.entry(request, requestVal),
            Map.entry("X-digRequestId", "111")
    );

    private Map<CharSequence, String> transaction = Map.ofEntries(
            Map.entry(content, aplication),
            Map.entry(request, requestVal),
            Map.entry(ipAddres, ipAddresVal),
            Map.entry("X-strcode", "8bf94cbf7fda418cad9c6f0d2b4a39b5"),
            Map.entry(custIDType, "CC"),
            Map.entry(cusIdenNum, "1000117217"),
            Map.entry(channel, "Web"),
            Map.entry("x-auth-token", "4e4f32c2-82be-405a-8213-695789068667")
    );


    private ScenarioBuilder scn = scenario("Request mngr")
            .exec(
                    http("getAllied")
                            .post("/ecommerce-widgets-request-mngr/V1/Utilities/allied")
                            .headers(allied)
                            .body(StringBody("""
                                    {
                                        "agreementCode": null,
                                        "allyCode": null,
                                        "category": {
                                            "Code": "8299",
                                            "Description": "Servicios Educativos"
                                        },
                                        "creationDate": "2023-11-08T21:41:11.986Z",
                                        "domains": [
                                            "https://www.homecenter.com.co",
                                            "https://wp-ae-stg.labdigitalbdbstaging.co"
                                        ],
                                        "email": "sbogota@homecenter.co",
                                        "id": "663e98ef-12ac-486c-b8c4-7c46b5c841ba",
                                        "license": {
                                            "ExpiredToken": "2024-09-05T12:00:00.000Z",
                                            "Licence": "ACTIVATED",
                                            "Token": "01197ccf-a19d-47d6-a823-2d2423f88140"
                                        },
                                        "modificationDate": "2024-01-15T21:21:55.301Z",
                                        "name": "SODIMAC COLOMBIA S.A.",
                                        "nit": "8002421062",
                                        "phone": "3102417905",
                                        "salePoints": [
                                            {
                                                "Account": {
                                                    "Number": "49274880",
                                                    "Type": "Current"
                                                },
                                                "Code": "20451407",
                                                "Address": "CRA 68D 80 70",
                                                "Email": "Abonosclientes@homecenter.co",
                                                "Enable": true,
                                                "Name": "Kiosco de Financiacion",
                                                "Phone": "3208899933",
                                                "Type": "Web"
                                            }
                                        ],
                                        "settings": {
                                            "Journey": "Checkout",
                                            "Landing": "https://www.homecenter.com.co",
                                            "Shortname": "HOMECENTER",
                                            "UrlResponse": "https://www.homecenter.com.co"
                                        },
                                        "shortName": "HOMECENTER",
                                        "policies": {
                                            "maxAmount": 2000000,
                                            "fees": 4,
                                            "engineVersion": "v1"
                                        }
                                    }
                                    """))
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
                    http("digitalRequest/close")
                            .post("/ecommerce-widgets-request-mngr/V1/Utilities/digital-request/close")
                            .headers(closeDigReq))

            .pause(1)
            .exec(
                    http("transaction")
                            .post("/ecommerce-widgets-request-mngr/V1/Utilities/transaction")
                            .headers(transaction)
                            .body(StringBody("""
                                    {
                                        "PaymentReference":"12344",
                                        "Product": {
                                            "AmountRequested": "100000",
                                            "UrlAllied": "https://wp-ae-stg.labdigitalbdbstaging.co/compra/",
                                            "Description": "qweqweqwe",
                                            "PaymentIva": "10"
                                        },
                                        "Description" : "producto"
                                    }
                                    """))
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
