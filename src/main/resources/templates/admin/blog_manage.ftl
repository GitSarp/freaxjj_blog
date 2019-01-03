<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8"/>
    <title>Simple example - Editor.md examples</title>
    <#--<link rel="stylesheet" href="/editor/css/style.css"/>-->
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="/bootstrap/table/bootstrap-table.css"/>
    <#--<link rel="stylesheet" href="/editor/css/editormd.css"/>-->
    <link rel="shortcut icon" href="https://pandao.github.io/editor.md/favicon.ico" type="image/x-icon"/>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">查询</h3>
            </div>
            <div class="panel-body">
                Panel content
            </div>
        </div>
    </div>

    <div id="toolbar" class="btn-group">
        <button id="btn_add" type="button" class="btn btn-default">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
        </button>
        <button id="btn_edit" type="button" class="btn btn-default">
            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
        </button>
        <button id="btn_delete" type="button" class="btn btn-default">
            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
        </button>
    </div>

    <div class="row" style="margin-top: 20px">
        <table data-toggle="table">
            <thead>
            <tr>
                <th>Item ID</th>
                <th>Item Name</th>
                <th>Item Price</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>Item 1</td>
                <td>$1</td>
            </tr>
            <tr>
                <td>2</td>
                <td>Item 2</td>
                <td>$2</td>
            </tr>
            </tbody>
        </table>
    </div>

    <#--<table data-toggle="table" data-url="data1.json">-->
        <#--<thead>-->
        <#--<tr>-->
            <#--<th data-field="id">Item ID</th>-->
            <#--<th data-field="name">Item Name</th>-->
            <#--<th data-field="price">Item Price</th>-->
        <#--</tr>-->
        <#--</thead>-->
    <#--</table>-->


</div>

<#--&lt;#&ndash; s 页面内容 &ndash;&gt;-->
<#--<div id="page-wrapper">-->
<#--&lt;#&ndash; s 页面内容 &ndash;&gt;-->
    <#--<!-- 按钮组 &ndash;&gt;-->
    <#--<div id="toolbar" class="btn-group">-->
        <#--<button id="id_btn_add" type="button" class="btn btn-default">-->
            <#--<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 新增-->
        <#--</button>-->
        <#--<button id="id_btn_edit" type="button" class="btn btn-default">-->
            <#--<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> 修改-->
        <#--</button>-->
        <#--<button id="id_btn_delete" type="button" class="btn btn-default">-->
            <#--<span class="glyphicon glyphicon-remove" aria-hidden="true"></span> 删除-->
        <#--</button>-->
    <#--</div>-->
    <#--<!-- s 表格 &ndash;&gt;-->
    <#--<table id="id_table_blog">-->

    <#--</table>-->
    <#--<!-- e 表格 &ndash;&gt;-->
<#--&lt;#&ndash; e 页面内容 &ndash;&gt;-->
<#--</div>-->
<#--&lt;#&ndash; e 页面内容 &ndash;&gt;-->

<script src="/editor/js/jquery.min.js"></script>
<script src="/bootstrap/js/bootstrap.js"></script>
<script src="/bootstrap/table/bootstrap-table.js"></script>
</body>
</html>