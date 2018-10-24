<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8"/>
    <title>Simple example - Editor.md examples</title>
    <link rel="stylesheet" href="/editor/css/style.css"/>
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.css"/>

    <link rel="stylesheet" href="/editor/css/editormd.css"/>
    <link rel="shortcut icon" href="https://pandao.github.io/editor.md/favicon.ico" type="image/x-icon"/>
</head>
<body>

<form>
    <!--隐藏字段，根据name构造dto实体-->
    <input name="mdMaterial" id="id_input_md" type="hidden">
    <input name="htmlMaterial" id="id_input_html" type="hidden">
    <input name="isRelease" id="id_input_article_release" type="hidden">

    <!--文章标题-->
    <div class="row">
        <div class="col-6">
            <div class="input-group">
                <input name="title" type="text" class="form-control" placeholder="标题...">
                <input name="rawTags" id="id_input_article_tags" placeholder="标签...">
                <input name="introduction" id="id_input_article_introduction" placeholder="简介...">
                <span class="input-group-btn">
                    <button class="btn btn-default" type="button" id="id_btn_blog_save">保存</button>
                    <button class="btn btn-default" type="button" id="id_btn_blog_submit">发布!</button>
                </span>
            </div><!-- /input-group -->
        </div>
    </div>
    <!--md编辑器-->
    <div id="layout">
        <header>
            <h1>Simple example</h1>
        </header>
        <div id="test-editormd">
            <textarea style="display:none;"></textarea>
        </div>

    </div>

    <!--代码编译器-->
    <#--<div class="row">-->
        <#--<iframe src="http://www.it1352.com/Onlinetools/OnlineCompileCommon/4?c_height=100&r_height=100&code=&autoExecute=true" style="width:520px;height:450px;"></iframe>-->
    <#--</div>-->
</form>

<script src="/editor/js/jquery.min.js"></script>
<script src="/bootstrap/js/bootstrap.js"></script>

<script src="/editor/editormd.min.js"></script>
<script src="/business/blog_op.js"></script>
</body>
</html>