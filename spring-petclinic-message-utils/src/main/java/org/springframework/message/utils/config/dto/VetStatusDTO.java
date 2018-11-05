package org.springframework.message.utils.config.dto;

public class VetStatusDTO {

    private int id;

    private boolean status;

    public VetStatusDTO(int id, boolean status) {
        this.id = id;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
