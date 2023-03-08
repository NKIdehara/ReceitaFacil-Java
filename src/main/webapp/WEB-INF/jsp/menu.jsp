<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/usuario/lista">Usuários</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Receitas</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Ingredientes</a>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="#">Granel</a></li>
                    <li><a class="dropdown-item" href="#">Líquido</a></li>
                    <li><a class="dropdown-item" href="#">Fresco</a></li>
                </ul>
            </li>
        </ul>
    </div>
</div>
</nav>
