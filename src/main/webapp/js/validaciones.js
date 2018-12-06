$(document).ready(function() {
	/*$("#crearLiguilla").hover(function(){
		alert("Puede crear la liguilla una vez");
	});*/
	
	if($("#crearLiguilla").val() == 1) {
		$("#crearLiguilla").attr('disabled','disabled');
	} else {
		$("#crearLiguilla").removeAttr("disabled");
	}
	
	
});



function crearTorneo() {
	document.crearTorneo.submit();
}

function modificarTorneo() {
	document.modificarTorneo.submit();
}

function eliminarTorneo() {
	document.eliminarTorneo.submit();
}