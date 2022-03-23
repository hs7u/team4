<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="web.Course.vo.*"%>
<%@ page import="java.util.*"%>
<%
	CourseVO courseVo = (CourseVO)request.getAttribute("currentCourse");
%>
<title>課程資料修改 - updateCourse.jsp</title>

<link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">

<style>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display-swap');
* {
	font-family: 'Poppins', sans-serif;
	font-size: 12px;
}

table {
	width: 830px;
	padding: 1.2rem .4rem;
	border-radius: 10px;
	box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.2);
}

table, th, td {
	border: 0px solid #CCCCFF;
}

th, td {
	margin: 0;
	padding: 1.2px;
}

h3 {
	font-size: 18px;
}

label {
	height: 100%;
	padding: .5rem;
	border: none;
	outline: none;
}

input {
	border-radius: 15px;
	padding: .5rem;
	border: none;
	outline: none;
}

input.las:hover {
	cursor: pointer;
	background-color: #666666;
	color: white;
}

.line {
	width: 20rem;
}

.lineup {
	margin-left: 1rem;
}

.secline {
	margin-left: 2rem;
}

.hint {
	width: 9rem;
}

.box {
	display: flex;
}

.view {
	max-width: 500px;
}

.preview {
	background-color: transparent;
	width: 400px;
	height: 100%;
	position: relative;
	display: inline-block;
}

.btn_sub {
	width: 5rem;
}

button {
	border: none;
	text-align: center;
	height: 2rem;
	width: 5rem;
	cursor: pointer;
	border-radius: 15px;
}
button.btn_modal_close{
    height: 2.5rem;
    width: 10rem;
    cursor: pointer;
    border-radius: 15px;
    margin: 0 auto;
    display: block;
}
div.overlay{
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100vh;
    background-color: hsla(0, 0%, 0%, .5);
    
    display: none;
}

/* 元素 article 置中及基本樣式 */
div.overlay > article{
    background-color: white;
    width: 90%;
    max-width: 800px;
    border-radius: 10px;
    box-shadow: 0 0 10px rgb(255, 0, 0);
    padding: 10px;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
}
.centerControl{
    display: flex;
    align-items: center;
    justify-content: center;
}
</style>

</head>
<body bgcolor='#f1f5f9'>
	<main class="box">
		<div class="view">
            <!-- <%=request.getContextPath()%>/Course/updateCourseServlet" enctype="multipart/form-data -->
			<FORM METHOD="post" ACTION="" id="myForm">
				<table>
					<tr>
						<td class="hint">課程名稱</td>
						<td>
							<input type="TEXT" class="line" name="courseName" size="45" value="<%=(courseVo.getCourseName() == null) ? "default" : courseVo.getCourseName()%>" />
						</td>
					</tr>
					<tr>
						<td class="hint">課程描述</td>
						<td>
							<input type="TEXT" class="line" name="courseDescribe" size="45" value="<%=(courseVo.getCourseDescribe() == null) ? "default" : courseVo.getCourseDescribe()%>" />
						</td>
					</tr>
					<tr>
						<td class="hint">課程價格</td>
						<td>
							<input type="TEXT" class="line" name="coursePrice" size="45" value="<%=(courseVo.getCoursePrice() == null) ? "0" : courseVo.getCoursePrice()%>" />
						</td>
					</tr>
					<tr>
						<td class="hint">課程圖片</td>
						<td>
							<input type="file" name="courseImage" id="" value="<%=(courseVo.getCourseImage() == null) ? "0" : courseVo.getCourseImage()%>" />
						</td>
					</tr>

                    <tr>
                        <td class="hint">開課人數</td>
                        <td>
                            <input type="TEXT" name="minOfCourse" size="45" value="<%=(courseVo.getMinOfCourse() == null) ? "0" : courseVo.getMinOfCourse()%>"/>
                        </td>
                    </tr>

                    <tr>
                        <td class="hint">額滿人數</td>
                        <td>
                            <input type="TEXT" name="maxOfCourse" size="45" value="<%=(courseVo.getMaxOfCourse() == null) ? "0" : courseVo.getMaxOfCourse()%>"/>
                        </td>
                    </tr>

                    <tr>
                        <td class="hint">上課地點</td>
                        <td>
                            <input type="TEXT" name="courseLocation" size="45" value="<%=(courseVo.getCourseLocation() == null) ? "0" : courseVo.getCourseLocation()%>"/>
                        </td>
                    </tr>





					<tr>
						<td class="hint">課程上架狀態</td>
						<td>
							<label for="course_status">
								<input type="radio" class="" name="courseStatus" size="45" value="1" checked="<%=(courseVo.getCourseStatus() == 1) ? true : false%>" />
								上架
							</label>
							<label for="course_status" class="lineup">
								<input type="radio" class="" name="courseStatus" size="45" value="0" checked="<%=(courseVo.getCourseStatus() == 0) ? true : false%>" />
								下架
							</label>
						</td>
					</tr>
					<tr>
						<td>
							<br>
							<input type="hidden" name="course_id" value="<%=courseVo.getCourseId()%>">
							<input type="hidden" name="action" value="update">
							<input type="button" class="las" id="btn_sub" value="送出修改">
							<br>
						</td>
						<td>
							<br>
							<input type="button" class="button_active las" value="取消修改" onclick="location.href='./listAllProduct_test.jsp'" />
							<br>
						</td>
					</tr>
				</table>
			</FORM>
		</div>

		<div class="preview">
			<h3>原課程圖預覽</h3>	
			<img src="data:image/png;base64,<%=Base64.getEncoder().encodeToString(courseVo.getCourseImage())%>" width="300px" height="100%" />
		</div>
	
	</main>
	<div class="overlay" style="border: none">
		<article>
			<p id="target" class="centerControl"></p>
			<button type="button" class="btn_modal_close">關閉</button>
		</article>
	</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	function dofirst(){
		const form = document.getElementById("myForm");
		document.getElementById('btn_sub').addEventListener('click',function(e){
			let fdate = new FormData(form);
			e.preventDefault();
			xhr = new XMLHttpRequest();
			xhr.addEventListener('readystatechange',callState);
			let urlSource = './updateCourse';
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
					window.location.assign("./listAllCourse.jsp");
				});
			});
		};
		if(xhr.readyState == 4){    //readyState: 0 -> 1 -> 2 -> 3 -> 4
			let t = document.getElementById("target");
			if(xhr.status == 200){
				let text = xhr.responseText;
				t.innerHTML = text;
				if(text.match(/success/) != null){
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
</script>
</html>