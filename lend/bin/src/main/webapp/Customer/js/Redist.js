function dofirst(){
    const form = document.getElementById("myForm");
    document.getElementById('btn_sub').addEventListener('click',function(e){
        let fdate = new FormData(form);
        e.preventDefault();
        xhr = new XMLHttpRequest();
        xhr.addEventListener('readystatechange',callState);
        let urlSource = '../Customer/regist';
        xhr.open('POST', urlSource, true); // if false --> 同步 | true: 非同步
        xhr.send(fdate);
    })
   
}
function callState(){
    $.fn.fail = function(){           
        this.fadeIn();
        $("button.btn_modal_close").on("click", function(){
            $("div.overlay").fadeOut();
        });
    };
    $.fn.success = function(){ 
        this.fadeIn();          
        $("button.btn_modal_close").on("click", function(){
            $("div.overlay").fadeOut("done", function(){
                window.location.assign("./index.html");
            });
        });
    };
    if(xhr.readyState == 4){    //readyState: 0 -> 1 -> 2 -> 3 -> 4
        let t = document.getElementById("target");
        if(xhr.status == 200){
            let text = `${xhr.responseText}`;
            t.innerText = text;
            if(text.match(/Success/) != null){
                $("div.overlay").success();
            }else{
                $("div.overlay").fail();
            }
        }else{
            t.innerText = `${xhr.status}: ${xhr.statusText}`;                    
        }
    }   
}
window.addEventListener('load',dofirst);