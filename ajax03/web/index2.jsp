<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>网站首页</title>
    <link rel="stylesheet" href="css/tt.css">
    <link rel="stylesheet" href="css/simplePagination.css">
</head>
<body>
<div class="top">
    <span class="top-left">下载APP</span>
    <span class="top-left"> 北京         晴天</span>
    <span class="top-right">更多产品</span>
</div>

<div class="container">

    <div class="left">
        <a>
            <img src="img/logo.png"><br/>
        </a>

        <ul>
            <li>
                <a class="channel-item active" href="#">
                    <span>
                        推荐
                    </span>
                </a>
            </li>

            <li><a class="channel-item" href="#">
                <span>
                    视频
                </span>
            </a></li>

            <li><a class="channel-item" href="#">
                <span>
                    热点
                </span>
            </a></li>

            <li><a class="channel-item" href="#">
                <span>
                    直播
                </span>
            </a></li>

            <li><a class="channel-item" href="#">
                <span>
                    图片
                </span>
            </a></li>

            <li><a class="channel-item" href="#">
                <span>
                    娱乐
                </span>
            </a></li>

            <li><a class="channel-item" href="#">
                <span>
                    游戏
                </span>
            </a></li>

            <li><a class="channel-item" href="#">
                <span>
                    体育
                </span>
            </a></li>
        </ul>

    </div>
    <div class="center">
        <ul class="news_list">

        </ul>

        <div class="content">
            <div class="pagination-holder clearfix">
                <div id="light-pagination" class="pagination"></div>
            </div>
        </div>

    </div>
</div>
</body>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/jquery.simplePagination.js"></script>
<script>
    // 1.定义当前页码和每页显示的条数
    let start = 1;
    let pageSize = 10;

    // 2.调用查询数据的方法
    queryByPage(start, pageSize);

    // 3.定义请求查询分页数据的函数，发起ajax异步请求，将数据显示到页面
    function queryByPage(start, pageSize) {
        $.ajax({
            //请求的资源路径
            url: "newsServlet2",
            //请求的参数
            data: {"start": start, "pageSize": pageSize},
            //请求的方式
            type: "POST",
            //响应数据形式
            dataType: "json",
            //请求成功后的回调函数
            success: function (pageInfo) {
                // 将数据显示到页面上
                let titles = "";
                for (let i = 0; i < pageInfo.list.length; i++) {
                    titles += "<li>\n" +
                        "                <div class=\"title-box\">\n" +
                        "                    <a href=\"#\" class=\"link\">\n" +
                        pageInfo.list[i].title +
                        "                        <hr>\n" +
                        "                    </a>\n" +
                        "                </div>\n" +
                        "            </li>";
                }
                $(".news_list").html(titles)

                // 4.为分页按钮区域设置页数参数(总页数和当前页)
                $("#light-pagination").pagination({
                    pages: pageInfo.pages,
                    currentPage: pageInfo.pageNum
                });

                // 5.为分页按钮绑定单击事件，完成上一页下一页查询功能
                $("#light-pagination .page-link").click(function () {
                    // 获取点击按钮的文本内容
                    let page = $(this).html();
                    // 如果点击的是Prev，调用查询方法，查询当前页的上一页数据
                    if (page == "Prev") {
                        queryByPage(pageInfo.pageNum - 1, pageSize);
                    } else if (page == "Next") {
                        // 如果点击的是Next，调用查询方法，查询当前页的下一页数据
                        queryByPage(pageInfo.pageNum + 1, pageSize);
                    } else {
                        // 调用查询方法，显示当前页的数据
                        queryByPage(page, pageSize);
                    }
                });
            }
        });
    }

</script>
</html>
