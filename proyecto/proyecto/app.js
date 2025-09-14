const fondo = document.querySelector(".fondo");
const loginlink = document.querySelector(".login-link");
const registrarlink = document.querySelector(".registrar-link");
const btn_button = document.querySelector(".btn_button");
const iconocerrar = document.querySelector(".icono-cerrar");
/* const menu_menu = document.getElementById('menu');
const menuContainer = document.getElementById('menu-container'); */

registrarlink.addEventListener("click",  () => {
    fondo.classList.add('active');
 
});
loginlink.addEventListener("click", () => {
    fondo.classList.remove('active');
    
});
btn_button.addEventListener("click", () => {
    fondo.classList.remove('active');


});

iconocerrar.addEventListener('click', function() {
    fondo.style.display = 'none'; 
    loginForm.classList.add('hide'); 
    registerForm.classList.add('hide'); 
});


btn_button.addEventListener('click', function() {
    fondo.style.display = 'flex'; 
    loginForm.classList.remove('hide'); 
    registerForm.classList.add('hide'); 
});

/* menu_menu.addEventListener('click', function() {
    fetch('menu/index2.html')
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al cargar el menú');
            }
            return response.text();
        })
        .then(data => {
            menuContainer.innerHTML = data; 
            menuContainer.style.display = 'block'; 
        })
        .catch(error => console.error(error));
});
 */

const showMenuButton = document.getElementById('menu'); // Asegúrate de que este ID sea correcto
showMenuButton.addEventListener('click', function() {
    // Ocultar el formulario de inicio de sesión si está visible
    loginForm.classList.add('hide');
    
    // Redirigir a otra página
    window.location.href = 'menu/index2.html'; // Cambia a la ruta de la página que deseas abrir
});