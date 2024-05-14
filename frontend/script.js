const formulario = document.querySelector("form");

const Iemail = document.querySelector(".email");
const Isenha = document.querySelector(".senha");

function login() {
  fetch("http://localhost:8080/login", {
    headers: {
      Accept: "application/json",
      "Conten-Type": "application/json",
    },

    method: "POST",
    body: JSON.stringify({
      email: Iemail.value,
      senha: Isenha.value,
    }),
  })
    .then(function (res) {
      console.log(res);
    })
    .catch(function (res) {
      console.log(res);
    });
}

function limpar() {
  Iemail.value = "";
  Isenha.value = "";
}

formulario.addEventListener("submit", function (event) {
  event.preventDefault();

  login();
  limpar();
});
