
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
 <!DOCTYPE html>
<html>
<title>Plant shop</title>
<meta charset="UTF-8">


 

  <!-- Image header -->
  <div class="w3-display-container w3-container w3-margin-bottom">
    <img src="<%= request.getContextPath() %>/images/menusample.PNG" alt="menusample" style="width:100%">
    <div class="w3-display-topleft w3-text-white" style="padding:24px 48px">
      <h1 class="w3-xxxlarge w3-hide-small " style="text-shadow:1px 1px 0 #444">태국 알로카시아 시리즈</h1>
      <h1 class="w3-hide-large w3-hide-medium" style="text-shadow:1px 1px 0 #444">경매 진행 중</h1>
      <h1 class="w3-hide-small " style="text-shadow:1px 1px 0 #444">경매 진행 중</h1>
      <p><a href="#gg" class="w3-button w3-black w3-padding-large w3-small">구경하기</a></p>
    </div>
  </div> 

 
<!-- category -->
    <div class="w3-container" id="gg">
    <div class=" w3-section w3-row-padding " style="padding-top: 6px; padding-bottom:6px;">
   <a href="auction?stateSelect=top&select=auction"><span class="w3-margin-right"><b>인기 경매 ▶</b></span> </a>
    
    </div>
    
    </div>
 
  <!-- Product grid -->
  <div class="w3-row-padding ">
  <c:if test="${acount>0 }">
     <c:forEach var="aproduct" items="${aTopProduct }">
      
         <div class="w3-third w3-container w3-margin-bottom w3-padding w3-small">
       <div class="w3-display-container"><img src="<%= request.getContextPath() %>/fileSave/${aproduct.imgs}" class="w3-border-top w3-border-left w3-border-right" style="height:350px; width:100%;">
      <span class="w3-tag w3-display-topleft">${i }위</span>
       	<c:set var="i" value="${i+1 }"/>
          <div class="w3-display-middle w3-display-hover">
            <button class="w3-button w3-red"  onclick="location.href='acontent?num=${aproduct.num}&pageNum=${currentPage}&part=content';">입찰하기</button>
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
 <c:if test="${acount==0 }">
 <table class="w3-table w3-border w3-hoverable w3-center w3-small " width="90%">
    	<tr class="w3-light-grey">
    	<td class="w3-center">등록된 상품이 없습니다.</td>
    	
    	</table>
 
 </c:if>
 </div>
  <!-- category -->
    <div class="w3-container" >
  <div class=" w3-section w3-row-padding " style="padding-top: 6px; padding-bottom:6px;">
  <a href="gpurchase?stateSelect=top&select=gpurchase"><span class="w3-margin-right"><b>인기 공동구매 ▶</b></span> </a>
    
    </div>
    </div>
 
  <!-- Product grid -->
  <div class="w3-row-padding ">
  <c:if test="${gcount>0 }">
      <c:forEach var="gproduct" items="${gTopProduct}">
    	
       <div class="w3-third w3-container w3-margin-bottom w3-padding w3-small">
        <div class="w3-display-container"><img src="<%= request.getContextPath() %>/fileSave/${gproduct.imgs}" class="w3-border-top w3-border-left w3-border-right" style="height:350px; width:100%;">
       <span class="w3-tag w3-display-topleft">${j }위</span>
       	<c:set var="j" value="${j+1 }"/>
          <div class="w3-display-middle w3-display-hover">
            <button class="w3-button w3-red"  onclick="location.href='gcontent?num=${gproduct.num}&pageNum=${currentPage}&part=content';">참여하기</button>
          </div>
        </div>
      <div class="w3-container w3-border ">

       <p>${gproduct.title }</p> 
                <div class="w3-light-grey" 
                style="margin-bottom:5px; margin-top:10px;">
                
 <c:if test="${((gproduct.count/gproduct.goal*100)-(gproduct.count/gproduct.goal*100)%1)>=100}">
 <div class="w3-green" style="height:3px;max-width:${(gproduct.count/gproduct.goal*100)-(gproduct.count/gproduct.goal*100)%1}%; "></div>
  </c:if>
  <c:if test="${(((gproduct.count/gproduct.goal*100)-(gproduct.count/gproduct.goal*100)%1)<100)&&((gproduct.count/gproduct.goal*100)-(gproduct.count/gproduct.goal*100)%1)>=80}">
  <div class="w3-orange" style="height:3px;max-width:${(gproduct.count/gproduct.goal*100)-(gproduct.count/gproduct.goal*100)%1}%; "></div>

</c:if>
<c:if test="${((gproduct.count/gproduct.goal*100)-(gproduct.count/gproduct.goal*100)%1)<80}">
  <div class="w3-red" style="height:3px;max-width:${(gproduct.count/gproduct.goal*100)-(gproduct.count/gproduct.goal*100)%1}%; "></div>
</c:if></div>
<font class="w3-small"><table width="100%"><tr><td>${gproduct.edate }일 남음  </td><td class="w3-right">${(gproduct.count/gproduct.goal*100)-(gproduct.count/gproduct.goal*100)%1}%</td></tr>  </table></font><p>
<table width="100%"><tr><td><b>공동구매가</b> </td><td class="w3-right"><b>${gproduct.price }원</b></td></tr>  </table>  <p/>
      </div>
    </div>
      
        
</c:forEach>
</c:if>
 <c:if test="${gcount==0 }">
 <table class="w3-table w3-border w3-hoverable w3-center w3-small " width="90%">
    	<tr class="w3-light-grey">
    	<td class="w3-center">등록된 상품이 없습니다.</td>
    	
    	</table>
 
 </c:if>
  </div>
  
  



  <!-- End page content -->

