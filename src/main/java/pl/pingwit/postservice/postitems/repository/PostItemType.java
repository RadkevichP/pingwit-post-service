package pl.pingwit.postservice.postitems.repository;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "postal_item_types")
public class PostItemType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;


    @Column(name = "basic_rate")
    private BigDecimal baseRate;

    public PostItemType() {
    }

    public PostItemType(Long id, String name, BigDecimal baseRate) {
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
}
