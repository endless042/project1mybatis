<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<title>Plant shop</title>
<meta charset="UTF-8">


<SCRIPT>
var RemainTime;
var StartOrNot;
function showCountdown(ExpireTime,startRemain){

	 var btn=document.getElementById('submitGpurc');
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

<div class="w3-cell-row w3-margin-bottom" >

<div class="w3-bar w3-white "><span class="w3-tag w3-medium w3-black w3-margin-top w3-margin-right">${gproduct.re }차</span>
<span class="w3-tag w3-xxlarge w3-white w3-margin-top w3-margin-right"><h4>${gproduct.title }</h4></span><hr></div>
 <!-- 사진쪽 div  -->
  <div class="w3-container w3-half w3-cell w3-padding">
  <div class="w3-display-container w3-text-white">
    <img src="<%= request.getContextPath() %>/fileSave/${gproduct.imgs}" alt="Lights" style="width:100%; height:450px;">
   <span class="w3-tag w3-display-topleft">
     <c:if test="${gproduct.state=='1'}">
    예정
    </c:if>
       <c:if test="${gproduct.state=='2'}">
    진행
    </c:if>
       <c:if test="${gproduct.state=='3'}">
    마감
    </c:if></span>

  </div></div>

<!-- 상세정보쪽 div -->

  <div class="w3-container w3-half w3-cell w3-cell-bottom w3-small " >
    <table style="width: 90%;"><tr><td class="w3-border-bottom">
    
    <p><b>품명 : </b>${gproduct.name }<br>
    
    	<b>원산지 : </b>${gproduct.origin }<br>
    	<b>분류 : </b>${gproduct.category }<br>
    	<b>크기 : </b>약 ${gproduct.height } cm<br>
   </td></tr>
   
 
   <tr><td class="w3-border-bottom"> 
   
      <p><b>진행기간 : </b>${formatSdate} ~ ${formatEdate}</p>
       
    
    <body onload="javascript:showCountdown('${timeCount}','${startRemain}');">
          <label><b>남은시간 :</b> </label> <input type="text" name="Countdown" value="" style="border:0px; " readonly>
</body><p/>
 </td><tr><tr><td class="w3-border-bottom">
    <p><label><b>진행상황</b></label> (${(gproduct.count/gproduct.goal*100)-(gproduct.count/gproduct.goal*100)%1}%)<br>
    
 <div class="w3-light-grey" 
   style="margin-bottom:5px; margin-top:10px;">
    <c:if test="${((gproduct.count/gproduct.goal*100)-(gproduct.count/gproduct.goal*100)%1)>=100}">
   <div class="w3-green" style="height:15px;max-width:${(gproduct.count/gproduct.goal*100)-(gproduct.count/gproduct.goal*100)%1}%; "></div>
   </c:if>
   
     <c:if test="${(((gproduct.count/gproduct.goal*100)-(gproduct.count/gproduct.goal*100)%1)<100)&&((gproduct.count/gproduct.goal*100)-(gproduct.count/gproduct.goal*100)%1)>=80}">
  <div class="w3-orange" style="height:15px;max-width:${(gproduct.count/gproduct.goal*100)-(gproduct.count/gproduct.goal*100)%1}%; "></div>
</c:if>

    
    
    <c:if test="${((gproduct.count/gproduct.goal*100)-(gproduct.count/gproduct.goal*100)%1)<80}">
  <div class="w3-red" style="height:15px;max-width:${(gproduct.count/gproduct.goal*100)-(gproduct.count/gproduct.goal*100)%1}%; "></div>
</c:if>
</div> <center>목표 수량 ${gproduct.goal }개 중 현재  ${gproduct.count }개 달성</center><br>
</td></tr><tr><td class="w3-border-bottom" valign="top">

<p>
<form method="post" action="gpurcSubmit?select=gproduct&part=content">
<select id="quantity" onchange="priceCal(${gproduct.price});"  class="w3-select w3-border " required="required" style="width: 80px; display: inline-block;" name="quantity">
	<option  selected="selected" disabled="disabled" >수량 선택</option>
	<option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
    </select>
    <span class="w3-tag w3-medium w3-white "
     style="min-width: 200px;"><b>합계 : <span id="totalprice"> 0 </span> 원</b>  |  가격 : ${gproduct.price}원<p/></span>

  
<script>
function priceCal(price){
	var x=document.getElementById("quantity").value;
	    document.getElementById("totalprice").innerHTML=x*price;
	
	
};

</script>
</td>
</tr>
<tr><td>

<div class="w3-bar w3-white w3-section">


  <input type="hidden" name="num" value="${num }">
  <input type="hidden" name="pageNum" value="${pageNum }">
  
<input  style="width: 33%; display: inline-block;" id="submitGpurc" disabled="disabled" class="w3-button w3-bar-item w3-green  w3-right  w3-border-top w3-border-left w3-border-bottom" type="submit" value="참여하기">
</form>
<button  style="width: 33%;" class="w3-button w3-bar-item  w3-white   w3-right w3-border-top w3-border-left w3-border-bottom " onclick="location.href='addCart?num=${gproduct.num}&pcode=g'">찜하기</button>
<button  style="width: 33%;"  class="w3-button w3-bar-item w3-white   w3-border-top w3-border-left w3-border-bottom w3-right "  >공유</button>

 
   
</div>

</td></tr>
</table>

</div>



  
  </div>
<hr>

<div class="w3-bar w3-border w3-small" >
  <a href="gcontent?part=content&pageNum=${pageNum }&num=${num}" style="width:25%" class="w3-bar-item w3-button <%=request.getParameter("part").equals("content")?"w3-green":"" %> w3-border-right">정보</a>
  <a href="gcontent?part=qna&pageNum=${pageNum }&num=${num}" style="width:25%" class="w3-bar-item w3-button w3-hide-small  w3-border-right <%=request.getParameter("part").equals("qna")?"w3-green":"" %> ">문의</a>
  <a href="gcontent?part=review&pageNum=${pageNum }&num=${num}" style="width:25%" class="w3-bar-item w3-button w3-hide-small  w3-border-right  <%=request.getParameter("part").equals("review")?"w3-green":"" %> ">후기</a>
  <a href="gcontent?part=reply&pageNum=${pageNum }&num=${num}&pronum=g${num}" style="width:25%" class="w3-bar-item w3-button w3-hide-small  <%=request.getParameter("part").equals("reply")?"w3-green":"" %> ">의견</a>
  <a href="javascript:void(0)" class="w3-bar-item w3-button w3-right w3-hide-large w3-hide-medium" onclick="myFunction()">&#9776;</a>
</div>

<div id="demo" class="w3-bar-block w3-black w3-hide w3-hide-large w3-hide-medium">
  <a href="gcontent?part=qna&pageNum=${pageNum }&num=${num}" class="w3-bar-item w3-button">문의</a>
  <a href="gcontent?part=review&pageNum=${pageNum }&num=${num}" class="w3-bar-item w3-button">후기</a>
  <a href="gcontent?part=reply&pageNum=${pageNum }&num=${num}" class="w3-bar-item w3-button">의견</a>
</div>

<c:if test="${part=='content'}">
  <div class="w3-container w3-section  " id="content">
  <p><font color="grey" class="w3-small">등록일시 : ${gproduct.rdate }</font></p>
  <pre><p>${gproduct.content }</p></pre>
 
  </div>
    </c:if>
 
<c:if test="${part=='qna'}">
  <div class="w3-container w3-section  " id="qna">
  <jsp:include page="/list.jsp">
  <jsp:param value="2" name="boardid"/>
  </jsp:include>
  </div>
  </c:if>
 
  <c:if test="${part=='review'}">
   <div class="w3-container w3-section  " id="review">
  <jsp:include page="/list.jsp">
  <jsp:param value="3" name="boardid"/>
  </jsp:include>
  </div>
    </c:if>
 
 <c:if test="${part=='reply'}"> 
   <div class="w3-container w3-section  " id="reply">
  <jsp:include page="/reply/list.jsp">
   <jsp:param value="g${gproduct.num }" name="pronum"/>
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

 
