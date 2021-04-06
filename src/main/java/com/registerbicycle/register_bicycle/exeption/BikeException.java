package com.registerbicycle.register_bicycle.exeption;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BikeException extends RuntimeException{

    public static final String MESSAGE_STANDARD = "Erro em objeto do tipo %s ao executar %s com id %s.";

    public static final String MESSAGE_INDEFINIDO = "indefinido";

    public BikeException(String typeObject, String action, Long id) {
        super(String.format(MESSAGE_STANDARD, typeObject, action, id));
    }

    public BikeException(String typeObject, String action) {
        super(String.format(MESSAGE_STANDARD, typeObject, action, MESSAGE_INDEFINIDO));
    }

}
