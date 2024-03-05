document.addEventListener('DOMContentLoaded', function() {
    const rows = document.querySelectorAll('.table tbody tr');
    rows.forEach((row, index) => {
        // Asegura que cada fila tenga la animación con un delay incremental
        row.style.animation = `fadeIn 0.5s ease-out ${0.5 + index * 0.1}s forwards`;
    });
});
