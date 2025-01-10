var stats = {
    type: "GROUP",
name: "All Requests",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "All Requests",
    "numberOfRequests": {
        "total": "20",
        "ok": "0",
        "ko": "20"
    },
    "minResponseTime": {
        "total": "351",
        "ok": "-",
        "ko": "351"
    },
    "maxResponseTime": {
        "total": "1638",
        "ok": "-",
        "ko": "1638"
    },
    "meanResponseTime": {
        "total": "640",
        "ok": "-",
        "ko": "640"
    },
    "standardDeviation": {
        "total": "348",
        "ok": "-",
        "ko": "348"
    },
    "percentiles1": {
        "total": "522",
        "ok": "-",
        "ko": "522"
    },
    "percentiles2": {
        "total": "598",
        "ok": "-",
        "ko": "598"
    },
    "percentiles3": {
        "total": "1391",
        "ok": "-",
        "ko": "1391"
    },
    "percentiles4": {
        "total": "1589",
        "ok": "-",
        "ko": "1589"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "t ≥ 800 ms <br> t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t ≥ 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 20,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "1.25",
        "ok": "-",
        "ko": "1.25"
    }
},
contents: {
"req_getcustomer-b7ac9": {
        type: "REQUEST",
        name: "getCustomer",
path: "getCustomer",
pathFormatted: "req_getcustomer-b7ac9",
stats: {
    "name": "getCustomer",
    "numberOfRequests": {
        "total": "20",
        "ok": "0",
        "ko": "20"
    },
    "minResponseTime": {
        "total": "351",
        "ok": "-",
        "ko": "351"
    },
    "maxResponseTime": {
        "total": "1638",
        "ok": "-",
        "ko": "1638"
    },
    "meanResponseTime": {
        "total": "640",
        "ok": "-",
        "ko": "640"
    },
    "standardDeviation": {
        "total": "348",
        "ok": "-",
        "ko": "348"
    },
    "percentiles1": {
        "total": "522",
        "ok": "-",
        "ko": "522"
    },
    "percentiles2": {
        "total": "598",
        "ok": "-",
        "ko": "598"
    },
    "percentiles3": {
        "total": "1391",
        "ok": "-",
        "ko": "1391"
    },
    "percentiles4": {
        "total": "1589",
        "ok": "-",
        "ko": "1589"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "t ≥ 800 ms <br> t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t ≥ 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 20,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "1.25",
        "ok": "-",
        "ko": "1.25"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
