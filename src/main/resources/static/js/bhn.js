function nsearchtable() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("ninputsearch");
  filter = input.value.toUpperCase();

  tbody = document.getElementsByTagName("tbody")[0];
  tr = tbody.getElementsByTagName("tr");
  console.log(tr);
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[1];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}
function nsearchproduct() {
  var input, filter, i, txtValue, name;
  input = document.getElementById("ninputsearch");
  filter = input.value.toUpperCase();

  products = document.getElementsByClassName("products");

  console.log(products[0]);
  for (i = 0; i < products.length; i++) {
    name = products[i].getElementsByClassName("nproductname");
    if (name) {
      txtValue = name[0].innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        products[i].style.display = "";
      } else {
        products[i].style.display = "none";
      }
    }
  }
}

var chartNv = Highcharts.chart("ndbtopnv", {
  chart: {
    type: "bar",
    height: "500",
  },
  title: {
    text: "Revenue by Employees",
    align: "left",
  },
  xAxis: {
    categories: [],
    title: {
      text: null,
    },
    gridLineWidth: 1,
    lineWidth: 0,
  },
  yAxis: {
    min: 0,
    title: {
      text: "Revenue",
      align: "high",
    },
    labels: {
      overflow: "justify",
    },
    gridLineWidth: 0,
  },
  tooltip: {
    valueSuffix: " $",
  },
  plotOptions: {
    bar: {
      colorByPoint: true,
      borderRadius: "50%",
      dataLabels: {
        enabled: true,
      },
      groupPadding: 0.1,
    },
    series: {
      dataLabels: {
        enabled: true,
        format: "{point.y:.2f}$",
      },
    },
  },
  legend: {
    layout: "vertical",
    align: "right",
    verticalAlign: "top",
    x: -40,
    y: 80,
    floating: true,
    borderWidth: 1,
    backgroundColor:
      Highcharts.defaultOptions.legend.backgroundColor || "#FFFFFF",
    shadow: true,
  },
  credits: {
    enabled: false,
  },
  series: [
    {
      name: "Revenue",
      data: [],
    },
  ],
});
var chartProduct = Highcharts.chart("ndbproducts", {
  chart: {
    type: "column",
  },
  title: {
    text: "Quantity by Products",
    align: "left",
  },
  xAxis: {
    categories: [],
    title: {
      text: null,
    },
    gridLineWidth: 1,
    lineWidth: 0,
  },
  yAxis: {
    min: 0,
    title: {
      text: "Quantity",
      align: "high",
    },
    labels: {
      overflow: "justify",
    },
    gridLineWidth: 0,
  },
  tooltip: {
    valueSuffix: " ",
  },
  plotOptions: {
    column: {
      colorByPoint: true,
      borderRadius: "50%",
      dataLabels: {
        enabled: true,
      },
      groupPadding: 0.1,
    },
    series: {
      dataLabels: {
        enabled: true,
      },
    },
  },
  legend: {
    layout: "vertical",
    align: "right",
    verticalAlign: "top",
    x: -40,
    y: 80,
    floating: true,
    borderWidth: 1,
    backgroundColor:
      Highcharts.defaultOptions.legend.backgroundColor || "#FFFFFF",
    shadow: true,
  },
  credits: {
    enabled: false,
  },
  series: [
    {
      name: "Quantity",
      data: [],
    },
  ],
});
var chart1 = Highcharts.chart("container1", {
  chart: {
    zoomType: "xy",
  },
  title: {
    text: "",
    align: "left",
  },
  xAxis: [
    {
      categories: null,
      crosshair: true,
    },
  ],
  yAxis: [
    {
      // Primary yAxis
      labels: {
        format: "{value} $",
        style: {
          color: Highcharts.getOptions().colors[1],
        },
      },
      title: {
        text: "Revenue",
        style: {
          color: Highcharts.getOptions().colors[1],
        },
      },
      opposite: true,
    },
    {
      // Secondary yAxis
      gridLineWidth: 0,
      title: {
        text: "Quantity",
        style: {
          color: Highcharts.getOptions().colors[0],
        },
      },
      labels: {
        format: "{value}",
        style: {
          color: Highcharts.getOptions().colors[0],
        },
      },
    },
  ],
  tooltip: {
    shared: true,
  },
  legend: {
    layout: "vertical",
    align: "left",
    x: 80,
    verticalAlign: "top",
    y: 55,
    floating: true,
    backgroundColor:
      Highcharts.defaultOptions.legend.backgroundColor || // theme
      "rgba(255,255,255,0.25)",
  },
  series: [
    {
      name: "Quantity",
      type: "column",
      yAxis: 1,
      data: null,
      tooltip: {
        valueSuffix: "",
      },
    },
    {
      name: "Revenue",
      type: "spline",
      data: null,
      tooltip: {
        valueSuffix: " $",
      },
    },
  ],
  responsive: {
    rules: [
      {
        condition: {
          maxWidth: 500,
        },
        chartOptions: {
          legend: {
            floating: false,
            layout: "horizontal",
            align: "center",
            verticalAlign: "bottom",
            x: 0,
            y: 0,
          },
          yAxis: [
            {
              labels: {
                align: "right",
                x: 0,
                y: -6,
              },
              showLastLabel: false,
            },
            {
              labels: {
                align: "left",
                x: 0,
                y: -6,
              },
              showLastLabel: false,
            },
            {
              visible: false,
            },
          ],
        },
      },
    ],
  },
});
// var chart2 = Highcharts.chart("container2", {
//   chart: {
//     zoomType: "xy",
//   },
//   title: {
//     text: "",
//     align: "left",
//   },
//   xAxis: [
//     {
//       categories: null,
//       crosshair: true,
//     },
//   ],
//   yAxis: [
//     {
//       // Primary yAxis
//       labels: {
//         format: "{value} $",
//         style: {
//           color: Highcharts.getOptions().colors[1],
//         },
//       },
//       title: {
//         text: "Revenue",
//         style: {
//           color: Highcharts.getOptions().colors[1],
//         },
//       },
//       opposite: true,
//     },
//     {
//       // Secondary yAxis
//       gridLineWidth: 0,
//       title: {
//         text: "Quantity",
//         style: {
//           color: Highcharts.getOptions().colors[0],
//         },
//       },
//       labels: {
//         format: "{value}",
//         style: {
//           color: Highcharts.getOptions().colors[0],
//         },
//       },
//     },
//   ],
//   tooltip: {
//     shared: true,
//   },
//   legend: {
//     layout: "vertical",
//     align: "left",
//     x: 80,
//     verticalAlign: "top",
//     y: 55,
//     floating: true,
//     backgroundColor:
//       Highcharts.defaultOptions.legend.backgroundColor || // theme
//       "rgba(255,255,255,0.25)",
//   },
//   series: [
//     {
//       name: "Quantity",
//       type: "column",
//       yAxis: 1,
//       data: null,
//       tooltip: {
//         valueSuffix: "",
//       },
//     },
//     {
//       name: "Revenue",
//       type: "spline",
//       data: null,
//       tooltip: {
//         valueSuffix: " $",
//       },
//     },
//   ],
//   responsive: {
//     rules: [
//       {
//         condition: {
//           maxWidth: 500,
//         },
//         chartOptions: {
//           legend: {
//             floating: false,
//             layout: "horizontal",
//             align: "center",
//             verticalAlign: "bottom",
//             x: 0,
//             y: 0,
//           },
//           yAxis: [
//             {
//               labels: {
//                 align: "right",
//                 x: 0,
//                 y: -6,
//               },
//               showLastLabel: false,
//             },
//             {
//               labels: {
//                 align: "left",
//                 x: 0,
//                 y: -6,
//               },
//               showLastLabel: false,
//             },
//             {
//               visible: false,
//             },
//           ],
//         },
//       },
//     ],
//   },
// });
var timeout;
async function changeDay(from2, to2, option) {
  var from = document.getElementById("fromDate").value;
  var to = document.getElementById("toDate").value;

  if (from && to) {
    var body = {
      from: from,
      to: to,
      from2: from2,
      to2: to2,
      option: option,
    };
  } else {
    var body = {
      from: null,
      to: null,
      from2: from2,
      to2: to2,
      option: option,
    };
  }
  var result = await fetch("http://localhost:8080/api/requestdata", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(body),
  });
  if (result.ok) {
    var data = await result.json();
    var revenue = data.revenue;
    var reHtml = document.getElementById("norevenue");
    reHtml.textContent = "$" + revenue;
    document.getElementById("noorders").textContent = data.orders;
    document.getElementById("nocustomer").textContent = data.customer;
    var text;
    if (option == "1") text = "From yesterday";
    if (option == "2") text = "From last Month";
    if (option == "3") text = "From last Year";
    var nform = document.getElementsByClassName("nfrom");
    nform[0].innerHTML =
      data.comparedRevenue >= 0
        ? `<i class="green"><i class="fa fa-sort-asc"></i>${data.comparedRevenue}% </i> ${text}`
        : `<i class="red"><i class="fa fa-sort-desc"></i>${-data.comparedRevenue}% </i> ${text}`;
    nform[1].innerHTML =
      data.comparedOrder >= 0
        ? `<i class="green"><i class="fa fa-sort-asc"></i>${data.comparedOrder}% </i> ${text}`
        : `<i class="red"><i class="fa fa-sort-desc"></i>${-data.comparedOrder}% </i> ${text}`;
    nform[2].innerHTML =
      data.comparedCustomer >= 0
        ? `<i class="green"><i class="fa fa-sort-asc"></i>${data.comparedCustomer}% </i> ${text}`
        : `<i class="red"><i class="fa fa-sort-desc"></i>${-data.comparedCustomer}% </i> ${text}`;
    chart1.xAxis[0].update({ categories: data.dataKey });
    chart1.series[0].update(
      {
        name: "Quantity",
        type: "column",
        yAxis: 1,
        data: data.dataValue1,
        tooltip: {
          valueSuffix: "",
        },
      },
      true
    );
    chart1.series[1].update(
      {
        name: "Revenue",
        type: "spline",
        data: data.dataValue2,
        tooltip: {
          valueSuffix: " $",
        },
      },
      true
    );
    chartNv.xAxis[0].update({ categories: data.dataNvKey });
    chartNv.series[0].update(
      {
        data: data.datanNvValue,
      },
      true
    );
    chartProduct.xAxis[0].update({ categories: data.dataProductKey });
    chartProduct.series[0].update(
      {
        data: data.datanProductValue,
      },
      true
    );
    // updateChart(chartNv, data.dataNvKey, data.datanNvValue);
    // updateChart(chartProduct,data.dataProductKey,data.datanProductValue);
  }

  
}
var intervalID;
function requestData(from2, to2, option){
  intervalID=setInterval(function(){
    changeDay(from2, to2, option);
  },1000);
}
function updateChart(chartUp, dataKey, dataKey) {
  // chart1.xAxis.update({ categories: dataKey });
  chartUp.xAxis[0].setCategories = dataKey;
  chartUp.series[0].update(
    {
      data: dataKey,
    },
    true
  );
}
function init() {
  const [date, time] = formatDate(new Date()).split(" ");
  document.getElementById("fromDate").value = date;
  document.getElementById("toDate").value = date;
  var date2f = new Date();
  date2f.setDate(date2f.getDate() - 1);
  const [date2, time2] = formatDate(date2f).split(" ");

  // overrideTimeOut();
  // console.log("window.activeTimers: "+window.activeTimers);
  requestData(date2, date2, "1");
  var id = setTimeout(";");
  console.log("id: " + id);
}
function padTo2Digits(num) {
  return num.toString().padStart(2, "0");
}

function formatDate(date) {
  return (
    [
      date.getFullYear(),
      padTo2Digits(date.getMonth() + 1),
      padTo2Digits(date.getDate()),
    ].join("-") +
    " " +
    [padTo2Digits(date.getHours()), padTo2Digits(date.getMinutes())].join(":")
  );
}
function clearInterval1() {
  // var id = setTimeout(";");
  clearInterval(intervalID);
  // while (id>5) {
  //   window.clearTimeout(id);
  //   id--;
  // }
}

function selectCustomDate() {
  var option = document.getElementById("selectCustomDate").value;
  var from = document.getElementById("fromDate").value;
  var to = document.getElementById("toDate").value;
  if (option === "1") {
    clearInterval1();
    const [date, time] = formatDate(new Date()).split(" ");
    document.getElementById("fromDate").value = date;
    document.getElementById("toDate").value = date;
    document.getElementById("fromDate").readOnly = true;
    document.getElementById("toDate").readOnly = true;
    var nform = document.getElementsByClassName("nfrom");
    for (var i = 0; i < nform.length; i++) {
      nform[i].removeAttribute("hidden");
    }
    var date2f = new Date();
    date2f.setDate(date2f.getDate() - 1);
    const [date2, time2] = formatDate(date2f).split(" ");

    requestData(date2, date2, option);
  } else if (option === "2") {
    clearInterval1();
    const [date, time] = formatDate(new Date()).split(" ");
    var firstDayf = new Date(
      new Date().getFullYear(),
      new Date().getMonth(),
      1
    );
    const [firstDay, timef] = formatDate(firstDayf).split(" ");
    document.getElementById("fromDate").value = firstDay;
    document.getElementById("toDate").value = date;
    document.getElementById("fromDate").readOnly = true;
    document.getElementById("toDate").readOnly = true;
    var nform = document.getElementsByClassName("nfrom");
    for (var i = 0; i < nform.length; i++) {
      nform[i].removeAttribute("hidden");
    }
    var firstDay2f = new Date(
      new Date().getFullYear(),
      new Date().getMonth() - 1,
      1
    );
    const [firstDay2, firsttime2] = formatDate(firstDay2f).split(" ");
    var lastDay2f = new Date(
      new Date().getFullYear(),
      new Date().getMonth(),
      0
    );
    const [lastDay2, lasttime2] = formatDate(lastDay2f).split(" ");
    requestData(firstDay2, lastDay2, option);
  } else if (option === "3") {
    clearInterval1();
    const [date, time] = formatDate(new Date()).split(" ");
    var firstDayf = new Date(new Date().getFullYear(), 0, 1);
    const [firstDay, timef] = formatDate(firstDayf).split(" ");
    document.getElementById("fromDate").value = firstDay;
    document.getElementById("toDate").value = date;
    document.getElementById("fromDate").readOnly = true;
    document.getElementById("toDate").readOnly = true;
    var nform = document.getElementsByClassName("nfrom");
    for (var i = 0; i < nform.length; i++) {
      nform[i].removeAttribute("hidden");
    }
    var firstDay2f = new Date(new Date().getFullYear() - 1, 0, 1);
    const [firstDay2, firsttime2] = formatDate(firstDay2f).split(" ");
    var lastDay2f = new Date(new Date().getFullYear(), 0, 0);
    const [lastDay2, lasttime2] = formatDate(lastDay2f).split(" ");
    requestData(firstDay2, lastDay2, option);
  } else if (option === "4") {
    clearInterval1();
    var datef = new Date();
    datef.setDate(datef.getDate() - 1);
    const [date, time] = formatDate(datef).split(" ");
    document.getElementById("fromDate").value = date;
    document.getElementById("toDate").value = date;
    document.getElementById("fromDate").readOnly = true;
    document.getElementById("toDate").readOnly = true;
    var nform = document.getElementsByClassName("nfrom");
    for (var i = 0; i < nform.length; i++) {
      nform[i].hidden = true;
    }
    requestData(null, null, option);
  } else if (option === "5") {
    clearInterval1();
    var firstDayf = new Date(
      new Date().getFullYear(),
      new Date().getMonth() - 1,
      1
    );
    const [firstDay, timef] = formatDate(firstDayf).split(" ");
    var lastDayf = new Date(new Date().getFullYear(), new Date().getMonth(), 0);
    const [lastDay, time] = formatDate(lastDayf).split(" ");
    document.getElementById("fromDate").value = firstDay;
    document.getElementById("toDate").value = lastDay;
    document.getElementById("fromDate").readOnly = true;
    document.getElementById("toDate").readOnly = true;
    var nform = document.getElementsByClassName("nfrom");
    for (var i = 0; i < nform.length; i++) {
      nform[i].hidden = true;
    }
    requestData(null, null, option);
  } else if (option === "6") {
    clearInterval1();
    var firstDayf = new Date(new Date().getFullYear() - 1, 0, 1);
    const [firstDay, timef] = formatDate(firstDayf).split(" ");
    var lastDayf = new Date(new Date().getFullYear(), 0, 0);
    const [lastDay, time] = formatDate(lastDayf).split(" ");
    document.getElementById("fromDate").value = firstDay;
    document.getElementById("toDate").value = lastDay;
    document.getElementById("fromDate").readOnly = true;
    document.getElementById("toDate").readOnly = true;
    var nform = document.getElementsByClassName("nfrom");
    for (var i = 0; i < nform.length; i++) {
      nform[i].hidden = true;
    }
    requestData(null, null, option);
  } else if (option === "7") {
    clearInterval1();
    document.getElementById("fromDate").readOnly = false;
    document.getElementById("toDate").readOnly = false;
    var nform = document.getElementsByClassName("nfrom");
    for (var i = 0; i < nform.length; i++) {
      nform[i].hidden = true;
    }
    requestData(null, null, option);
  }
}
