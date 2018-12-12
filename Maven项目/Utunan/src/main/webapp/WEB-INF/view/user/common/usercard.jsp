<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container" id="anchor" >
    <div class="wrapper">
        <div class="usercard" id="usercard">
            <div class="userheadimg">
                <img src="${User.userHeadImg}" alt="" srcset="">
            </div>
            <div class="countdown">
                <h4>2018年11月13日</h4>
                <h5>距离考试还有<span style="color:#ff5f2c;font-size: 25px;">555</span>天</h5>
            </div>
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