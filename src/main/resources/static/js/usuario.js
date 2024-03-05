document.addEventListener('DOMContentLoaded', function() {
    // Asegura que el contenedor esté oculto al cargar la página
    document.getElementById('infoGatoContenedor').style.display = 'none';
    document.getElementById('fondoOscuro').style.display = 'none'; // Si usas un fondo oscuro, también asegúrate de que esté oculto

    // Seleccionar todas las fotos de mascotas
    const fotosMascotas = document.querySelectorAll('.foto-mascota');
    let indiceActual = 0; // Índice del gato actual

    // Asignar evento de clic a cada foto de mascota
    fotosMascotas.forEach((foto, index) => {
        foto.addEventListener('click', function() {
            mostrarInfoGato(index);
            // Muestra la capa oscura y el contenedor de información del gato
            document.getElementById('fondoOscuro').style.display = 'block';
            document.getElementById('infoGatoContenedor').style.display = 'flex';
        });
    });

    // Función para mostrar la información del gato seleccionado
    function mostrarInfoGato(index) {
        indiceActual = index; // Actualiza el índice del gato actual
        const gato = fotosMascotas[index];
        // Obtener datos del gato seleccionado
        const nombre = gato.getAttribute('data-nombre');
        const raza = gato.getAttribute('data-raza');
        const edad = gato.getAttribute('data-edad');
        const fotoUrl = gato.getAttribute('src');

        // Asignar datos al contenedor de información
        document.getElementById('nombreGato').textContent = nombre;
        document.getElementById('edadGato').textContent = `Edad: ${edad}`;
        document.getElementById('fotoGato').src = fotoUrl;
    }

    // Botón de cerrar: oculta la información del gato y la capa oscura
    document.getElementById('cerrarInfo').addEventListener('click', function() {
        document.getElementById('infoGatoContenedor').style.display = 'none';
        document.getElementById('fondoOscuro').style.display = 'none';
    });

    // Navegación entre gatos: anterior y siguiente
    document.getElementById('anteriorGato').addEventListener('click', function() {
        if (indiceActual > 0) {
            mostrarInfoGato(indiceActual - 1);
        }
    });
    document.getElementById('siguienteGato').addEventListener('click', function() {
        if (indiceActual < fotosMascotas.length - 1) {
            mostrarInfoGato(indiceActual + 1);
        }
    });
});
