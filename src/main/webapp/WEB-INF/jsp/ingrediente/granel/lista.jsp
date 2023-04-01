<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="java.util.Collection"%>
<%@ page import ="java.util.HashSet"%>
<%@ page import ="br.edu.infnet.al.receitafacil.model.domain.IngredienteGranel"%>

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
    <% String opc = (String)request.getAttribute("opcao");%>
    <% String msg = (String)request.getAttribute("mensagem");%>
    
    <%@include file="/WEB-INF/jsp/menu.jsp" %>

    <div class="container">
        <form action="/ingrediente/granel/cadastro" method="get">
            <h3>Ingrediente / Granel</h3>
            <button type="submit" class="btn btn-primary">Novo</button>
        </form>

        <%if(opc != null) {%>
            <%if(opc.equals("i")) {%>
                <div class="alert alert-success alert-dismissible">
                    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                    <strong>Novo ingrediente!</strong> <%=msg%>
                </div>
            <%}%>
            <%if(opc.equals("e")) {%>
                <div class="alert alert-warning alert-dismissible">
                    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                    <strong>⚠️</strong> <%=msg%>
                </div>
            <%}%>
            <%if(opc.equals("x")) {%>
                <div class="alert alert-danger alert-dismissible">
                    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                    <strong>Ingrediente excluído!</strong> <%=msg%>
                </div>
            <%}%>
        <%}%>

        <% 
            Collection<IngredienteGranel> ingredientes = new HashSet<IngredienteGranel>();
            ingredientes = (Collection)request.getAttribute("ingredientes");
        %>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>id</th>
                    <th>Nome</th>
                    <th>Preço</th>
                    <th>Quantidade</th>
                    <th>Unidade</th>
                    <th>Perecível</th>
                    <th>Fracionado</th>
                    <th>Densidade</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%for(IngredienteGranel i : ingredientes) {%>
                    <tr>
                        <td><%=i.getId()%></td>
                        <td><%=i.getNome()%></td>
                        <td><%=i.getPreco()%></td>
                        <td><%=i.getQuantidade()%></td>
                        <td><%=i.getUnidade()%></td>
                        <td><%if(i.isPerecivel()) { %>Sim<% } else { %>Não<% } %></td>
                        <td><%if(i.isFracionado()) { %>Sim<% } else { %>Não<% } %></td>
                        <td><%=i.getDensidade()%></td>
                        <td><a href="/ingrediente/granel/<%=i.getId()%>/excluir">excluir</a></td>
                    </tr>
                <%}%>
            </tbody>
        </table>
        <form action="/home" method="get">
            <button type="submit" class="btn btn-primary">↩️ Retornar</button>
        </form>
    </div>
</body>

</html>