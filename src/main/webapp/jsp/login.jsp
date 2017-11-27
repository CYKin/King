<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<body class="login">
<div>
    <input type="text" name="checkCode" id="code">
    <img src="${pageContext.request.contextPath}/login/getKaptcha" id="kaptchaImage" style="width: 90px;height: 35px"/>
    <input type="submit" value="提交" onclick="checkKaptcha()">
</div>

<script type="text/javascript">
    $(function () {
        // 验证码渐变效果切换
        $('#kaptchaImage').click(
            function () {
                $(this).hide().attr('src', '${pageContext.request.contextPath}/login/getKaptcha?' + Math.floor(Math.random() * 100)).fadeIn();
            }
        );
    });

    function checkKaptcha() {
        $.ajax({
            type: "post",
            dataType: "json",
            url: '${pageContext.request.contextPath}/login/checkKaptcha?random=' + Math.random(),
            data: {
                "checkCode": $('#code').val()
            },
            success: function (data) {
                alert(data);
            }
        });
    }

</script>

</body>
</html>
