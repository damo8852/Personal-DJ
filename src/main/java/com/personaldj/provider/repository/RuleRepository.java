package com.personaldj.provider.repository;

import com.personaldj.domain.entity.Rule;
import com.personaldj.domain.enums.RuleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RuleRepository extends JpaRepository<Rule, Long> {
    List<Rule> findByType(RuleType type);
}
