<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Paciente</title>
<link href="styles/styles.css" rel="stylesheet" type="text/css">
<script src="includes/scripst.js"></script>
</head>
<body>

<s:action name="menu" executeResult="true"></s:action>

<p class="pTitulo">Pacientes</p>

<table class="tableList">

	<tr class="trTitulo">
		<td width="5%">ID</td>
		<td width="35%">Nome</td>
		<td width="20%">CPF</td>
		<td width="30%">Endereço</td>
		<td width="5%"></td>
		<td width="5%"></td>
	</tr>
	
	<s:iterator value="pacientes">
	
		<tr>
			<td><s:property value="id" /></td>
			<td><s:property value="nome" /></td>
			<td><s:property value="cpf" /></td>
			<td><s:property value="endereco" /></td>
			<td>
				<s:url action="formPaciente" var="urlEdit" escapeAmp="false">
					<s:param name="paciente.id"><s:property value="id" /></s:param>
					<s:param name="paciente.nome"><s:property value="nome" /></s:param>
					<s:param name="paciente.cpf"><s:property value="cpf" /></s:param>
					<s:param name="paciente.endereco"><s:property value="endereco" /></s:param>
				</s:url>
				<a href="<s:property value="#urlEdit" />" title="Editar">
					<img src="images/editar.png">
				</a>
			</td>
			<td>
				<s:url action="removerPaciente" var="urlDelete" escapeAmp="false">
					<s:param name="paciente.id"><s:property value="id" /></s:param>
				</s:url>
				<a href="<s:property value="#urlDelete" />" title="Remover" onclick="return confirmRemocao();">
					<img src="images/remover.png">
				</a>
			</td>
		</tr>

	</s:iterator>

</table>

<a href="formPaciente" class="imgLink footerLink">
	<img src="images/add.png"><br>
	Cadastrar
</a>

</body>
</html>