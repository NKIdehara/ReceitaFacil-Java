<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="br.edu.infnet.al.receitafacil.model.domain.Endereco"%>
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
        <h3>Cadastro de Usuários</h3>

        <form action="/cep" method="post">
            <div class="mb-3 mt-3">
                <label class="form-label">CEP:</label>
                <div class="input-group mb-3">
                    <button class="btn btn-outline-secondary" type="submit" id="busca-cep">Buscar</button>
                    <input type="number" class="form-control" name="buscacep" oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);" maxlength = "8" value="20010020">
                </div>
            </div>
        </form>
        <% String encontrado = (String)request.getAttribute("encontrado");%>
        <% Endereco endereco = (Endereco)request.getAttribute("endereco");%>
        <%if(encontrado != null) {%>
            <%if(encontrado.equals("n")) {%>
                <div class="alert alert-danger" role="alert">
                    <strong>CEP incorreto!</strong> 
                </div>
            <%}%>
        <%}%>

        <form action="/usuario/incluir" method="post" enctype="multipart/form-data">
            <div class="mb-3">
                <label for="formFile" class="form-label">Foto:</label>
                <!-- <input class="form-control" type="file" id="formFile" name="foto" onchange="preview()"> -->
                <input class="form-control" type="file" id="formFile" name="file" onchange="preview()">
                <img id="frame" src="" class="img-fluid" width="200" name="imagem"/>
            </div>
            <script>
                function preview() {
                    frame.src = URL.createObjectURL(event.target.files[0]);
                }
            </script>

            <div class="mb-3 mt-3">
                <label class="form-label">Nome:</label>
                <input type="text" class="form-control" id="nome" name="nome" value="Admin">
            </div>

            <div class="mb-3 mt-3">
                <label class="form-label">Senha:</label>
                <input type="password" class="form-control" name="senha" value="123456" >
            </div>

            <div class="mb-3 mt-3">
                <label class="form-label">e-mail:</label>
                <input type="email" class="form-control" name="email" value="email@email.com">
            </div>

            <div class="mb-3 mt-3">
                <label class="form-label">Telefone:</label>
                <input type="number" class="form-control" name="telefone" oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);" maxlength="12" value="012934567899">
            </div>

            <%if(encontrado != null) {%>
                <%if(encontrado.equals("s")) {%>
                    <div class="mb-3 mt-3">
                        <label class="form-label">CEP:</label>
                        <input type="text" class="form-control" name="cep" value="<%=endereco.getCep()%>" readonly>
                    </div>
            
                    <div class="mb-3 mt-3">
                        <label class="form-label">Endereço:</label>
                        <input type="text" class="form-control" name="endereco" value="<%=endereco.getLogradouro()%>" readonly>
                    </div>
            
                    <div class="mb-3 mt-3">
                        <label class="form-label">Bairro:</label>
                        <input type="text" class="form-control" name="bairro" value="<%=endereco.getBairro()%>" readonly>
                    </div>
            
                    <div class="mb-3 mt-3">
                        <label class="form-label">Cidade:</label>
                        <input type="text" class="form-control" name="cidade" value="<%=endereco.getLocalidade()%>" readonly>
                    </div>
            
                    <div class="mb-3 mt-3">
                        <label class="form-label">UF:</label>
                        <input type="text" class="form-control" name="uf" value="<%=endereco.getUf()%>" readonly>
                    </div>
                        
                    <button type="submit" class="btn btn-primary">Cadastrar</button>
                <%}%>
            <%}%>
        </form>
    </div>
</body>
</html>