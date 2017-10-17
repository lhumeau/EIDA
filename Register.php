<?php
     //error_reporting(0);
    $con = mysqli_connect("192.168.198.2", "root", "root", "eida");
    
     if($_SERVER['REQUEST_METHOD']=='POST')
        {


       
    $nombre = $_POST["nombre"];
    $apellido = $_POST["apellido"];
    $correo = $_POST["correo"];
    $contrasena = $_POST["contrasena"];

                }



        $statement = mysqli_prepare($con, "INSERT INTO login (nombre, apellido, correo, contrasena) VALUES (?, ?, ?, ?)");

        mysqli_stmt_bind_param($statement, "ssss", $nombre, $apellido, $correo, $contrasena);
        mysqli_stmt_execute($statement);
    
            $response = array();
            $response["success"] = true;  
            
            header('Content-Type: application/json');
            echo json_encode($response);

?>