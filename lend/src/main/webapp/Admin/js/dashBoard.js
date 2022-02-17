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
                            <td><input type="submit" class="las" value="修改"></td>
                            <td><input type="submit" class="las" value="刪除"></td>
                        </tr>`;
            $(".dynamicsC").after();
            $(table).appendTo("tbody.dynamicsC");
        } 
      })
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
          for(let i = 0 ; i< 3; i++){
            let add = `<div class="info">
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
            $(add).appendTo("div.newCustomer");
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
    getAccountInfo();
    getCustomers();
    getCourses();
    openWorker();
    productInsert();
    courseInsert();
}
window.addEventListener('load',init);