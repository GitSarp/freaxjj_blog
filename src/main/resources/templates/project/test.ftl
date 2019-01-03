<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <script src="/editor/js/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
            $("#submit").click(function(){
                var code=$("#code").val();
                alert(code);
                $.post("/test",
                        {
                            code:code,
                        },
                        function(data,status){
                            $("#result").text(data,status);
                        });
            });
        });
    </script>
</head>

<body>
<input>
    <form>
        <textarea rows="10" name="code" id="code"></textarea>
        <button type="button" value="提交" id="submit"></button>
        <textarea rows="10" name="result" id="result"></textarea>
    </form>

<#if msg??>
    <label>输出结果：${msg}</label>
</#if>

</body>
</html>