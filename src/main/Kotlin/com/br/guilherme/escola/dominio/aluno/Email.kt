package com.br.guilherme.escola.dominio.aluno

class Email(email: String?) {
    // VALUE OBJECT
    var endereco: String = ""
        private set

    private val regex1 = "^((([!#$%&'*+\\-/=?^_`{|}~\\w])|([!#$%&'*+\\-/=?^_`{|}~\\w][!#$%&'*+\\-/=?^_`{|}~\\.\\w]{0,}[!#$%&'*+\\-/=?^_`{|}~\\w]))[@]\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*)$".toRegex()

    init {
        if(email == null) { throw IllegalArgumentException("com.br.guilherme.escola.dominio.aluno.Email invalido!")}
        if(!email.matches(regex1)) { throw IllegalArgumentException("com.br.guilherme.escola.dominio.aluno.Email invalido!")}
        this.endereco = email
    }


}