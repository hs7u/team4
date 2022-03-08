function init(){
    $("button.btn_regist").on("click", function(e){
        let regist = {};
        regist.customerEmail    = $("input#registEmail").val();
        regist.customerPassword = $("input#registPassword").val();
        regist.customerName     = $("input#registName").val();
        regist.customerPhone    = $("input#registPhone").val();
        regist.customerAddress  = $("input#registAddress").val();
        regist.customerBirthday = $("input#registBitrhday").val();
        regist.customerGender   = $("input[name = customerGender]:checked").val();
        axios({
            method: "post",
            url: "./Customer/regist",
            data: JSON.stringify(regist),
            headers: { "Content-Type": "application/json" },
          }).then(res=>{
              let check = res.data;
              if(check.match(/success/) != null){
                console.log(check);
              }
          })
    });
    $("button.btn_login").on("click", function(e){
        let login = {};
        login.customerEmail     = $("input#loginEmail").val();
        login.customerPassword  = $("input#loginPassword").val();
        axios({
            method: "post",
            url: "./Customer/login",
            data: JSON.stringify(login),
            headers: { "Content-Type": "application/json" },
          }).then(res=>{
              let check = res.data;
              if(check.match(/Success/) != null){
                window.location.href = "./my-account.html";
              }else if (check.match(/login/) != null){
              	window.location.href = "./my-account.html";
              }
          })
    })
}



window.addEventListener("load", init);