package com.meli.ComidaSaludable.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaloriasIngredienteDTO {
    private String name;
    private double calories;
}
