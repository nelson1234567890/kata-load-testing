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
        "total": "32",
        "ok": "-",
        "ko": "32"
    },
    "maxResponseTime": {
        "total": "187",
        "ok": "-",
        "ko": "187"
    },
    "meanResponseTime": {
        "total": "90",
        "ok": "-",
        "ko": "90"
    },
    "standardDeviation": {
        "total": "40",
        "ok": "-",
        "ko": "40"
    },
    "percentiles1": {
        "total": "93",
        "ok": "-",
        "ko": "93"
    },
    "percentiles2": {
        "total": "99",
        "ok": "-",
        "ko": "99"
    },
    "percentiles3": {
        "total": "165",
        "ok": "-",
        "ko": "165"
    },
    "percentiles4": {
        "total": "183",
        "ok": "-",
        "ko": "183"
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
        "total": "1.333",
        "ok": "-",
        "ko": "1.333"
    }
},
contents: {
"req_captcha-70b29": {
        type: "REQUEST",
        name: "captcha",
path: "captcha",
pathFormatted: "req_captcha-70b29",
stats: {
    "name": "captcha",
    "numberOfRequests": {
        "total": "20",
        "ok": "0",
        "ko": "20"
    },
    "minResponseTime": {
        "total": "32",
        "ok": "-",
        "ko": "32"
    },
    "maxResponseTime": {
        "total": "187",
        "ok": "-",
        "ko": "187"
    },
    "meanResponseTime": {
        "total": "90",
        "ok": "-",
        "ko": "90"
    },
    "standardDeviation": {
        "total": "40",
        "ok": "-",
        "ko": "40"
    },
    "percentiles1": {
        "total": "93",
        "ok": "-",
        "ko": "93"
    },
    "percentiles2": {
        "total": "99",
        "ok": "-",
        "ko": "99"
    },
    "percentiles3": {
        "total": "165",
        "ok": "-",
        "ko": "165"
    },
    "percentiles4": {
        "total": "183",
        "ok": "-",
        "ko": "183"
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
        "total": "1.333",
        "ok": "-",
        "ko": "1.333"
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
