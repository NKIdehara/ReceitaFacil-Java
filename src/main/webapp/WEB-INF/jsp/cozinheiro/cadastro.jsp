<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>🍴 Receita Fácil 🍳</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>

<body>
    <%@include file="/WEB-INF/jsp/menu.jsp" %>
    <div class="container">
        <form action="/cozinheiro/incluir" method="post">
            <h3>Cadastro de Usuários</h3>

            <div class="mb-3 mt-3">
                <label class="form-label">Nome:</label>
                <input type="text" class="form-control" name="nome" value="Cozinheiro">
            </div>

            <div class="mb-3 mt-3">
                <label class="form-label">CPF:</label>
                <input type="password" class="form-control" name="cpf" value="12345678999">
            </div>

            <div class="mb-3 mt-3">
                <label class="form-label">e-mail:</label>
                <input type="email" class="form-control" name="email" value="cozinheiro@email.com">
            </div>

            <button type="submit" class="btn btn-primary">Cadastrar</button>
        </form>
    </div>

</body>

</html>