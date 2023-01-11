<%--
  Created by IntelliJ IDEA.
  User: presmelito
  Date: 11/01/2023
  Time: 7:26 am
  To change this template use File | Settings | File Templates.
--%>
<header>
    <nav class="navbar navbar-expand-md bg-dark navbar-dark">
        <div>
            <a href="#" class="navbar-brand"> My Todo</a>
        </div>

        <ul class="navbar-nav navbar-collapse justify-content-end">
            <li><a href="<%= request.getContextPath() %>/login" class="nav-link">Login</a></li>
            <li><a href="<%= request.getContextPath() %>/register" class="nav-link">Signup</a></li>
        </ul>
    </nav>
</header>
