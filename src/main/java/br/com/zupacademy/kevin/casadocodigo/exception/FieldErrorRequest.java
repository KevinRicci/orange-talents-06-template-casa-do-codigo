package br.com.zupacademy.kevin.casadocodigo.exception;

public class FieldErrorRequest {

    private String campo;
    private String causa;

    public FieldErrorRequest(String campo, String causa) {
        this.campo = campo;
        this.causa = causa;
    }

    public String getCampo() {
        return campo;
    }

    public String getCausa() {
        return causa;
    }
}
