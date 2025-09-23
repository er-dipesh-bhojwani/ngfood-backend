package com.ngfood.mill.dto;

public class MillNameLookupDto {
    public MillNameLookupDto(Long millId, String name) {
        this.millId = millId;
        this.name = name;
    }

    private Long millId;
    private String name;

    public Long getMillId() {
        return millId;
    }

    public void setMillId(Long millId) {
        this.millId = millId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
