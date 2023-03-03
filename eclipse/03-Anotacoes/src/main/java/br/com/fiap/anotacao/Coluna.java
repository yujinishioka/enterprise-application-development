package br.com.fiap.anotacao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Define até quando a anotação estará presente
@Retention(RetentionPolicy.RUNTIME)
//Define onde a anotação pode ser utilizada (FIELD - atributo)
@Target({ElementType.FIELD , ElementType.METHOD})
public @interface Coluna {

	String nome();
	int tamanho() default 0;
	boolean obrigatorio() default false;
	
}