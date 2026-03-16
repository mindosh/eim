package mk.ukim.finki.wp.eimtlabaratoriska.model.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Accommodation extends BaseAuditableEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Host host;

    @Column(nullable = false)
    private Integer numRooms;

    @Column(nullable = false)
    private Boolean rented=false;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Condition condition;

    public Accommodation(String name, Category category, Host host, Integer numRooms,Condition condition) {
        this.name = name;
        this.category = category;
        this.host = host;
        this.numRooms = numRooms;
        this.condition = condition;
    }

}