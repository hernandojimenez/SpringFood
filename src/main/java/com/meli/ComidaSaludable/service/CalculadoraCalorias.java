package com.meli.ComidaSaludable.service;

import com.meli.ComidaSaludable.dtos.CaloriasDTO;
import com.meli.ComidaSaludable.dtos.CaloriasIngredienteDTO;
import com.meli.ComidaSaludable.dtos.PlatoDTO;

import java.util.List;

public interface CalculadoraCalorias {

    public CaloriasDTO getCalorias(PlatoDTO platoDTO);
}
