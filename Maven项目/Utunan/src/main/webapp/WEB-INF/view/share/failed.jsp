<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/12/27
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传失败</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="refresh" content="8;url='/share'" />
    <link rel="stylesheet" href="/css/share/index.css">
    <link rel="stylesheet" href="/css/share/animate.min.css">

    <script>
        var NUMBER_OF_LEAVES = 15;
        var width=window.screen.width;
        function init(){
            var container = document.getElementById('leafContainer');
            for (var i = 0; i < NUMBER_OF_LEAVES; i++)
            {
                container.appendChild(createALeaf());
            }

        }
        function randomInteger(low, high)
        {
            return low + Math.floor(Math.random() * (high - low));
        }
        function randomFloat(low, high)
        {
            return low + Math.random() * (high - low);
        }
        function pixelValue(value)
        {
            return value + 'px';
        }

        function durationValue(value)
        {
            return value + 's';
        }
        function createALeaf()
        {
            var leafDiv = document.createElement('div');
            var image = document.createElement('img');
            image.src = '/images/share/cash' + randomInteger(8, 12) + '.png';
            leafDiv.style.top = "-100px";
            leafDiv.style.left = pixelValue(randomInteger(0, width));
            var spinAnimationName = (Math.random() < 0.5) ? 'clockwiseSpin' : 'counterclockwiseSpinAndFlip';
            leafDiv.style.webkitAnimationName = 'fade, drop';
            image.style.webkitAnimationName = spinAnimationName;
            var fadeAndDropDuration = durationValue(randomFloat(3, 9));
            var spinDuration = durationValue(randomFloat(3, 7));
            leafDiv.style.webkitAnimationDuration = fadeAndDropDuration + ', ' + fadeAndDropDuration;
            var leafDelay = durationValue(randomFloat(0, 0));
            leafDiv.style.webkitAnimationDelay = leafDelay + ', ' + leafDelay;
            image.style.webkitAnimationDuration = spinDuration;
            leafDiv.appendChild(image);
            return leafDiv;
        }
        window.addEventListener('load', init, false);
    </script>
    <style>
        .content{
            padding-top: 250px;
            height: 60px;
            font-size: 30px;
            color: #ffffff;
            text-align: center;
        }

    </style>
</head>

<body>
<div class="moneybox" id="leafContainer"></div>
<div class="content">
    您的上传失败了，请重新上传！！！！<br>
    <span style="color: #fed71a">8 S</span>后将自动返回优共享主页。
</div>

<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>

</body>

</html>
