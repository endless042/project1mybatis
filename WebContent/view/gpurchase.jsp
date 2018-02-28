<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<title>Plant shop</title>
<meta charset="UTF-8">


 
<!-- category -->
    <div class="w3-container">
    <div class="w3-section w3-bottombar w3-padding-16 w3-small">
      <span class="w3-margin-right">Filter:</span> 
      <button class="w3-button w3-black">ALL</button>
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
    
       <div class="w3-third w3-container w3-margin-bottom w3-padding w3-small">
        <div class="w3-display-container"><img src="<%= request.getContextPath() %>/images/sample.PNG" class="w3-border-top w3-border-left w3-border-right" style="width:100%; ">
      <span class="w3-tag w3-display-topleft">New</span>
          <div class="w3-display-middle w3-display-hover">
            <button class="w3-button w3-red"  onclick="location.href='<%= request.getContextPath() %>/view/gproductview.jsp';">참여하기</button>
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
            <button class="w3-button w3-red"  onclick="location.href='gproductview.jsp';">참여하기</button>
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
            <button class="w3-button w3-red"  onclick="location.href='gproductview.jsp';">참여하기</button>
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
  
    <!-- Product grid -->
  <div class="w3-row-padding ">
    
       <div class="w3-third w3-container w3-margin-bottom w3-padding w3-small">
        <div class="w3-display-container"><img src="<%= request.getContextPath() %>/images/sample.PNG" class="w3-border-top w3-border-left w3-border-right" style="width:100%; ">
      <span class="w3-tag w3-display-topleft">New</span>
          <div class="w3-display-middle w3-display-hover">
            <button class="w3-button w3-red"  onclick="location.href='gproductview.jsp';">참여하기</button>
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
            <button class="w3-button w3-red"  onclick="location.href='gproductview.jsp';">참여하기</button>
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
            <button class="w3-button w3-red"  onclick="location.href='gproductview.jsp';">참여하기</button>
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
  
  
  </div>
    <!-- Pagination -->
  <div class="w3-center w3-padding-32 w3-small">
    <div class="w3-bar">
      <a href="#" class="w3-bar-item w3-button w3-hover-black">«</a>
      <a href="#" class="w3-bar-item w3-black w3-button">1</a>
      <a href="#" class="w3-bar-item w3-button w3-hover-black">2</a>
      <a href="#" class="w3-bar-item w3-button w3-hover-black">3</a>
      <a href="#" class="w3-bar-item w3-button w3-hover-black">4</a>
      <a href="#" class="w3-bar-item w3-button w3-hover-black">»</a>
    </div>
  </div>
  



  <!-- End page content -->
 