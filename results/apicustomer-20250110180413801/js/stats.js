var stats = {
    type: "GROUP",
name: "All Requests",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "All Requests",
    "numberOfRequests": {
        "total": "2",
        "ok": "0",
        "ko": "2"
    },
    "minResponseTime": {
        "total": "4803",
        "ok": "-",
        "ko": "4803"
    },
    "maxResponseTime": {
        "total": "5824",
        "ok": "-",
        "ko": "5824"
    },
    "meanResponseTime": {
        "total": "5314",
        "ok": "-",
        "ko": "5314"
    },
    "standardDeviation": {
        "total": "511",
        "ok": "-",
        "ko": "511"
    },
    "percentiles1": {
        "total": "5314",
        "ok": "-",
        "ko": "5314"
    },
    "percentiles2": {
        "total": "5569",
        "ok": "-",
        "ko": "5569"
    },
    "percentiles3": {
        "total": "5773",
        "ok": "-",
        "ko": "5773"
    },
    "percentiles4": {
        "total": "5814",
        "ok": "-",
        "ko": "5814"
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
    "count": 2,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.286",
        "ok": "-",
        "ko": "0.286"
    }
},
contents: {
"req_customer-91ec1": {
        type: "REQUEST",
        name: "customer",
path: "customer",
pathFormatted: "req_customer-91ec1",
stats: {
    "name": "customer",
    "numberOfRequests": {
        "total": "2",
        "ok": "0",
        "ko": "2"
    },
    "minResponseTime": {
        "total": "4803",
        "ok": "-",
        "ko": "4803"
    },
    "maxResponseTime": {
        "total": "5824",
        "ok": "-",
        "ko": "5824"
    },
    "meanResponseTime": {
        "total": "5314",
        "ok": "-",
        "ko": "5314"
    },
    "standardDeviation": {
        "total": "511",
        "ok": "-",
        "ko": "511"
    },
    "percentiles1": {
        "total": "5314",
        "ok": "-",
        "ko": "5314"
    },
    "percentiles2": {
        "total": "5569",
        "ok": "-",
        "ko": "5569"
    },
    "percentiles3": {
        "total": "5773",
        "ok": "-",
        "ko": "5773"
    },
    "percentiles4": {
        "total": "5814",
        "ok": "-",
        "ko": "5814"
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
    "count": 2,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.286",
        "ok": "-",
        "ko": "0.286"
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
