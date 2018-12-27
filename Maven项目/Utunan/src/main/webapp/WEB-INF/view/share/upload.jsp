<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>发表问题 编辑问题 公用</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="keywords" content="fly,layui,前端社区">
    <meta name="description" content="Fly社区是模块化前端UI框架Layui的官网社区，致力于为web开发提供强劲动力">
    <link rel="stylesheet" href="/layui/wyd/layui.css">
    <link rel="stylesheet" href="/layui/wyd/global.css">
    <link rel="stylesheet" href="/css/share/upload.css">
    <link rel="stylesheet" href="/css/common.css"/>
    <link rel="stylesheet" href="/css/school/animate.css">
    <link rel="stylesheet" href="/css/school/dialog.css">
    <script src="/layui/layui.js" charset="utf-8"></script>
    <script src="/js/jquery-1.8.3.min.js" charset="utf-8"></script>


    <script>

        layui.use(['form','upload'], function () {
            var $ = layui.jquery
                , form=layui.form
                , upload = layui.upload;
            var uploadInst = upload.render({
                elem: '#test10'
                , url: '/upload1'    //服务器地址
                , accept: 'file' //允许所有类型文件上传
                , auto: false     //不允许文件自动上传
                , bindAction: '#submit'   //指向按钮触发上传
                , size: 20000    //设置最大上传大小为20MB
                , drag: true       //接受拖拽文件上传
                , before: function (obj) {
                    //预读本地文件示例，不支持ie8
                    obj.preview(function (index, file, result) {
                        $('#test10').attr('src', result);      //得到文件base64编码，
                    });
                }
                , error: function () {
                    //演示失败状态，并实现重传
                    var demoText = $('#demoText');
                    demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                    demoText.find('.demo-reload').on('click', function () {
                        //实现重传
                        uploadInst.upload();
                    })
                }
            })
        });
    </script>


</head>
<body>
<%@ include file="../common/header.jsp" %>
<div class="layui-container fly-marginTop" style="margin-top:80px;margin-bottom:30px;width: 1000px;opacity:1;">
    <div class="fly-panel" pad20 style="padding-top: 5px;">
        <!--<div class="fly-none">没有权限</div>-->
        <div class="layui-form layui-form-pane">
            <div class="layui-tab layui-tab-brief" lay-filter="user">
                <ul class="layui-tab-title">
                    <li class="layui-this">发表新帖<!-- 编辑帖子 --></li>
                </ul>
                <div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
                    <div class="layui-tab-item layui-show">
                        <form id="shangchuanform" name="shangchuan" onsubmit="return false" class="layui-form" action="/upload1" method="post" enctype="multipart/form-data">
                            <div class="layui-row layui-col-space12 layui-form-item">
                                <div class="layui-col-md3">
                                    <label class="layui-form-label">资源类型</label>
                                    <div class="layui-input-block">
                                        <select lay-verify="required" name="sourcetype" lay-filter="filetypes">
                                            <option value="0">招生简章</option>
                                            <option value="1">招生专业目录</option>
                                            <option value="11">考研真题</option>
                                            <option value="12">备考习题</option>
                                            <option value="13">课件分享</option>
                                            <option value="14">参考书目</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="layui-col-md9" id="filetitle" style="display:none">
                                    <label for="L_title" class="layui-form-label">标题</label>
                                    <div class="layui-input-block">
                                        <input type="text" id="L_title" name="title"
                                               class="layui-input">
                                        <!-- <input type="hidden" name="id" value="{{d.edit.id}}"> -->
                                    </div>
                                </div>
                            </div>
                            <div class="layui-row layui-col-space12 layui-form-item" id="LAY_quiz">
                                <div class="layui-col-md3">
                                    <label class="layui-form-label">所属年份</label>
                                    <div class="layui-input-block">
                                        <select name="year">
                                            <option value="2019">2019</option>
                                            <option value="2018">2018</option>
                                            <option value="2017">2017</option>
                                            <option value="2016">2016</option>
                                            <option value="2015">2015</option>
                                            <option value="2014">2014</option>
                                            <option value="2013">2013</option>
                                            <option value="2012">2012</option>
                                            <option value="2011">2011</option>
                                            <option value="2010">2010</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="layui-upload-drag" id="test10">
                                <i class="layui-icon"></i>
                                <p>点击上传，或将文件拖拽到此处</p>
                            </div>
                            <div class="layui-form-item layui-form-text">
                                <label class="layui-form-label">资源简介</label>
                                <div class="layui-input-block">
                                    <textarea name="desc" placeholder="请输入内容" class="layui-textarea"></textarea>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <div class="layui-inline">
                                    <label class="layui-form-label">悬赏积分</label>
                                    <div class="layui-input-block">
                                        <input type="text" name="integral" required lay-verify="required"
                                               autocomplete="off" class="layui-input" style="width: 177px;">
                                        <!-- <input type="hidden" name="id" value="{{d.edit.id}}"> -->
                                    </div>
                                    <div class="layui-form-mid layui-word-aux">发表后无法更改积分</div>
                                </div>
                            </div>
                            <div class="layui-col-md3">
                                <label class="layui-form-label">文件类型</label>
                                <div class="layui-input-block">
                                    <select lay-verify="required" name="filetype" lay-filter="column">
                                        <option value="tupian">图片</option>
                                        <option value="txt">txt文件</option>
                                        <option value="doc">doc文件</option>
                                        <option value="pdf">pdf文件</option>
                                        <option value="yasuo">压缩文件</option>
                                        <option value="ppt">ppt文件</option>
                                        <option value="other">其他</option>
                                    </select>
                                </div>
                            </div>
                            <script>
                                allschool = {
                                    "北京": ["北京大学", "中国人民大学", "清华大学", "北京交通大学", "北京工业大学", "北京航空航天大学", "北京理工大学", "北京科技大学", "北京化工大学", "北京邮电大学",
                                        "中国农业大学", "北京林业大学", "北京中医药大学", "北京师范大学", "北京外国语大学", "中国传媒大学", "中央财经大学", "对外经济贸易大学", "北京体育大学",
                                        "中央音乐学院", "中央民族大学", "中国政法大学", "华北电力大学", "中国矿业大学(北京)", "中国石油大学(北京)", "中国地质大学(北京)"
                                    ],
                                    "天津": ["南开大学", "天津大学", "天津医科大学"],
                                    "河北": ["华北电力大学(保定)", "河北工业大学"],
                                    "山西": ["太原理工大学"],
                                    "内蒙古": ["内蒙古大学"],
                                    "辽宁": ["辽宁大学", "大连理工大学", "东北大学", "大连海事大学"],
                                    "吉林": ["吉林大学", "延边大学", "东北师范大学"],
                                    "黑龙江": ["哈尔滨工业大学", "哈尔滨工程大学", "东北农业大学", "东北林业大学"],
                                    "上海": ["复旦大学", "同济大学", "上海交通大学", "华东理工大学", "东华大学", "华东师范大学", "上海外国语大学", "上海财经大学", "上海大学", "海军军医大学"],
                                    "江苏": ["南京大学", "苏州大学", "东南大学", "南京航空航天大学", "南京理工大学", "中国矿业大学", "河海大学", "江南大学", "南京农业大学", "中国药科大学", "南京师范大学"],
                                    "浙江": ["浙江大学"],
                                    "安徽": ["安徽大学", "中国科学技术大学", "合肥工业大学"],
                                    "福建": ["厦门大学", "福州大学"],
                                    "江西": ["南昌大学"],
                                    "山东": ["山东大学", "中国海洋大学", "中国石油大学(华东)"],
                                    "河南": ["郑州大学"],
                                    "湖北": ["武汉大学", "华中科技大学", "中国地质大学(武汉)", "武汉理工大学", "华中农业大学", "华中师范大学", "中南财经政法大学"],
                                    "湖南": ["湖南大学", "中南大学", "湖南师范大学", "国防科技大学"],
                                    "广东": ["中山大学", "暨南大学", "华南理工大学", "华南师范大学"],
                                    "海南": ["海南大学"],
                                    "广西": ["广西大学"],
                                    "四川": ["四川大学", "西南交通大学", "电子科技大学", "四川农业大学", "西南财经大学"],
                                    "重庆": ["重庆大学", "西南大学"],
                                    "贵州": ["贵州大学"],
                                    "云南": ["云南大学"],
                                    "西藏": ["西藏大学"],
                                    "陕西": ["西北大学", "西安交通大学", "西北工业大学", "西安电子科技大学", "长安大学", "西北农林科技大学", "陕西师范大学", "空军军医大学"],
                                    "甘肃": ["兰州大学"],
                                    "青海": ["青海大学"],
                                    "宁夏": ["宁夏大学"],
                                    "新疆": ["新疆大学", "石河子大学"]
                                }
                            </script>
                            <!--针对院校在jsp里弄得-->
                            <div class="layui-col-md3">
                                <select lay-filter="provinces" id="provinces" lay-verify="" name="province"
                                        onChange="set_school(this, this.form.school);">
                                    <option value="0">选择省份</option>
                                </select>
                                <select lay-filter="school" name="school" id="school">
                                    <option value="0">选择学校</option>
                                </select>
                            </div>

                            <script>
                                provinces = document.getElementById("provinces");
                                var para = document.createElement("option");
                                for (key in allschool) {
                                    para.append(key);
                                    para.value = key
                                    provinces.appendChild(para)
                                    para = document.createElement("option");
                                }
                                layui.use('form', function () {
                                    var form = layui.form;
                                     form.render();
                                    form.on('select(provinces)', function (data) {
                                        value = data.value;
                                        html = ''
                                        for (i in allschool[value]) {
                                            html += "<option value='" + allschool[value][i] + "'>" + allschool[value][i] + "</option>";
                                        }
                                        console.log(html)
                                        form.on('select(school)')
                                        school = document.getElementById("school")
                                        school.innerHTML = html;
                                        form.render();
                                    })
                                })
                            </script>
                            <div class="layui-form-item" style="padding-top:30px;clear: both;">
                                <label for="L_vercode" class="layui-form-label">人类验证</label>
                                <div class="layui-input-inline">
                                    <%--<input type="text" id="L_vercode" name="vercode" required lay-verify="required"
                                           placeholder="请回答后面的问题" autocomplete="off" class="layui-input">--%>
                                        <input type="text" id="L_vercode" class="layui-input" placeholder="请输入验证码" name="userinput"/>
                                </div>
                                <div class="layui-form-mid">
                                    <%--<span style="color: #c00;">1+1=?</span>--%>
                                    <img src="/getIdentityPic" id="identity" onclick="reloadImage()" onload="btn.disabled= false;" style="margin-top: -8px;">
                                    <input type="button" value="换个图片" onclick="reloadImage()" id="btn">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <button id="fabu" class="layui-btn" lay-filter="*" onclick="judgePic()" lay-submit>立即发布</button>  <%--id="submit"--%>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    schools = new Object();
    <c:forEach items="${provinceList}" var="province">
    schools['${province}'] = new Array(
        <c:forEach items="${schoolList}" var="school" varStatus="status">
        <c:if test="${(province==school.schoolProvince) && !status.last}">
        '${school.schoolName}',
        </c:if>
        <c:if test="${(province==school.schoolProvince) && status.last}">
        '${school.schoolName}'
        </c:if>
        </c:forEach>)
    </c:forEach>

    function set_school(province, school) {
        var pv, cv;
        var i, ii;
        pv = province.value;
        cv = school.value;
        school.length = 1;
        if (pv == '0') return;
        if (typeof(schools[pv]) == 'undefined') return;
        for (i = 0; i < schools[pv].length; i++) {
            ii = i + 1;
            school.options[ii] = new Option();
            school.options[ii].text = schools[pv][i];
            school.options[ii].value = schools[pv][i];
        }
    }

</script>
<script>
    lq = document.getElementById("LAY_quiz");
    filetitle = document.getElementById("filetitle");
    lt = document.getElementById("L_title");
    layui.use('form', function () {
        var form = layui.form;
        form.on('select(filetypes)', function (data) {
            if (data.value == 0 || data.value == 1) {
                filetitle.style.display = "none";
                lq.className = "layui-row layui-col-space12 layui-form-item"
                $("#filetitle").empty();
            } else {
                filetitle.style.display = "block";
                lq.className = "layui-row layui-col-space12 layui-form-item layui-hide"
                html = '<label for="L_title" class="layui-form-label">标题</label>' +
                    '<div class="layui-input-block">' +
                    '<input type="text" id="L_title" required lay-verify="required" name="title" class="layui-input">' +
                    '<!-- <input type="hidden" name="id" value="{{d.edit.id}}"> --></div>'
                $("#filetitle").empty();
                $("#filetitle").append(html)
            }
        });
    });
</script>
<script type="text/javascript">
    function reloadImage(){
        document.getElementById('btn').disable=true;
        document.getElementById('identity').src='/getIdentityPic?time='
            +new Date().getTime();
    }

    var userinput = document.getElementById("L_vercode");
    function judgePic() {
        var str = userinput.value.replace(/(^\s*)|(\s*$)/g, '');//去除空格;
        if(str == '' || str == undefined || str == null){
            //文本框为空
            javascript:$('body').judgenull({type:'success'});
        }else{
            $.ajax({
                //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "/judgePicCode" ,//url
                /*data: {"userinput":userinput},*/
                data: $('#shangchuanform').serialize(),
                success: function (result) {
                    console.log(result);//打印服务端返回的数据(调试用)
                    var res = result.res;
                    if(res=="ok"){
                        console.log("验证成功！");
                        document.shangchuan.submit();
                    }else{
                        console.log("验证失败！");
                        reloadImage();
                        javascript:$('body').judgefalse({type:'success'});
                    }
                },
                error : function() {
                    console.log("网崩了！")
                }
            });
        }
    }
</script>
<script charset="UTF-8" type="text/javascript"  src="/js/school/dialog.js"></script>
</body>
</html>