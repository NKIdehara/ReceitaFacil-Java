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

    <div class="container">
        <form action="/login" method="post">
            <h3>Login</h3>
            <div class="mb-3 mt-3">
                <label class="form-label">Nome:</label>
                <input type="email" class="form-control" name="email" value="admin@email.com">
            </div>
            <div class="mb-3 mt-3">
                <label class="form-label">Nome:</label>
                <input type="password" class="form-control" name="senha" value="123456">
            </div>

            <button type="submit" class="btn btn-primary">Acessar</button>

            <%if(msg != null) {%>
                <div class="alert alert-danger alert-dismissible">
                    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                    <strong>Erro! </strong> <%=msg%>
                </div>
            <%}%>
        </form>
    </div>
</body>

</html>