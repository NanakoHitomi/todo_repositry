<%@ page language="java"
contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Todo新規作成</title>
  <style>ul {list-style: none; margin: 0; padding: 0;} li {float: left; margin-right: 20px; }</style>
</head>
<body>
    <h1>Todo新規作成</h1>
    <% String message = (String)request.getAttribute("message"); %>   
    <p><%= message %></p>
    <form action="create" method="get">
      <label for="title">タイトル</label><br>
      <input type="text" name="title" value=''><br>
      <br>
      <label for="content">本文</label><br>
      <textarea name="content" id="" cols="30" rows="10"></textarea><br>
     <!--  <label for="priority">重要度</label><br> -->
      <!-- <input type="radio" name="priority" value="0"checkd />低
      <input type="radio" name="priority" value="1">中
      <input type="radio" name="priority" value="2">高<br> -->
       <label for="priority">優先度</label><br>
      <input type="text" name="priority" value=''><br>
      
      <label for="date">締切</label><br>
      <input type="date" name="date" value=''><br>
      <p></p>
      <button type="submit">保存する</button>
      <a href='list'>キャンセル</a>
  </form>
<ul>
      <li><p><a href='list'>戻る</a></p></li>
    </ul>      
</body>
</html>
