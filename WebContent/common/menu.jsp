<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String select=request.getParameter("select");
    	
      
       
    String loginId=(String)session.getAttribute("loginId");
    String levelCk=(String)session.getAttribute("levelCk");
    String userName=(String)session.getAttribute("userName");
    	boolean login = (loginId==null?false:true);
    %>
    
    
<html>
<title>Plant shop</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.w3-sidebar a {font-family: "Roboto", sans-serif}
body,h1,h2,h3,h4,h5,h6,.w3-wide {font-family: "Montserrat", sans-serif;}

a {
text-decoration: none;
}



</style>


<body class="w3-content" style="max-width:1200px">

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-bar-block w3-white w3-collapse w3-top" style="z-index:3;width:250px" id="mySidebar">
  <div class="w3-container w3-display-container w3-padding-16 w3-white ">
    <i onclick="w3_close()" class="fa fa-remove w3-hide-large w3-button w3-display-topright"></i>
  <div onclick="location.href='<%=request.getContextPath()%>/page/main';" > <h3 class="w3-wide" style="cursor:pointer"><b>&nbsp;&nbsp;GLOBAL<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; PLANT</b></h3></div>
  </div>
  <div class="w3-padding-64 w3-medium w3-text-grey " style="font-weight:bold">
     <a href="<%= request.getContextPath() %>/page/main" class="w3-bar-item w3-button" >메인</a>
     <a href="<%= request.getContextPath() %>/page/auction?select=auction" class="w3-bar-item w3-button
      <%= (select!=null&&select.equals("auction"))?"w3-light-grey":"" %>" >경매</a>
      <a href="<%= request.getContextPath() %>/page/gpurchase?select=gpurchase" class="w3-bar-item w3-button 
      <%= (select!=null&&select.equals("gpurchase"))?"w3-light-grey":"" %>" >공동구매</a>
      <a href="<%= request.getContextPath() %>/page/survey?select=survey" class="w3-bar-item w3-button 
      <%= (select!=null&&select.equals("survey"))?"w3-light-grey":"" %>" >수입제안</a>
   

   
       <a onclick="myAccFunc('board')" href="javascript:void(0)" class="w3-button w3-block w3-white w3-left-align" id="<%=(request.getParameter("bdck")!=null)?"boardmenu":"off" %>">
      게시판 <i class="fa fa-caret-down"></i>
    </a>
    <div id="board" class="w3-bar-block w3-hide w3-padding-large w3-medium">
      <a href="<%= request.getContextPath() %>/board/list?select=notice" class="w3-bar-item w3-button <%= (select!=null&&select.equals("notice"))?"w3-light-grey":"" %>">소식</a>
      <a href="<%= request.getContextPath() %>/board/list" class="w3-bar-item w3-button <%= (select!=null&&select.equals("review"))?"w3-light-grey":"" %>">후기</a>
      <a href="<%= request.getContextPath() %>/board/list?boardid=2&select=qna" class="w3-bar-item w3-button <%= (select!=null&&select.equals("qna"))?"w3-light-grey":"" %>">문의</a>
      <a href="<%= request.getContextPath() %>/board/list" class="w3-bar-item w3-button <%= (select!=null&&select.equals("community"))?"w3-light-grey":"" %>">커뮤니티</a>
   
    </div>
    
    


    
   
  </div>
  <div class="w3-small">
 <% if (!login){%>
  <a href="javascript:void(0)" class="w3-bar-item w3-button w3-padding" onclick="document.getElementById('login').style.display='block'">로그인</a>
   <a href="<%= request.getContextPath() %>/user/join" class="w3-bar-item w3-button w3-padding">회원가입</a>  <%}else{
   
   	if(levelCk.equals("0")){%> <a href="<%= request.getContextPath() %>/adm/userlist?select=auserlist" class="w3-bar-item w3-button w3-padding">관리자 페이지</a>
	  <%}else{ %>
	    <a href="<%= request.getContextPath() %>/page/mypage" class="w3-bar-item w3-button w3-padding">마이페이지</a><%}%>
	   <a href="../user/logoutPro" class="w3-bar-item w3-button w3-padding">로그아웃</a>
	  <%  }%>
   
      
  <a href="<%= request.getContextPath() %>/page/contact" class="w3-bar-item w3-button w3-padding">ABOUT US</a> 
 <br><br>
 
 <!-- 최근 본 상품 -->
 <%-- <table class="w3-bar-item w3-padding"><tr height="40px"><th>최근 본 상품</th>
 <th>
 <a href="#" style="text-decoration: none;">◀</a>&nbsp; <a href="#" style="text-decoration: none;">▶</a>&nbsp;&nbsp;</th>
 </tr>
 <tr></tr>
 <tr>
 <td colspan="2"> <img src="<%= request.getContextPath() %>/images/sample.PNG" style="width:40%">&nbsp;
 <img src="<%= request.getContextPath() %>/images/sample.PNG" style="width:40%"></td><tr>
  <tr>
 <td colspan="2"> <img src="<%= request.getContextPath() %>/images/sample.PNG" style="width:40%">&nbsp;
 <img src="<%= request.getContextPath() %>/images/sample.PNG" style="width:40%"></td><tr>
 </table> --%>
 </div>
 <!--  -->
</nav>

<!-- Top menu on small screens -->
<header class="w3-bar w3-top w3-hide-large w3-black w3-xlarge">
  <div class="w3-bar-item w3-padding-24 w3-wide">GLOBAL PLANT</div>
  <a href="javascript:void(0)" class="w3-bar-item w3-button w3-padding-24 w3-right" onclick="w3_open()"><i class="fa fa-bars"></i></a>
</header>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>




<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:250px">

  <!-- Push down content on small screens -->
  <div class="w3-hide-large" style="margin-top:83px"></div>
  

  <!-- Top header -->
  <header class="w3-container w3-xlarge">
    <p class="w3-left" id="title">${title}</p>
    <p class="w3-right "><font class="w3-small "><%if(login){%><%=userName %>님 환영합니다.&nbsp;&nbsp;<%} %></font>
      <i class="fa fa-heart w3-margin-right" style="color:red;cursor:pointer;" onclick="location.href='<%=request.getContextPath()%>/page/cart'" style="cursor:pointer"></i>
      <i class="fa fa-search" onclick="document.getElementById('search').style.display='block'" style="cursor:pointer"></i>
    </p>
    
    <!-- 검색 모달 -->
    
    <div id="search" class="w3-modal">
    <div class="w3-modal-content w3-card-4  w3-animate-zoom " style="max-width:600px">
      <header class="w3-container w3-black"> 
        <span onclick="document.getElementById('search').style.display='none'" 
        class="w3-button w3-display-topright w3-medium">&times;</span>
        <h5>검색</h5>
      </header>
      <div class="w3-container w3-white">
       <span class="w3-center w3-medium w3-margin-top"><p>식물 이름을 입력하세요</p></span>
        <form><input class="w3-input w3-center w3-border w3-medium w3-margin-top w3-margin-bottom w3-padding" name="keyword" type="text" style="display: block; width: 100%;">
       <div class="w3-center"><button class="w3-button w3-black w3-small">검색</button></form></div>
        
      </div>
      <footer class="w3-container w3-white">
        <span class="w3-right w3-small"><p>자세히 찾아보기</p></span>
      </footer>
    </div>
  </div>
  
  
  </header>
<!-- login Modal -->


 <div id="login" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom w3-small" style="max-width:600px">

      <div class="w3-center"><br>
        <span onclick="document.getElementById('login').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
        
      </div>

      <form class="w3-container" method="post" action="../user/loginPro">
        <div class="w3-section">
          <label><b>ID</b></label>
          <input class="w3-input w3-border w3-margin-bottom" type="text" style="display: block; width: 100%;" placeholder="아이디를 입력하세요." name="tryid" required>
          <label><b>PASSWORD</b></label>
          <input class="w3-input w3-border" style="display: block; width: 100%;" type="password" placeholder="비밀번호를 입력하세요." name="trypwd" required>
          <button class="w3-button w3-block w3-black w3-section w3-padding" type="submit">로그인</button>
          <input class="w3-check w3-margin-top" type="checkbox" checked="checked">로그인 기억하기
        </div>
      </form>

      <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
        <button onclick="document.getElementById('login').style.display='none'" type="button" class="w3-button w3-black">취소</button>
        <span class="w3-right w3-padding w3-hide-small"><a href="../user/join">회원가입</a>&nbsp;&nbsp;&nbsp; <a href="#">비밀번호</a>를 잊으셨나요?</span>
      </div>

    </div>
  </div>

<script>
// Accordion 
function myAccFunc(id) {
    var x = document.getElementById(id);
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
    } else {
        x.className = x.className.replace(" w3-show", "");
    }
}

document.getElementById("boardmenu").click();

// Script to open and close sidebar
function w3_open() {
    document.getElementById("mySidebar").style.display = "block";
    document.getElementById("myOverlay").style.display = "block";
}
 
function w3_close() {
    document.getElementById("mySidebar").style.display = "none";
    document.getElementById("myOverlay").style.display = "none";
}
</script>
</body>
</html>
