$.fn.alloy = function(){           
    this.fadeIn();
    $("button.btn_modal_close").on("click", function(){
        $("div.overlay").fadeOut("done", function(){
            window.location.assign("./AdminDashBoard_v2.html");
        });
    });
};
$.fn.denied = function(){ 
    this.fadeIn();          
    $("button.btn_modal_close").on("click", function(){
        $("div.overlay").fadeOut("done", function(){
            window.location.reload();
        });
    });
};
function dofirst(){
    document.getElementById('regist').addEventListener('click', function(){
        window.location.assign("./Registration.html");
    })
    document.getElementById('btn_sub').addEventListener('click',function(e){
        let data = document.querySelectorAll("#myForm > input");
        let form_data = {
            adminAccount: data[0].value,
            adminPassword: data[1].value,
        }
        let fdate = JSON.stringify(form_data);
        axios({
              method: "post",
              url: "../Admin/login",
              data: fdate,
              headers: { "Content-Type": "application/json" },
            }).then(res=>{
                let t = document.getElementById("target");
                let text = res.data;
                t.innerText = text;
                if(text.match(/Success/) != null || text.match(/login/) != null){
                    $("div.overlay").alloy();
                }else{
                    $("div.overlay").denied();
                }
            })
    })
}
window.addEventListener('load',dofirst);