<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<h4>Ultimas ordens adicionadas</h4>
<a href="<c:url value="/ordem/cadastro"/>" class="btn btn-default">Nova Ordem de serviço</a>

<div class="col-sm-5">
	<div class="box-content no-padding table-responsive">
		<table
			class="table m-table table-bordered table-hover table-heading"
			id="datatable-2">
			<thead>
				<tr>
					<th>Cliente</th>
					<th>Serviço</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ordens}" var="ordem">
					<tr>
						<td>${ordem.cliente.nome}</td>
						<td>${ordem.servico.descricao}</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
				  <td></td>	
				</tr>
			</tfoot>
		</table>
	</div>
</div>
<!-- id="ticker-table" -->