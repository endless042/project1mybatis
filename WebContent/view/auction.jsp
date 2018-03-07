<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<html>
<title>Plant shop</title>
<meta charset="UTF-8">

 <SCRIPT>
var RemainTime;
function showCountdown(ExpireTime){
	
            var day, hour, min, sec, mod
            var CountText
           
            RemainTime = ExpireTime - 1;
            CountText = ""
            
            if (RemainTime >= 0){
            	
            	
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
            		
            	}
            }

            if (( sec <= 0 && CountText == "0초" ) || ( CountText == "" )){
                        CountText = "종료";
                     
            }
            document.getElementById("Countdown").innerHTML=CountText;

            if (CountText != "종료"){
                        setTimeout("showCountdown(RemainTime)", 1000);
            }
}


</SCRIPT>

 

<!-- category -->
    <div class="w3-container">
    <div class="w3-section w3-bottombar w3-padding-16 w3-small">
      <span class="w3-margin-right">Filter:</span> 
      
      <button class="w3-button w3-black">ALL(${count})</button>
      <button class="w3-button w3-white"><i class="fa fa-diamond w3-margin-right"></i>인기</button>
      <button class="w3-button w3-white w3-hide-small"><i class="fa fa-map-pin w3-margin-right"></i>진행 중</button>
      <button class="w3-button w3-white w3-hide-small"><i class="fa fa-map-pin w3-margin-right"></i>마감임박</button>
      <button class="w3-button w3-white w3-hide-small"><i class="fa fa-map-pin w3-margin-right"></i>진행예정</button>
       <button class="w3-button w3-white w3-hide-small"><i class="fa fa-map-pin w3-margin-right"></i>완료</button>
    </div>
    </div>
 
 <div>
  <!-- Product grid -->
  
  
  <div class="w3-row-padding ">
  
  <c:if test="${count==0}">
    	
    	<table class="w3-table w3-border w3-hoverable w3-center w3-small " width="90%">
    	<tr class="w3-light-grey">
    	<td class="w3-center">등록된 상품이 없습니다.</td>
    	
    	</table>
    	</c:if>
     <c:if test="${count!=0}">
    	
    	
      
      <c:forEach var="aproduct" items="${productList}">
        <div class="w3-third w3-container w3-margin-bottom w3-padding w3-small">
         <div class="w3-display-container"><img src="<%= request.getContextPath() %>/fileSave/${aproduct.imgs}" class="w3-border-top w3-border-left w3-border-right" style="height:350px; width:100%;">
       
          <div class="w3-display-middle w3-display-hover">
          
            <button class="w3-button w3-red" onclick="location.href='acontent?num=${aproduct.num}&pageNum=${currentPage}&part=content';">입찰하기</button>
          </div>
        </div>
      <div class="w3-container w3-border ">

       <p>${aproduct.title} </p> 
               <font class="w3-small"><table width="100%" class="w3-light-grey">
               <tr><td><b>진행기간</b></td>
               <td class="w3-right">
              ${aproduct.sdate } 부터<br>
              ${aproduct.edate } 까지
              
              </td></tr>  </table></font><p>
               <table width="100%"><tr><td><b>현재가</b> </td><td class="w3-right"><b>${aproduct.eprice}원(${aproduct.count }명 참여)</b></td></tr>  </table>  <p/>
      </div>
    </div>

</c:forEach>
   </c:if>
  
   </div>
   

 <!-- 하단 페이징  -->
    	<div class="w3-center w3-section w3-small">
    	
    	<c:if test="${startPage>bottomLine}">
    		
    		 <a href="auction?pageNum=${startPage-bottomLine}" class="w3-bar-item w3-button w3-hover-black">«</a>
    	
    		</c:if>
    	
    		<c:forEach var="i" begin="${startPage }" end="${endPage }">
    		
    		<c:if test="${i!=currentPage}">
    		  <a href="auction?pageNum=${i}"
    		 class="w3-bar-item w3-button w3-hover-black">${i}</a> 
    		 
    		 
    		 	</c:if>
    		
    		
    		<c:if test="${i==currentPage}">
    		  <a href="auction?pageNum=${i}" 
    		  class="w3-bar-item w3-black w3-button">${i}</a> 
    		</c:if>
    		
    		</c:forEach>
    	
    	
    	<c:if test="${endPage<pageCount}">
    		
    		
    		 <a href="auction?pageNum=${ startPage+bottomLine}" class="w3-bar-item w3-button w3-hover-black">»</a>
    			</c:if>
    	
    		 
    		
    	</div>
    	
    	
</div>




  <!-- End page content -->
 