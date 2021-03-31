package com.meli.ComidaSaludable.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.ComidaSaludable.dtos.CaloriasDTO;
import com.meli.ComidaSaludable.dtos.CaloriasIngredienteDTO;
import com.meli.ComidaSaludable.dtos.IngredienteDTO;
import com.meli.ComidaSaludable.dtos.PlatoDTO;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalcularaCaloriasImpl implements CalculadoraCalorias{


    public double obtenerCalorias(PlatoDTO platoDTO) {

        double totalCalorias =0;
        List<CaloriasIngredienteDTO> list = loadFile();
        for(CaloriasIngredienteDTO l1: list){
            for(IngredienteDTO l2: platoDTO.getIngredientes()){
                if(l1.getName().equals(l2.getNombre())){
                    totalCalorias += l1.getCalories()* l2.getPeso();
                }
            }
        }
        return totalCalorias;
    }
    public List<CaloriasIngredienteDTO>  obtenerMaxCalorias(PlatoDTO platoDTO) {
        List<CaloriasIngredienteDTO> cal =new ArrayList<>();
        double calorias =0;

        List<CaloriasIngredienteDTO> list = loadFile();
        for(int i=0; i< list.size(); i++){
            for(int j=0; j<platoDTO.getIngredientes().size(); j++){
                if(list.get(i).getName().equals(platoDTO.getIngredientes().get(j).getNombre())){
                    calorias=list.get(i).getCalories() * platoDTO.getIngredientes().get(j).getPeso();
                    CaloriasIngredienteDTO calo = new CaloriasIngredienteDTO();
                    calo.setName(list.get(i).getName());
                    calo.setCalories(calorias);
                    cal.add(calo);

                }
            }
        }
        return cal;
    }
    public double obtenerMaxCaloriasI(List<CaloriasIngredienteDTO> list) {
        double max=0;
        for(CaloriasIngredienteDTO l: list){
            if(l.getCalories()>=max){
                max=l.getCalories();
            }
        }
        return max;
    }


    public static  List<CaloriasIngredienteDTO> loadFile(){
        List<CaloriasIngredienteDTO> list = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        }catch (Exception e){
            e.printStackTrace();
        }

        TypeReference<List<CaloriasIngredienteDTO>> typeRef = new TypeReference<List<CaloriasIngredienteDTO>>() {};

        try {
            list = objectMapper.readValue(file, typeRef);

        }catch (Exception e){
            e.printStackTrace();
        }

        return list;

    }

    @Override
    public CaloriasDTO getCalorias(PlatoDTO platoDTO) {
        CaloriasDTO caloriasDTO = new CaloriasDTO();
        double totalcalorias = obtenerCalorias(platoDTO);
        List<CaloriasIngredienteDTO> cal= obtenerMaxCalorias(platoDTO);
        double maxtotal = obtenerMaxCaloriasI(cal);
        caloriasDTO.setTotalcalorias(totalcalorias);
        caloriasDTO.setMaxcalorias(maxtotal);
        caloriasDTO.setIngredientes(cal);
        return caloriasDTO;
    }

}
