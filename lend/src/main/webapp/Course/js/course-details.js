window.addEventListener("load", function () {

    // function Uint8ToString(u8a) {
    //     var CHUNK_SZ = 0x8000;
    //     var c = [];
    //     for (var i = 0; i < u8a.length; i += CHUNK_SZ) {
    //         c.push(String.fromCharCode.apply(null, u8a.subarray(i, i + CHUNK_SZ)));
    //     }
    //     return c.join("");
    // }

    var info = JSON.parse(localStorage.getItem("current"));
    $("#courseImage").attr("src",`data:image/png;base64,${info.courseImage}`);

    $(".portfolio-content").find("h2").html(info.courseName);
    $(".portfolio-content").find(".desc p").html(info.courseDescribe);
    $(".portfolio-content").find("#coursePrice").next().find(".value").html(info.coursePrice);
    $(".portfolio-content").find("#minOfCourse").next().find(".value").html(info.minOfCourse);
    $(".portfolio-content").find("#maxOfCourse").next().find(".value").html(info.maxOfCourse);
    $(".portfolio-content").find("#courseLocation").next().find(".value").html(info.courseLocation);
    // console.log(courseId)
    // console.log(typeof courseId);
    // let data = {
    //     action: "courseDetails"
    // }
    // let fdata = JSON.stringify(data);
     

    // $.ajax({
    //     type: "post",
    //     url: "./Course/courseDetails",
    //     data: { "id": courseId },
    //     timeout: 0,
    //     success: function (res) {

    //         let u8 = new Uint8Array(res.courseImage)
    //         let b64encoded = btoa(Uint8ToString(u8));
            
    //        
    //        
    //        
    //        
    //        
    //        
    //        
    //         console.log(res.courseName);
    //         console.log(res);
    //     },
    //     error: function () {

    //     }
    // })
})