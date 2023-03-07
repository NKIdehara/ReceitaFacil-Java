<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>🍴 Receita Fácil 🍳</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
    <% String msg = (String)request.getAttribute("mensagem");%>

    <img src="./../../resources/ic_cook.png" height="300">
    <h1>Receita Fácil</h1>

    <div class="container">
        <form action="/usuario/lista" method="get">
            <button type="submit" class="btn btn-primary">Usuários</button>
        </form>
        <form action="/" method="get">
            <button type="submit" class="btn btn-primary">❌ Logout</button>
        </form>
    </div>
</body>

</html>