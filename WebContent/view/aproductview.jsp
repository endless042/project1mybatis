<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    


<meta charset="UTF-8">

<SCRIPT>
var RemainTime;
var StartOrNot;
function showCountdown(ExpireTime,startRemain){

	 var btn=document.getElementById('submitAuction');
	  function btn_on() {
	   
	   btn.disabled = false;
	  }
	  
	  function btn_off() {
	  
	   btn.disabled = 'disabled';
	  }
	  
	  
            var day, hour, min, sec, mod
            var CountText
           
            RemainTime = ExpireTime - 1;
            StartOrNot =startRemain;
            CountText = ""
            
           
            if (RemainTime >= 0){
            		btn_on();
            	
                        day = Math.floor(ExpireTime / (3600 * 24));
                        mod = ExpireTime % (24 * 3600);

                        hour = Math.floor(mod / 3600);
                        mod = mod % 3600;

                        min = Math.floor(mod / 60);

                        sec = mod % 60;

                        CountText = (day > 0) ? day + "일 " : "0일 ";
                        CountText = (hour > 0) ? CountText + hour + "시간 " : (CountText.length > 0) ? CountText + hour + "시간 " : CountText;
                        CountText = (min > 0) ? CountText + min + "분 " : (CountText.length > 0) ? CountText + min + "분 " : CountText;
                        CountText = CountText + sec + "초"
            
            	if(RemainTime <86000){
            		 window.document.all.Countdown.style.color='red';
            	}
            }

            if (( sec <= 0 && CountText == "0초"  ) || ( CountText == "" )){
                        CountText = "종료";
                        btn_off();
            }
            if (( startRemain==1 ) || ( CountText == "" )){
                CountText = "예정";
                btn_off();
    }
            

            window.document.all.Countdown.value = CountText;

            if (CountText != "종료"){
                        setTimeout("showCountdown(RemainTime,StartOrNot)", 1000);
            }
            
           
            
}

</SCRIPT>
  <style>
 .w3-sidebar a {font-family: "Roboto", sans-serif}
body,h1,h2,h3,h4,h5,h6,.w3-wide {font-family: "Montserrat", sans-serif;}
 pre {
font-family: "Montserrat", sans-serif;
}
 
 </style>

 
 <!-- Section -->
  <div class="w3-container w3-content w3-padding" style="max-width:850px" id="contact">

<div class="w3-cell-row w3-margin-bottom " >

<div class="w3-bar w3-white "><span class="w3-tag w3-medium w3-black w3-margin-top w3-margin-right">${aproduct.re}차</span>
<span class="w3-tag w3-xxlarge w3-white w3-margin-top w3-margin-right"><h3>${aproduct.title}</h4></span><hr></div>
 <!-- 사진쪽 div  -->

  <div class="w3-container w3-half w3-cell w3-padding">
  <div class="w3-display-container w3-text-white">
    <img src="<%= request.getContextPath() %>/fileSave/${aproduct.imgs}" style="width:100%; height:450px;">
   <span class="w3-tag w3-display-topleft"> <c:if test="${aproduct.state=='1'}">
    예정
    </c:if>
       <c:if test="${aproduct.state=='2'}">
    진행
    </c:if>
       <c:if test="${aproduct.state=='3'}">
    마감
    </c:if></span>

  </div></div>
  
<!-- 상세정보쪽 div-->
  <div class="w3-container w3-half w3-cell w3-cell-bottom w3-small" >
    <table  style="width: 90%;"><tr><td class="w3-border-bottom">
    
    <p><b>품명 : </b>${aproduct.name}<br>
    
    	<b>원산지 : </b>${aproduct.origin}<br>
    	<b>분류 : </b>${aproduct.category}<br>
    	<b>크기 : </b>약 ${aproduct.height} cm<br>
   </td></tr>
   
  
   <tr><td class="w3-border-bottom"> 
   
      <p><b>진행기간 : </b>${formatSdate} ~ ${formatEdate}</p>
 </td><tr><tr><td class="w3-border-bottom">
    <p><label><b>남은시간</b> </label><p/>
    
    <body onload="javascript:showCountdown('${timeCount}','${startRemain }');">
          <input type="text" class="w3-xlarge " name="Countdown" value="" style="border:0px; max-width:250px;" readonly>
</body><p/>
    

    
      <!--  <span class="w3-tag w3-padding w3-round-large w3-sand w3-center w3-border"><span class="w3-large">0</span></span>
        <span class="w3-tag w3-padding w3-round-large w3-sand w3-center w3-border"><span class="w3-large">3</span></span>
         <span class="w3-large"><b>:</b></span>
         <span class="w3-tag w3-padding w3-round-large w3-sand w3-center w3-border"><span class="w3-large">1</span></span>
          <span class="w3-tag w3-padding w3-round-large w3-sand w3-center w3-border"><span class="w3-large">4</span></span> 
            <span class="w3-large"><b>:</b></span> 
           <span class="w3-tag w3-padding w3-round-large w3-sand w3-center w3-border"><span class="w3-large">5</span></span>
            <span class="w3-tag w3-padding w3-round-large w3-sand w3-center w3-border"><span class="w3-large">8</span></span> 
   --><p>
</td></tr><tr><td class="w3-border-bottom">
<p>
<span class="w3-tag w3-large  w3-white   ">현재가 : ${aproduct.eprice} 원</span>
<span class="w3-tag w3-white w3-small">&#8725;&nbsp;&nbsp;시작가 : ${aproduct.sprice} 원</span></p>



</td>
</tr>
<tr><td>

<div class="w3-bar w3-white w3-section  ">

<button style="width: 33%;" onclick="document.getElementById('auctionSubmitModal').style.display='block'" id="submitAuction" disabled="disabled" class="w3-button w3-bar-item w3-green w3-right  w3-border-top w3-border-left w3-border-bottom" >입찰하기</button>
<button  style="width: 33%;" class="w3-button w3-bar-item  w3-white   w3-right w3-border-top w3-border-left w3-border-bottom " onclick="location.href='addCart?num=${aproduct.num}&pcode=a'">찜하기</button>
<button  style="width: 33%;"  class="w3-button w3-bar-item w3-white   w3-border-top w3-border-left w3-border-bottom w3-right "  >공유</button>

   
</div>
</td></tr>
<tr><td class="w3-border w3-padding">
<b>최근 입찰 내역:</b><br>
<c:if test="${historycount!=0}">
<c:forEach var="history" items="${historylist }">
${history.userid }님&nbsp;&nbsp;(${history.price }원)&nbsp;&nbsp;${history.adate }<br>
</c:forEach>
</c:if>
<c:if test="${historycount==0}">
입찰 내역이 없습니다.
</c:if>
</td></tr>
</table>

</div>



  
  </div>
  
 <!--   입찰 모달   -->
  
  <div id="auctionSubmitModal" class="w3-modal" >
    <div class="w3-modal-content w3-small" style="max-width:450px;">
      <header class="w3-container w3-black"> 
        <span onclick="document.getElementById('auctionSubmitModal').style.display='none'" 
        class="w3-button w3-display-topright">&times;</span>
         <h5>입찰가를 입력하세요</h5>
      </header>
     <br><div class="w3-padding-32 w3-center w3-margin-left w3-margin-right">
      
      <form action="auctionSubmit?num=${ num}&pageNum=${ pageNum}&select=auction&part=content" method="post">
<input required="required" class="w3-input w3-border w3-margin-top" type="number"  placeholder="가격 입력" name="price">
<br>
<input type="hidden" name="num" value="${ num}">
<input type="hidden" name="pageNum" value="${ pageNum}">

<button class="w3-button w3-black" type="submit" >보내기</button>
</form>
</div>
      
    </div>
  </div>
 <!--   입찰모달끝  -->
  
  
<hr>

<div class="w3-bar w3-border w3-small" >
  <a href="acontent?part=content&pageNum=${pageNum }&num=${num}" style="width:25%" class="w3-bar-item w3-button <%=request.getParameter("part").equals("content")?"w3-green":"" %> w3-border-right">정보</a>
  <a href="acontent?part=qna&pageNum=${pageNum }&num=${num}" style="width:25%" class="w3-bar-item w3-button w3-hide-small  w3-border-right <%=request.getParameter("part").equals("qna")?"w3-green":"" %> ">문의</a>
  <a href="acontent?part=review&pageNum=${pageNum }&num=${num}" style="width:25%" class="w3-bar-item w3-button w3-hide-small  w3-border-right  <%=request.getParameter("part").equals("review")?"w3-green":"" %> ">후기</a>
  <a href="acontent?part=reply&pageNum=${pageNum }&num=${num}" style="width:25%" class="w3-bar-item w3-button w3-hide-small  <%=request.getParameter("part").equals("reply")?"w3-green":"" %> ">의견</a>
  <a href="javascript:void(0)" class="w3-bar-item w3-button w3-right w3-hide-large w3-hide-medium" onclick="myFunction()">&#9776;</a>
</div>

<div id="demo" class="w3-bar-block w3-black w3-hide w3-hide-large w3-hide-medium">
  <a href="acontent?part=qna&pageNum=${pageNum }&num=${num}" class="w3-bar-item w3-button">문의</a>
  <a href="acontent?part=review&pageNum=${pageNum }&num=${num}" class="w3-bar-item w3-button">후기</a>
  <a href="acontent?part=reply&pageNum=${pageNum }&num=${num}&pronum=a${num}" class="w3-bar-item w3-button">의견</a>
</div>

<c:if test="${part=='content'}">
  <div class="w3-container w3-section" id="content">
  <p><font color="grey" class="w3-small">등록일시 : ${aproduct.rdate }</font></p>
  <pre><p>${aproduct.content }</p></pre>
 
  </div>
  </c:if>
 
<c:if test="${part=='qna'}">
  <div class="w3-container w3-section" id="qna">
   <jsp:include page="/list.jsp">
  <jsp:param value="2" name="boardid"/>
  </jsp:include>
  </div>
    </c:if>
 <c:if test="${part=='review'}">
   <div class="w3-container w3-section" id="review">
 <jsp:include page="/list.jsp">
  <jsp:param value="3" name="boardid"/>
  </jsp:include>
  </div>
    </c:if>
 
  <c:if test="${part=='reply'}">
   <div class="w3-container w3-section" id="reply">
   <jsp:include page="/reply/list.jsp">
   <jsp:param value="a${aproduct.num }" name="pronum"/>
   </jsp:include>
  </div>
    </c:if>

  

</div>


 


 
  <!-- End page content -->
 

<script>
function myFunction() {
    var x = document.getElementById("demo");
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
    } else { 
        x.className = x.className.replace(" w3-show", "");
    }
}
</script>

 
