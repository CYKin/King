<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 跳转到登录页面之前的URL -->
<%--<%--%>
    <%--String redirectUrl = (String) request.getSession().getAttribute("redirectUrl");--%>
    <%--String bikeNo = (String) request.getSession().getAttribute("bikeNo");--%>
    <%--request.setAttribute("url", redirectUrl);--%>
    <%--request.setAttribute("bikeNo", bikeNo);--%>
<%--%>--%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1.0"/>
    <title>登录</title>
    <!-- 引入 Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- 引入自定义css -->
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <!-- 包括所有已编译的插件 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body class="login">
<div class="container a ">
    <div class="row center-vertical">
        <%--屏蔽框--%>
        <div class="hidebox" align="center">
            <img src="${pageContext.request.contextPath}/images/Loading.gif"
                 style="width: 69.6px;height: 44.8px;top:50%;left:50%;margin-top:322px;border-radius:6px;"/>
        </div>
        <div class="col-sm-4 col-sm-offset-4 ">
            <br><br><br>

            <form class="bs-example bs-example-form" role="form">
                <div class="input-control" align="center" style="margin-bottom: 10px">
                    <img src="${pageContext.request.contextPath}/images/logo.jpg" style="width: 60px;height: 60px"/>

                    <h1>租借单车</h1>
                </div>
                <div class="input-group input-group-lg">
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-phone"></span>
                    </span>
                    <input type="text" class="form-control input-lg" id="userPhone" name="userPhone"
                           placeholder="请输入手机号" maxlength="11" onkeyup="this.value=this.value.replace(/\D/g,'')"
                           onafterpaste="this.value=this.value.replace(/\D/g,'')">
                    <span class="glyphicon form-control-feedback"></span>
                </div>
                <br>

                <div class="input-group input-group-lg">
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-picture"></span>
                    </span>
                    <input type="text" name="kaptcha" class="form-control input-lg" id="kaptcha" placeholder="请输入验证码">
                    <span class="glyphicon form-control-feedback"></span>
                    <span class="input-group-addon-kaptcha">
                        <img src="${pageContext.request.contextPath}/login/getkaptchaCode.do" id="kaptchaImage"
                             style="cursor:pointer">
                    </span>
                </div>
                <br>

                <div class="form-group center">
                    <p align="center">
                        <button type="button" class="btn btn-lg btn-md btn-primary" id="submit">登录</button>
                    </p>
                </div>
                <button type="button" id="showBox">显示</button>
            </form>
        </div>
    </div>
</div>
</body>
<script>

    //更换验证码
    $("#kaptchaImage").click(function () {
        $(this).attr('src', '${pageContext.request.contextPath}/login/getkaptchaCode.do?' + Math.floor(Math.random() * 100));
    });

    //校验手机号格式
    function checkUserPhone() {
        var $userPhone = $("#userPhone");
        var userPhone = $userPhone.val();
        if (!userPhone) {
            addCheckError($userPhone);
            return false;
        }
        var reg = /^1[3|4|5|7|8][0-9]{9}$/; //手机号验证规则
        if (!reg.test(userPhone)) {
            addCheckError($userPhone);
            return false;
        }
        addCheckOk($userPhone);
        return userPhone;
    }

    //校验验证码格式
    function checkKaptcha() {
        var $kaptcha = $("#kaptcha");
        var kaptcha = $kaptcha.val();
        if (!kaptcha) {
            addCheckError($kaptcha);
            return false;
        }
        var regKaptcha = /^[0-9a-zA-Z]{4}$/;//验证码验证规则
        if (!regKaptcha.test(kaptcha)) {
            addCheckError($kaptcha);
            return false;
        }
        //addCheckOk($kaptcha);
        return kaptcha;
    }

    //添加校验错误样式
    function addCheckError($element) {
        $element.parent("div").addClass("has-error");
        $element.next("span").addClass("glyphicon-remove-sign");
    }
    //移除校验错误样式
    function removeCheckError($element) {
        $element.parent("div").removeClass("has-error");
        $element.next("span").removeClass("glyphicon-remove-sign");
    }
    //添加校验成功样式
    function addCheckOk($element) {
        $element.parent("div").addClass("has-success");
        $element.next("span").addClass("glyphicon-ok-sign");
    }
    //移除校验成功样式
    function removeCheckOk($element) {
        $element.parent("div").removeClass("has-success");
        $element.next("span").removeClass("glyphicon-ok-sign");
    }

    //当输入框获得焦点时，移除成功或失败样式
    $("#userPhone,#kaptcha").on("focus", function () {
        removeCheckError($(this));
        removeCheckOk($(this));
    });

    //登录
    $("#submit").on("click", function () {
        showBox();
        var userPhone = checkUserPhone();
        if (!userPhone) {
            hideBox();
            return false;
        }
        var kaptcha = checkKaptcha();
        if (!kaptcha) {
            hideBox();
            return false;
        }
        var url = "${url}";
        if (!url) {
            window.location.href = "${pageContext.request.contextPath }/index.jsp";
            return;
        }
        url = "${url}" + "?bikeNo=" + "${bikeNo}";
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath }/login/login.do",
            data: {
                userPhone: userPhone,
                kaptcha: kaptcha
            },
            dataType: "json",
            success: function (data) {
                console.info("data:" + data);
                if (data.kaptchaFlag) {
                    //alert("验证码正确");
                    addCheckOk($("#kaptcha"));
                    if (data.userFlag) {
                        window.location.href = url;
                    } else {
                        alert("用户不存在");
                        hideBox();
                    }
                } else {
                    alert("验证码错误");
                    addCheckError($("#kaptcha"));
                    hideBox();
                }
            }
        });
    });
    $("#showBox").click(function () {
        showBox();
    });
    $("#hideBox").click(function () {
        hideBox();
    });
    //页面屏蔽不可点击
    function showBox() {
        $(".hidebox").show().height($(window).height());
    }
    //去除隐藏层和弹出层
    function hideBox() {
        $(".hidebox").hide();
    }
</script>
</html>
