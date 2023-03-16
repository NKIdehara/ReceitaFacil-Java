<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="br.edu.infnet.al.receitafacil.model.domain.Usuario"%>
<% Usuario user = (Usuario)request.getAttribute("usuario");%>

<nav class="navbar navbar-expand-sm bg-light navbar-light">
    <div class="d-flex flex-column">
        <div class="rounded mx-auto d-block">
            <img src="./../../resources/ic_cook.png" height="100">
        </div>
            <div class="text-nowrap bd-highlight">
            <h2>Receita Fácil</h2>
        </div>
    </div>
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <form action="/home" method="get">
                <button type="submit" class="btn btn-outline-secondary">🏠</button>
            </form>
            <%if(user != null) {%>
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="/usuario/lista">Usuários</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/receita/lista">Receitas</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Ingredientes</a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="/ingrediente/granel/lista">Granel</a></li>
                            <li><a class="dropdown-item" href="/ingrediente/liquido/lista">Líquido</a></li>
                            <li><a class="dropdown-item" href="/ingrediente/fresco/lista">Fresco</a></li>
                        </ul>
                    </li>
                </ul>
            
                <div class="mb-3 row">
                    <h5>Bem vindo <%=user.getNome()%></h5>
                    <form class="d-flex" action="/logout" method="get">
                        <button type="submit" class="btn btn-outline-secondary">❌ Logout</button>
                    </form>
                </div>
            <%}%>

        </div>
    </div>
</nav>
