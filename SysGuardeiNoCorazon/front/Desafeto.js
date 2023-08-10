var myModal = new bootstrap.Modal(document.getElementById('modalAltera'))

    fetch("http://localhost:8080/Desafetos",{
        method: "GET",
        headers: {"Content-type": "application/json;charset=UTF-8"}
    }).then(data => data.json())
    .then(json => {

        const divMain = document.getElementById("main")
        
        let s = "<table class='table'>"
            +"<tr><th>id</th><th>Nome</th><th>Apelido</th><th>Sexo</th><th>DeOndeConheco</th></tr>"

            json.forEach(element => {
                
                s += `<tr><td>${element.id}</td><td>${element.nome}</td><td>${element.apelido}</td><td>${element.sexo}</td><td>${element.deOndeConheco}</td>`
                +`<td><button class="btn btn-primary" onclick="abrirModalAltera(${element.id})" >alterar</button>`
                +`<button class="btn btn-primary" onclick="detalharRegistros(${element.id})">detalhar</button>`
                +`<button class="btn btn-secondary" onclick="deletar(${element.id})">deletar</button></td></tr>`

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

        const retorno = await fetch("http://localhost:8080/Desafetos/"+id,
            {
                method: "GET",
                headers: {"Content-type": "application/json;charset=UTF-8"}
            }
        )

        retorno.json().then(json => {

            document.getElementById("txtid").value = json.id
            document.getElementById("txtNome").value = json.nome
            document.getElementById("txtApelido").value = json.apelido
            document.getElementById("txtSexo").value = json.sexo
            document.getElementById("txtDeOndeConheco").value = json.deOndeConheco

        })

    }

    async function deletar(id){

        if(confirm("Deseja realmente deletar o registro?")){

            const retorno = await fetch("http://localhost:8080/Desafetos/"+id,
            {
                method:"DELETE",
                headers: {"Content-type": "application/json;charset=UTF-8"}
            })

            location.reload();

        }
    }
        async function detalharRegistros(id){
    
            window.location='Desavencas_Desafeto.html?${id}';
        };

