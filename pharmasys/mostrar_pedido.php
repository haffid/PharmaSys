<?php

include_once("connection.php");
$jsonArray = array();
if(isset($_GET["id_producto"])){ 
    $id_cliente = $_GET["id_cliente"];
$consulta = "SELECT fecha_pedido, nombre_cliente, nombre_producto, precio_pedido, cantidad_pedido, total_pedido, estado_pedido
FROM tbl_pedido 
INNER JOIN tbl_cliente_android 
ON fk_id_cliente = id_cliente
INNER JOIN tbl_producto 
ON fk_id_producto_pedido = id_producto
INNER JOIN tbl_estado_pedido 
ON fk_id_estadop = id_estado_pedido
WHERE id_cliente = $id_cliente";
$resultado = mysqli_query($connection, $consulta) or die ("Error " . mysqli_error($connection));

mysqli_set_charset( $connection, 'utf8');

if($resultado == true){
    while($registro = mysqli_fetch_array($resultado)){
    $jsonArray["tbl_pedido" and "tbl_cliente_android" and "tbl_producto" and "tbl_estado_pedido"][] = $registro;
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