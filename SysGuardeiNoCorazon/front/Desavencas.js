var myModal = new bootstrap.Modal(document.getElementById('modalAltera'))

    fetch("http://localhost:8080/Desavencas",{
        method: "GET",
        headers: {"Content-type": "application/json;charset=UTF-8"}
    }).then(data => data.json())
    .then(json => {

        const divMain = document.getElementById("main")
        
        let s = "<table class='table'>"
            +"<tr><th>codigo</th><th>data</th><th>hora</th><th>Descricao</th><th>Motivacao</th><th>Local</th><th>Desafeto_id</th></tr>"

            json.forEach(element => {
                
                s += '<tr><td>${element.codigo}</td><td>${element.data}</td><td>${element.hora}</td><td>${element.descricao}</td><td>${element.motivacao}</td><td>${element.local}</td><td>${element.desafeto_id}</td>'
                +`<td><button class="btn btn-primary" onclick="abrirModalAltera(${element.id})" >alterar</button>`
                +`<button class="btn btn-primary" onclick="detalharRegistros(${element.id})">detalhar</button>`
                +`<button class="btn btn-secondary" onclick="deletar(${element.id})">deletar</button> </td></tr>`

            })

            /*for(let i = 0; i < json.length; i++){
                s += '<tr><td>'+json[i].codigo+'</td><td>'+json[i].nome+'</td><td>'+json[i].contato+'</td></tr>'
            }*/

        s += "</table>"

        divMain.innerHTML = s

    }).catch( err => {
        document.getElementById("main").innerHTML = "Erro ao recuperar a lista"
    })


    async function abrirModalAltera(id){
        myModal.show()

        const retorno = await fetch("http://localhost:8080/Desavencas/"+id,
            {
                method: "GET",
                headers: {"Content-type": "application/json;charset=UTF-8"}
            }
        )

        retorno.json().then(json => {

            document.getElementById("txtcodigo").value = json.codigo
            document.getElementById("txtData").value = json.data
            document.getElementById("txtHora").value = json.hora
            document.getElementById("txtDescricao").value = json.descricao
            document.getElementById("txtMotivacao").value = json.motivacao
            document.getElementById("txtLocal").value = json.local
            document.getElementById("txtdesafeto_id").value = json.desafeto_id

        })

    }

    async function deletar(id){

        if(confirm("Deseja realmente deletar o registro?")){

            const retorno = await fetch("http://localhost:8080/Desavencas/"+id,
            {
                method:"DELETE",
                headers: {"Content-type": "application/json;charset=UTF-8"}
            })

            location.reload();

        }
    }
       

