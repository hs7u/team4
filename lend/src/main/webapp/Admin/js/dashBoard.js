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
          console.log(res.data);
          
         
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
          console.log(res.data);
          
         
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
            window.location.assign("./AdminDashBoard_v2.html#addProduct");
        });
    });
};
function courseInsert(){
    const form = document.getElementById("courseForm");
    document.getElementById('btn_course').addEventListener('click',function(e){
        let fdate = new FormData(form);
        e.preventDefault();
        xhr = new XMLHttpRequest();
        xhr.addEventListener('readystatechange',callState);
        let urlSource = '../lend/Course/addNewCourse';
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
        xhr.addEventListener('readystatechange',callState);
        let urlSource = '../Product/addNewProduct';
        xhr.open('POST', urlSource, true); // if false --> 同步 | true: 非同步
        xhr.send(fdate);
    })
   
}
function callState(){
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
    openWorker();
    productInsert();
    courseInsert();
}
window.addEventListener('load',init);