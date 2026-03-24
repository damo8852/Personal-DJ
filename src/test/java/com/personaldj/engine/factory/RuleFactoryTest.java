package com.personaldj.engine.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.personaldj.domain.entity.Rule;
import com.personaldj.domain.enums.RuleType;

public class RuleFactoryTest {

    private RuleFactory ruleFactory;

    @BeforeEach
    public void setUp() {
        ruleFactory = new RuleFactory();
    }

    @Test
    public void testCreateMoodMatchRule() {
        Rule rule = ruleFactory.create(RuleType.MOOD_MATCH);

        assertNotNull(rule);
        assertEquals(RuleType.MOOD_MATCH, rule.getType());
        assertNotNull(rule.getDescription());
        assertTrue(rule.getDescription().contains("valence"));
        assertTrue(rule.getDescription().contains("mood"));
    }

    @Test
    public void testCreateAvoidRepeatArtistRule() {
        Rule rule = ruleFactory.create(RuleType.AVOID_REPEAT_ARTIST);

        assertNotNull(rule);
        assertEquals(RuleType.AVOID_REPEAT_ARTIST, rule.getType());
        assertNotNull(rule.getDescription());
        assertTrue(rule.getDescription().contains("artist"));
    }

    @Test
    public void testCreatedRuleIsNotPersisted() {
        Rule rule = ruleFactory.create(RuleType.MOOD_MATCH);

        assertNull(rule.getId());
    }

    @Test
    public void testEachRuleTypeCreatesUniqueRule() {
        Rule moodRule = ruleFactory.create(RuleType.MOOD_MATCH);
        Rule artistRule = ruleFactory.create(RuleType.AVOID_REPEAT_ARTIST);

        assertNotEquals(moodRule.getType(), artistRule.getType());
        assertNotEquals(moodRule.getDescription(), artistRule.getDescription());
    }
}
