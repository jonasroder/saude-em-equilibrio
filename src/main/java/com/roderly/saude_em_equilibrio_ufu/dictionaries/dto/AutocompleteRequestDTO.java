package com.roderly.saude_em_equilibrio_ufu.dictionaries.dto;

public record AutocompleteRequestDTO (
    String idColumn,
    String descColumn,
    String tableName,
    Boolean is_active,
    String whereClause
){}
