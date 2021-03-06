package com.ricardomaricato.productservice.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "TB_PRODUTO")
public class Product implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "DESCRICAO", length = 100, nullable = false)
    private String description;

    @Column(name = "VALOR", nullable = false)
    private BigDecimal value;

    public Product() {
    }

    public Product(@NonNull Long id, @NonNull String description, @NonNull BigDecimal value) {
        this.id = Objects.requireNonNull(id);
        this.description = Objects.requireNonNull(description);
        this.value = Objects.requireNonNull(value);
    }

    public Product(@NonNull String description, @NonNull BigDecimal value) {
        this.description = Objects.requireNonNull(description);
        this.value = Objects.requireNonNull(value);
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", value=" + value +
                '}';
    }
}
