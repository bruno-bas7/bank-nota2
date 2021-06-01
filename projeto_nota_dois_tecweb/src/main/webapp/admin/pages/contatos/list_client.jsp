<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>

<mt:admin_template>
	
	<jsp:attribute name="content">
		
		<div class="container-fluid">
          <div class="row">
            <div class="col-md-12">
   				<c:if test="${not empty sucesso}">
   					<div class="alert alert-success">${sucesso}</div>
   				</c:if>
            </div>
            
            <div class="table table-responsive table-striped table-hover">
                    <table class="table">
                      <thead class=" text-primary">
                       	  <th scope="col">ID</th>
					      <th scope="col">Nome</th>
					      <th scope="col">E-mail</th>
					      <th scope="col">Phone</th>
					      <th scope="col">Remover</th>
					      <th scope="col">Editar</th>
                      </thead>
                      <tbody>
                        <c:forEach var="client" items="${clients}">
                        	<tr>
                        		<td><c:out value="${client.id}"/></td>
                        		<td><c:out value="${client.name}"/></td>
                        		<td><c:out value="${client.email}"/></td>
                        		<td><c:out value="${client.phone}"/></td>

                        		<td>
                        			<a class="btn btn-danger" 
                        					href="${pageContext.request.contextPath}/clientServlet?id=${client.id}&acao=remover">
                        					<c:out value="Remover"/>
                        			</a>
                        		</td>	
                        		<td>
                        			<a class="btn btn-primary" 
                        					href="${pageContext.request.contextPath}/clientServlet?id=${client.id}&acao=editar">
                        					<c:out value="Editar"/>
                        			</a>
                        		</td>
                        		<td></td>
                        	</tr>
					     
                        </c:forEach>
                         <a class="btn btn-sucesso" id="btn_cadastro" href="${pageContext.request.contextPath}/admin/pages/contatos/add_client.jsp">
                        					<c:out value="Cadastrar Novo"/>
                        			</a>
                      </tbody>
                    </table>
                  </div>
                </div>
            
          </div>
        		
	</jsp:attribute>
		
</mt:admin_template>