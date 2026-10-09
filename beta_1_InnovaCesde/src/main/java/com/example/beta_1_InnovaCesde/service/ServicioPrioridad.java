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

    // Buscar
    public List<Prioridad> buscar() {
        return this.repositorioPrioridad.findAll();
    }

    // Actualizar
    public Prioridad modificar(UUID id, Prioridad datosNuevos) {
        Optional<Prioridad> prioridadBuscada = this.repositorioPrioridad.findById(id);

        if (prioridadBuscada.isPresent()) {
            Prioridad prioridadEncontrada = prioridadBuscada.get();

            // Modificando los datos
            prioridadEncontrada.setNombre(datosNuevos.getNombre());
            // Si la clase Prioridad tiene otros campos (ej: descripcion), los agregas aquí:
            // prioridadEncontrada.setDescripcion(datosNuevos.getDescripcion());

            // Guardo los cambios y los retorno
            return this.repositorioPrioridad.save(prioridadEncontrada);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Prioridad no encontrada");
        }
    }

    // Eliminar
    public boolean eliminar(UUID id) {
        Optional<Prioridad> prioridadBuscada = this.repositorioPrioridad.findById(id);

        if (prioridadBuscada.isPresent()) {
            this.repositorioPrioridad.deleteById(id);
            return true;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontró la prioridad");
        }
    }
}