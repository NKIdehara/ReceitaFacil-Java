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
        <form action="/ingrediente/liquido/incluir" method="post">
            <h3>Cadastro de Ingredientes / Líquido</h3>

            <div class="mb-3 mt-3">
                <label class="form-label">Nome:</label>
                <input type="text" class="form-control" name="nome" value="Leite">
            </div>

            <div class="mb-3 mt-3">
                <label class="form-label">Preço:</label>
                <input type="number" class="form-control" name="preco" value="0.00">
            </div>

            <div class="mb-3 mt-3">
                <label class="form-label">Quantidade:</label>
                <input type="number" class="form-control" name="quantidade" value="1">
            </div>

            <div class="mb-3 mt-3">
                <label class="form-label">Unidade:</label>
                <input type="text" class="form-control" name="unidade" value="l">
            </div>

            <div class="form-check">
                <label class="form-check-label">
                    <input class="form-check-input" type="checkbox" name="quente" value="true">Quente
                </label>
            </div>

            <div class="form-check">                
                <label class="form-check-label">
                    <input class="form-check-input" type="checkbox" name="pacote" value="true">Pacote
                </label>
            </div>

            <div class="mb-3 mt-3">
                <label class="form-label">Densidade:</label>
                <input type="number" class="form-control" name="densidade" value="0">
            </div>

            <button type="submit" class="btn btn-primary">Cadastrar</button>
        </form>
    </div>

</body>

</html>