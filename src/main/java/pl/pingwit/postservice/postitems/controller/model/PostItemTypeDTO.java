package pl.pingwit.postservice.postitems.controller.model;

import java.math.BigDecimal;
import java.util.Objects;

public class PostItemTypeDTO {

    private Long id;
    private String name;
    private BigDecimal baseRate;

    public PostItemTypeDTO() {
    }

    public PostItemTypeDTO(Long id, String name, BigDecimal baseRate) {
        this.id = id;
        this.name = name;
        this.baseRate = baseRate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(BigDecimal baseRate) {
        this.baseRate = baseRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostItemTypeDTO that = (PostItemTypeDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(baseRate, that.baseRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, baseRate);
    }

    @Override
    public String toString() {
        return "PostItemTypeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", baseRate=" + baseRate +
                '}';
    }
}
