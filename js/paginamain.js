var imagenesOriginales = {};

function voltearImagen(caja) {
    var imagenes = caja.querySelectorAll('.imagen_caja');
    imagenes.forEach(function(imagen) {
    imagen.src = '/img/gatoprincipal.jpg';
    });
}

function revertirImagen(caja) {
    var imagenes = caja.querySelectorAll('.imagen_caja');
    imagenes.forEach(function(imagen) {
    imagen.src = imagenesOriginales[imag.id];
    });
}
