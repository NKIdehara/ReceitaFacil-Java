<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="java.util.Collection"%>
<%@ page import ="java.util.HashSet"%>
<%@ page import ="br.edu.infnet.al.receitafacil.model.domain.Cozinheiro"%>
<%@ page import ="br.edu.infnet.al.receitafacil.model.domain.Ingrediente"%>
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

            <!-- COZINHEIROS -->
            <% 
                Collection<Cozinheiro> cozinheiros = new HashSet<Cozinheiro>();
                cozinheiros = (Collection)request.getAttribute("cozinheiros");
            %>
            <div class="mb-3 mt-3">
                <label class="form-label">Cozinheiro(a):</label>
                <select class="form-select form-select-sm" aria-label=".form-select-sm example" name="cozinheiro">
                    <%for(Cozinheiro c : cozinheiros) {%>
                        <option value="<%=c.getId()%>"><%=c.getNome()%></option>
                    <%}%>
                </select>
                <%if(cozinheiros.isEmpty()) {%>
                    <div class="alert alert-warning" role="alert">Lista de Cozinheiros está vazia!</div>
                <%}%>
            </div>

            <!-- INGREDIENTES -->
            <%
                Collection<Ingrediente> ingredientes = new HashSet<Ingrediente>();
                ingredientes = (Collection)request.getAttribute("ingredientes");
            %>
            <div class="mb-3 mt-3">
                <ol class="list-group ">
                    <li class="list-group-item d-flex justify-content-between align-items-start">
                        <div class="ms-2 me-auto">
                            <div class="fw-normal">Ingredientes:</div>
                            <%for(Ingrediente ingrediente : ingredientes) {%>
                                <div><label class="form-check-label"><input class="form-check-input me-1" type="checkbox" name="ingredientes" value="<%=ingrediente.getId()%>"><%=ingrediente.getNome()%></label></div>
                            <%}%>
                        </div>
                        <span class="badge bg-primary rounded-pill"><%=ingredientes.size()%></span>
                    </li>
                </ol>
                <%if(ingredientes.isEmpty()) {%>
                    <div class="alert alert-warning" role="alert">Lista de Ingredientes está vazia!</div>
                <%}%>
            </div>

            <%if(!cozinheiros.isEmpty() && !ingredientes.isEmpty()) {%>
                <button type="submit" class="btn btn-primary">Cadastrar</button>
            <%} else {%>
                <button type="submit" class="btn btn-primary" disabled>Cadastrar</button>
            <%}%>                
        </form>
    </div>

</body>

</html>