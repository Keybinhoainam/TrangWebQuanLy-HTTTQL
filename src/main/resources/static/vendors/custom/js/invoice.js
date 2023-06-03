

function fill_info_customer(index) {
	let a = '.customer_tbl #KH' + index;
    var customer = $(a);
    var profile = `<div class="col-md-6 col-sm-6  profile_details">
		                <div class="well profile_view"  style="background-color: #2A3F54; color: white;">
		                  <div class="col-sm-12">
		                    <h4 class="brief col-sm-10 " style="font-size: 20px;"><i>Khách hàng</i></h4>
		                    <div class="right col-sm-2 text-center">
		                      <i class="fa fa-user" style="font-size: 36px;"></i>
		                    </div>
		                    <div class="left col-sm-12">
		                      <h2 style="font-weight: bold;font-size: 30px;">${customer.find("td:eq(1)").text()}</h2>
		                      <br>
		                      <ul class="list-unstyled">
		                      	<li style="font-size: 16px;"><i class="fa fa-credit-card"></i> ID: <span id="customer_id">${customer.find("td:eq(0)").text()}</span> </li>
		                        <li style="font-size: 16px;"><i class="fa fa-building"></i> Address: ${customer.find("td:eq(4)").text()}</li>
		                        <li style="font-size: 16px;"><i class="fa fa-phone"></i> Phone: ${customer.find("td:eq(2)").text()}</li>
		                        <li style="font-size: 16px;"><i class="fa fa-envelope"></i> Email: ${customer.find("td:eq(3)").text()}</li>
		                      </ul>
		                    </div>
		                  </div>
		                </div>
		              </div>`
	$('.profile_customer').html(profile);
}

function fill_info_supplier(index) {
	let a = '.supplier_tbl #NCC' + index;
    var supplier = $(a);
    var profile = `<div class="col-md-6 col-sm-6  profile_details">
		                <div class="well profile_view"  style="background-color: #2A3F54; color: white;">
		                  <div class="col-sm-12">
		                    <h4 class="brief col-sm-10 " style="font-size: 20px;"><i>Nhà cung cấp</i></h4>
		                    <div class="right col-sm-2 text-center">
		                      <i class="fa fa-user" style="font-size: 36px;"></i>
		                    </div>
		                    <div class="left col-sm-12">
		                      <h2 style="font-weight: bold;font-size: 30px;">${supplier.find("td:eq(1)").text()}</h2>
		                      <br>
		                      <ul class="list-unstyled">
		                      	<li style="font-size: 16px;"><i class="fa fa-credit-card"></i> ID: <span id="supplier_id">${supplier.find("td:eq(0)").text()}</span> </li>
		                        <li style="font-size: 16px;"><i class="fa fa-building"></i> Address: ${supplier.find("td:eq(3)").text()}</li>
		                        <li style="font-size: 16px;"><i class="fa fa-phone"></i> Phone: ${supplier.find("td:eq(2)").text()}</li>
		                      </ul>
		                    </div>
		                  </div>
		                </div>
		              </div>`
	$('.profile_supplier').html(profile);
}

function add_to_cart(index) {
	let a = '.product_tbl #SP' + index;
	var product = $(a);	
	let id_tag = '#CART'+product.find("td:eq(0)").text();
	if($(id_tag).length){
		return;
	}
    var product_row = ` <tr id="CART${product.find("td:eq(0)").text()}">
							<td class="sp_id">${product.find("td:eq(0)").text()}</td>
							<td>${product.find("td:eq(1)").text()}</td>
							<td>${product.find("td:eq(2)").text()}</td>
							<td>
							    <input class="sp_soluong" type="number" min="1"
							        value="1" max="${product.find("td:eq(3)").text()}">
							</td>
							<td>
							    <div onclick="remove_to_cart(${product.find("td:eq(0)").text()})"
							        class="btn btn-danger btn-sm">
							        <i class="fa fa-close"></i>
							    </div>
							</td>
						</tr >`
	console.log(product_row);
    $('.cart_tbl tbody').append(product_row);
}

function add_to_purchase(index) {
	let a = '.product_tbl #SP' + index;
	var product = $(a);	
	let id_tag = '#CART'+product.find("td:eq(0)").text();
	if($(id_tag).length){
		return;
	}
    var product_row = ` <tr id="CART${product.find("td:eq(0)").text()}">
							<td class="sp_id">${product.find("td:eq(0)").text()}</td>
							<td>${product.find("td:eq(1)").text()}</td>
							<td>
							    <input class="sp_giaNhap" type="text"
							        value=0>
							</td>
							<td>
							    <input class="sp_soluong" type="number" min="1"
							        value="1">
							</td>
							<td>
							    <div onclick="remove_to_cart(${product.find("td:eq(0)").text()})"
							        class="btn btn-danger btn-sm">
							        <i class="fa fa-close"></i>
							    </div>
							</td>
						</tr >`
	console.log(product_row);
    $('.cart_tbl tbody').append(product_row);
}

function remove_to_cart(id) {
    let a = '#CART' + id;
    $(a).remove();
}

function add_invoice() {
    var kh_id = $('#customer_id').text();
    var cart_ids = $('.cart_tbl .sp_id');
    var cart_sls = $('.cart_tbl .sp_soluong');
    var discount = $('.discount_invoice').val();
    var cart_detail = [];
    if (!kh_id) {
        alert("Chưa chọn khách hàng!");
        return;
    }
    if (cart_ids.length <= 0) {
        alert("Giỏ hàng trống!");
        return;
    }
    
    for (let i = 0; i < cart_sls.length; i++) {
        let max = cart_sls[i].max,
        	min = cart_sls[i].min,
        	value = cart_sls[i].value;
        if(parseInt(value) < parseInt(min) || parseInt(value) > parseInt(max)){
			alert("Số lượng không hợp lệ!");
			return;
		}
    }
    
    for (let i = 0; i < cart_ids.length; i++) {
        cart_detail.push({
            "soLuong": cart_sls[i].value,
            "sanPham": {
                "id": cart_ids[i].textContent
            }
        })
    }
    let today = new Date().toISOString().slice(0, 10)
    var invoice = {
        "trangThai": "Done",
        "discount": discount,
        "ngayBan": today,
        "khachHang": {
            "id": kh_id
        },
        "listChiTietHoaDonBan": cart_detail
    }
    console.log(invoice);
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(invoice),
        url: "http://localhost:8080/data/add",
        success: function (id) {
            alert("Thành công!");
            window.location = 'http://localhost:8080/sell/invoice?id='+id;
        },
        error: function () {
            alert("Có lỗi xảy ra!");
        }
    })
}

function add_purchase() {
    var ncc_id = $('#supplier_id').text();
    var cart_ids = $('.cart_tbl .sp_id');
    var cart_sls = $('.cart_tbl .sp_soluong');
    var cart_gns = $('.cart_tbl .sp_giaNhap');
    var cart_detail = [];
    if (!ncc_id) {
        alert("Chưa chọn nhà cung cấp!");
        return;
    }
    if (cart_ids.length <= 0) {
        alert("Giỏ hàng trống!");
        return;
    }
    
    
    for (let i = 0; i < cart_gns.length; i++) {
        let value = cart_gns[i].value;
        if(isNaN(value)){
			alert("Giá nhập không hợp lệ!");
			return;
		}
		if(parseFloat(value)<=0){
			alert("Giá nhập không hợp lệ!");
			return;
		}
    }
    
    for (let i = 0; i < cart_sls.length; i++) {
        let value = cart_sls[i].value;
        if(parseInt(value) < 1){
			alert("Số lượng không hợp lệ!");
			return;
		}
    }
    
    for (let i = 0; i < cart_ids.length; i++) {
        cart_detail.push({
            "soLuong": cart_sls[i].value,
            "donGiaNhap": cart_gns[i].value,
            "sanPham": {
                "id": cart_ids[i].textContent
            }
        })
    }
    let today = new Date().toISOString().slice(0, 10)
    var purchase = {
        "trangThai": "Done",
        "ngayNhap": today,
        "nhaCungCap": {
            "id": ncc_id
        },
        "listChiTietHoaDonNhap": cart_detail
    }
    console.log(purchase);
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(purchase),
        url: "http://localhost:8080/data/purchase",
        success: function (id) {
            alert("Thành công!");
            window.location = 'http://localhost:8080/purchase/invoice?id='+id;
        },
        error: function () {
            alert("Có lỗi xảy ra!");
        }
    })
}

function exportTableToExcel(tableID, filename = ''){
    var downloadLink;
    var dataType = 'application/vnd.ms-excel';
    var tableSelect = document.getElementById(tableID);
    var tableHTML = tableSelect.outerHTML.replace(/ /g, '%20');
    
    // Specify file name
    filename = filename?filename+'.xls':'excel_data.xls';
    
    // Create download link element
    downloadLink = document.createElement("a");
    
    document.body.appendChild(downloadLink);
    
    if(navigator.msSaveOrOpenBlob){
        var blob = new Blob(['\ufeff', tableHTML], {
            type: dataType
        });
        navigator.msSaveOrOpenBlob( blob, filename);
    }else{
        // Create a link to the file
        downloadLink.href = 'data:' + dataType + ', ' + tableHTML;
    
        // Setting the file name
        downloadLink.download = filename;
        
        //triggering the function
        downloadLink.click();
    }
}