<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="content">
  <div class="row">
    <div class="col-md-12">
      <div class="card">
        <div class="card-header">
          <h4 class="card-title"> Usuarios</h4>
        </div>
        <div class="card-body">
          <div class="table-responsive">
            <table class="table">
              <thead class=" text-primary">

              <th>Usuario</th>
              <th>Mail</th>
              <th>Rol</th>


              </thead>
              <tbody>

              <c:forEach items="${usuarios}" var="bo">
                <tr>
                  <td>${bo.username}</td>
                  <td>${bo.mail}</td>
                </tr>
              </c:forEach>

              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>