var stats = {
    type: "GROUP",
name: "All Requests",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "All Requests",
    "numberOfRequests": {
        "total": "20",
        "ok": "20",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "4474",
        "ok": "4474",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "50945",
        "ok": "50945",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "34215",
        "ok": "34215",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "14893",
        "ok": "14893",
        "ko": "-"
    },
    "percentiles1": {
        "total": "37256",
        "ok": "37256",
        "ko": "-"
    },
    "percentiles2": {
        "total": "47387",
        "ok": "47387",
        "ko": "-"
    },
    "percentiles3": {
        "total": "49262",
        "ok": "49262",
        "ko": "-"
    },
    "percentiles4": {
        "total": "50608",
        "ok": "50608",
        "ko": "-"
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
    "count": 20,
    "percentage": 100
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.339",
        "ok": "0.339",
        "ko": "-"
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
        "total": "20",
        "ok": "20",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "4474",
        "ok": "4474",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "50945",
        "ok": "50945",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "34215",
        "ok": "34215",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "14893",
        "ok": "14893",
        "ko": "-"
    },
    "percentiles1": {
        "total": "37256",
        "ok": "37256",
        "ko": "-"
    },
    "percentiles2": {
        "total": "47387",
        "ok": "47387",
        "ko": "-"
    },
    "percentiles3": {
        "total": "49262",
        "ok": "49262",
        "ko": "-"
    },
    "percentiles4": {
        "total": "50608",
        "ok": "50608",
        "ko": "-"
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
    "count": 20,
    "percentage": 100
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.339",
        "ok": "0.339",
        "ko": "-"
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
