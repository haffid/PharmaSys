<?php

include_once("connection.php");
$jsonArray = array();
$consulta = "SELECT * FROM tbl_producto ORDER BY nombre_producto ASC";
$resultado = mysqli_query($connection, $consulta) or die ("Error " . mysqli_error($connection));

mysqli_set_charset( $connection, 'utf8');

if($resultado == true){
    while($registro = mysqli_fetch_array($resultado)){
    $jsonArray["tbl_producto"][] = $registro;
    }

    echo json_encode($jsonArray, JSON_UNESCAPED_UNICODE);//Agregue "JSON_UNESCAPED_UNICODE" para que muestre bien los acentos
    mysqli_close($connection);

}else{
    $resultadoVacio["nombre_producto"] = "...";
    $resultadoVacio["tipo_producto"] = "...";
    $resultadoVacio["descripcion_producto"] = "...";
    $resultadoVacio["precio_producto"] = "...";
    $resultadoVacio["fk_id_proveedor"] = "...";
    $jsonArray["tbl_producto"][] = $resultadoVacio;
    echo json_encode($jsonArray);
    mysqli_close($connection);
}


?>