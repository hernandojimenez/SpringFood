package com.meli.ComidaSaludable.excepciones;

import lombok.Data;

@Data
public class CaloriasExcepciones extends Exception{

    private String code;

    public CaloriasExcepciones(String message, String code, Throwable cause) {
        super(message,cause);
        this.code=code;

    }

}
