<!DOCTYPE html>
<html lang="en">
<head>
<link href="/bootstrap/css/bootstrap-grid.css" rel="stylesheet">

<link href="/blog_template/bootstrap.min.css" rel="stylesheet">
<link href="/blog_template/blog.css" rel="stylesheet">
<#-- EditorMD -->
<link href="/editor/css/editormd.css" rel="stylesheet">
</head>
<body>
<#--<div class="container-fluid">-->
    <#--<div class="row-fluid">-->
        <#--<div class="span12">-->
            <#--<h3 class="text-center">-->
                <#--${blogDetail.title}-->
            <#--</h3>-->
        <#--</div>-->
    <#--</div>-->
    <#--<div class="row-fluid">-->
        <#--<div class="span12">-->
            <#--<h3 class="text-center">-->
                <#--<p>${blogDetail.htmlMaterial}</p>-->
            <#--</h3>-->

            <#--<nav aria-label="...">-->
                <#--<ul class="pager">-->
                    <#--<li><a href="#">Previous</a></li>-->
                    <#--<li><a href="#">Next</a></li>-->
                <#--</ul>-->
            <#--</nav>-->
        <#--</div>-->
    <#--</div>-->
<#--</div>-->

<div class="blog-masthead">
    <div class="container">
        <#include "public/nav.ftl">
    </div>
</div>

<div class="container container-fluid cus_content">
<#-- 博客标题 -->
    <div class="row" style="margin-top: 3rem"></div>
    <div class="row style="margin-top: 3rem">
    <#-- 博客内容 -->
        <div class="col-md-8 offset-md-2">
            <h3 class="p-3 font-weight-bold">${blogDetail.title!'标题'}</h3>
            <div class="row pl-3 pr-3">
                <div class="col-md-6"></div>
                <div class="col-md-6 text-md-right">
                    <p class="small text-secondary">${blogDetail.gmtModified?string('yyyy-MM-dd')!""}</p>
                </div>
            </div>
        ${blogDetail.htmlMaterial!'文章内容'}
        </div>
    </div>

    <div class="row style="margin-top: 3rem;margin-bottom: 3rem">
        <nav aria-label="...">
            <ul class="pager">
                <li><a href="#">Previous</a></li>
                <li><a href="#">Next</a></li>
            </ul>
        </nav>
    </div>
</div>

<script src="/blog_template/jquery.min.js"></script>
<script src="/blog_template/bootstrap.min.js"></script>

</body>
</html>