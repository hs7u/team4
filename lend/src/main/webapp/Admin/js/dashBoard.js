// function Uint8ToString(u8a){
//     var CHUNK_SZ = 0x8000;
//     var c = [];
//     for (var i=0; i < u8a.length; i+=CHUNK_SZ) {
//       c.push(String.fromCharCode.apply(null, u8a.subarray(i, i+CHUNK_SZ)));
//     }
//     return c.join("");
// }
function logout(e) {
    e.preventDefault();
    axios.get("./logout").then(res => {
        console.log(res.data)
    })
}
function getQa() {
    let data = {
        action: "qaList"
    }
    let fdate = JSON.stringify(data);
    axios({
        method: "post",
        url: "../Admin/dashBoard",
        data: fdate,
        headers: { "Content-Type": "application/json" },
    }).then(res => {
        for (let i = 0; i < res.data.length; i++) {
            let table = `<tr>
                            <td>${res.data[i].customerId}</td>
                            <td>${res.data[i].quession}</td>
                            <td><input type="button" class="las CUP" qrTarget="${res.data[i].qaId}" value="回應"></td>
                        </tr>`;
            $(table).appendTo("tbody.qaList");
        }
        $('#qaTable').DataTable({
            "lengthMenu": [5, 10, 20, 50], //顯示筆數設定 預設為[10, 25, 50, 100]
            "pageLength": '5'
        });
    })
}
function getCourses() {
    let data = {
        action: "courseList"
    }
    let fdate = JSON.stringify(data);
    axios({
        method: "post",
        url: "../Admin/dashBoard",
        data: fdate,
        headers: { "Content-Type": "application/json" },
    }).then(res => {
        $("tbody.dynamicsC").empty();
        $("div.forCUP").empty();
        for (let i = 0; i < res.data.length; i++) {
            let state = res.data[i].courseStatus == 0 ? '未開課' : res.data[i].courseStatus == 1 ? "開課中" : "報名中";
            let light = res.data[i].courseStatus == 0 ? 'red' : res.data[i].courseStatus == 1 ? "green" : "yellow";
            // var u8 = new Uint8Array(res.data[i].courseImage)
            // var b64encoded = btoa(Uint8ToString(u8));
            let table = `<tr>
                            <td>${res.data[i].courseName}</td>
                            <td><img src="data:image/png;base64,${res.data[i].courseImage}" width="60" height="40""/></td>
                            <td>
                                <span class="status ${light}"></span>
                                ${state}
                            </td>
                            <td><input type="button" class="las CUP" CUPtarget="${res.data[i].courseId}" value="修改"></td>
                            <td><input type="button" class="las Cdelete" CUPtarget="${res.data[i].courseId}" value="刪除"></td>
                        </tr>`;
            let uptable = `<div class="overCUP ${res.data[i].courseId}" style="display : none">
                                <article>
                                    <FORM METHOD="post" class="courseUPForm" enctype="multipart/form-data">
                                        <div class="forflex">
                                            <table>
                                                <tr class="twoline tt">
                                                    <td><label for="">課程名稱<input class="hh nomal ${res.data[i].courseId}" type="TEXT" name="courseName" size="45" placeholder="Ex:/ 水彩繪杯墊" value="${res.data[i].courseName}"></label></td>
                                                </tr>
                                                <tr class="twoline">
                                                    <td><label for="">課程描述<input class="hh nomal ${res.data[i].courseId}" type="TEXT" name="courseDescribe" size="45" placeholder="Ex:/ 可學習自行繪製杯墊" value="${res.data[i].courseDescribe}"/></label></td>
                                                </tr>
                                                <tr class="twoline">
                                                    <td><label for="">上課地點<input class="hh nomal ${res.data[i].courseId}" type="TEXT" name="courseLocation" size="45" placeholder="Ex:/ 台南市新營區民治路36號" value="${res.data[i].courseLocation}"/></label></td>
                                                </tr>
                                                <tr class="twoline">
                                                    <td><label for="">開課人數<input class="hh nomal ${res.data[i].courseId}" type="TEXT" name="minOfCourse" size="45" placeholder="Ex:/ 10" value="${res.data[i].minOfCourse}"/></label></td>
                                                </tr>
                                                <tr class="twoline">
                                                    <td><label for="">開始報名<input type="date" class="nomal ${res.data[i].courseId}" name="signUpStartdate"></label></td>
                                                </tr>
                                                <tr class="twoline">
                                                    <td><label for="">開課中<input type="radio" class="nomal ${res.data[i].courseId}" name="courseStatus" value="1" checked="${res.data[i].courseStatus == 1 ? true : false}"></label>
                                                    </td>
                                                </tr>
                                            </table>                    
                                            <table>
                                                <tr class="">
                                                    <td>課程圖片<label for="photoCUP${res.data[i].courseId}" class="nomal hh CUPlable">上傳<input type="file" id="photoCUP${res.data[i].courseId}" name="courseImage" size="45" style="display: none;"/></label></td>
                                                </tr>
                                                <tr class="twoline ">
                                                    <td class="nomalSec"><label for="">課程日期<input type="date" class="nomal ${res.data[i].courseId}" name="courseDate"></label></td>
                                                </tr>
                                                <tr class="twoline">
                                                    <td><label for="">課程價格<input class="hh nomal ${res.data[i].courseId}" type="TEXT" name="coursePrice" size="45" placeholder="Ex:/ 1500" value="${res.data[i].coursePrice}"/></label></td>
                                                </tr>
                                                <tr class="twoline">
                                                    <td><label for="">額滿人數<input class="hh nomal ${res.data[i].courseId}" type="TEXT" name="maxOfCourse" size="45" placeholder="Ex:/ 30" value="${res.data[i].maxOfCourse}"/></label></td>
                                                </tr>                        
                                                <tr class="twoline">
                                                    <td><label for="">截止報名<input type="date" class="nomal ${res.data[i].courseId}" name="signUpDeadline"></label></td>
                                                </tr>   
                                                <tr class="twoline">
                                                    <td> <label for="">未開課<input type="radio" class="nomal ${res.data[i].courseId}" name="courseStatus" value="0" checked="${res.data[i].courseStatus == 0 ? true : false}"></label></td>
                                                </tr>
                                            </table>
                                        </div>
                                        <input type="hidden" class="${res.data[i].courseId}" name="courseId" value="${res.data[i].courseId}">
                                        <button type="button"  class="btn_CUP btn_UPcourse" CUPtarget="${res.data[i].courseId}" >送出修改</button>
                                        <button type="button" class="btn_CUP closeCUP" CUPtarget="${res.data[i].courseId}">取消修改</button>
                                    </FORM>
                                </article>
                            </div>`;
            let mainTable = `<tr>
                                <td>${res.data[i].courseName}</td>
                                <td>${res.data[i].coursePrice}</td>
                                <td>
                                    <span class="status ${light}"></span>
                                    ${state}
                                </td>
                            </tr>`;
            $(table).appendTo("tbody.dynamicsC");
            $(uptable).appendTo("div.forCUP");
            if (i <= 3) {
                $(mainTable).appendTo("tbody.mainCource");
            }
        }
        $('#courseTable').DataTable({
            "lengthMenu": [5, 10, 20, 50], //顯示筆數設定 預設為[10, 25, 50, 100]
            "pageLength": '5',
            destroy: true,
            retrieve: true
        });
        cupListener();
    })
}

function getOrder() {
    let order = {
        action: "orderList"
    }
    let odate = JSON.stringify(order);
    axios({
        method: "post",
        url: "../Admin/dashBoard",
        data: odate,
        headers: { "Content-Type": "application/json" },
    }).then(res => {
        $("tbody.dynamicsD").empty();
        $("div.forOUP").empty();
        for(let i = 0 ; i < res.data.length; i++){
            let state1 = res.data[i].orderStatus == 0 ? '未完成' : res.data[i].orderStatus == 1 ? "完成" : "訂單處理中" ;
            let state2 = res.data[i].paymentStatus == 0 ? '未付款' : res.data[i].paymentStatus == 1 ? "已付款" : "已退款" ;
            let state3 = res.data[i].shippingStatus == 0 ? '未出貨' : res.data[i].shippingStatus == 1 ? "已出貨" : "已退貨" ;
            let ship = res.data[i].shippingMethodCode == 2 ? '超商店到店' : res.data[i].shippingMethodCode == 3 ? "宅急便" : res.data[i].shippingMethodCode == 4 ? "面交" : "處理中";
            let light = res.data[i].orderStatus == 0 ? 'red' : res.data[i].orderStatus == 1 ? "green" : "yellow" ;
            let table = `<tr>
                            <td>${res.data[i].orderId}</td>
                            <td>${res.data[i].customerId}</td>
                            <td>${moment(res.data[i].orderCreatedDate).locale("zh-tw").format("YYYY-MM-DD HH:mm")}</td>
                            <td>
                                <span class="status ${light}"></span>
                                ${state1}
                            </td>
                            <td><input type="button" class="las OUP" OUPtarget="${res.data[i].orderId}" value="明細"></td>
                        </tr>`;
            let detail = `<div class="overOUP" id="OUP${res.data[i].orderId}" >
                            <article>
                                <FORM METHOD="post" id="courseForm" enctype="multipart/form-data">
                                    <div id="forflexO1">
                                        <table>
                                            <tr class="twoban">
                                                <td><label for="">運送方式</label></td>
                                                <td><label for="">運費</label></td>
                                                <td><label for="">出貨日</label></td>
                                                <td><label for="">付款狀態</label></td>
                                                <td><label for="">運送狀態</label></td>
                                            </tr>
                                            <tr class="oans">
                                                <td>${ship}</td>
                                                <td class="${res.data[i].orderId}"><label for="">$ ${res.data[i].orderDeliveryCharge}</label></td>
                                                <td>${moment(res.data[i].orderShippingDate).locale("zh-tw").format("YYYY-MM-DD HH:mm")}</td>
                                                <td>
                                                    <span class="status ${light}"></span>
                                                    ${state2}
                                                </td>
                                                <td>
                                                    <span class="status ${light}"></span>
                                                    ${state3}
                                                </td>
                                            </tr>
                                            <tr class="twoban">
                                                <td><label for="">收件人</label></td>
                                                <td class="adre" style="width: 460px;"><label for="">收件地址</label></td>
                                                <td><label for="">備註</label></td>
                                            </tr>
                                            <tr class="oans">
                                                <td class="${res.data[i].orderId}"><label for="">${res.data[i].recipient}</label></td>
                                                <td class="adre ${res.data[i].orderId}" style="width: 460px;"><label for="">${res.data[i].sendersAddress}</label></td>
                                                <td class="${res.data[i].orderId}"><label for="">${res.data[i].orderDetails}</label></td>
                                            </tr>
                                        </table>
                                    </div>
                                    <div id="forflexO2">
                                        <table>
                                            <thead>
                                                <tr class="twoban">
                                                    <td><label for="">商品編號</label></td>
                                                    <td><label for="">商品名稱</label></td>
                                                    <td><label for="">數量</label></td>
                                                    <td><label for="">金額</label></td>
                                                    <td><label for="">客製化圖片</label></td>
                                                </tr>
                                            </thead>
                                            <tbody class="orderB${i} ds">
                                                <tr>

                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <button type="button" class="btn_OUP closeOUP" OUPtarget="${res.data[i].orderId}">關閉</button>
                                </FORM>
                            </article>`;
            
            $(table).appendTo("tbody.dynamicsD");
            $(detail).appendTo("div.forOUP");
            for(let j = 0; j < res.data[i].detail.length; j++){
                let img = res.data[i].detail[j].customerUploadImg == null ? `<img src="https://stickershop.line-scdn.net/stickershop/v1/product/9247729/IOS/main_animation@2x.png" width="60" height="40""/>` : `<img src="data:image/png;base64,${res.data[i].detail[j].customerUploadImg}" width="60" height="40""/>` ;
                let innerDetail = `<tr class="oans2">
                                    <td>${res.data[i].detail[j].productId}</td>
                                    <td>${res.data[i].detail[j].product.productName}</td>
                                    <td>${res.data[i].detail[j].productQuantity}</td>
                                    <td>$ ${res.data[i].detail[j].productPrice}</td>
                                    <td>${img}</td>
                                   </tr>`;
                $(innerDetail).appendTo(`.orderB${i}`);
            }
        }
        $('#orderTable').DataTable({
            "lengthMenu": [5, 10, 20, 50], //顯示筆數設定 預設為[10, 25, 50, 100]
            "pageLength": '5',
            destroy: true,
            retrieve: true
        });
        oupListener();
    });
}
function timeable(res) {
    $("p#target").text(res);
    $("div.overlay").css("z-index", 999999).fadeIn();
    $("button.btn_modal_close").on("click", function () {
        $("div.overlay").fadeOut("done", function () {
            window.location.reload();
        });
    });
}
function cupListener() {
    let sendCoDate = {};
    let sendCTDate = {};
    $(document).on("click", '.Cdelete', function(){
        let target = $(this).attr("CUPtarget");
        console.log(target);
        axios.get(`../Course/delete/${target}`).then(res => {
            window.location.reload();
        })
    })
    $('#courseTable').on('click', 'input.CUP' ,function (e) {
        e.preventDefault();
        $("div.overCUP." + $(this).attr("CUPtarget")).fadeIn();
        $("input[name='courseImage']").on("change", function () {
            let reader = new FileReader(); // 用來讀取檔案
            reader.readAsArrayBuffer(this.files[0]); // 讀取檔案
            reader.addEventListener("load", function () {
                let u = new Uint8Array(reader.result);
                sendCoDate.courseImage = Array.from(u);
            })
        })
    });
    $("button.closeCUP").on("click", function (e) {
        e.preventDefault();
        $("div.overCUP." + $(this).attr("CUPtarget")).fadeOut();
    });
    $("button.btn_UPcourse").on("click", function (e) {
        e.preventDefault();
        sendCoDate.courseId = $("input." + $(this).attr("CUPtarget") + "[name = 'courseId']").val();
        sendCoDate.courseName = $("input." + $(this).attr("CUPtarget") + "[name = 'courseName']").val();
        sendCoDate.coursePrice = $("input." + $(this).attr("CUPtarget") + "[name = 'coursePrice']").val();
        sendCoDate.maxOfCourse = $("input." + $(this).attr("CUPtarget") + "[name = 'maxOfCourse']").val();
        sendCoDate.minOfCourse = $("input." + $(this).attr("CUPtarget") + "[name = 'minOfCourse']").val();
        sendCoDate.courseLocation = $("input." + $(this).attr("CUPtarget") + "[name = 'courseLocation']").val();
        sendCoDate.courseDescribe = $("input." + $(this).attr("CUPtarget") + "[name = 'courseDescribe']").val();
        sendCoDate.courseStatus = $("input." + $(this).attr("CUPtarget") + "[name = 'courseStatus']:checked").val();

        sendCTDate.courseDate = $("input." + $(this).attr("CUPtarget") + "[name = 'courseDate']").val();
        sendCTDate.courseId = $("input." + $(this).attr("CUPtarget") + "[name = 'courseId']").val();
        sendCTDate.signUpStartdate = $("input." + $(this).attr("CUPtarget") + "[name = 'signUpStartdate']").val();
        sendCTDate.signUpDeadline = $("input." + $(this).attr("CUPtarget") + "[name = 'signUpDeadline']").val();
        sendCoDate = JSON.stringify(sendCoDate);
        sendCTDate = JSON.stringify(sendCTDate);
        console.log(sendCoDate);
        console.log(sendCTDate);
        axios({
            method: "post",
            url: "../Course/update",
            data: sendCoDate,
            headers: { "Content-Type": "application/json" },
        }).then(res => {
            let check = res.data;
            if (check.match(/success/) != null) {
                axios({
                    method: "post",
                    url: "../CourseTimeable/insert",
                    data: sendCTDate,
                    headers: { "Content-Type": "application/json" },
                }).then(res => {
                    let check2 = res.data;
                    if (check2.match(/success/) != null) {
                        $("div.overCUP." + $(this).attr("CUPtarget")).fadeOut();
                        window.location.reload();
                    } else {
                        timeable(res.data);
                    }
                })
            } else {
                timeable(res.data);
            }
        })
    });
}
function oupListener() {
    $("#orderTable").on("click", 'input.OUP' ,function (e) {
        e.preventDefault();
        $("div#OUP" + $(this).attr("OUPtarget")).fadeIn();
    });
    $("button.closeOUP").on("click", function (e) {
        e.preventDefault();
        $("div#OUP" + $(this).attr("OUPtarget")).fadeOut();
    });
}
function getCustomers() {
    let data = {
        action: "customerList"
    }
    let fdate = JSON.stringify(data);
    axios({
        method: "post",
        url: "../Admin/dashBoard",
        data: fdate,
        headers: { "Content-Type": "application/json" },
      }).then(res=>{
        for(let i = 0 ; i < res.data.length; i++){
            let cstate = res.data[i].customerStatus == 0 ? '未開通' : res.data[i].customerStatus == 1 ? "已開通" : "等驗證" ;
            let clight = res.data[i].customerStatus == 0 ? 'red' : res.data[i].customerStatus == 1 ? "green" : "yello" ;
            let mainAdd = `<div class="info">
                            <span class="las la-user-plus" style="font-size: 2.5rem;"></span>
                            <div>
                                <h4>${res.data[i].customerName}</h4>
                                <small>${res.data[i].customerEmail}</small>
                            </div>
                            <div class="contact">
                                <span class="las la-user-circle"></span>
                                <span class="las la-comment"></span>
                                <span class="las la-phone"></span>
                            </div>
                        </div>`;
            let list = `<tr>
                            <td><h4>${res.data[i].customerName}</h4></td>
                            <td><small>${res.data[i].customerEmail}</small></td>
                            <td><span class="status ${clight}"></span>${cstate}</td>
                            <td><input type="button" class="las" value="停權"></td>
                            <td><span class="las la-birthday-cake">${moment(res.data[i].customerBirthday).locale("zh-tw").format("YYYY-MM-DD HH:mm")}</span></td>
                            <td><span class="las la-phone">${res.data[i].customerPhone}</span></td>
                        </tr>`;
            $(list).appendTo("tbody.cuList");
            if(i <= 3){
                $(mainAdd).appendTo("div.newCustomer");            
            }
        }
        $('#customerTable').DataTable({
            "lengthMenu": [5, 10, 20, 50], //顯示筆數設定 預設為[10, 25, 50, 100]
            "pageLength": '5',
            destroy: true,
            retrieve: true
        });
    })
}
function getAccountInfo() {
    let data = {
        action: "accountInfo"
    }
    let fdate = JSON.stringify(data);
    axios({
        method: "post",
        url: "../Admin/dashBoard",
        data: fdate,
        headers: { "Content-Type": "application/json" },
    }).then(res => {
        $("#currentAccount").find("h4").text(res.data.adminAccount);
        $("#currentAccount").find("small").text(res.data.permission);
    })
}
function openWorker() {
    if (window.Worker) {
        // 建立一個 Dedicated Worker
        let customerCount = document.getElementById("customerCount");
        let worker1 = new Worker("./js/workers/worker1.js");
        worker1.onmessage = function (e) {
            customerCount.innerText = `${e.data}`;
        };
        let courseCount = document.getElementById("courseCount");
        let worker2 = new Worker("./js/workers/worker2.js");
        worker2.onmessage = function (e) {
            courseCount.innerText = `${e.data}`;
        };
        let orderCount = document.getElementById("orderCount");
        let worker3 = new Worker("./js/workers/worker3.js");
        worker3.onmessage = function (e) {
            orderCount.innerText = `${e.data}`;
        };
        let incomeCount = document.getElementById("incomeCount");
        let worker4 = new Worker("./js/workers/worker4.js");
        worker4.onmessage = function (e) {
            incomeCount.innerText = `$${e.data}`;
        };
    }
}
$.fn.cUploaded = function () {
    this.fadeIn();
    $("button.btn_modal_close").on("click", function () {
        $("div.overlay").fadeOut("done", function () {
            window.location.reload();
        });
    });
};
// $.fn.cUpfail = function(){ 
//     this.fadeIn();          
//     $("button.btn_modal_close").on("click", function(){
//         $("div.overlay").fadeOut("done", function(){
//             window.location.reload();
//         });
//     });
// };
// $.fn.pUploaded = function(){           
//     this.fadeIn();
//     $("button.btn_modal_close").on("click", function(){
//         $("div.overlay").fadeOut("done", function(){
//             window.location.assign("./AdminDashBoard_v2.html#product");
//         });
//     });
// };
// $.fn.pUpfail = function(){ 
//     this.fadeIn();          
//     $("button.btn_modal_close").on("click", function(){
//         $("div.overlay").fadeOut("done", function(){
//             window.location.assign("./AdminDashBoard_v2.html#product");
//         });
//     });
// };
function courseInsert(){
    let coDate = {};
    $("input.courseInsert[name='courseImage']").on("change", function () {
        let reader = new FileReader(); // 用來讀取檔案
        reader.readAsArrayBuffer(this.files[0]); // 讀取檔案
        reader.addEventListener("load", function () {
            let u = new Uint8Array(reader.result);
            coDate.courseImage = Array.from(u);
        })
    })
    $("#btn_course").on('click', function (e) {
        coDate.courseName = $("input.courseInsert[name='courseName']").val();
        coDate.courseDescribe = $("input.courseInsert[name='courseDescription']").val();
        coDate.coursePrice = $("input.courseInsert[name='coursePrice']").val();
        coDate.minOfCourse = $("input.courseInsert[name='minOfCourse']").val();
        coDate.maxOfCourse = $("input.courseInsert[name='maxOfCourse']").val();
        coDate.courseLocation = $("input.courseInsert[name='courseLocation']").val();
        e.preventDefault();
        coDate = JSON.stringify(coDate);
        axios({
            method: "post",
            url: "../Course/addCourse",
            data: coDate,
            headers: { "Content-Type": "application/json" },
        }).then(res => {
            $(function () {
                $("button.btn_modal_close").on("click", function () {
                    $("div.overlay").fadeOut();
                });
            });
            let check = res.data;
            let t = document.getElementById("target");
            t.innerText = check;
            // if(check.match(/success/) != null){
            $("div.overlay").cUploaded();
            // }else{
            //     $("div.overlay").cUpfail();
            // }
        })
    })

}
function productInsert(){
    let pdate = {};
    $("input[name='productImage']").on("change" ,function(){
        let reader = new FileReader(); // 用來讀取檔案
        reader.readAsArrayBuffer(this.files[0]); // 讀取檔案
        reader.addEventListener("load", function () {
            let u = new Uint8Array(reader.result);
            pdate.productImage = Array.from(u);
        })
    })
    document.getElementById('btn_product').addEventListener('click',function(e){
        e.preventDefault();
        pdate.productCategoryCode  = $('input[name="productCategoryCode"]:checked').val();
        pdate.customerProductPrice = $('input[name="customerProductPrice"]').val();
        pdate.customization        = $('input[name="customization"]:checked').val();
        pdate.productInventory     = $('input[name="productInventory"]').val();
        pdate.productName          = $('input[name="productName"]').val();
        pdate.productPrice         = $('input[name="productPrice"]').val();
        pdate.productDescription   = $('input[name="productDescription"]').val();
        pdate = JSON.stringify(pdate);
            axios({
              method: "post",
              url: "../Product/addNewProduct",
              data: pdate,
              headers: { "Content-Type": "application/json" },
            }).then(res=>{
                $(function(){           
                    $("button.btn_modal_close").on("click", function(){
                        $("div.overlay").fadeOut();
                    });
                });
                let check = res.data;
                let t = document.getElementById("target");
                t.innerText = check;
                // if(check.match(/success/) != null){
                    $("div.overlay").cUploaded();
                // }else{
                //     $("div.overlay").cUpfail();
                // }
            })    
    })
}
// function callStateC(){
//     $(function(){           
//         $("button.btn_modal_close").on("click", function(){
//             $("div.overlay").fadeOut();
//         });
//     });
//     if(xhr.readyState == 4){    //readyState: 0 -> 1 -> 2 -> 3 -> 4
//         let t = document.getElementById("target");
//         if(xhr.status == 200){
//             let text = `${xhr.responseText}`
//             t.innerText = text;
//             if(text.match(/成功/) != null){
//                 $("div.overlay").cUploaded();
//             }else{
//                 $("div.overlay").cUpfail();
//             }
//         }else{
//             t.innerText = `${xhr.status}: ${xhr.statusText}`
//         }
//         $("div.overlay").fadeIn();
//     }   
// }
// function callStateP(){
//     $(function(){           
//         $("button.btn_modal_close").on("click", function(){
//             $("div.overlay").fadeOut();
//         });
//     });
//     if(xhr.readyState == 4){    //readyState: 0 -> 1 -> 2 -> 3 -> 4
//         let t = document.getElementById("target");
//         if(xhr.status == 200){
//             let text = `${xhr.responseText}`
//             t.innerText = text;
//             if(text.match(/成功/) != null){
//                 $("div.overlay").pUploaded();
//             }else{
//                 $("div.overlay").pUpfail();
//             }
//         }else{
//             t.innerText = `${xhr.status}: ${xhr.statusText}`
//         }
//         $("div.overlay").fadeIn();
//     }   
// }
function init(){
    openWorker();
    productInsert();
    courseInsert();

}
$(document).ready(function () {
    getAccountInfo();
    getCustomers();
    getCourses();
    getOrder();
})
window.addEventListener('load', init);