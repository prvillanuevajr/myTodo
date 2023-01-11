<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: presmelito
  Date: 11/01/2023
  Time: 10:51 am
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="../../includes/header.jsp"/>
<jsp:include page="../../includes/authNav.jsp"/>
<div class="container">
  <div class="row">
    <div class="col">
      <button class="btn btn-primary">Add Todo</button>
    </div>
  </div>
  <div class="row">
    <div class="col-md-8 offset-md-2">
      <table class="table table-sm table-bordered">
        <thead>
        <tr>
          <th>Title</th>
          <th>Description</th>
          <th>Target Date</th>
          <th>Completed At</th>
          <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${todos}" var="todo">
          <tr>
            <td>${todo.title}</td>
            <td>${todo.description}</td>
            <td>${todo.targetDate}</td>
            <td>${todo.completedAt}</td>
            <td></td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>
<jsp:include page="../../includes/footer.jsp"/>
