document.addEventListener("DOMContentLoaded", function() {
    // Ejemplo de datos de mascotas
    const mascotas = [
        {foto: "ruta/a/la/foto1.jpg", nombre: "Gato 1", raza: "Raza 1", edad: "2 años"},
        {foto: "ruta/a/la/foto2.jpg", nombre: "Gato 2", raza: "Raza 2", edad: "3 años"},
        // Agrega más gatos según sea necesario
    ];

    let indiceActual = 0;
    
    // Actualizar la UI con la información de la mascota actual
    function actualizarMascota() {
        document.getElementById("fotoGato").src = mascotas[indiceActual].foto;
        document.getElementById("nombreGato").textContent = mascotas[indiceActual].nombre;
        document.getElementById("razaGato").textContent = mascotas[indiceActual].raza;
        document.getElementById("edadGato").textContent = mascotas[indiceActual].edad;
    }
    
    // Inicializar con la primera mascota
    actualizarMascota();

    // Evento para el botón anterior
    document.getElementById("prev").addEventListener("click", function() {
        if (indiceActual > 0) {
            indiceActual--;
            actualizarMascota();
        }
    });

    // Evento para el botón siguiente
    document.getElementById("next").addEventListener("click", function() {
        if (indiceActual < mascotas.length - 1) {
            indiceActual++;
            actualizarMascota();
        }
    });
});
