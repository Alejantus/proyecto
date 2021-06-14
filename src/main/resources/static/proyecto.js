function pasarMayus() {
    let letra = this.value;

    this.value = letra.charAt(0).toUpperCase + letra.slice(1);
}
let nombre = document.getElementById("nombre");
let apellido = document.getElementById("apellidos")
nombre.addEventListener('blur', pasarMayus);
apellido.addEventListener('blur', pasarMayus);