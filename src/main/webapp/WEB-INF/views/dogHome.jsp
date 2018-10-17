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
    <b>서버 -> 안드로이드 온습도받기 : </b>
    <p>www.dogfriends.site/view</p>

    <b>안드로이드 -> 서버  온습도 임시로 보기 : </b>
    <p>www.dogfriends.site/webview</p>

    <b>아두이노 -> 서버 온습도 set : </b>
    <p>www.dogfriends.site/setTempHumi</p>

    <b>안드로이드 -> 서버 전원 set :  </b>
    <p>www.dogfriends.site/android/setpower</p>

    <b>안드로이드 -> 서버 수동모드 set :  </b>
    <p>www.dogfriends.site/android/setmanual</p>

    <b>서버 -> 아두이노 전원, 수동모드 :  </b>
    <p>www.dogfriends.site/arduino/handle</p>



    <div class = "refresh">
        <p >온도 : ${temp}</p> <!--View Controller 추가-->
        <p>습도 : ${humi}</p>
        <p>전원 : ${statePower}</p><!--Handle Controller 추가할것 미완성-->
        <p>수동모드 : ${manual}</p>
    </div>

    <button id="btn">새로고침 미완성</button>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    
    <!-- <script>
        $(document).ready( () => {
            $("#btn").click( () => {
                $("p").text("dd");
            });
        });
    </script>
     -->
    <script>

        $(document).ready( () => {
            $("#btn").click( () => {
                $.ajax({
                    url : "/setTempHumi",
                    method : "POST",
                    data : {
                            temp : {temp},
                            humi : {humi}
                    }
                });
        });
    });
    </script>

    <p id="text"></p>

<!-- 
    <script src="../../../resources/handlebars-v4.0.12.js"></script>
    <script id="" class="well" type="text/x-handlebars-template"> 
    </script> -->
    
</body>
</html>
