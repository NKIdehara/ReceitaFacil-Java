<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="java.util.Collection"%>
<%@ page import ="java.util.HashSet"%>
<%@ page import ="br.edu.infnet.al.receitafacil.model.domain.Usuario"%>

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
        <form action="/usuario/cadastro" method="get">
            <h3>Usuários</h3>
            <button type="submit" class="btn btn-primary">Novo</button>
        </form>

        <%if(opc != null) {%>
            <%if(opc.equals("i")) {%>
                <div class="alert alert-success alert-dismissible">
                    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                    <strong>Novo(a) usuário(a)!</strong> <%=msg%>
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
                    <strong>Usuário(a) excluído(a)!</strong> <%=msg%>
                </div>
            <%}%>
        <%}%>

        <% 
            Collection<Usuario> usuarios = new HashSet<Usuario>();
            usuarios = (Collection)request.getAttribute("usuarios");
        %>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>id</th>
                    <th>Nome</th>
                    <th>E-mail</th>
                    <th>Senha</th>
                    <th>Telefone</th>
                    <th>CEP</th>
                    <th>Quantidade de<br>Cozinheiros</th>
                    <th>Quantidade de<br>Receitas</th>
                    <th>Quantidade de<br>Ingredientes</th>
                    <%if(user.isAdmin()) {%>
                        <th></th>
                    <%}%>
                </tr>
            </thead>
            <tbody>
                <%for(Usuario u : usuarios) {%>
                    <tr>
                        <td><%=u.getId()%></td>
                        <td><a href="/usuario/<%=u.getId()%>/verificar"><%=u.getNome()%></a></td>
                        <td><%=u.getEmail()%></td>
                        <td><%=u.getSenha()%></td>
                        <td><%=u.getTelefone()%></td>
                        <td><%=u.getCep()%></td>
                        <td><%if(u.getCozinheiros() != null) { %><%=u.getCozinheiros().size()%><%} else {%>0<%}%></td>
                        <td><%if(u.getReceitas() != null) { %><%=u.getReceitas().size()%><%} else {%>0<%}%></td>
                        <td><%if(u.getIngredientes() != null) { %><%=u.getIngredientes().size()%><%} else {%>0<%}%></td>
                        <%if(user.isAdmin()) {%>
                            <%if(!u.getEmail().equals(user.getEmail())) {%>
                                <td><a href="/usuario/<%=u.getId()%>/excluir">excluir</a></td>
                            <%} else {%>
                                <td><a>⛔</a></td>
                            <%}%>
                        <%}%>
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