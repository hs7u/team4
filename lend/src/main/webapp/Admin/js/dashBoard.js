function Uint8ToString(u8a){
    var CHUNK_SZ = 0x8000;
    var c = [];
    for (var i=0; i < u8a.length; i+=CHUNK_SZ) {
      c.push(String.fromCharCode.apply(null, u8a.subarray(i, i+CHUNK_SZ)));
    }
    return c.join("");
  }
function logout(e) {
    e.preventDefault();
    axios.get("./logout").then(res => {
        console.log(res.data)
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
      }).then(res=>{
        $("tbody.dynamicsC").empty();
        for(let i = 0 ; i < res.data.length; i++){
            let state = res.data[i].courseStatus == 0 ? '未開課' : res.data[i].courseStatus == 1 ? "開課中" : "報名中" ;
            let light = res.data[i].courseStatus == 0 ? 'red' : res.data[i].courseStatus == 1 ? "green" : "yello" ;
            // let data = new Uint8Array(res.data[i].courseImage);
            var u8 = new Uint8Array(res.data[i].courseImage)
            var b64encoded = btoa(Uint8ToString(u8));
            let table = `<tr>
                            <td>${res.data[i].courseName}</td>
                            <td><img src="data:image/png;base64,${b64encoded}" width="60" height="40""/></td>
                            <td>
                                <span class="status ${light}"></span>
                                ${state}
                            </td>
                            <td><input type="button" class="las CUP" CUPtarget="${res.data[i].courseId}" value="修改"></td>
                            <td><input type="button" class="las" value="刪除"></td>
                        </tr>`;
            let uptable = `<div class="overCUP ${res.data[i].courseId}">
                                <article>
                                    <FORM METHOD="post" id="courseUPForm" enctype="multipart/form-data">
                                        <div id="forflex">
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
                                                    <td><label for="">開課中<input type="radio" class="nomal ${res.data[i].courseId}" name="courseStatus" value="1" checked="${res.data[i]}"></label>
                                                    </td>
                                                </tr>
                                            </table>                    
                                            <table>
                                                <tr class="">
                                                    <td>課程圖片<label for="photoCUP" class="nomal hh CUPlable">上傳<input type="file" class="${res.data[i].courseId}" id="photoCUP" name="courseImage" size="45" style="display: none;"/></label></td>
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
                                                    <td> <label for="">未開課<input type="radio" class="nomal ${res.data[i].courseId}" name="courseStatus" value="0" checked="${res.data[i]}"></label></td>
                                                </tr>
                                            </table>
                                        </div>
                                        <button type="button"  class="btn_CUP btn_UPcourse" CUPtarget="${res.data[i].courseId}" >送出修改</button>
                                        <button type="button" class="btn_CUP closeCUP" CUPtarget="${res.data[i].courseId}">取消修改</button>
                                    </FORM>
                                </article>
                            </div>`;    
            $(table).appendTo("tbody.dynamicsC");
            $("div.overlay").after(uptable);
        }        
      })
}
function cupListener() {
    let sendCoDate = {};
    let sendCTDate = {};
    $("input.CUP").on("click", function(e){
        e.preventDefault();
        $("div.overCUP."+$(this).attr("CUPtarget")).fadeIn();
        $("input[name='courseImage']").on("change" ,function(){
            let reader = new FileReader(); // 用來讀取檔案
            reader.readAsArrayBuffer(this.files[0]); // 讀取檔案
            reader.addEventListener("load", function () {
            let u = new Uint8Array(reader.result);
            sendCoDate.courseImage = Array.from(u);
            })
        })
    });
    $("button.closeCUP").on("click", function(e){
        e.preventDefault();
        $("div.overCUP."+$(this).attr("CUPtarget")).fadeOut();
    });
    $("button.btn_UPcourse").on("click", function(e){
        e.preventDefault();        
        sendCoDate.courseName     = $("input."+$(this).attr("CUPtarget")+"[name = 'courseName']").val();
        sendCoDate.coursePrice    = $("input."+$(this).attr("CUPtarget")+"[name = 'coursePrice']").val();
        sendCoDate.maxOfCourse    = $("input."+$(this).attr("CUPtarget")+"[name = 'maxOfCourse']").val();
        sendCoDate.minOfCourse    = $("input."+$(this).attr("CUPtarget")+"[name = 'minOfCourse']").val();
        sendCoDate.courseLocation = $("input."+$(this).attr("CUPtarget")+"[name = 'courseLocation']").val();
        sendCoDate.courseDescribe = $("input."+$(this).attr("CUPtarget")+"[name = 'courseDescribe']").val();
        sendCoDate.courseStatus   = $("input."+$(this).attr("CUPtarget")+"[name = 'courseStatus']:checked").val();

        sendCTDate.signUpStartdate  = $("input."+$(this).attr("CUPtarget")+"[name = 'signUpStartdate']").val();
        sendCTDate.signUpDeadline   = $("input."+$(this).attr("CUPtarget")+"[name = 'signUpDeadline']").val();
        sendCTDate.courseDate       = $("input."+$(this).attr("CUPtarget")+"[name = 'courseDate']").val();
        sendCoDate = JSON.stringify(sendCoDate);
        sendCTDate = JSON.stringify(sendCTDate);
        console.log(sendCoDate);
        console.log(sendCTDate);
        axios({
            method: "post",
            url: "./Course/update",
            data: sendCoDate,
            headers: { "Content-Type": "application/json" },
          }).then(res=>{
              if(res.data != null){
                axios({
                    method: "post",
                    url: "./CourseTimeable/insert",
                    data: sendCTDate,
                    headers: { "Content-Type": "application/json" },
                  }).then(res=>{
                      if(res.data != null){
                        $("div.overCUP."+$(this).attr("CUPtarget")).fadeOut();  
                      }
                  })  
              }
          })     
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
            let light = res.data[i].customerStatus == 0 ? 'red' : res.data[i].customerStatus == 1 ? "green" : "yello" ;
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
                            <td><span class="status ${light}"></span>${cstate}</td>
                            <td><span class="las la-user-circle"></span></td>
                            <td><span class="las la-comment"></span></td>
                            <td><span class="las la-phone">${res.data[i].customerPhone}</span></td>
                        </tr>`;
            $(list).appendTo("tbody.cuList");
            if(i <= 2){
                $(mainAdd).appendTo("div.newCustomer");            
            }
        }
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
      }).then(res=>{
          $("#currentAccount").find("h4").text(res.data.adminAccount);
          $("#currentAccount").find("small").text(res.data.permission);
      })
}
function openWorker() {
    if(window.Worker){
        // 建立一個 Dedicated Worker
        let customerCount = document.getElementById("customerCount");
        let worker1 = new Worker("./js/workers/worker1.js");
        worker1.onmessage = function(e) {
            customerCount.innerText = `${e.data}`;
        };
        let courseCount = document.getElementById("courseCount");
        let worker2 = new Worker("./js/workers/worker2.js");
        worker2.onmessage = function(e) {
            courseCount.innerText = `${e.data}`;
        };
        let orderCount = document.getElementById("orderCount");
        let worker3 = new Worker("./js/workers/worker3.js");
        worker3.onmessage = function(e) {
            orderCount.innerText = `${e.data}`;
        };
        let incomeCount = document.getElementById("incomeCount");
        let worker4 = new Worker("./js/workers/worker4.js");
        worker4.onmessage = function(e) {
            incomeCount.innerText = `$${e.data}`;
        };
    }
}
$.fn.cUploaded = function(){           
    this.fadeIn();
    $("button.btn_modal_close").on("click", function(){
        $("div.overlay").fadeOut("done", function(){
            window.location.assign("./AdminDashBoard_v2.html#course");
        });
    });
};
$.fn.cUpfail = function(){ 
    this.fadeIn();          
    $("button.btn_modal_close").on("click", function(){
        $("div.overlay").fadeOut("done", function(){
            window.location.assign("./AdminDashBoard_v2.html#course");
        });
    });
};
$.fn.pUploaded = function(){           
    this.fadeIn();
    $("button.btn_modal_close").on("click", function(){
        $("div.overlay").fadeOut("done", function(){
            window.location.assign("./AdminDashBoard_v2.html#product");
        });
    });
};
$.fn.pUpfail = function(){ 
    this.fadeIn();          
    $("button.btn_modal_close").on("click", function(){
        $("div.overlay").fadeOut("done", function(){
            window.location.assign("./AdminDashBoard_v2.html#product");
        });
    });
};
function courseInsert(){
    const form = document.getElementById("courseForm");
    document.getElementById('btn_course').addEventListener('click',function(e){
        let fdate = new FormData(form);
        e.preventDefault();
        xhr = new XMLHttpRequest();
        xhr.addEventListener('readystatechange',callStateC);
        let urlSource = '../addCourse';
        xhr.open('POST', urlSource, true); // if false --> 同步 | true: 非同步
        xhr.send(fdate);
    })
   
}
function productInsert(){
    const form = document.getElementById("productForm");
    document.getElementById('btn_product').addEventListener('click',function(e){
        let fdate = new FormData(form);
        e.preventDefault();
        xhr = new XMLHttpRequest();
        xhr.addEventListener('readystatechange',callStateP);
        let urlSource = '../Product/addNewProduct';
        xhr.open('POST', urlSource, true); // if false --> 同步 | true: 非同步
        xhr.send(fdate);
    })
}
function callStateC(){
    $(function(){           
        $("button.btn_modal_close").on("click", function(){
            $("div.overlay").fadeOut();
        });
    });
    if(xhr.readyState == 4){    //readyState: 0 -> 1 -> 2 -> 3 -> 4
        let t = document.getElementById("target");
        if(xhr.status == 200){
            let text = `${xhr.responseText}`
            t.innerText = text;
            if(text.match(/成功/) != null){
                $("div.overlay").cUploaded();
            }else{
                $("div.overlay").cUpfail();
            }
        }else{
            t.innerText = `${xhr.status}: ${xhr.statusText}`
        }
        $("div.overlay").fadeIn();
    }   
}
function callStateP(){
    $(function(){           
        $("button.btn_modal_close").on("click", function(){
            $("div.overlay").fadeOut();
        });
    });
    if(xhr.readyState == 4){    //readyState: 0 -> 1 -> 2 -> 3 -> 4
        let t = document.getElementById("target");
        if(xhr.status == 200){
            let text = `${xhr.responseText}`
            t.innerText = text;
            if(text.match(/成功/) != null){
                $("div.overlay").pUploaded();
            }else{
                $("div.overlay").pUpfail();
            }
        }else{
            t.innerText = `${xhr.status}: ${xhr.statusText}`
        }
        $("div.overlay").fadeIn();
    }   
}
function init(){  
    openWorker();
    productInsert();
    courseInsert();
    $('#customerTable').DataTable({
        "lengthMenu": [5, 10, 20, 50], //顯示筆數設定 預設為[10, 25, 50, 100]
        "pageLength":'5'
    });
    $('#courseTable').DataTable({
        "lengthMenu": [5, 10, 20, 50], //顯示筆數設定 預設為[10, 25, 50, 100]
        "pageLength":'5'
    });
    cupListener();  
}
$(document).ready(function () {
    getAccountInfo();
    getCustomers();
    getCourses();
})
window.addEventListener('load',init);