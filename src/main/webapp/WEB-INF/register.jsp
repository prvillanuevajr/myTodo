<%--
  Created by IntelliJ IDEA.
  User: presmelito
  Date: 11/01/2023
  Time: 7:09 am
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="../includes/header.jsp"/>
<jsp:include page="../includes/guessNav.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="card">
                <div class="card-body">
                    <form action="<%=request.getContextPath()%>/register" method="post">
                        <div class="form-group">
                            <label for="firstName">First Name:</label>
                            <input type="text" class="form-control" id="firstName" placeholder="First Name" name="firstName" required>
                        </div>
                        <div class="form-group">
                            <label for="lastName">Last Name:</label>
                            <input type="text" class="form-control" id="lastName" placeholder="Last Name" name="lastName" required>
                        </div>
                        <div class="form-group">
                            <label for="userName">User Name:</label>
                            <input type="text" class="form-control" id="userName" placeholder="User Name" name="userName" required>
                        </div>
                        <div class="form-group">
                            <label for="password">Password:</label>
                            <input type="password" class="form-control" id="password" placeholder="password" name="password" required>
                        </div>
                        <button class="btn btn-success">Register</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../includes/footer.jsp"/>
