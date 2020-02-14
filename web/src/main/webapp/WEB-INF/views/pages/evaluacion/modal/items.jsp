<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<button type="button" class="btn btn-primary" data-toggle="modal" data-target=".asd${bo.id}">Items</button>
<div class="modal fade modal-${bo.id}" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
                <div class="row">
                    <div class="col-md-12">
                        <ul class="list-group">


                                <c:forEach items="${bo.items}" var="item">
                                    <li class="list-group-item">${item.value}</li>
                                </c:forEach>

                        </ul>
                    </div>
                </div>
        </div>
    </div>
</div>
</c:forEach>
