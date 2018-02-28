
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
      <span class="w3-margin-right"><b>진행 중 경매 ▶</b></span> 
    
    </div>
    
    </div>
 
  <!-- Product grid -->
  <div class="w3-row-padding ">
     
      
        <div class="w3-third w3-container w3-margin-bottom w3-padding w3-small">
         <div class="w3-display-container"><img src="<%= request.getContextPath() %>/images/sample.PNG" class="w3-border-top w3-border-left w3-border-right" style="width:100%; ">
       
          <div class="w3-display-middle w3-display-hover">
            <button class="w3-button w3-red">입찰하기</button>
          </div>
        </div>
      <div class="w3-container w3-border ">

      <p> 코브라아비스 30cm 중품</p>
               <font class="w3-small"><table width="100%" class="w3-light-grey"><tr><td>남은시간  </td><td class="w3-right">3일 15시간 30초</td></tr>  </table></font><p>
               <table width="100%"><tr><td><b>현재가</b> </td><td class="w3-right"><b>34,000원</b></td></tr>  </table>  <p/>
      </div>
    </div>
    
 <div class="w3-third w3-container w3-margin-bottom w3-padding w3-small">
        <div class="w3-display-container"><img src="<%= request.getContextPath() %>/images/sample.PNG" class="w3-border-top w3-border-left w3-border-right" style="width:100%; ">
      <span class="w3-tag w3-display-topleft">New</span>
          <div class="w3-display-middle w3-display-hover">
            <button class="w3-button w3-red">입찰하기</button>
          </div>
        </div><div class="w3-container w3-border ">

       <p>코브라아비스 30cm 중품</p> 
                <font class="w3-small"><table width="100%" class="w3-light-grey"><tr><td>남은시간  </td><td class="w3-right">3일 15시간 30초</td></tr>  </table></font><p>
                
                <table width="100%"><tr><td><b>현재가</b> </td><td class="w3-right"><b>34,000원</b></td></tr>  </table>  <p/>
      </div>
    </div>
    
   <div class="w3-third w3-container w3-margin-bottom w3-padding w3-small">
       <div class="w3-display-container"><img src="<%= request.getContextPath() %>/images/sample.PNG" class="w3-border-top w3-border-left w3-border-right" style="width:100%; ">
       
          <div class="w3-display-middle w3-display-hover">
            <button class="w3-button w3-red">입찰하기</button>
          </div>
        </div>
      <div class="w3-container w3-border ">

       <p>코브라아비스 30cm 중품</p> 
                <font class="w3-small"><table width="100%" class="w3-light-grey"><tr><td>남은시간  </td><td class="w3-right"><font color="red">0일 5시간 30초</font></td></tr>  </table></font><p>
      <table width="100%"><tr><td><b>현재가</b> </td><td class="w3-right"><b>34,000원</b></td></tr>  </table>  <p/>
      </div>
    </div>
     </div>
 
  <!-- category -->
    <div class="w3-container" >
   <div class=" w3-section w3-row-padding " style="padding-top: 6px; padding-bottom:6px;">
      <span class="w3-margin-right"><b>진행 중 공동구매 ▶</b></span> 
    
    </div>
    </div>
 
  <!-- Product grid -->
  <div class="w3-row-padding ">
    
       <div class="w3-third w3-container w3-margin-bottom w3-padding w3-small">
        <div class="w3-display-container"><img src="<%= request.getContextPath() %>/images/sample.PNG" class="w3-border-top w3-border-left w3-border-right" style="width:100%; ">
      <span class="w3-tag w3-display-topleft">New</span>
          <div class="w3-display-middle w3-display-hover">
            <button class="w3-button w3-red">참여하기</button>
          </div>
        </div>
      <div class="w3-container w3-border ">

       <p>코브라아비스 30cm 중품</p> 
                <div class="w3-light-grey" style="margin-bottom:5px; margin-top:10px;">
  <div class="w3-red" style="height:3px;width:60%; "></div>
</div><font class="w3-small"><table width="100%"><tr><td>13일 남음  </td><td class="w3-right">60%</td></tr>  </table></font><p>
<table width="100%"><tr><td><b>공동구매가</b> </td><td class="w3-right"><b>34,000원</b></td></tr>  </table>  <p/>
      </div>
    </div>
      
        
    
       <div class="w3-third w3-container w3-margin-bottom w3-padding w3-small">
       <div class="w3-display-container"><img src="<%= request.getContextPath() %>/images/sample.PNG" class="w3-border-top w3-border-left w3-border-right" style="width:100%; ">
       
          <div class="w3-display-middle w3-display-hover">
            <button class="w3-button w3-red">참여하기</button>
          </div>
        </div>
      <div class="w3-container w3-border ">

       <p>코브라아비스 30cm 중품</p> 
                <div class="w3-light-grey" style="margin-bottom:5px; margin-top:10px;">
  <div class="w3-orange" style="height:3px;width:90%; "></div>
</div><font class="w3-small"><table width="100%"><tr><td>13일 남음  </td><td class="w3-right">90%</td></tr>  </table></font><p>
<table width="100%"><tr><td><b>공동구매가</b> </td><td class="w3-right"><b>34,000원</b></td></tr>  </table>  <p/>
      </div>
    </div>
      
       
       <div class="w3-third w3-container w3-margin-bottom w3-padding w3-small">
        <div class="w3-display-container"><img src="<%= request.getContextPath() %>/images/sample.PNG" class="w3-border-top w3-border-left w3-border-right  " style="width:100%;">
      <span class="w3-tag w3-display-topleft">달성</span>
          <div class="w3-display-middle w3-display-hover">
            <button class="w3-button w3-red">참여하기</button>
          </div>
        </div>
      <div class="w3-container w3-border ">

       <p>코브라아비스 30cm 중품</p> 
                <div class="w3-light-grey" style="margin-bottom:5px; margin-top:10px;">
  <div class="w3-green" style="height:3px;width:100%; "></div>
</div><font class="w3-small"><table width="100%"><tr><td>13일 남음  </td><td class="w3-right">130%</td></tr>  </table></font><p>
<table width="100%"><tr><td><b>공동구매가</b> </td><td class="w3-right"><b>34,000원</b></td></tr>  </table>  <p/>
      </div>
    </div>
  </div>
  
  



  <!-- End page content -->

