document.addEventListener('DOMContentLoaded', function() {
    // Lista de elementos a animar
    const elementsToAnimate = [
        document.querySelector('h1'), // Asume que tienes un <h1> para el título
        document.querySelector('.frase1'),
        document.querySelector('.frase2'),
        ...document.querySelectorAll('.login__container__input'), // Asume múltiples elementos de entrada
        document.querySelector('.login__container__button')
    ];

    // Añade clases animadas con retrasos
    elementsToAnimate.forEach((el, index) => {
        if (el) {
            el.classList.add('animated', `delay-${index + 1}`);
        }
    });
});