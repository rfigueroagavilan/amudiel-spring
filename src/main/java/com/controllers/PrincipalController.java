package com.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.controllers.requests.CrearCervezaDTO;
import com.models.BarEntity;
import com.models.CervezaEntity;
import com.models.EBar;
import com.repositories.CervezaRepository;

import jakarta.validation.Valid;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class PrincipalController {


    @Autowired
    private CervezaRepository cervezaRepository;

    @GetMapping("/holi")
    public String hola(){
        return "hola mundo";
    }

    @GetMapping("/holiSeguro")
    public String holaAsegurado(){
        return "hola mundo asegurado";
    }

    @PostMapping("/crearCerveza")
    public ResponseEntity<?> crearCerveza(@Valid @RequestBody CrearCervezaDTO crearCervezaDTO){

            Set<BarEntity> bares = crearCervezaDTO.getBares().stream()
                .map(bar -> BarEntity.builder()
                    .nombre_bar(EBar.valueOf(bar))
                    .build())
                .collect(Collectors.toSet());

            CervezaEntity cervezaEntity = CervezaEntity.builder()
                .nombre(crearCervezaDTO.getNombre())
                .alcohol(crearCervezaDTO.getAlcohol())
                .bares(bares)
                .build();

            cervezaRepository.save(cervezaEntity);

            return ResponseEntity.ok(cervezaEntity);
    }

    @DeleteMapping("/borrarCerveza")
    public String borrarCerveza(@RequestParam String id){

        cervezaRepository.deleteById(Long.parseLong(id));
        return "Se ha borrado la cerveza con id ".concat(id);
    }
}
