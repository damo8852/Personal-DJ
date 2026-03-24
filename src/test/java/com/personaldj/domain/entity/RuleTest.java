package com.personaldj.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

import com.personaldj.domain.enums.RuleType;

public class RuleTest {

    @Test
    public void testSetAndGetType() {
        Rule rule = new Rule();
        rule.setType(RuleType.MOOD_MATCH);

        assertEquals(RuleType.MOOD_MATCH, rule.getType());
    }

    @Test
    public void testSetAndGetDescription() {
        Rule rule = new Rule();
        rule.setDescription("Match the mood");

        assertEquals("Match the mood", rule.getDescription());
    }

    @Test
    public void testSetAndGetConfigJson() {
        Rule rule = new Rule();
        rule.setConfigJson("{\"threshold\": 0.7}");

        assertEquals("{\"threshold\": 0.7}", rule.getConfigJson());
    }

    @Test
    public void testIdIsNullBeforePersist() {
        Rule rule = new Rule();

        assertNull(rule.getId());
    }
}
