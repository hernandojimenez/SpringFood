package com.meli.ComidaSaludable.controller;

import com.meli.ComidaSaludable.dtos.CaloriasDTO;
import com.meli.ComidaSaludable.dtos.CaloriasIngredienteDTO;
import com.meli.ComidaSaludable.dtos.PlatoDTO;
import com.meli.ComidaSaludable.service.CalculadoraCalorias;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/food")
public class CalcularCaloriasController {

    private CalculadoraCalorias calculadoraCalorias;

    public CalcularCaloriasController(CalculadoraCalorias calculadoraCalorias) {
        this.calculadoraCalorias = calculadoraCalorias;
    }
    @PostMapping("/maxcalorias")
    public ResponseEntity<CaloriasIngredienteDTO> getTotalCalorias(@RequestBody PlatoDTO platoDTO){
        CaloriasDTO caloriasDTO = calculadoraCalorias.getCalorias(platoDTO);
        return new ResponseEntity(caloriasDTO,HttpStatus.OK);
    }
}
