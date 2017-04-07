
//Flot Pie Chart
$(function() {

    var data = [{
        label: "冷却塔",
        data: 21,
        color: "#d3d3d3",
    }, {
        label: "冷却泵",
        data: 3,
        color: "#bababa",
    }, {
        label: "风机盘管",
        data: 15,
        color: "#79d2c0",
    }, {
        label: "空气处理机",
        data: 22,
        color: "#1ab394",
    },{
        label: "中央空调主机",
            data: 30,
            color: "green",
    }];

    var plotObj = $.plot($("#flot-pie-chart"), data, {
        series: {
            pie: {
                show: true
            }
        },
        grid: {
            hoverable: true
        },
        tooltip: true,
        tooltipOpts: {
            content: "%p.0%, %s", // show percentages, rounding to 2 decimal places
            shifts: {
                x: 20,
                y: 0
            },
            defaultTheme: false
        }
    });
});


$(function() {
    var barOptions = {
        series: {
            lines: {
                show: true,
                lineWidth: 2,
                fill: true,
                fillColor: {
                    colors: [{
                        opacity: 0.0
                    }, {
                        opacity: 0.0
                    }]
                }
            }
        },
        xaxis: {
            tickDecimals: 0
        },
        colors: ["#1ab394","#000000","red","green"],
        grid: {
            color: "#999999",
            hoverable: true,
            clickable: true,
            tickColor: "#D4D4D4",
            borderWidth:0
        },
        legend: {
            show: false
        },
        tooltip: true,
        tooltipOpts: {
            content: "x: %x, y: %y"
        }
    };
    var barData = {
        label: "bar",
        data: [
            [1, 34],
            [2, 25],
            [3, 19],
            [4, 34],
            [5, 32],
            [6, 44]
        ]
    };
    var barData1 = {
        label: "bar1",
        data: [
            [1, 43],
            [2, 22],
            [3, 11],
            [4, 34],
            [5, 33],
            [6, 48]
        ]
    };
    var barData2 = {
        label: "bar1",
        data: [
            [1, 23],
            [2, 32],
            [3, 41],
            [4, 33],
            [5, 31],
            [6, 45]
        ]
    };
    var barData3 = {
        label: "bar1",
        data: [
            [1, 33],
            [2, 15],
            [3, 41],
            [4, 30],
            [5, 25],
            [6, 40]
        ]
    };
    $.plot($("#flot-line-chart"), [barData,barData1,barData2,barData3], barOptions);
});

