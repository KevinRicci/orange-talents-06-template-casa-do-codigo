package br.com.zupacademy.kevin.casadocodigo.cliente.validacao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {ClienteRestricoesValidator.class})
@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ClienteRestricoes {

    String message() default "br.com.zupacademy.kevin.casadocodigo.cliente.validacao.ClienteRestricoes";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String idPais();

    String idEstado();
}
