<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exame</title>
<link href="styles/styles.css" rel="stylesheet" type="text/css">
<script src="includes/scripst.js"></script>
</head>
<body>

<s:action name="menu" executeResult="true"></s:action>

<p class="pTitulo">Exames</p>

<table class="tableList">

	<tr class="trTitulo">
		<td width="5%">ID</td>
		<td width="35%">Nome</td>
		<td width="20%">Paciente</td>
		<td width="20%">Médico</td>
		<td width="10%">Data</td>
		<td width="5%"></td>
		<td width="5%"></td>
	</tr>
	
	<s:iterator value="exames">
	
		<tr>
			<td><s:property value="id" /></td>
			<td><s:property value="nome" /></td>
			<td><s:property value="paciente.nome" /></td>
			<td><s:property value="medico.nome" /></td>
			<td><s:property value="data" /></td>
			<td>
				<s:url action="formExame" var="urlEdit" escapeAmp="false">
					<s:param name="exame.id"><s:property value="id" /></s:param>
					<s:param name="exame.nome"><s:property value="nome" /></s:param>
					<s:param name="exame.medico.id"><s:property value="medico.id" /></s:param>
					<s:param name="exame.paciente.id"><s:property value="paciente.id" /></s:param>
					<s:param name="exame.data"><s:property value="data" /></s:param>
				</s:url>
				<a href="<s:property value="#urlEdit" />" title="Editar">
					<img src="images/editar.png">
				</a>
			</td>
			<td>
				<s:url action="removerExame" var="urlDelete" escapeAmp="false">
					<s:param name="exame.id"><s:property value="id" /></s:param>
				</s:url>
				<a href="<s:property value="#urlDelete" />" title="Remover" onclick="return confirmRemocao();">
					<img src="images/remover.png">
				</a>
			</td>
		</tr>

	</s:iterator>

</table>

<a href="formExame" class="imgLink footerLink">
	<img src="images/add.png"><br>
	Cadastrar
</a>

</body>
</html>