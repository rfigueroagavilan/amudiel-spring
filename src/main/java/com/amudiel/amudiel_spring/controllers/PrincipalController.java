package com.amudiel.amudiel_spring.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.amudiel.amudiel_spring.controllers.requests.CrearCervezaDTO;
import com.amudiel.amudiel_spring.models.BarEntity;
import com.amudiel.amudiel_spring.models.CervezaEntity;
import com.amudiel.amudiel_spring.models.EBar;
import com.amudiel.amudiel_spring.models.ETipo;
import com.amudiel.amudiel_spring.models.TipoEntity;
import com.amudiel.amudiel_spring.repositories.CervezaRepository;
import com.amudiel.amudiel_spring.repositories.TipoRepository;

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
    private TipoRepository tipoRepository;

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

            ETipo tipoEnum = ETipo.valueOf(crearCervezaDTO.getTipo().toUpperCase());

            TipoEntity tipoEntity = TipoEntity.builder()
                .nombre_tipo(tipoEnum)
                .build();

            

            Set<BarEntity> bares = crearCervezaDTO.getBares().stream()
                .map(bar -> BarEntity.builder()
                    .nombre_bar(EBar.valueOf(bar))
                    .build())
                .collect(Collectors.toSet());

            CervezaEntity cervezaEntity = CervezaEntity.builder()
                .nombre(crearCervezaDTO.getNombre())
                .alcohol(crearCervezaDTO.getAlcohol())
                .tipos(tipoEntity)
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
