const form = document.querySelector("[formSubmiter]")

form.addEventListener("submit",(e) => {

    e.preventDefault()

    const formData = new FormData(form)

    const envio = {}

    envio.nome = "";
    envio["nome"] = ""

    for(const [key, value] of formData){
        envio[key] = value
    }

    const method = form.getAttribute("formSubmiter")

    fetch("http://localhost:8080/Desavencas",
        {
            method,
            body: JSON.stringify(envio),
            headers: {"Content-type": "application/json; charset=UTF-8"}
        }).then(data => {
            location.reload()
        })

})