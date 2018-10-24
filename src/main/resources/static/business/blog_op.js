/* 博客发布 */
// Markdown 编辑器
var testEditor;

$(function () {
    testEditor = editormd("test-editormd", {
        width: "90%",
        height: 640,
        syncScrolling: "single",
        path: "/editor/lib/"
    });

    /*
    // or
    testEditor = editormd({
        id      : "test-editormd",
        width   : "90%",
        height  : 640,
        path    : "../lib/"
    });
    */


    //保存按钮绑定函数
    $("#id_btn_blog_save").bind("click", function () {
        /* markdown 格式文本 */
        $("#id_input_md").val(testEditor.getMarkdown());
        /* html 格式内容 */
        $("#id_input_html").val($(".markdown-body").prop('outerHTML'));
        $("#id_input_article_release").val(false);
        submitBlogAddForm();
    });

    //发布按钮绑定函数
    $("#id_btn_blog_submit").bind("click", function () {
        /* markdown 格式文本 */
        $("#id_input_md").val(testEditor.getMarkdown());
        /* html 格式内容 */
        $("#id_input_html").val($(".markdown-body").prop('outerHTML'));
        $("#id_input_article_release").val(true);
        submitBlogAddForm();
    });

    // $('#id_btn_release_in_modal').bind('click', function () {
    //     saveDetailText();
    //     submitBlogAddForm();
    // });
});

/**
 * 提交文章表单
 */
function submitBlogAddForm(is_release) {

    // 提交表单
    var form = document.forms[0];
    form.action = "/admin/blogadd";
    form.method = "post";
    form.submit();
}
