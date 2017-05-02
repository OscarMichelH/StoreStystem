<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set scope="session" var="role" value="${usuario.role}" />
            
            <c:if test="${role == 'ADMINISTRADOR'}">
                <%@include file="navbar_admin.jsp" %>
            </c:if>
            
            <c:if test="${role == 'VENDEDOR'}">
                <%@include file="navbar_vendedor.jsp" %>
                <%@include file="../home_vendedores.jsp" %>
            </c:if>

           <c:if test="${role == 'GERENTE INVENTARIO'}">
                <%@include file="navbar_gerenteInventario.jsp" %>

            </c:if>
            
            <c:if test="${role == null}">
                <%@include file="navbar_base.jsp" %>
            </c:if>  
                  <c:if test="${role != 'VENDEDOR'}">
                <%@include file="buscador.jsp" %>
            </c:if>