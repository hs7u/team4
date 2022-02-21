<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="web.Course.vo.*" %>

      <% // CourseVO courseVO=(CourseVO) request.getAttribute("courseVO"); %>

        <html>

        <head>
          <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
          <title>新增課程資料 - addCourse.jsp</title>
          <link rel="stylesheet" href="css/addCourse.css">
          <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Course/css/addCourse.css" />
          <link rel="stylesheet"
            href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">

          <style>
            table#table-1 {
              background-color: #CCCCFF;
              border: 2px solid black;
              text-align: center;
            }

            table#table-1 h4 {
              color: red;
              display: block;
              margin-bottom: 1px;

            }

            h4 {
              color: blue;
              display: inline;
            }

            table {
              width: 880px;
              margin-top: 0.1px;
              margin-bottom: 1px;
            }

            table,
            th,
            td {
              border: 0px solid #CCCCFF;


            }

            th,
            td {
              margin: auto;
              padding: 1px;
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
              background-color: rgb(197, 238, 169);
            }
          </style>

        </head>

        <body bgcolor='white'>
          <input type="checkbox" id="nav-toggle">
          <div class="sidebar">
            <div class="sidebar-brand">
              <h2><span class="lab la-accusoft"></span><span>studio4art</span></h2>
            </div>
            <div class="sidebar-menu">
              <ul>
                <li>
                  <a href=""><span class="las la-igloo"></span>
                    <span>Dashboard</span></a>
                </li>
                <li>
                  <a href=""><span class="las la-users"></span>
                    <span>客戶管理</span></a>
                </li>
                <li>
                  <a href="" class="active"><span class="las la-clipboard-list"></span>
                    <span>課程管理</span></a>
                </li>
                <li>
                  <a href=""><span class="las la-shopping-bag"></span>
                    <span>訂單列表</span></a>
                </li>
                <li>
                  <a href=""><span class="las la-receipt"></span>
                    <span>商品管理</span></a>
                </li>
                <li>
                  <a href=""><span class="las la-user-circle"></span>
                    <span>帳號管理</span></a>
                </li>
                <li>
                  <a href=""><span class="las la-clipboard-list"></span>
                    <span>新增商品</span></a>
                </li>
              </ul>
            </div>
          </div>

          <div class="main-content">
            <header>
              <h2>
                <label for="nav-toggle">
                  <span class="las la-bars"></span>
                </label>
                新增課程
              </h2>
              <div class="search-wrapper">
                <span class="las la-search"></span>
                <input type="search" placeholder="Search here">
              </div>
              <div class="user-wrapper">
                <img src="<%=request.getContextPath()%>/Course/image/cat.jpg" width="40px" height="40px" alt="">
                <div>
                  <h4>doge</h4>
                  <small>toor</small>
                </div>
              </div>
            </header>
            <main>

              <h3>新增課程資料</h3>

              <%-- 錯誤表列 --%>
                <c:if test="${not empty errorMsgs}">
                  <font style="color: red">請修正以下錯誤:</font>
                  <ul>
                    <c:forEach var="message" items="${errorMsgs}">
                      <li style="color: red">${message}</li>
                    </c:forEach>
                  </ul>
                </c:if>

                <form name="form1" method="POST" action="<%=request.getContextPath() %>/Course/addCourse"
                  enctype="multipart/form-data">
                  <table>
                    <tr>
                      <td>課程名稱</td>
                      <td><input type="TEXT" name="courseName" size="45" placeholder="Ex:/ 水彩繪杯墊"></td>
                    </tr>
                    <tr>
                      <td>課程描述</td>
                      <td><input type="TEXT" name="courseDescribe" size="45" placeholder="Ex:/ 可學習自行繪製杯墊" /></td>
                    </tr>
                    <tr>
                      <td>課程價格</td>
                      <td><input type="TEXT" name="coursePrice" size="45" placeholder="Ex:/ 1500" /></td>
                    </tr>
                    <tr>
                      <td>課程圖片</td>
                      <td><input type="file" name="courseImage" /></td>
                    </tr>
                    <tr>
                      <td>開課人數</td>
                      <td><input type="TEXT" name="minOfCourse" size="45" placeholder="Ex:/ 10" /></td>
                    </tr>
                    <tr>
                    <tr>
                      <td>額滿人數</td>
                      <td><input type="TEXT" name="maxOfCourse" size="45" placeholder="Ex:/ 30" /></td>
                    </tr>
                    <tr>
                      <td>上課地點</td>
                      <td><input type="TEXT" name="courseLocation" size="45" placeholder="Ex:/ 台南市新營區民治路36號" /></td>
                    </tr>

                    <!-- <tr>
                      <td>課程日期</td>
                      <td><input type="date" name="courseDate"></td>
                    </tr>
                    <tr>
                      <td>開始報名</td>
                      <td><input type="date" name="signUpStartdate"></td>
                    </tr>
                    <tr>
                      <td>截止報名</td>
                      <td><input type="date" name="signUpDeadline"></td>
                    </tr> -->


                  </table>
                  <br> <input type="hidden" name="action" value="insert">
                  <input type="submit" id="insert" class="las" value="送出新增">

                </form>
            </main>

            <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
            <!-- <script>
      $(document).ready(function(){
        $("#insert").click(function(){

          $.ajax({
            type: "POST",
            url: "/course.do",
            data: $("#myForm").serialize(),
            dataType: "json",
            success:function(response){
              alert("新增成功");
            },
            error: function (xhr, ajaxOptions, thrownError) {
                        alert(xhr.status + "\n" + thrownError);
                    }

          });

        });
      });
    </script>  -->
        </body>

        </html>