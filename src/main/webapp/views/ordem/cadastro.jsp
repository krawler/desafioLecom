<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false" %>

<sf:form modelAttribute="ordemServico" action="incluir"  method="POST">
	
	<div class="form-group col-sm-12">
		<label for="cliente" class="col-sm-1 control-label">
		 <sf:errors cssClass="has-error" path="cliente"/>
		 Cliente
		</label>
		<div class="col-sm-5">
			<sf:select path="cliente" class="form-control">
				<sf:options items="${ clientes }" itemValue="id" itemLabel="nome" />
				<!-- 
				<c:forEach items="${ clientes }" var="cliente">
					<sf:option value="${ cliente }">${cliente.nome}</sf:option>
				</c:forEach>
				 -->
			</sf:select>
		</div>
	</div>
	
	<div class="form-group col-sm-12">
		<label for="servicos" class="col-sm-1 control-label">
		 <sf:errors cssClass="has-error" path="servicos"/>
		 Serviços 	
		</label>
		<div class="col-sm-5">
			<sf:select path="servicos" class="form-control">
				<sf:options items="${ servicos }" itemValue="id" itemLabel="descricao" />
				<!-- 
				<c:forEach items="${servicos}" var="servico">
					<sf:option value="${ servico }">${servico.descricao}</sf:option>
				</c:forEach>
				 -->
			</sf:select>
		</div>
	</div>
	
	<c:if test="${ ordemServico.id != null }">
		<div class="form-group col-sm-4 col-sm-offset-2 right">
			<a href="<c:url value="/cliente/finalizar"/>" class="btn btn-default">Finalizar Serviço</a>
		</div>
	</c:if>
	
	<div class="form-group col-sm-4 col-sm-offset-2 right">
		<button type="submit" class="btn btn-primary">Gravar</button>
	</div>
</sf:form>