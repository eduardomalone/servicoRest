<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<!DOCTYPE html>
<html>
<head>
<sx:head/>
<meta charset="ISO-8859-1">
<title>Exame</title>
<link href="styles/styles.css" rel="stylesheet" type="text/css">
<script src="includes/scripst.js"></script>

<style type="text/css">

.label {
	font-style: unset;
}

.tdLabel {
	text-align: unset;
}

</style>

<script type="text/javascript">

function validar() {
	
	alert(dojo.widget.byId("medico").getSelectedKey());
	alert(dojo.widget.byId("paciente").getSelectedKey());
	
}

// Carregar autocomplete quando for uma edi��o
function carregar(id, pacienteId, medicoId) {
	
	if(id != null) {
		dojo.widget.byId("medico").setSelectedKey(medicoId);
		dojo.widget.byId("paciente").setSelectedKey(pacienteId);
	}
	
}

</script>
</head>
<body onLoad="carregar(<s:property value="exame.id" />, <s:property value="exame.paciente.id" />, <s:property value="exame.medico.id"/>);">

<p class="pTitulo">
	<s:if test="exame.id != null">Editar</s:if>
	<s:else>Cadastrar</s:else>
	Exame
</p>

<form action="salvarExame" method="post">
	<s:hidden name="exame.id"></s:hidden>
	<table>
		<tr>
			<td>
				<s:textfield name="exame.nome" label="Nome"></s:textfield>
			</td>
		</tr>
		<tr>
			<td>M�dico:</td>
			<td>
				<sx:autocompleter id="medico" list="medicos"
				keyName="exame.medico.id" keyValue="%{exame.medico.id}"></sx:autocompleter>				
			</td>		
		</tr>
		<tr>
			<td>Paciente:</td>
			<td>
				<sx:autocompleter id="paciente" list="pacientes" 
				keyName="exame.paciente.id" keyValue="%{exame.paciente.id}"></sx:autocompleter>
			</td>
		</tr>
		<tr>
			<td>
				Data:
			</td>
			<td>
				<sx:datetimepicker displayFormat="dd/MM/yyyy" name="exame.data"></sx:datetimepicker>
			</td>
		</tr>
	</table>
	<br>
	<s:submit name="salvar" value="Salvar" cssClass="submitConfirm" />
	
</form>
</body>
</html>