package com.personaldj.provider.repository;

import com.personaldj.domain.entity.UserFeedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserFeedbackRepository extends JpaRepository<UserFeedback, Long> {
    List<UserFeedback> findBySessionId(Long sessionId);
    List<UserFeedback> findByTrackIdAndFeedbackType(Long trackId, String feedbackType);
}
