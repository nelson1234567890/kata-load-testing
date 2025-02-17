package bnpl;

import com.utilidades.CofigFile;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import java.io.IOException;
import java.util.Map;

import static io.gatling.javaapi.core.CoreDsl.StringBody;
import static io.gatling.javaapi.core.CoreDsl.nothingFor;
import static io.gatling.javaapi.core.CoreDsl.rampUsers;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class ApiCustomer extends Simulation {


    private String content = "Content-Type";
    private String application = "application/json";
    private String channel = "X-channel";
    private String identNum = "X-CustIdentNum";
    private String custID = "1000117217";
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
    private CofigFile env = new CofigFile();
    private String accessToken = env.getProperty("accessToken");

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

    private Map<CharSequence, String> extradata = Map.ofEntries(
            Map.entry(content, application),
            Map.entry(request, requestVal),
            Map.entry(custIdentType, "CC"),
            Map.entry(xName, xNameValue),
            Map.entry(channel, "Web"),
            Map.entry(identNum, custID),
            Map.entry(ipAddres, ipAddresVal),
            Map.entry(xAccesToken, accessToken)
    );

    private Map<CharSequence, String> paymentPlan = Map.ofEntries(
            Map.entry(xAccesToken, accessToken),
            Map.entry(custIdentType, "CC"),
            Map.entry(identNum, custID),
            Map.entry(request, requestVal),
            Map.entry(content, application)
    );

    private Map<CharSequence, String> crmSafeData = Map.ofEntries(
            Map.entry(content, application),
            Map.entry(custIdentType, "CC"),
            Map.entry(identNum, custID),
            Map.entry(ipAddres, ipAddresVal),
            Map.entry(request, requestVal),
            Map.entry(xAccesToken, accessToken)
    );

    private ScenarioBuilder scn = scenario("Customer Manager")
            .exec(
                    http("getCustomer")
                            .get("/ecommerce-customer-mngr/V1/Utilities/customer")
                            .headers(customer)
                            .check(status().is(200))

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
                            .check(status().is(204))
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
                            .check(status().is(200))
            )
            .pause(1)
            .exec(
                    http("extraData")
                            .post("/ecommerce-customer-mngr/V1/Utilities/customer/extra-data")
                            .headers(extradata)
                            .body(StringBody("""
                                        {
                                            "address": {
                                                "city": "MEDELLIN - ANTIOQUIA",
                                                "address": "AG",
                                                "complement1": "13",
                                                "address2": "2",
                                                "complement2": "5",
                                                "neighbourhood": "OLARTE",
                                                "cityId": "05001",
                                                "stateProv": "05",
                                                "postalCode": "05001000"
                                            },
                                            "fullAddress": "AGRUPACION 13 # 2 - 5 - MEDELLIN - ANTIOQUIA - Colombia",
                                            "officeCode": "0452",
                                            "dateOfIssue": "1997/07/08",
                                            "placeOfIssuance": "AGUADAS - CALDAS",
                                            "dispatcher": "eyJjZWxsUGhvbmUiOm51bGwsImVtYWlsIjpudWxsLCJpZGVudGl0eU",
                                            "idPlaceOfIssuance": "17013000"
                                        }
                                    """))
                            .check(status().is(204))
            )
            .pause(1)
            .exec(
                    http("paymentPlan")
                            .post("/ecommerce-widgets-request-mngr/V1/Utilities/paymentplan")
                            .headers(paymentPlan)
                            .body(StringBody("""
                                        {
                                            "amountRequested": 150000,
                                            "period": "BEGINNING_OF_MONTH",
                                            "amountApproved": 2000000,
                                            "bankFees": 4
                                        }
                                    """))
                            .check(status().is(200))
            )
            .pause(1)
            .exec(
                    http("crmSafeData")
                            .get("/ecommerce-customer-mngr/V1/Utilities/crm/safe-data")
                            .headers(crmSafeData)
                            .check(status().is(200))
            )
            .pause(1);

    public ApiCustomer() throws IOException {
        setUp(
                scn.injectOpen(
                        nothingFor(2),
                        rampUsers(5).during(60)
                ).protocols(httpProtocol)
        );
    }
}
