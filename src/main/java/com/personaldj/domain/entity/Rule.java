package com.personaldj.domain.entity;

import com.personaldj.domain.enums.RuleType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rules")
@Data
@NoArgsConstructor
public class Rule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RuleType type;

    private String description;

    /** JSON-encoded configuration parameters for this rule */
    @Column(columnDefinition = "TEXT")
    private String configJson;
}
