"<div class='container-fluid' style='margin-top: 50px;'>"+
    "<div class='panel panel-default'>"+
        "<div class='panel-heading'>Dados cadastrais</div>"+
        "<div class='panel-body'>"+
            "<form th:action='@{/criarconta/save}' method='post'>"+
                "<div class='form-group col-sm-6'>"+
                    "<label for='nome' >Nome completo</label>"+
                    "<input class='form-control' name='nome' id='nome' type='text' />"+
                "</div>"+
                "<div class='form-group col-sm-6'>"+
                    "<label for='criarContaEmail' >Email</label>"+
                    "<input class='form-control' name='criarContaEmail' id='criarContaEmail' type='email' />"+
                "</div>"+
                "<div class='form-group col-sm-6'>"+
                    "<label for='senha' >Senha</label>"+
                    "<input class='form-control' name='senha' id='senha' type='password' />"+
                "</div>"+
                "<div class='form-group col-sm-6'>"+
                    "<label for='confirmaSenha' >Confirma senha</label>"+
                    "<input class='form-control' name='confirmaSenha' id='confirmaSenha' type='password' />"+
                "</div>"+

                "<div class='form-group col-sm-1'>"+
                    "<label class='control-label' for='ativo' >Ativo</label>"+
                    "<div>"+
                        "<input checked name='ativo' id='ativo' disabled type='checkbox' />"+
                    "</div>"+
                "</div>"+

                "<div class='form-group col-sm-5'>"+
                    "<label class='control-label' for='perfil' >Perfil</label>"+
                    "<div>"+
                        "<input checked name='perfil' id='perfil' disabled type='checkbox' />"+
                    "</div>"+
                "</div>"+

                "<div class='form-group col-sm-6'>"+
                    "<label for='dataNascimento' >Data nascimento</label>"+
                    "<input class='form-control' name='dataNascimento' id='dataNascimento' type='date' />"+
                "</div>"+

            "</form>"+
        "</div>"+
    "</div>"+
"</div>";