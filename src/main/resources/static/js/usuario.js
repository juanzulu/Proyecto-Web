document.addEventListener('DOMContentLoaded', function() {
    const fotosMascotas = document.querySelectorAll('.foto-mascota');
    let indiceActual = 0; // Índice del gato actual

    fotosMascotas.forEach((foto, index) => {
        foto.addEventListener('click', function() {
            mostrarInfoGato(index);
            document.getElementById('fondoOscuro').style.display = 'block'; // Muestra la capa oscura
        });
    });

    document.getElementById('cerrarInfo').addEventListener('click', function() {
        document.getElementById('infoGatoContenedor').style.display = 'none';
        document.getElementById('fondoOscuro').style.display = 'none'; // Oculta la capa oscura
    });

    document.getElementById('anteriorGato').addEventListener('click', function() {
        if (indiceActual > 0) {
            mostrarInfoGato(--indiceActual);
        }
    });

    document.getElementById('siguienteGato').addEventListener('click', function() {
        if (indiceActual < fotosMascotas.length - 1) {
            mostrarInfoGato(++indiceActual);
        }
    });

    function mostrarInfoGato(index) {
        const gato = fotosMascotas[index];
        const nombre = gato.getAttribute('data-nombre');
        const raza = gato.getAttribute('data-raza');
        const edad = gato.getAttribute('data-edad');
        const fotoUrl = gato.getAttribute('src');

        document.getElementById('nombreGato').textContent = nombre;
        document.getElementById('razaGato').textContent = raza;
        document.getElementById('edadGato').textContent = edad;
        document.getElementById('fotoGato').setAttribute('src', fotoUrl);

        document.getElementById('infoGatoContenedor').style.display = 'block';
        indiceActual = index; // Actualiza el índice del gato actual
    }

    const handle = document.querySelector('.handle');
    const sidebar = document.querySelector('.sidebar-right');
    let isSidebarOpen = false;

    handle.addEventListener('click', function() {
        if (isSidebarOpen) {
            sidebar.style.right = '-230px';
            isSidebarOpen = false;
        } else {
            sidebar.style.right = '0';
            isSidebarOpen = true;
            animateUserInfo(); // Llama a la función de animación cuando el sidebar se abre.
        }
    });

    // Define la función para animar los elementos de información del usuario en cascada.
    function animateUserInfo() {
        const elementos = document.querySelectorAll('.usuario-info h2, .usuario-info p');
        let delay = 0;
        elementos.forEach((elemento) => {
            setTimeout(() => {
                elemento.style.opacity = 1;
                elemento.style.transform = 'translateY(0)';
            }, delay);
            delay += 100; // Incrementa el retraso para el próximo elemento.
        });
    }

   

    function mostrarInfoGato(index) {
        const gato = fotosMascotas[index];
        const nombre = gato.getAttribute('data-nombre');
        const raza = gato.getAttribute('data-raza');
        const edad = gato.getAttribute('data-edad');
        const fotoUrl = gato.getAttribute('src');
    
        document.getElementById('nombreGato').textContent = nombre;
        document.getElementById('razaGato').textContent = raza;
        document.getElementById('edadGato').textContent = edad;
        document.getElementById('fotoGato').setAttribute('src', fotoUrl);
    
        // Asegurando que la opacidad inicial sea 0 para permitir la transición
        const contenedor = document.getElementById('infoGatoContenedor');
        contenedor.style.opacity = '0'; // Asegúrate de que esto esté antes de cambiar display a 'block'
        contenedor.style.display = 'block';
        setTimeout(() => contenedor.style.opacity = '1', 10); // Activa la transición de opacidad
        indiceActual = index; // Actualiza el índice del gato actual
    }

});
