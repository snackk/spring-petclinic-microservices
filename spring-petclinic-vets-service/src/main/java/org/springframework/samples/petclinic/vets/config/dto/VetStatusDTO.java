package org.springframework.samples.petclinic.vets.config.dto;

public class VetStatusDTO {

    private int id;

    private boolean status;

    public VetStatusDTO() {
        super();
    }

    public VetStatusDTO(int id, boolean status) {
        super();
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

    @Override
    public String toString() {
        return "VetStatusDTO [id=" + this.id + ", status=" + this.status + "]";
    }
}
