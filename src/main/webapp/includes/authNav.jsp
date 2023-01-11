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
      <li>
        <form action="<%= request.getContextPath() %>/logout" id="logoutForm" method="post" style="display: none">
        </form>
        <a href="#" onclick="document.querySelector('#logoutForm').submit()">Logout</a>
      </li>
    </ul>
  </nav>
</header>
