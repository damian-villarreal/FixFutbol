$(document).ready(function() {
	$("#crearLiguilla").hover(function(){
		$(this).append($("<span>Puede seleccionar una vez</span>"));
	}, function(){
		$(this).find()
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