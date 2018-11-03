<%--
  Created by IntelliJ IDEA.
  User: 孙程程
  Date: 2018/10/30
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发帖功能实现</title>
    <style type="text/css">
        #editor{
            margin: auto;
            margin-top: 50px;
            width: 800px;
        }
        .title{
            margin: 30px 0;
        }
        #title{
            resize: none;
            border: 0;
            height: 44px;
            min-height: 44px;
            display: block;
            width: 100%;
            font-size: 32px;
            line-height: 1.4;
            font-weight: 600;
            overflow: hidden;
        }
        .toolbar {
            border: 1px solid #ccc;
            border-bottom: 0;
        }
        .text {
            height: 300px;
            border: 1px solid #ccc;
            overflow: hidden;
        }
        .submit{
            text-align: center;
            width: 800px;
            margin: 10px 0;
        }
        #submit{
            width: 80px;
            height: 30px;
            background-color: unset;
            border: 1px solid #c24f4a;
        }
    </style>
</head>
<body>
    <form id="editor" action="postServlet" method="post">
        <div class="title">
            <textarea id="title"> 请输入标题 </textarea>
        </div>
        <div id="div1" class="toolbar">
        </div>
        <div id="div2" class="text" > <!--可使用 min-height 实现编辑区域自动增加高度-->
            <p id="text">欢迎来到优图南社区</p>
        </div>
        <div class="submit" >
            <input type="submit" value="发表" id="submit"/>
            <input type="hidden" name="hidden1" id="hidden1"/>
            <input type="hidden" name="hidden2" id="hidden2"/>
        </div>
    </form>

    <!-- script -->
    <script type="text/javascript" src="js/wangEditor.min.js"></script>
    <script type="text/javascript">
        var E = window.wangEditor;
        var editor = new E('#div1', '#div2');
        //editor.customConfig.uploadImgServer = '/upload'; // 上传图片到服务器
        editor.customConfig.uploadImgShowBase64 = true;  // 使用 base64 保存图片
        //自定义菜单选项
        editor.customConfig.menus = [
            'bold',  // 粗体
            'fontSize',  // 字号
            'fontName',  // 字体
            'italic',  // 斜体
            'underline',  // 下划线
            'strikeThrough',  // 删除线
            'foreColor',  // 文字颜色
            'backColor',  // 背景颜色
            'link',  // 插入链接
            'list',  // 列表
            'justify',  // 对齐方式
            'quote',  // 引用
            'emoticon',  // 表情
            'image',  // 插入图片
            'table',  // 表格
            'video',  // 插入视频
            'code',  // 插入代码
            'undo',  // 撤销
            'redo'  // 重复
        ];
        // 表情面板可以有多个 tab ，因此要配置成一个数组。数组每个元素代表一个 tab 的配置
        editor.customConfig.emotions = [
            {
                // tab 的标题
                title: '默认',
                // type -> 'emoji' / 'image'
                type: 'image',
                // content -> 数组
                content: [
                    {
                        alt: '[坏笑]',
                        src: 'http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/50/pcmoren_huaixiao_org.png'
                    }, {
                        alt: '[舔屏]',
                        src: 'http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/40/pcmoren_tian_org.png'
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/7a/shenshou_thumb.gif",
                        alt : "[草泥马]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/60/horse2_thumb.gif",
                        alt : "[神马]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/bc/fuyun_thumb.gif",
                        alt : "[浮云]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/c9/geili_thumb.gif",
                        alt : "[给力]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/f2/wg_thumb.gif",
                        alt : "[围观]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/70/vw_thumb.gif",
                        alt : "[威武]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/6e/panda_thumb.gif",
                        alt : "[熊猫]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/81/rabbit_thumb.gif",
                        alt : "[兔子]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/bc/otm_thumb.gif",
                        alt : "[奥特曼]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/15/j_thumb.gif",
                        alt : "[囧]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/89/hufen_thumb.gif",
                        alt : "[互粉]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/c4/liwu_thumb.gif",
                        alt : "[礼物]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/ac/smilea_thumb.gif",
                        alt : "[呵呵]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/0b/tootha_thumb.gif",
                        alt : "[嘻嘻]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/6a/laugh.gif",
                        alt : "[哈哈]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/14/tza_thumb.gif",
                        alt : "[可爱]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/af/kl_thumb.gif",
                        alt : "[可怜]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/a0/kbsa_thumb.gif",
                        alt : "[挖鼻屎]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/f4/cj_thumb.gif",
                        alt : "[吃惊]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/6e/shamea_thumb.gif",
                        alt : "[害羞]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/c3/zy_thumb.gif",
                        alt : "[挤眼]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/29/bz_thumb.gif",
                        alt : "[闭嘴]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/71/bs2_thumb.gif",
                        alt : "[鄙视]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/6d/lovea_thumb.gif",
                        alt : "[爱你]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/9d/sada_thumb.gif",
                        alt : "[泪]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/19/heia_thumb.gif",
                        alt : "[偷笑]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/8f/qq_thumb.gif",
                        alt : "[亲亲]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/b6/sb_thumb.gif",
                        alt : "[生病]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/58/mb_thumb.gif",
                        alt : "[太开心]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/17/ldln_thumb.gif",
                        alt : "[懒得理你]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/98/yhh_thumb.gif",
                        alt : "[右哼哼]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/6d/zhh_thumb.gif",
                        alt : "[左哼哼]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/a6/x_thumb.gif",
                        alt : "[嘘]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/af/cry.gif",
                        alt : "[衰]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/73/wq_thumb.gif",
                        alt : "[委屈]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/9e/t_thumb.gif",
                        alt : "[吐]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/f3/k_thumb.gif",
                        alt : "[打哈欠]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/27/bba_thumb.gif",
                        alt : "[抱抱]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/7c/angrya_thumb.gif",
                        alt : "[怒]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/5c/yw_thumb.gif",
                        alt : "[疑问]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/a5/cza_thumb.gif",
                        alt : "[馋嘴]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/70/88_thumb.gif",
                        alt : "[拜拜]"
                    }, {
                        src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/e9/sk_thumb.gif",
                        alt : "[思考]"
                    }
                ]
            },
            {
                // tab 的标题
                title: 'emoji',
                // type -> 'emoji' / 'image'
                type: 'emoji',
                // content -> 数组
                content: ['😀', '😃', '😄', '😁', '😆']
            }
        ];
        editor.create();
        //设置标题和文本框点击置空
        var once1 = true;
        var once2 = true;
        document.getElementById('title').addEventListener('click', function () {
            if(once1){
                var title = document.getElementById("title");
                title.innerText="";
                once1 = false;
            }
        }, false);
        document.getElementById('div2').addEventListener('click', function () {
            if(once2){
                var text = document.getElementById("text");
                text.innerText="";
                once2 = false;
            }
        }, false);
        //设置隐藏域内容
        document.getElementById('submit').addEventListener('click', function () {
            //获取标题内容
            var hid1 = document.getElementById("hidden1");
            hid1.value=document.getElementById("title").value;
            //获取帖子内容（html格式）
            var hid2 = document.getElementById("hidden2");
            hid2.value=editor.txt.html();
        }, false);
    </script>
</body>
</html>
