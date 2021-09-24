<?php

include_once("connection.php");

 //se crea el array que contendra la informacion ya sea para trasladar o recepcionar
 $jsonArray = array();

 //Definimos los campos que seran utilizados
    if(isset($_GET["nombre_cliente"]) && isset($_GET["apellido_cliente"]) 
    && isset($_GET["direccion_cliente"]) && isset($_GET["correo_cliente"]) && isset($_GET["clave_cliente"])){

//Declarar variables que definiran los datos a insertar
$nombre_cliente = $_GET["nombre_cliente"];
$apellido_cliente = $_GET["apellido_cliente"];
$direccion_cliente = $_GET["direccion_cliente"];
$correo_cliente = $_GET["correo_cliente"];
$clave_cliente = $_GET["clave_cliente"];

//Declaracion de la consulta a realizar
$insertar = "INSERT INTO tbl_cliente_Android (nombre_cliente, apellido_cliente, direccion_cliente, correo_cliente, clave_cliente)
VALUES ('{$nombre_cliente}', '{$apellido_cliente}', '{$direccion_cliente}', '{$correo_cliente}', '{$clave_cliente}');";

//Obtenemos el resultado de la conexion
$resultado = mysqli_query($connection, $insertar) or die('Error ' . mysqli_error($connection));

$jsonArray["tbl_cliente_Android"] = $resultado;

echo json_encode($jsonArray);
mysqli_close($connection);


    }else{
        echo json_encode($jsonArray);
        mysqli_close($connection);
        echo 'Datos no insertados';
    }


?>