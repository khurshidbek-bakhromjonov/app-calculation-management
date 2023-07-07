package com.calcmanagement.payload;

import lombok.Data;

@Data
public class OrganisationDTO {
    private Long id;
    private String name;
    private Long regionId;
    private Long parentId;
}