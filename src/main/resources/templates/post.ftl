<!DOCTYPE html>
<html lang="en">
<!-- Bootstrap core CSS -->
<link href="/blog_template/bootstrap.min.css" rel="stylesheet">
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <h3 class="text-center">
                ${blogDetail.title}
            </h3>
        </div>
    </div>
    <div class="row-fluid">
        <div class="span12">
            <h3 class="text-center">
                ${blogDetail.htmlMaterial}
            </h3>

            <nav aria-label="...">
                <ul class="pager">
                    <li><a href="#">Previous</a></li>
                    <li><a href="#">Next</a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>

<script src="/blog_template/jquery.min.js"></script>
<script src="/blog_template/bootstrap.min.js"></script>
</body>
</html>