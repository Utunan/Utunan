<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>欢迎来到Utunan</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="css/homepage.css">

</head>
<body>
<%@include file="common/header.jsp"%>
<div class="container">
    <div class="imgsign">
        徐思涵天下第一美<br/>
        欧耶!
    </div>
    <div class="homepageimg">
        <img src="images/homepage/homebanner.jpg" alt="" srcset="">
    </div>
</div>

<div class="container">
    <div class="wrapper">
        <div class="mainplate">
            <div class="summary" id="summary">
                <div class="plateinfo">
                    主要板块
                </div>
            </div>
            <div>
                <a href="">
                    <img src="images/homepage/school.png" alt="" srcset="">
                </a>
                <a hREF="">院校库</a>
            </div>
            <div>
                <a href="">
                    <img src="images/homepage/code.png" alt="" srcset="">
                </a>
                <a hREF="">题库</a>
            </div>
            <div>
                <a href="">
                    <img src="images/homepage/tablk.png" alt="" srcset="">
                </a>
                <a hREF="">社区</a>
            </div>
        </div>
    </div>
    <div class="questionbank">
        <div class="wrapper">
            <div class="qbleft">
                <nav>
                    <li><a href="" style="margin-right:50px;font-size:20px;color:#000;">计算机网络</a></li>
                    <li><a href="" style="margin-right:0px;font-size: 25px;color:grey;">数据结构</a></li>
                    <li><a href="" style="margin-right:50px;font-size: 18px">操作系统</a></li>
                    <li><a href="" style="margin-left:23px;color:#000; font-weight: bold;">计算机组成原理</a></li>
                </nav>
            </div>
            <div class="qbmiddle">
                <img src="images/homepage/barchart.png">
                <h4>[题库]</h4>
                <p>”纸上得来终觉浅，绝知此事要躬行“。
                    精心搜录CS、MSE专业考研各门专业课试题。
                    从专项练习到智能组卷，
                    满足您的题目练习需要。
                </p>
            </div>
            <div class="qbright">
                <nav>
                    <li><a href="" style="margin-left:20px;color:#000; font-weight: bold;">数据库原理</a></li>
                    <li><a href="" style="margin-right:100px;font-size: 20px">算法</a></li>
                    <li><a href="" style="margin-left:60px;font-size:20px;color:#000;">C语言编程</a></li>
                    <li><a href="" style="margin-left:50px;font-size: 18px;color:grey;">查看更多</a></li>
                </nav>
            </div>
        </div>
    </div>
    <div class="schoolsearch">
        <div class="wrapper">
            <h2>[院校库]</h2>
            <form method="GET" action="">
                    <span>院校所在地区:
                        <select name="schoolProvince">
                            <option value="None">请选择省份</option>
                            <option value="北京">
                                北京</option>
                            <option value="天津">
                                天津</option>
                            <option value="上海">
                                上海</option>
                            <option value="重庆">
                                重庆 </option>
                            <option value="河北">
                                河北 </option>
                            <option value="山西">
                                山西 </option>
                            <option value="辽宁">
                                辽宁 </option>
                            <option value="吉林">
                                吉林 </option>
                            <option value="黑龙江">
                                黑龙江</option>
                            <option value="江苏">
                                江苏 </option>
                            <option value="浙江">
                                浙江 </option>
                            <option value="安徽">
                                安徽 </option>
                            <option value="福建">
                                福建 </option>
                            <option value="江西">
                                江西 </option>
                            <option value="山东">
                                山东 </option>
                            <option value="河南">
                                河南 </option>
                            <option value="湖北">
                                湖北 </option>
                            <option value="湖南">
                                湖南 </option>
                            <option value="广东">
                                广东 </option>
                            <option value="海南">
                                海南 </option>
                            <option value="四川">
                                四川 </option>
                            <option value="贵州">
                                贵州 </option>
                            <option value="云南">
                                云南 </option>
                            <option value="陕西">
                                陕西 </option>
                            <option value="甘肃">
                                甘肃 </option>
                            <option value="青海">
                                青海 </option>
                            <option value="台湾">
                                台湾 </option>
                            <option value="广西">
                                广西</option>
                            <option value="内蒙古">
                                内蒙古</option>
                            <option value="西藏">
                                西藏</option>
                            <option value="宁夏">
                                宁夏 </option>
                            <option value="新疆">
                                新疆</option>
                            <option value="香港">
                                香港</option>
                            <option value="澳门">
                                澳门</option>
                        </select>
                    </span>
                <span>院校类别:
                        <select name="schoolType">
                            <option value="None">院校类型</option>
                            <option value="985">985院校</option>
                            <option value="211">211院校</option>
                            <option value="zizhuhuaxian">自主划线院校</option>
                        </select>
                    </span>
                <span>院校名称: <input name="schoolName" type="text"> </span>
                <span>研究方向: <input name="schoolName" type="text"> </span>
                <input type="submit" class="searchschoolinfo" value="查询">
                <p style="color:#fff;font-weight:900;font-size: 18px;">112所高校研招信息全部收入囊中，提供多种检索方式。时光宝贵，我们帮助您更快、更精确的找到您理想高校。</p>
                <input type="submit" class="allschoolinfo" value="查看更多">
            </form>
        </div>
    </div>
    <div class="community">
        <div class="wrapper">
            <div class="commtop">
                <img src="images/homepage/community.png">
                <h4>[社区]</h4>
            </div>
            <p>漫漫考研路，这里有和你一样的志同道合者！考研经验交流、题目解惑、院校答疑，尽在此处。来这里与大家畅快交流！</p>
            <div class="commoncon">
                <div class="comment">
                    <p style="margin-top:30px;">13:15 网友“杀鲨鱼”提问：</p>
                    <p style="font-size: 15px;">《C语言中双向队列链表应该如何遍历？》</p>
                    <p>标签 【数据结构】 【 链表】 </p>
                </div>
                <div class="branch">
                    <div class="one">
                        <p style="margin-top:30px;margin-bottom: 25px;">与他人分享你的知识。助人亦是助己</p>
                        <h5>问答社区</h5>
                    </div>
                    <div class="two">
                        <h5 style="margin-top:70px;margin-bottom: 0;">垂直分类</h5>
                        <p>所有问题只聚焦于专注计算机考研相关领域。</p>
                    </div>
                    <div class="three">
                        <p style="margin-top:35px;margin-bottom: 0px;">标签化每一个提问，让浏览更高效专一</p>
                        <h5 style="margin-top:15px;">标签化提问</h5>
                    </div>
                    <div class="four"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="common/footer.jsp"%>
</body>
</html>