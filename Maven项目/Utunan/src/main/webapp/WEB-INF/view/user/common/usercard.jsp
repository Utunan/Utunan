<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container" id="anchor">
    <div class="wrapper">
        <div class="usercard" id="usercard">
            <div class="userheadimg">
                <img src="${User.userHeadImg}" alt="" srcset="">
            </div>
            <div class="countdown">
                <h4 id="date"></h4>
                <h5>距离<span id="examyear">2020</span>年考研还有<br><span id="surplus" style="color:#ff5f2c;font-size: 20px;">361</span>天</h5>
            </div>
            <script>
                var date = new Date();
                year = date.getFullYear();
                month = date.getMonth() + 1;
                newdate = date.getDate()
                var nextExamYear=new Date('2019-12-21');
                console.log(nextExamYear)
                var difference=(nextExamYear-date)/(60*60*24)/1000
                if (parseInt(month) < 10)
                    month = "0" + month;

                if (parseInt(newdate) < 10)
                    newdate = "0" + newdate;
                $('#date').html(year + "年" + month + "月" + newdate + "日")
                $('#surplus').html(parseInt(difference))
            </script>
            <div class="userinfo">
                <div class="nickname">${User.userNickName}</div>
                <div class="schoolinfo">
                    <span>本科院校 : <span>${User.userSchool}</span></span>
                    <span>目标院校 : <span>${User.dreamSchool}</span></span>
                </div>
            </div>
        </div>
    </div>
</div>