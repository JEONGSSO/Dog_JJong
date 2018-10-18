<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

        <div>
                <p>온도 : "${temp}"</p>
                <p>습도 : "${humi}"</p>
                <p>전원 : "${statePower}"</p>
                <p>수동모드 : "${manual}"</p>
            </div>
        
            <button onclick = "refresh()">새로고침</button>
        
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
            
            <script>
                function refresh(){
                    let temp = "${temp}",
                        humi = "${humi}",
                        statePower = "${statePower}",
                        manual = "${manual}";
                }
            </script>
    
</body>
</html>