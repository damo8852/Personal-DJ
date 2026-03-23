package com.personaldj.provider.repository;

import com.personaldj.domain.entity.DjSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DjSessionRepository extends JpaRepository<DjSession, Long> {
    List<DjSession> findByUserIdOrderByStartedAtDesc(Long userId);
}
