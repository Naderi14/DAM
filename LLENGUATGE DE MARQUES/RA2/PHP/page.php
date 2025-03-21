<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PHP</title>
     <!-- Latest compiled and minified CSS -->
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

     <!-- Latest compiled JavaScript -->
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <div class="container">
        <form>
            <label for="nombre" class="form-label">Nombre usuario:</label>
            <input class="form-control" type="text" name="nombre" id="nombre" placeholder="Nombre de usuario">
            <label for="edad" class="form-label">Edad usuario:</label>
            <input class="form-control" type="number" name="edad" id="edad" placeholder="Edad usuario">
            <button class="btn btn-primary m-2" type="button" name="enviar" id="enviar" value="Enviar">Generar</button>
        </form>
    </div>
    <?php
        if (isset($_POST["enviar"])){
            $usuario = $_POST["nombre"];
            $edad = $_POST["edad"];
        
            if ($usuario == 'Fran'){
                echo "Puedes entrar";
            } else {
                echo "No puedes entrar";
            }
        }
    ?>
</body>
</html>

