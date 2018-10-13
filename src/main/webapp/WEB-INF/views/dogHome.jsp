<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>

<body>
    <b>안드로이드 온습도받기 : </b>
         <p>www.dogfriends.site/view</p>
    <b>아두이노 온습도 : </b>
         <p>www.dogfriends.site/setTempHumi</p>
    <b>수정 중 : 자동제어 온오프   </b>
        <p>www.dogfriends.site/ctrl</p>

    <div>
        <p>온도 : ${temp}</p> <!--View Controller 추가-->
        <p>습도 : ${humi}</p>
        <p>전원 : ${isPower}</p><!--Handle Controller 추가할것 미완성-->
    </div>

</body>
</html>
