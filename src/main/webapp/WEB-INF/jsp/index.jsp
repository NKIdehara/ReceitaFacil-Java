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

    <%@include file="/WEB-INF/jsp/menu.jsp" %>

    <div class="d-grid gap-2 col-sm-2 mx-auto">
        <form action="/usuario/cadastro" method="get">
            <button class="btn btn-primary" type="submit">Primeiro acesso</button>
        </form>
        <form action="/login" method="get">
            <button class="btn btn-primary" type="submit">Log in</button>
        </form>
    </div>
</body>

</html>