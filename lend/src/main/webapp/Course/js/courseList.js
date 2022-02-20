window.addEventListener("load",function(){

    
function Uint8ToString(u8a){
        var CHUNK_SZ = 0x8000;
        var c = [];
        for (var i=0; i < u8a.length; i+=CHUNK_SZ) {
          c.push(String.fromCharCode.apply(null, u8a.subarray(i, i+CHUNK_SZ)));
        }
        return c.join("");
    }
    let data = {
        action: "courseList"
    }
    let fdata = JSON.stringify(data);
    // console.log(fdata);
    $.ajax({
        type:"post",
        url:"../Admin/dashBoard",
        data: fdata,
        timeout:0,
        statusCode: {                 // 狀態碼
            200: function (res) {
            },
            404: function (res) {
            },
            500: function (res) {
            }
        },
        success: function(res){      // request 成功取得回應後執行
            // console.log(res);
            // console.log(Array.isArray(res));
            // console.log(typeof res );
            let response = JSON.parse(res);
            // console.log(response);
            // console.log(typeof response);
            // console.log(response[0]["courseName"])
            response.forEach(element => {
            let u8 = new Uint8Array(element.courseImage)
            // console.log(element);
            let b64encoded = btoa(Uint8ToString(u8));
            let showData = `<div class="col learts-mb-30">
                                <div class="portfolio">
                                    <div class="thumbnail"><img src="data:image/png;base64,${b64encoded}" /></div>
                                    <div class="content">
                                        <h4 class="title"><a href="course-details.html">${element.courseName}</a></h4>
                                            <div class="desc">
                                            <p>${element.courseDescribe}</p>
                                        </div>
                                        <div class="link"><a href="course-details.html">Read more</a></div>
                                    </div>
                                </div>
                            </div>`;
            $(showData).appendTo("#show");
            });
        },
        error: function(xhr){         // request 發生錯誤的話執行
        // console.log(xhr);
        }
    })
})

