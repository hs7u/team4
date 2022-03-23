$.fn.alloy = function(){           
    this.fadeIn();
    $("button.btn_modal_close").on("click", function(){
        $("div.overlay").fadeOut("done", function(){
            window.location.assign("./login.html");
        });
    });
};
$.fn.denied = function(){ 
    this.fadeIn();          
    $("button.btn_modal_close").on("click", function(){
        $("div.overlay").fadeOut("done", function(){
            window.location.assign("./Registration.html");
        });
    });
};
$.fn.exeist = function(){ 
    this.fadeIn();          
    $("button.btn_modal_close").on("click", function(){
        $("div.overlay").fadeOut("done", function(){
            window.location.assign("./AdminDashBoard_v2.html");
        });
    });
};
function dofirst(){
    const form = document.getElementById("myForm");
    document.getElementById('btn_sub').addEventListener('click',function(e){
        let data = document.querySelectorAll("#myForm > input");
        let form_data = {
            adminAccount: data[0].value,
            adminPassword: data[1].value,
        }
        let fdate = JSON.stringify(form_data);
        axios({
              method: "post",
              url: "../Admin/regist",
              data: fdate,
              headers: { "Content-Type": "application/json" },
            }).then(res=>{
                let t = document.getElementById("target");
                let text = res.data;
                t.innerText = text;
                if(text.match(/Success/) != null){
                    $("div.overlay").alloy();
                }else if(text.match(/Fail/) != null){
                    $("div.overlay").denied();
                }else{
                    $("div.overlay").exeist();
                }
            })
    })
}
window.addEventListener('load',dofirst);