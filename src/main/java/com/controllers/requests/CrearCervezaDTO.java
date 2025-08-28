package com.controllers.requests;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrearCervezaDTO {

    @NotBlank
    private String nombre;

    @NotBlank
    private Double alcohol;
    
    private Set<String> bares;
}
