function subData() {
    let data = document.querySelectorAll("#myForm > input");
    let form_data = {
            customerEmail: data[0].value,
            customerPassword: data[1].value,
        }
    return JSON.stringify(form_data);
}
function dofirst(){
    const form = document.getElementById("myForm");
    document.getElementById('btn_sub').addEventListener('click',function(e){
        let fdate = subData();
        console.log(fdate);
        e.preventDefault();
        xhr = new XMLHttpRequest();
        xhr.addEventListener('readystatechange',callState);
        let urlSource = '../Customer/login';
        xhr.open('POST', urlSource, true); // if false --> 同步 | true: 非同步
        xhr.send(fdate);
    })
   
}
function callState(){
    $.fn.alloy = function(){           
        this.fadeIn();
        $("button.btn_modal_close").on("click", function(){
            $("div.overlay").fadeOut("done", function(){
                window.location.assign("./index.html");
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
    if(xhr.readyState == 4){    //readyState: 0 -> 1 -> 2 -> 3 -> 4
        let t = document.getElementById("target");
        if(xhr.status == 200){
            let text = `${xhr.responseText}`;
            t.innerText = text;
            if(text.match(/Success/) != null){
                $("div.overlay").alloy();
            
            }else{
                $("div.overlay").denied();
            }
            
        }else{
            t.innerText = `${xhr.status}: ${xhr.statusText}`;                   
        }
    }   
}
window.addEventListener('load',dofirst);