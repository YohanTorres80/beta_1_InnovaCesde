package com.example.beta_1_InnovaCesde.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.beta_1_InnovaCesde.models.Prioridad;
import com.example.beta_1_InnovaCesde.repository.IRepositorioPrioridad;

@Service
public class ServicioPrioridad {


    //inyecto una dependencia hacia el repositorio
    @Autowired
    private IRepositorioPrioridad repositorioPrioridad;

    //operaciones que habilitamos ejecutar en nuestra tabla


    //guardar
    public Prioridad guardarPrioridad(Prioridad datosPrioridad){

        return this.repositorioPrioridad.save(datosPrioridad);

    }


    //buscar


    //actualizar


    //eliminar

}
