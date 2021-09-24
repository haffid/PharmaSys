<?php

include_once("connection.php");
$jsonArray = array();
$consulta = "SELECT * FROM tbl_cliente_Android";
$resultado = mysqli_query($connection, $consulta) or die ("Error " . mysqli_error($connection));

mysqli_set_charset( $connection, 'utf8');

if($resultado == true){
    while($registro = mysqli_fetch_array($resultado)){
    $jsonArray["tbl_cliente_Android"][] = $registro;
    }

    echo json_encode($jsonArray, JSON_UNESCAPED_UNICODE);//Agregue "JSON_UNESCAPED_UNICODE" para que muestre bien los acentos
    mysqli_close($connection);

}else{
    $resultadoVacio["id_cliente"] = "...";
    $resultadoVacio["nombre_cliente"] = "...";
    $resultadoVacio["apellido_cliente"] = "...";
    $resultadoVacio["direccion_cliente"] = "...";
    $resultadoVacio["correo_cliente"] = "...";
    $resultadoVacio["clave_cliente"] = "...";
    $jsonArray["tbl_cliente_Android"][] = $resultadoVacio;
    echo json_encode($jsonArray);
    mysqli_close($connection);
}


?>