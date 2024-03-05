document.addEventListener('DOMContentLoaded', function() {
    // Inicializa el estado oculto del contenedor de información y del fondo oscuro.
    document.getElementById('infoGatoContenedor').style.display = 'none';
    document.getElementById('fondoOscuro').style.display = 'none';

    // Selecciona todas las fotos de mascotas y establece el índice inicial.
    const fotosMascotas = document.querySelectorAll('.foto-mascota');
    let indiceActual = 0;

    // Evento de clic para cada foto de mascota.
    fotosMascotas.forEach((foto, index) => {
        foto.addEventListener('click', function() {
            mostrarInfoGato(index);
            document.getElementById('fondoOscuro').style.display = 'block';
            document.getElementById('infoGatoContenedor').style.display = 'flex';
        });
    });

    // Función para mostrar la información del gato seleccionado.
    function mostrarInfoGato(index) {
        indiceActual = index;
        const gato = fotosMascotas[index];
        const nombre = gato.getAttribute('data-nombre');
        const raza = gato.getAttribute('data-raza');
        const edad = gato.getAttribute('data-edad');
        const fotoUrl = gato.getAttribute('src');

        document.getElementById('nombreGato').textContent = nombre;
        document.getElementById('edadGato').textContent = `Edad: ${edad}`;
        document.getElementById('fotoGato').src = fotoUrl;
    }

    // Cierra la información del gato y el fondo oscuro al clickear 'cerrar' o el fondo oscuro.
    document.getElementById('cerrarInfo').addEventListener('click', ocultarInformacionGato);
    document.getElementById('fondoOscuro').addEventListener('click', ocultarInformacionGato);

    function ocultarInformacionGato() {
        document.getElementById('infoGatoContenedor').style.display = 'none';
        document.getElementById('fondoOscuro').style.display = 'none';
    }

    // Navegación entre gatos: anterior y siguiente.
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

    // Manejar el toggle de la sidebar con la viñeta.
    const handle = document.querySelector('.handle');
    const sidebar = document.querySelector('.sidebar-right');
    
    handle.addEventListener('click', function() {
        sidebar.classList.toggle('active');
        // No se necesita preparar o actualizar la información del usuario cada vez,
        // pero puedes agregar esa lógica aquí si es necesario.
        document.getElementById('nombreGato').textContent = nombre;
        document.getElementById('edadGato').textContent = `Edad: ${edad}`;
    });
});
