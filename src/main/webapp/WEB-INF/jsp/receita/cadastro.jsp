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
        <form action="/receita/incluir" method="post">
            <h3>Cadastro de Receitas</h3>

            <div class="mb-3 mt-3">
                <label class="form-label">Nome:</label>
                <input type="text" class="form-control" name="nome" value="Arroz">                
            </div>

            <div class="mb-3 mt-3">
                <label class="form-label">Preparo:</label>
                <input type="text" class="form-control" name="preparo" value="Lavar o arroz; cozinhar com água e sal por 30 min.">
            </div>

            <div class="mb-3 mt-3">
                <label class="form-label">Tempo (min):</label>
                <input type="text" class="form-control" name="tempo" value="30">                
            </div>

            <div class="mb-3 mt-3">
                <label class="form-label">Quantidade de Pessoas:</label>
                <input type="text" class="form-control" name="qtdePessoas" value="1">                
            </div>

            <button type="submit" class="btn btn-primary">Cadastrar</button>
        </form>
    </div>

</body>

</html>