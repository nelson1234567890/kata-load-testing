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
    private String accessToken =
            "eyJhbGciOiJSUzI1NiJ9.eyJpZGVudGl0eVR5cGUiOiAiQyIsICJpZGVudGl0eU51bWJlciI6IjEwMDAxMTcyMTciLCAiZGF0ZWluaXRpYWwiOiIyMDI1LTAxLTEwIDE3OjUwOjI0In0.SkBLYQhzTTg2AErRie1D8t6C3f2lEp0NCGB54I6W9qKyE5eu8ZRqr5DvCfSpdpbYNKUeW5FWhMkGWSemmYQmMY6CsmMXMXrL-x9fMgoCD7s6RAfLkTKcjrXPugLmvTKZL30Hbs20wjuhgrKcURfyAelTZLRw4iW4fw4B7yIjJW4";

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

    private ScenarioBuilder scn = scenario("Customer Manager")
            .exec(
                    http("getCustomer")
                            .get("/ecommerce-customer-mngr/V1/Utilities/customer")
                            .headers(customer)

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
                                            "dispatcher": "eyJjZWxsUGhvbmUiOm51bGwsImVtYWlsIjpudWxsLCJpZGVudGl0eU51bWJlciI6IjEwMjAzMDQwNTAiLCJhY2Nlc3NUb2tlbiI6ImV5SmhiR2NpT2lKU1V6STFOaUo5LmV5SnBaR1Z1ZEdsMGVWUjVjR1VpT2lBaVF5SXNJQ0pwWkdWdWRHbDBlVTUxYldKbGNpSTZJakV3TWpBek1EUXdOVEFpTENBaVpHRjBaV2x1YVhScFlXd2lPaUl5TURJMExURXdMVEE0SURFME9qUTFPakU1SW4wLmR4SjVXdVJuMzl5eWF5UW52ZjlZTjJWVEhUSFFWTE9aUVRqLUlsTmRXYmxGTG5SdVFDdVFlbG5yNGlQTWktYzhWdXFGUkMxMFR0RXQ4Wm5wU2MwUmF4Tk1ETVpXT1p4aVRnVlZtbktEeUEwTmYyOF8teVZGVjBneUdLWGFIOU8xbkV0ZVg5NmZBQnk4VzVHSURlOXByWm1STU5YZG5DNG9RUjFYRmdDOExuWSIsImtleUF1dGhlbnRpY2F0ZWRDZWxsUGhvbmUiOm51bGwsImFjY2Vzc1R5cGUiOiIzIiwib3B0aW9uQ29kZSI6bnVsbCwib2ZmaWNlQ29kZSI6bnVsbCwiZnJvbUxhdW5jaGVyIjpudWxsLCJyZWFjdGl2YXRpb25BY2NvdW50IjpudWxsLCJhcHBWZXJzaW9uIjpudWxsLCJwcm9kdWN0SWQiOm51bGwsInNwZWNpZmljSW5mb0ZvclByb2R1Y3QiOm51bGwsImN1c3RvbWVyU3RhdGUiOiJBQ1RJVkUiLCJwcml2YXRlSXAiOm51bGwsInV1aWRUaHJlYXQiOm51bGwsIm5ldHdvcmsiOm51bGwsImNoYW5uZWwiOiJXRUIiLCJ1dG1VdWlkIjoiMTk2NDFhYmItNWI2Zi00ZTkxLTg1ODEtM2E0ZGZjMGE2MTdlIiwidXRtSW5mbyI6bnVsbCwiY2VsbHBob25lVXNlZEZvckF1dGhlbnRpY2F0aW9uIjpudWxsLCJvcmlnaW4iOm51bGwsImlkZW50aXR5VHlwZSI6IkMiLCJ1dWlkIjoiMWFjMTQxMDYtYzJhZS00NWY5LWFhZGUtMjk1ZWZkYTE0NDNhIiwicmVleHBlZGl0aW9uRmxhZyI6bnVsbCwic3BlY2lmaWNQcm9kdWN0SW5mb1V1aWQiOiI1NDBlN2YzYi1jMmU2LTQ5ZDgtYjkxMi04Mjk2NGM0YWE4MWQiLCJzcGVjaWZpY1Byb2R1Y3RJbmZvIjp7InJlcXVlc3RJZCI6IjE5NjQxYWJiLTViNmYtNGU5MS04NTgxLTNhNGRmYzBhNjE3ZSIsImlkZW50aWZpY2F0aW9uTnVtYmVyIjoiMTAzMDY3Njk1MCIsIkFwcE5hbWUiOiJCTlBMIiwiSm91cm5leSI6IkNoZWNrb3V0IiwiT3JpZ2luIjoiaHR0cHM6Ly93cC1hZS1zdGcubGFiZGlnaXRhbGJkYnN0YWdpbmcuY28vY29tcHJhL29yZGVyLXJlY2VpdmVkLzIxNTYvP2tleT13Y19vcmRlcl96ZjBPU3VtTHEwd0pWIiwicmVkaXJlY3RFcnJvclVybCI6Imh0dHBzOi8vd3AtYWUtc3RnLmxhYmRpZ2l0YWxiZGJzdGFnaW5nLmNvL2NvbXByYS9vcmRlci1yZWNlaXZlZC8yMTU2Lz9rZXk9d2Nfb3JkZXJfemYwT1N1bUxxMHdKViIsInJldXNlIjpmYWxzZSwiYXZhaWxDcmVkaXQiOiIxMDAwMDAwLjAwIiwicGF5bWVudFJlZmVyZW5jZSI6IjIxNTYiLCJjdXN0b21lclR5cGUiOiJJU19DTElFTlQiLCJ1c2VySm91cm5leSI6Ik9yaWdpbmF0aW9uIiwiZW1haWwiOiJucm9qYTEzQGJhbmNvZGVib2dvdGEuY29tLmNvIiwidGltZXN0YW1wIjoxNzI4NDE2NDkyNDY5LCJyZWRpcmVjdEFsbGllZCI6Imh0dHBzOi8vd3AtYWUtc3RnLmxhYmRpZ2l0YWxiZGJzdGFnaW5nLmNvL2NvbXByYS9vcmRlci1yZWNlaXZlZC8yMTU2Lz9rZXk9d2Nfb3JkZXJfemYwT1N1bUxxMHdKViIsImlzUHJveHkiOiJmYWxzZSIsImdlbmRlciI6Ik0iLCJuaXQiOiI5MDAzNjY3ODgwIiwicG9saWNpZXMiOnsibWF4QW1vdW50IjoyMDAwMDAwLCJmZWVzIjo0LCJlbmdpbmVWZXJzaW9uIjoiVjMiLCJjYW5DaGFuZ2VDdXN0b21lckRhdGEiOnRydWV9LCJjZWxscGhvbmVOdW1iZXIiOiIzMDEyNTMyNDY4In0sImhhc2hCaW9tZXRyaWMiOiIiLCJhcGlDaXR5IjoiQXNoYnVybiIsIm9saW1waWFNZXRob2QiOmZhbHNlLCJicmFuY2giOjAsImF1dGhVdWlkIjpudWxsLCJzaXRlIjpudWxsLCJ3YXN0ZUluZm8iOm51bGwsImZpcnN0QXV0aEF0dGVtcHQiOmZhbHNlLCJwZXJzb25hbEluZm8iOnsiYXBwbGljYXRpb25JZCI6bnVsbCwiaWRlbnRpdHlUeXBlIjoiQ0MiLCJpZGVudGl0eU51bWJlciI6IjEwMjAzMDQwNTAiLCJsaXN0RW1haWxzIjpbIm5lbHNvbnJvamFzNjY2QHlhaG9vLmNvbSIsIm5yb2phMTNAYmFuY29kZWJvZ290YS5jb20uY28iLCJuZWxzb25mZXJuYW5kb3JvamFzQGdtYWlsLmNvbS5jbyIsIm5lbHNvbmZlcm5hbmRvcm9qYXM2QGhvdG1haWwuY29tIiwibmVsc29uZmVybmFuZG9yb2phc0BpY2xvdWQuY29tIl0sImZpcnN0TmFtZSI6IkFudG9uaWEiLCJzZWNvbmROYW1lIjoiU29maWEiLCJmaXJzdExhc3ROYW1lIjoiUm9qYXMiLCJzZWNvbmRMYXN0TmFtZSI6IkEiLCJnZW5kZXIiOiJNVUpFUiIsImlkZW50aXR5RXhwZWRpdGlvbkRhdGUiOiIwOC8wNy8xOTk3In0sImF1dGhNZXRob2QiOm51bGwsImZsb3ciOiJPcmlnaW5hdGlvbiIsInJlcXVlc3RJZCI6IjE5NjQxYWJiLTViNmYtNGU5MS04NTgxLTNhNGRmYzBhNjE3ZSJ9",
                                            "idPlaceOfIssuance": "17013000"
                                        }
                                    """))
            )
            .pause(1);

    public ApiCustomer() throws IOException {
        setUp(
                scn.injectOpen(
                        nothingFor(5),
                        rampUsers(20).during(15)
                        //atOnceUsers(100)
                ).protocols(httpProtocol)
        );
    }
}
