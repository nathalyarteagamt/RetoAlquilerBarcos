let URL_CLIENTE = "http://127.0.0.1:8080/api/Client"
let milistaclientetemporal;
function addCliente() { 

    let misdatos = {
        id:$("#idcliente").val(),
        name:$("#namecliente").val(),
        email:$("#emailcliente").val(),
        age:$("#agecliente").val()
    }

    let dataJson = JSON.stringify(misdatos);

    $.ajax(
        {
            headers: {
                 "Access-Control-Allow-Origin": "*", "Content-Type": 'application/json'
            },
            url: URL_CLIENTE + "/save",
            type:"POST",
            data:dataJson,
            dataType:"JSON",
            success: function (respuesta) {
                getClientes();
            },
            error: function (xhr, status) {
                alert('ha sucedido un problema');
                console.log(status);
            },
            complete: function (xhr, status) {
                getClientes();
            }
        }
    );
}

function getOneCliente() {
    
 }

function getClientes() { 

    $.ajax(
        {
            headers: {
                accept: 'application/json', "Access-Control-Allow-Origin": "*"
            },
            url: URL_CLIENTE+"/all",
            type:"GET",
            dataType:"JSON",
            success: function (datacliente) {
                pintarClientes(datacliente);
            },
            error: function (xhr, status) {
                console.log(status);
            },
            complete: function (xhr, status) {
                alert('Petición realizada');
                console.log("TOdo Ok")
            }
        }
    );
}



function modCliente() {
        let misdatos = {
        id: $("#idcliente").val(),
        name: $("#namecliente").val(),
        email: $("#emailcliente").val(),
        age: $("#agecliente").val()
    }

    let dataJson = JSON.stringify(misdatos);

    $.ajax(
        {
            headers: {
                 "Access-Control-Allow-Origin": "*", "Content-Type": 'application/json'
            },
            url: URL_CLIENTE,
            type:"PUT",
            data: dataJson,
            dataType:"JSON",
            success: function (respuesta) {
                getClientes();
            },
            error: function (xhr, status) {
                console.log(status);
            },
            complete: function (xhr, status) {
                getClientes();
            }
        }
    );
}

function delCliente() { }

function pintarClientes(listaclientes) {

    let tablaclientes = "<table>";
    tablaclientes = tablaclientes + "<thead>";
    tablaclientes = tablaclientes + "<tr>";
    tablaclientes = tablaclientes + "<td>" + "ID" + "</td>";
    tablaclientes = tablaclientes + "<td>" + "Name" + "</td>";
    tablaclientes = tablaclientes + "<td>" + "Email" + "</td>";
    tablaclientes = tablaclientes + "<td>" + "Age" + "</td>";
    tablaclientes = tablaclientes + "<td>" + "Función" + "</td>";
    tablaclientes = tablaclientes + "</tr>";
    tablaclientes = tablaclientes + "</thead>";

    milistaclientetemporal = listaclientes;

    for (i = 0; i < listaclientes.length; i++) {
        tablaclientes = tablaclientes + "<tr>";
        tablaclientes = tablaclientes + "<td>" + listaclientes[i].idClient + "</td>";
        tablaclientes = tablaclientes + "<td>" + listaclientes[i].name + "</td>";
        tablaclientes = tablaclientes + "<td>" + listaclientes[i].email + "</td>";
        tablaclientes = tablaclientes + "<td>" + listaclientes[i].age + "</td>";
        
        tablaclientes = tablaclientes + "<td>" + "<button onClick='traerCliente(" +listaclientes[i].idClient +")'>TraerCliente</button>"+"</td>";
        tablaclientes = tablaclientes + "</tr>";
                
    }
    tablaclientes = tablaclientes + "</table>";
    $("#listaClientes").empty();
    $("#listaClientes").append(tablaclientes);

}

function traerCliente(identificacion) {
    for (i = 0; i < milistaclientetemporal.length; i++) {
        if (milistaclientetemporal[i].idClient == identificacion) {
            $("#idcliente").val(milistaclientetemporal[i].idClient);
            $("#namecliente").val( milistaclientetemporal[i].name);
            $("#emailcliente").val(milistaclientetemporal[i].email);
            $("#agecliente").val( milistaclientetemporal[i].age);
        }
    }        
}