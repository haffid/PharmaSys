<?php
include_once("connection.php");
$jsonArray = array();
if(isset($_GET["correo_cliente"]) && isset($_GET["clave_cliente"])){
    $correo_cliente = $_GET["correo_cliente"];
    $clave_cliente = $_GET["clave_cliente"];
    $login = "SELECT correo_cliente, clave_cliente FROM tbl_cliente_Android WHERE correo_cliente = '$correo_cliente' AND  clave_cliente = '$clave_cliente'"; 
    $resultado = mysqli_query($connection, $login) or die ("Error ". mysqli_error($connection));

    if(mysqli_num_rows($resultado) > 0){ 
        $registros = mysqli_fetch_array($resultado);
        $jsonArray["tbl_cliente_Android"][] = $registros;
    }else{
        $resultadoVacio["correo_cliente"] = "...";
        $resultadoVacio["clave_cliente"] = "...";
        $jsonArray["tbl_cliente_Android"][] = $resultadoVacio;

    }
    echo json_encode($jsonArray); 
    mysqli_close($connection);
    }else{

        echo json_encode($jsonArray); 
        mysqli_close($connection); 
        echo "Datos no encontrados php";
    }
?>