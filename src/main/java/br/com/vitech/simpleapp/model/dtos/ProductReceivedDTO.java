package br.com.vitech.simpleapp.model.dtos;

public record ProductReceivedDTO(
        String name,
        Double price,
        Integer quantity
) {
}
