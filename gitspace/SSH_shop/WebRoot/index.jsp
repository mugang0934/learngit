<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <%@ include file="/public/head.jspf" %>  
  </head>  
    
  <body>  
          <a href="${pageContext.request.contextPath }/test_update.action?id=2&type=gga&hot=false">访问update</a>  
    <a href="test_save.action?id=1&type=haha&hot=true">测试ModelDriven</a>  
    <a href="test_query.action">查询所有类别</a><br/>  
    <c:forEach items="${requestScope.categoryList }" var="category">  
        ${category.id } | ${category.type } | ${category.hot } <br/>  
    </c:forEach>  
      
    <c:forEach items="${sessionScope.categoryList }" var="category">  
        ${category.id } | ${category.type } | ${category.hot } <br/>  
    </c:forEach>  
      
    <c:forEach items="${applicationScope.categoryList }" var="category">  
        ${category.id } | ${category.type } | ${category.hot } <br/>  
    </c:forEach>  
    
    <a href="send_main_aindex.action">测试到后台</a>
  </body>  
</html>  