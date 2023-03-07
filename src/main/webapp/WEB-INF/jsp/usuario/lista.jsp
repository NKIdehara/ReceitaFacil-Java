<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="java.util.List"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="br.edu.infnet.al.receitafacil.domain.Usuario"%>

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

    <img src="./../../resources/ic_cook.png" height="300">
    <h1>Receita Fácil</h1>

    <div class="container">
        <form action="/usuario" method="get">
            <h3>Usuários</h3>
            <button type="submit" class="btn btn-primary">Novo</button>
        </form>

        <%if(opc != null) {%>
            <%if(opc.equals("i")) {%>
                <div class="alert alert-success alert-dismissible">
                    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                    <strong>Novo usuário!</strong> <%=msg%>
                </div>
            <%}%>
            <%if(opc.equals("e")) {%>
                <div class="alert alert-warning alert-dismissible">
                    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                    <strong>Usuário modificado!</strong> <%=msg%>
                </div>
            <%}%>
            <%if(opc.equals("x")) {%>
                <div class="alert alert-danger alert-dismissible">
                    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                    <strong>Usuário excluído!</strong> <%=msg%>
                </div>
            <%}%>
        <%}%>

        <% 
            List<Usuario> usuarios = new ArrayList<Usuario>();
            usuarios = (List)request.getAttribute("usuarios");
        %>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>E-mail</th>
                    <th>Senha</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%for(Usuario u : usuarios) {%>
                    <tr>
                        <td><%=u.getNome()%></td>
                        <td><%=u.getEmail()%></td>
                        <td><%=u.getSenha()%></td>
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