<?php

include_once("connection.php");

 //se crea el array que contendra la informacion ya sea para trasladar o recepcionar
 $jsonArray = array();

 //Definimos los campos que seran utilizados
    if(isset($_GET["fecha_pedido"]) && isset($_GET["fk_id_cliente"]) 
    && isset($_GET["fk_id_producto_pedido"]) && isset($_GET["descripcion_pedido"]) 
    && isset($_GET["precio_pedido"]) && isset($_GET["cantidad_pedido"]) 
    && isset($_GET["total_pedido"]) && isset($_GET["fk_id_estadop"])){
    

//Declarar variables que definiran los datos a insertar
$fecha_pedido = $_GET["fecha_pedido"];
$fk_id_cliente = $_GET["fk_id_cliente"];
$fk_id_producto_pedido = $_GET["fk_id_producto_pedido"];
$descripcion_pedido = $_GET["descripcion_pedido"];
$precio_pedido = $_GET["precio_pedido"];
$cantidad_pedido = $_GET["cantidad_pedido"];
$total_pedido = $_GET["total_pedido"];
$fk_id_estadop = $_GET["fk_id_estadop"];

//Declaracion de la consulta a realizar
//$insertar = "INSERT INTO tbl_pedido SELECT * FROM tbl_pedido WHERE fecha_pedido = '$fecha_pedido' AND  fk_id_cliente = $fk_id_cliente 
//AND  fk_id_producto_pedido = $fk_id_producto_pedido AND  descripcion_pedido = '$descripcion_pedido' AND  precio_pedido = $precio_pedido 
//AND  cantidad_pedido = $cantidad_pedido AND  total_pedido = $total_pedido AND  fk_id_estadop = $fk_id_estadop";
$insertar = "INSERT INTO tbl_pedido  (fecha_pedido, fk_id_cliente, fk_id_producto_pedido, descripcion_pedido, precio_pedido, cantidad_pedido, total_pedido, fk_id_estadop)
VALUES ('{$fecha_pedido}', {$fk_id_cliente}, {$fk_id_producto_pedido}, '{$descripcion_pedido}', {$precio_pedido}, {$cantidad_pedido}, {$total_pedido}, {$fk_id_estadop});";

//Obtenemos el resultado de la conexion
$resultado = mysqli_query($connection, $insertar) or die('Error ' . mysqli_error($connection));

$jsonArray["tbl_pedido"] = $resultado;

echo json_encode($jsonArray);
mysqli_close($connection);


    }


?>