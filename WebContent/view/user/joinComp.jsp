<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<title>Plant shop</title>
<meta charset="UTF-8">

 
 

<div class="w3-container w3-padding-64 w3-small" width="100%" style="margin-bottom: 150px; " >
  
<table align="center" width="100%" style="max-width:600px"><tr ><td>
 <div class="w3-card-4 w3-center " style="max-width:600px" >
      <form class="w3-container w3-padding-24">
        <div class="w3-section">
        
          회원가입이 완료되었습니다.<div style="margin-top:50px"></div>
           <input type="button" onclick="location.href='<%=request.getContextPath()%>/page/main'" class="w3-button w3-black w3-margin-right" value="메인으로">
  <input type="button" onclick="location.href='login'" class="w3-button w3-black" value="로그인하기">
        </div>
      </form>


 
  </div>
  
      
  </td></tr>
  </table>
</div>



  <!-- End page content -->

