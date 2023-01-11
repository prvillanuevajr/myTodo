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
      <form action="<%=request.getContextPath()%>/todos" method="post">
        <div class="form-group">
          <label for="title">Title:</label>
          <input type="text" class="form-control" id="title" placeholder="Title" name="title" required>
        </div>
        <div class="form-group">
          <label for="description">Description:</label>
          <input type="text" class="form-control" id="description" placeholder="Description" name="description" required>
        </div>
        <div class="form-group">
          <label for="targetDate">Description:</label>
          <input type="datetime-local" class="form-control" id="targetDate" placeholder="Description" name="targetDate" required>
        </div>
        <button class="btn btn-success">save</button>
      </form>
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
