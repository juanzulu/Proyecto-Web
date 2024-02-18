var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
    showSlides(slideIndex += n);
}

function showSlides(n) {
    var i;
    var slides = document.getElementsByClassName("contenedor_de_la_imagen")[0].getElementsByTagName("img");
    if (n > slides.length) {slideIndex = 1}    
    if (n < 1) {slideIndex = slides.length}
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";  
    }
    slides[slideIndex-1].style.display = "block";  
}





function cambiarImagen(elemento, idCaja) {
    var caja = document.getElementById(idCaja);
    var imagen = caja.querySelector('.imagen_caja');
    imagen.classList.toggle('cambiada');

    // Aplicar estilos específicos basados en el ID de la caja
    if (idCaja === 'caja1') {
        imagen.src = '/img/gatoprincipal.png';
    }else if (idCaja === 'caja2') {
        imagen.src = '/img/viaje.png';
    }else if (idCaja === 'caja3') {
        imagen.src = '/img/farmacia.png';
    }else if (idCaja === 'caja4') {
        imagen.src = '/img/comida.png';
    }else if (idCaja === 'caja5') {
        imagen.src = '/img/perro.png';
    }else if (idCaja === 'caja6') {
        imagen.src = '/img/clinica.png';
    }
    // Agrega más condiciones para otros IDs si es necesario
    caja.style.backgroundImage = urlImagen;
}


function revertirImagen(idCaja) {
    var caja = document.getElementById(idCaja);
    var imagenes = caja.querySelectorAll('.imagen_caja');
    imagenes.forEach(function(imagen) {
        // Restaurar la imagen original basada en el ID de la caja
        if (idCaja === 'caja1') {
            imagen.src = '/img/caja1.png';
        } else if (idCaja === 'caja2') {
            imagen.src = '/img/caja2.png';
        } else if (idCaja === 'caja3') {
            imagen.src = '/img/caja3.png';
        } else if (idCaja === 'caja4') {
            imagen.src = '/img/caja4.png';
        } else if (idCaja === 'caja5') {
            imagen.src = '/img/caja5.png';
        } else if (idCaja === 'caja6') {
            imagen.src = '/img/caja6.png';
        }
        // Agrega más condiciones para otros IDs si es necesario
        caja.style.backgroundImage = urlImagen;
    });
}

const carousel = document.querySelector('.fondo_principal');
const images = document.querySelectorAll('.contenedor_de_la_imagen img');
let currentIndex = 0;
const slideWidth = images[0].clientWidth;

function moveCarousel() {
  currentIndex++;
  if (currentIndex === images.length) {
    currentIndex = 0;
  }
  const offset = -currentIndex * slideWidth;
  carousel.style.transform = `translateX(${offset}px)`;
}

setInterval(moveCarousel, 90000000); // Cambia la imagen cada 2 segundos


function togglePopup() {
    var popup = document.getElementById("popup");
    if (popup.style.display === "block") {
      popup.style.display = "none";
    } else {
      popup.style.display = "block";
    }
  }
  

