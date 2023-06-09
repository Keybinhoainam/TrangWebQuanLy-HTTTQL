function exportCustomDate() {
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

    exportData(date2, date2, option);
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
    exportData(firstDay2, lastDay2, option);
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
    exportData(firstDay2, lastDay2, option);
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
    exportData(null, null, option);
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
    exportData(null, null, option);
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
    exportData(null, null, option);
  } else if (option === "7") {
    clearInterval1();
    document.getElementById("fromDate").readOnly = false;
    document.getElementById("toDate").readOnly = false;
    var nform = document.getElementsByClassName("nfrom");
    for (var i = 0; i < nform.length; i++) {
      nform[i].hidden = true;
    }
    exportData(null, null, option);
  }
}

async function exportData(from2, to2, option) {
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
    	createExcel(data);
   }
 }

function getData1(data) {
    var raqData = [];
    var nvData = [];
    var slData = [];
    for (let i = 0; i < data['dataKey'].length; i++) {
        raqData.push({
            "stt": i + 1,
            "thoiGian": data['dataKey'][i],
            "soLuong": data['dataValue1'][i],
            "doanhThu": data['dataValue2'][i],
        })
    }
    for (let i = 0; i < data['dataNvKey'].length; i++) {
        nvData.push({
            "stt": i + 1,
            "nhanVien": data['dataNvKey'][i],
            "soLuong": data['datanNvValue'][i],
        })
    }
    for (let i = 0; i < data['dataProductKey'].length; i++) {
        slData.push({
            "stt": i + 1,
            "sanPham": data['dataProductKey'][i],
            "soLuong": data['datanProductValue'][i],
        })
    }
    var sumv1 = data['dataValue1'].reduce((a, b) => a + b, 0),
        sumv2 = data['dataValue2'].reduce((a, b) => a + b, 0),
        sumv3 = data['datanNvValue'].reduce((a, b) => a + b, 0),
        sumv4 = data['datanProductValue'].reduce((a, b) => a + b, 0)
    return [raqData, nvData, slData, sumv1, sumv2, sumv3, sumv4];
}

async function createExcel(data) {
    var [raqData, nvData, slData, sumv1, sumv2, sumv3, sumv4] = getData1(data);
    const wb = new ExcelJS.Workbook();
    const time = new Date();
    var createAt = `(${time.getHours()}:${time.getMinutes()}:${time.getSeconds()} ${time.getDate()}-${time.getMonth()}-${time.getFullYear()})`
    var dateHeader = ['STT', 'Thời gian', 'Số lượng', 'Doanh thu'],
        nvHeader = ['STT', 'Nhân viên', 'Doanh thu'],
        quantityHeader = ['STT', 'Sản phẩm', 'Số lượng'],
        width1 = [
            { width: 15 },
            { width: 30 },
            { width: 30 },
            { width: 30 }
        ],
        width2 = [
            { width: 15 },
            { width: 50 },
            { width: 30 },
        ];
    var footer1 = ['Tổng', '', sumv1, sumv2],
        footer2 = ['Tổng', '', sumv3],
        footer3 = ['Tổng', '', sumv4];
    addSheet(wb, "Doanh thu", "Thống kê doanh thu và số lượng", createAt,
        dateHeader, raqData, footer1, width1, true)
    addSheet(wb, "Nhân viên", "Thống kê doanh thu theo nhân viên", createAt,
        nvHeader, nvData, footer2, width2, true)
    addSheet(wb, "Sản phẩm", "Thống kê số lượng bán được của mỗi loại sản phẩm", createAt,
        quantityHeader, slData, footer3, width2)

    var filename = 'Report';
    const buf = await wb.xlsx.writeBuffer();
    saveAs(new Blob([buf]), `${filename}.xlsx`);
}

async function addSheet(workbook, sheetname, report, myTime, myHeader, myData, myFooter = null, widths = null, money = false) {
    const ws = workbook.addWorksheet(sheetname);
    const columns = myHeader?.length;
    const title = {
        border: false,
        height: 32,
        font: {
            name: 'Calibri',
            size: 22,
            bold: true,
            italic: true,
            color: { argb: '316885' },
        },
        alignment: {
            horizontal: 'center',
            vertical: 'middle'
        },
        // fill: {
        //     type: 'pattern',
        //     pattern: 'solid', //darkVertical
        //     fgColor: {
        //         argb: '0000FF',
        //     },
        // },
    };
    const time = {
        border: false,
        height: 25,
        font: {
            name: 'Calibri',
            size: 12,
            bold: false,
            italic: true,
            color: { argb: '000000' },
        },
        alignment: {
            horizontal: 'center',
            vertical: 'middle'
        },
        // fill: {
        //     type: 'pattern',
        //     pattern: 'solid', //darkVertical
        //     fgColor: {
        //         argb: '0000FF',
        //     },
        // },
    };
    const header = {
        border: true,
        height: 24,
        font: { name: 'Calibri', size: 14, bold: true, color: { argb: 'FFFFFF' } },
        alignment: { horizontal: 'center', vertical: 'middle' },
        fill: {
            type: 'pattern',
            pattern: 'solid', //darkVertical
            fgColor: {
                argb: '418AB3',
            },
        },
    };
    const data = {
        border: true,
        height: 0,
        font: { name: 'Calibri', size: 12, bold: false, color: { argb: '000000' } },
        alignment: { horizontal: 'center', vertical: 'middle' },
        fill: null,
    };
    const footer = {
        border: true,
        height: 28,
        font: { name: 'Calibri', size: 14, bold: true, color: { argb: 'b80000' } },
        alignment: null,
        // fill: {
        //     type: 'pattern',
        //     pattern: 'solid', //darkVertical
        //     fgColor: {
        //         argb: '0000FF',
        //     },
        // },
    };

    if (widths && widths.length > 0) {
        ws.columns = widths;
    }

    let row = addRow(ws, [report], title, money);
    mergeCells(ws, row, 1, columns);

	row = addRow(ws, [myTime], time, money);
    mergeCells(ws, row, 1, columns);
	
    addRow(ws, [], null, money);

    addRow(ws, myHeader, header, money);

    myData.forEach((rowData) => {
        console.log('rowData', rowData);
        addRow(ws, Object.values(rowData), data, money);
    });

    row = addRow(ws, myFooter, footer, money);
    mergeCells(ws, row, 1, 2);
}

function addRow(ws, data, section, money = false) {
    const borderStyles = {
        top: { style: 'thin', color: { argb: 'FFFFFF' } },
        left: { style: 'thin', color: { argb: '948A54' } },
        bottom: { style: 'thin', color: { argb: '948A54' } },
        right: { style: 'thin', color: { argb: '948A54' } },
    };
    const row = ws.addRow(data);
    console.log('addRow', section, data);
    row.eachCell({ includeEmpty: true }, (cell, colNumber) => {
        if (section?.border) {
            cell.border = borderStyles;
        }
        if (section?.alignment) {
            cell.alignment = section.alignment;
        } else {
            cell.alignment = { vertical: 'middle' };
        }
        if (typeof cell.value === 'number') {
            cell.alignment = { horizontal: 'right', vertical: 'middle' };
            // cell.numFmt = '$#,##0.00;[Red]-$#,##0.00';
        }
        if (money && colNumber === data.length && typeof cell.value === 'number') {
            cell.numFmt = '$#,##0.00;[Red]-$#,##0.00';
        }
        if (section?.font) {
            cell.font = section.font;
        }
        if (section?.fill) {
            cell.fill = section.fill;
        }
    });
    if (section?.height > 0) {
        row.height = section.height;
    }
    return row;
}

function mergeCells(ws, row, from, to) {
    // console.log(
    // 	'mergeCells',
    // 	row,
    // 	from,
    // 	to,
    // 	row.getCell(from)._address,
    // 	row.getCell(to)._address
    // );
    ws.mergeCells(`${row.getCell(from)._address}:${row.getCell(to)._address}`);
}

