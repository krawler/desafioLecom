<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page isELIgnored="false"%>

<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<div class="box-name">
					<div class="col-xs-8">
						<span><h4 style="margin-top: 6px;">Listagem de Ordens
								de Serviço</h4></span>
					</div>
					<a href="<c:url value="/ordem/cadastro"/>" class="btn btn-default">Nova
						ordem de serviço</a>
				</div>
				<div class="box-icons">
					<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
					</a> <a class="expand-link"> <i class="fa fa-expand"></i>
					</a> <a class="close-link"> <i class="fa fa-times"></i>
					</a>
				</div>
				<div class="no-move"></div>
			</div>
			<div class="box-content no-padding table-responsive">
				<table
					class="table table-bordered table-striped table-hover table-heading table-datatable"
					id="datatable-2">
					<thead>
						<tr>
							<th>Cliente</th>
							<th>Serviço</th>
							<th>Ações</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ordens}" var="ordem">
							<c:forEach items="${ordem.servicos}" var="servico">
								<tr>
									<td>${ordem.cliente.nome}</td>
									<td>${servico.descricao}</td>
									<td>
										<table>
											<tr>
												<td><a
													href="<c:url value="/ordem/cadastro/${ordem.id}"/>"
													class="btn btn-default">Editar</a></td>
												<td><a
													href="<c:url value="/ordem/excluir/${ordem.id}"/>"
													class="btn btn-default">Excluir</a></td>
											</tr>
										</table>
									</td>
								</tr>
							</c:forEach>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>

						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
</div>
