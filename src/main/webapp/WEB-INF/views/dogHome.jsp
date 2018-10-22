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

    <b>아두이노 -> 서버 온습도 set : </b>
    <p>www.dogfriends.site/setTempHumi</p>

    <b>안드로이드 -> 서버 전원, 모드 set :  </b>
    <p>www.dogfriends.site/android/setpower</p>

    <b>서버 -> 아두이노 모드 전달 :  </b>
    <p>www.dogfriends.site/arduino/handle</p>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <input type="text" id="msg">
        <button id="btnSend">Send</button>
    </input>

    <script>

        
        $(document).ready(  function() {
            connectWS();    
            
            $('#btnSend').on('click', function(evt) {
                evt.preventDefault();
                if (socket.readyState !== 1) return;
                let msg = $('input#msg').val();
                console.log("msgggggggggggggggg>>" + msg)
                ws.send(msg);
            });
        });
        
        var socket = null;
        var ws = new WebSocket("ws://localhost:8080/dogHome");
        
        function connectWS(){
                socket = ws;
        ws.onopen = function () {
            console.log('Info: connection opened.');
        };
            ws.onmessage = function (event) {
                console.log("ReceiveMessage:", event.data+'\n');
            };

            ws.onclose = function (event) { console.log('Info: connection closed.'); };
            ws.onerror = function (err) { console.log('Info: connection closed.'); };
        }
    

    </script>

         <!-- <div>
//             <p>온도 : "${temp}"</p>
//             <p>습도 : "${humi}"</p>
//             <p>전원 : "${statePower}"</p>
//             <p>수동모드 : "${manual}"</p>
//         </div>
//     </script>

//     <button onclick = "refresh()">새로고침</button>

//     <script>
//         function refresh(){
//             let temp = "${temp}",
//                 humi = "${humi}",
//                 statePower = "${statePower}",
//                 manual = "${manual}";
//         }
//     </script>
    
//     <script>
       
//         $(document).ready( () => {
//             $("#btn").click( () => {
//                 $.ajax({
//                     url : "/setTempHumi",
//                     method : "POST",
//                     data : {
//                             temp : {temp},
//                             humi : {humi}
//                     }
//                 });
//         });
//     });
//     </script>

//     <p id="text"></p> -->

<!-- 
//     <script src="../../../resources/handlebars-v4.0.12.js"></script>
//     <script id="" class="well" type="text/x-handlebars-template"> 
//     </script> -->

</body>
</html>
