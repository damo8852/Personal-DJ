package com.personaldj.engine.factory;

import com.personaldj.domain.entity.Rule;
import com.personaldj.domain.enums.RuleType;
import org.springframework.stereotype.Component;

/**
 * Factory pattern implementation.
 * Creates pre-configured {@link Rule} instances based on the given {@link RuleType}.
 */
@Component
public class RuleFactory {

    /**
     * Creates a new {@link Rule} configured for the given type.
     *
     * @param type the rule type to create
     * @return a configured Rule entity (not yet persisted)
     */
    public Rule create(RuleType type) {
        return switch (type) {
            case MOOD_MATCH -> buildRule(type, "Prefer tracks whose valence matches the session mood target.");
            case AVOID_REPEAT_ARTIST -> buildRule(type, "Do not play the same artist more than once in a configurable window.");
        };
    }

    private Rule buildRule(RuleType type, String description) {
        Rule rule = new Rule();
        rule.setType(type);
        rule.setDescription(description);
        return rule;
    }
}
