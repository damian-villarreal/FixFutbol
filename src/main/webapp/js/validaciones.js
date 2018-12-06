$(document).ready(function() {
	$("#crearLiguilla").hover(function(){
		alert("Puede crear la liguilla una vez");
	});
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