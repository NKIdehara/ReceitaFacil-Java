<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="br.edu.infnet.al.receitafacil.model.domain.Usuario"%>
<%@ page import ="br.edu.infnet.al.receitafacil.model.domain.Endereco"%>
<% Usuario u = (Usuario)request.getAttribute("selecionado");%>
<% Endereco e = (Endereco)request.getAttribute("endereco");%>
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
        <h3>Verificação de Usuário</h3>

        <div class="mb-3 mt-3">
            <label class="form-label">Nome:</label>
            <input type="text" class="form-control" name="nome" value="<%=u.getNome()%>" readonly>
        </div>

        <div class="mb-3 mt-3">
            <label class="form-label">e-mail:</label>
            <input type="email" class="form-control" name="email" value="<%=u.getEmail()%>" readonly>
        </div>

        <div class="mb-3 mt-3">
            <label class="form-label">Telefone:</label>
            <input type="number" class="form-control" name="telefone" value="<%=u.getTelefone()%>" readonly>
        </div>

        <div class="mb-3 mt-3">
            <label class="form-label">CEP:</label>
            <input type="text" class="form-control" name="cep" value="<%=u.getCep()%>" readonly>
        </div>

        <div class="mb-3 mt-3">
            <label class="form-label">Endereço:</label>
            <input type="text" class="form-control" name="endereco" value="<%=e.getLogradouro()%>" readonly>
        </div>

        <div class="mb-3 mt-3">
            <label class="form-label">Bairro:</label>
            <input type="text" class="form-control" name="bairro" value="<%=e.getBairro()%>" readonly>
        </div>

        <div class="mb-3 mt-3">
            <label class="form-label">Cidade:</label>
            <input type="text" class="form-control" name="cidade" value="<%=e.getLocalidade()%>" readonly>
        </div>

        <div class="mb-3 mt-3">
            <label class="form-label">UF:</label>
            <input type="text" class="form-control" name="uf" value="<%=e.getUf()%>" readonly>
        </div>

        <form action="/usuario/lista" method="get">
            <button type="submit" class="btn btn-primary">↩️ Retornar</button>
        </form>
    </div>

</body>

</html>