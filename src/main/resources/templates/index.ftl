<!DOCTYPE html>
<!-- saved from url=(0038)https://v3.bootcss.com/examples/blog/# -->
<html lang="zh-CN"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://v3.bootcss.com/favicon.ico">

    <title>Blog Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="/blog_template/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="/blog_template/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/blog_template/blog.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="/blog_template/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript">//================================================

    (ytCinema = {
        players: {objs: [], active: 0},
        messageEvent: new Event('ytCinemaMessage'),
        playerStateChange: function (stateId) {
            var message = document.getElementById("ytCinemaMessage"),
                    stateIO = "playerStateChange:".concat(stateId);
            // console.log("Debug " + message.textContent + " " +stateIO);
            if (message && message.textContent !== stateIO) {
                message.textContent = stateIO;
                message.dispatchEvent(ytCinema.messageEvent);
            }
        },
        initialize: function () {
            this.messageEvent;
            window.addEventListener("load", initvideoinject, false);
            document.addEventListener("DOMContentLoaded", initvideoinject, false);
            initvideoinject();

            // New Mutation Summary API Reference
            var MutationObserver = window.MutationObserver || window.WebKitMutationObserver || window.MozMutationObserver;
            if(MutationObserver) {
                // setup MutationSummary observer
                var videolist = document.querySelector('body');
                var observer = new MutationObserver(function (mutations, observer) {
                    mutations.forEach(function (mutation) {
                        if(mutation.target.tagName == "VIDEO") {
                            if (mutation.attributeName === "src") {
                                initvideoinject();
                            }
                        }
                        if(typeof mutation.addedNodes == "VIDEO" || typeof mutation.removedNodes == "VIDEO") {
                            initvideoinject();
                        }
                    });
                });

                observer.observe(videolist, {
                    subtree: true,       // observe the subtree rooted at ...videolist...
                    childList: true,     // include childNode insertion/removals
                    characterData: false, // include textContent changes
                    attributes: true     // include changes to attributes within the subtree
                });
            } else {
                // setup DOM event listeners
                document.addEventListener("DOMNodeRemoved", initvideoinject, false);
                document.addEventListener("DOMNodeInserted", initvideoinject, false);
            }

            function initvideoinject(e) {
                var youtubeplayer = document.getElementById("movie_player") || null;
                var htmlplayer = document.getElementsByTagName("video") || false;

                if(youtubeplayer !== null) { // YouTube video element
                    var interval = window.setInterval(function () {
                        if (youtubeplayer.pause || youtubeplayer.pauseVideo) {
                            window.clearInterval(interval);
                            if (youtubeplayer.pauseVideo) {youtubeplayer.addEventListener("onStateChange", "ytCinema.playerStateChange");}
                        }
                    }, 10);
                }
                if(htmlplayer && htmlplayer.length > 0) { // HTML5 video elements
                    var setPlayerEvents = function(players) {
                        for(var j=0; j<players.length; j++) {
                            (function(o, p) {
                                var ev = {
                                    pause: function() {if(!p.ended) {o.players.active -= 1;} if(o.players.active < 1){o.playerStateChange(2);}},
                                    play: function() {o.players.active += 1; o.playerStateChange(1);},
                                    ended: function() {o.players.active -= 1; if(o.players.active < 1){o.playerStateChange(0);}}
                                };
                                p.removeEventListener("pause", ev.pause); p.removeEventListener("play", ev.play); p.removeEventListener("ended", ev.ended);

                                p.addEventListener("pause", ev.pause);
                                p.addEventListener("play", ev.play);
                                p.addEventListener("ended", ev.ended);
                                o.players.objs.push(p);
                            }(this.ytCinema, htmlplayer[j]));
                        }
                    };

                    setPlayerEvents(htmlplayer);

                    (function(o) {
                        var triggerDOMChanges = function() {
                            var htmlplayer = document.getElementsByTagName("video") || null;

                            if(htmlplayer == null || htmlplayer.length === 0) {o.players.active = 0; if(o.players.active < 1){o.playerStateChange(0);} return;}

                            o.players.active = 0;

                            for(var j=0; j<htmlplayer.length; j++) {
                                if(!htmlplayer[j].paused && !htmlplayer[j].ended) {
                                    o.players.active += 1;
                                }
                            }
                            if(o.players.active < 1){o.playerStateChange(0);}

                            setPlayerEvents(htmlplayer);
                        };

                    }(this.ytCinema));
                }
            }
        }
    }).initialize();</script></head>

<body>

<div class="blog-masthead">
    <div class="container">
        <nav class="blog-nav">
            <a class="blog-nav-item active" href="/index">Home</a>
            <a class="blog-nav-item" href="https://v3.bootcss.com/examples/blog/#">Projects</a>
            <a class="blog-nav-item" href="https://v3.bootcss.com/examples/blog/#">Media</a>
            <a class="blog-nav-item" href="https://v3.bootcss.com/examples/blog/#">Album</a>
            <a class="blog-nav-item" href="https://v3.bootcss.com/examples/blog/#">About</a>
            <form class="blog-nav-item navbar-form" style="margin-left: 270px">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Search</button>
            </form>
            <ul class="blog-nav-item nav navbar-nav navbar-right">
                <button type="button" class="btn btn-default navbar-btn">Sign in</button>
            </ul>
        </nav>
    </div>
</div>

<div class="container">

    <div class="blog-header">
        <h1 class="blog-title">The Bootstrap Blog</h1>
        <p class="lead blog-description">The official example template of creating a blog with Bootstrap.</p>
    </div>

    <div class="row">

        <div class="col-sm-8 blog-main">
        <#if blogList??>
            <#if (blogList?size>0)>
            <#list blogList as items>
                <div class="blog-post">
                    <a href="/post/${items.id}"><h2 class="blog-post-title">${items.title}</h2></a>
                    <p class="blog-post-meta">${items.gmtModified?string('yyyy-MM-dd HH:mm:ss')} by <a href="https://v3.bootcss.com/examples/blog/#">FreaxJJ</a></p>
                    <p>${items.introduction}</p>
                </div><!-- /.blog-post -->
            </#list>
            </#if>
        </#if>

            <#--<nav>-->
                <#--<ul class="pager">-->
                    <#--<li><a href="https://v3.bootcss.com/examples/blog/#">Previous</a></li>-->
                    <#--<li><a href="https://v3.bootcss.com/examples/blog/#">Next</a></li>-->
                <#--</ul>-->
            <#--</nav>-->

            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <#list 1..pageNum as i>
                        <li><a href="/page/${i}?gmtCreateStr=${gmtCreateStr}">${i}</a></li>
                    </#list>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>

        </div><!-- /.blog-main -->

        <div class="col-sm-3 col-sm-offset-1 blog-sidebar">
            <div class="sidebar-module sidebar-module-inset">
                <h4>Tags</h4>
                <input name="tag" id="id_input_tag" type="hidden">
                <ol class="list-unstyled">
                    <#if tagList??>
                        <#if (tagList?size>0)>
                            <#list tagList as item>
                                <li><a href="/page/1">${item.tagName!"默认"}(${item.articleCount})</a></li>
                            </#list>
                        </#if>
                    </#if>
                </ol>
                <#--<p>Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras mattis consectetur purus sit amet fermentum. Aenean lacinia bibendum nulla sed consectetur.</p>-->
            </div>

            <div class="sidebar-module">
                <h4>Archives</h4>
                <input name="time" id="id_input_time" type="hidden">
                <ol class="list-unstyled">
                    <#--<li><a href="https://v3.bootcss.com/examples/blog/#">March 2014</a></li>-->
                    <#if archiveList??>
                        <#if (archiveList?size>0)>
                            <#list archiveList as item>
                                <li><a href="/page/1?gmtCreateStr=${item.gmtCreateStr}">${item.gmtCreateStr}(${item.articleCount})</a></li>
                            </#list>
                        </#if>
                    </#if>
                </ol>
            </div>

            <div class="sidebar-module">
                <h4>Elsewhere</h4>
                <ol class="list-unstyled">
                    <li><a href="https://www.github.com/GitSarp/#">GitHub</a></li>
                    <li><a href="https://v3.bootcss.com/examples/blog/#">Twitter</a></li>
                    <li><a href="https://v3.bootcss.com/examples/blog/#">Facebook</a></li>
                </ol>
            </div>
        </div><!-- /.blog-sidebar -->

    </div><!-- /.row -->

</div><!-- /.container -->

<footer class="blog-footer">
    <p>Blog template built for <a href="http://getbootstrap.com/">Bootstrap</a> by <a href="https://twitter.com/mdo">@mdo</a>.</p>
</footer>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="/blog_template/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="/blog_template/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="/blog_template/ie10-viewport-bug-workaround.js"></script>


<div id="ytCinemaMessage" style="display: none;"></div></body></html>