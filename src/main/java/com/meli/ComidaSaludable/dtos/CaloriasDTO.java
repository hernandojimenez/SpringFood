package com.meli.ComidaSaludable.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaloriasDTO {
    private double maxcalorias;
    private double totalcalorias;
    private List<CaloriasIngredienteDTO> ingredientes;
}
