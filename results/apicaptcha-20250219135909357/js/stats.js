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
        "total": "28",
        "ok": "-",
        "ko": "28"
    },
    "maxResponseTime": {
        "total": "202",
        "ok": "-",
        "ko": "202"
    },
    "meanResponseTime": {
        "total": "78",
        "ok": "-",
        "ko": "78"
    },
    "standardDeviation": {
        "total": "44",
        "ok": "-",
        "ko": "44"
    },
    "percentiles1": {
        "total": "82",
        "ok": "-",
        "ko": "82"
    },
    "percentiles2": {
        "total": "93",
        "ok": "-",
        "ko": "93"
    },
    "percentiles3": {
        "total": "154",
        "ok": "-",
        "ko": "154"
    },
    "percentiles4": {
        "total": "192",
        "ok": "-",
        "ko": "192"
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
        "total": "28",
        "ok": "-",
        "ko": "28"
    },
    "maxResponseTime": {
        "total": "202",
        "ok": "-",
        "ko": "202"
    },
    "meanResponseTime": {
        "total": "78",
        "ok": "-",
        "ko": "78"
    },
    "standardDeviation": {
        "total": "44",
        "ok": "-",
        "ko": "44"
    },
    "percentiles1": {
        "total": "82",
        "ok": "-",
        "ko": "82"
    },
    "percentiles2": {
        "total": "93",
        "ok": "-",
        "ko": "93"
    },
    "percentiles3": {
        "total": "154",
        "ok": "-",
        "ko": "154"
    },
    "percentiles4": {
        "total": "192",
        "ok": "-",
        "ko": "192"
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
