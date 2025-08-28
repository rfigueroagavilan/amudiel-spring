package com.amudiel.amudiel_spring.controllers.requests;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrearCervezaDTO {

    @NotBlank
    private String nombre;

    @NotNull
    private Double alcohol;

    @NotBlank
    private String tipo;

    private Set<String> bares;
}
