
function cambiarImagen(elemento, idCaja) {
    var caja = document.getElementById(idCaja);
    var imagen = caja.querySelector('.imagen_caja');
    imagen.classList.toggle('cambiada');

    var caja1 = document.getElementById('vuelta1');
    var caja2 = document.getElementById('vuelta2');
    var caja3 = document.getElementById('vuelta3');
    var caja4 = document.getElementById('vuelta4');
    var caja5 = document.getElementById('vuelta5');
    var caja6 = document.getElementById('vuelta6');

    // Aplicar estilos específicos basados en el ID de la caja
    if (idCaja === 'caja1') {
        caja1.style.display = 'block';
    }else if (idCaja === 'caja2') {
        caja2.style.display = 'block';
    }else if (idCaja === 'caja3') {
        caja3.style.display = 'block';
    }else if (idCaja === 'caja4') {
        caja4.style.display = 'block';
    }else if (idCaja === 'caja5') {
        caja5.style.display = 'block';
    }else if (idCaja === 'caja6') {
        caja6.style.display = 'block';
    }
}


function revertirImagen(idCaja) {
    var caja = document.getElementById(idCaja);
    var imagenes = caja.querySelectorAll('.imagen_caja');

    var caja1 = document.getElementById('vuelta1');
    var caja2 = document.getElementById('vuelta2');
    var caja3 = document.getElementById('vuelta3');
    var caja4 = document.getElementById('vuelta4');
    var caja5 = document.getElementById('vuelta5');
    var caja6 = document.getElementById('vuelta6');


    imagenes.forEach(function(imagen) {
        // Restaurar la imagen original basada en el ID de la caja
        if (idCaja === 'caja1') {
            caja1.style.display = 'none';
        } else if (idCaja === 'caja2') {
            caja2.style.display = 'none';
        } else if (idCaja === 'caja3') {
            caja3.style.display = 'none';
        } else if (idCaja === 'caja4') {
            caja4.style.display = 'none';
        } else if (idCaja === 'caja5') {
            caja5.style.display = 'none';
        } else if (idCaja === 'caja6') {
            caja6.style.display = 'none';
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
  

