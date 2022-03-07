window.addEventListener("load", function () {

    function Uint8ToString(u8a) {
        var CHUNK_SZ = 0x8000;
        var c = [];
        for (var i = 0; i < u8a.length; i += CHUNK_SZ) {
            c.push(String.fromCharCode.apply(null, u8a.subarray(i, i + CHUNK_SZ)));
        }
        return c.join("");
    }

    let courseId = JSON.parse(localStorage.getItem("courseId"));
    // console.log(courseId)
    // console.log(typeof courseId);
    // let data = {
    //     action: "courseDetails"
    // }
    // let fdata = JSON.stringify(data);

     

    $.ajax({
        type: "post",
        url: "./Course/courseDetails",
        data: { "id": courseId },
        timeout: 0,
        success: function (res) {

            let u8 = new Uint8Array(res.courseImage)
            let b64encoded = btoa(Uint8ToString(u8));
            
            $(".portfolio-image").find("img").attr("src",`data:image/png;base64,${b64encoded}`);

            $(".portfolio-content").find("h2").html(res.courseName);
            $(".portfolio-content").find(".desc p").html(res.courseDescribe);
            $(".portfolio-content").find("#coursePrice").next().find(".value").html(res.coursePrice);
            $(".portfolio-content").find("#minOfCourse").next().find(".value").html(res.minOfCourse);
            $(".portfolio-content").find("#maxOfCourse").next().find(".value").html(res.maxOfCourse);
            $(".portfolio-content").find("#courseLocation").next().find(".value").html(res.courseLocation);
            console.log(res.courseName);
            console.log(res);
        },
        error: function () {

        }
    })
})