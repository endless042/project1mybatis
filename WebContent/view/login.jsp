<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<title>Plant shop</title>
<meta charset="UTF-8">
 


<div class="w3-container w3-padding-64 w3-small" width="100%" style="margin-bottom: 150px; " >
  
<table align="center" width="100%" style="max-width:600px"><tr ><td>
 <div class="w3-card-4 " style="max-width:600px" >
      <form class="w3-container" action="loginPro.jsp">
        <div class="w3-section">
          <label><b>ID</b></label>
          <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="아이디를 입력하세요." name="tryid" required>
          <label><b>PASSWORD</b></label>
          <input class="w3-input w3-border" type="password" placeholder="비밀번호를 입력하세요." name="trypwd" required>
          <button class="w3-button w3-block w3-black w3-section w3-padding" type="submit">로그인</button>
          <input class="w3-check w3-margin-top" type="checkbox" checked="checked">로그인 기억하기
        </div>
      </form>

      

 
  </div>
  
      <div class="w3-container w3-border-top w3-padding-16 ">
       <!--w3-hide-small  <button onclick="document.getElementById('login').style.display='none'" type="button" class="w3-button w3-black">취소</button> &nbsp;&nbsp;&nbsp;-->
       <span class="w3-right w3-padding "> <a href="#">비밀번호</a>를 잊으셨나요?</span> <span class="w3-right w3-padding "><a href="index.jsp?select=join">회원가입</a></span>
      </div>
  </td></tr>
  </table>
</div>

 
  






  <!-- End page content -->
