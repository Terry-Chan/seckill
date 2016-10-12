<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- 引入jstl--%>
<%@include file="common/tag.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>商品秒杀列表</title>
    <%@include file="common/header.jsp" %>
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h1>商品秒杀列表</h1>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>商品名称</th>
                    <th>库存</th>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>创建时间</th>
                    <th>详情页</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="seckill" items="${list}">
                    <tr>
                        <td>${seckill.name}</td>
                        <td>${seckill.number}</td>
                        <td><fmt:formatDate value="${seckill.startTime}"
                                            pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                        <td><fmt:formatDate value="${seckill.endTime}"
                                            pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                        <td><fmt:formatDate value="${seckill.createTime}"
                                            pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                        <td>
                            <a class="btn btn-info" href="/seckill/${seckill.seckillId}/detail" target="_blank">link</a>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>