package com.personaldj.engine.strategy;

import com.personaldj.domain.entity.DjSession;
import com.personaldj.domain.entity.Track;
import com.personaldj.domain.entity.UserFeedback;
import com.personaldj.provider.repository.UserFeedbackRepository;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * scores tracks based on how often the user has liked vs. skipped tracks from the same artist
 * this is the simplest proxy for genre affinity without needing a separate genre field
 * a like on any track by this artist increases the score
 * a skip on any track by this artist decreases it
 * score range: [0.0, 1.0], default 0.5 (neutral) when no history exists
 */
@Component
public class GenreAffinityStrategy implements ScoringStrategy {

    private final UserFeedbackRepository feedbackRepository;

    public GenreAffinityStrategy(UserFeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }
    private long countForUser(List<UserFeedback> feedbacks, Long userId) {
        return feedbacks.stream()
            .filter(f -> f.getSession().getUser().getId().equals(userId)).count();
    }

    @Override
    public double score(Track candidate, DjSession session) {
        // pull all past sessions for this user to get their feedback history
        Long userId = session.getUser().getId();

        List<UserFeedback> likes  = feedbackRepository.findByTrackIdAndFeedbackType(candidate.getId(), "LIKE");
        List<UserFeedback> skips  = feedbackRepository.findByTrackIdAndFeedbackType(candidate.getId(), "SKIP");
        List<UserFeedback> hates  = feedbackRepository.findByTrackIdAndFeedbackType(candidate.getId(), "DISLIKE");

        // filter to only this user's feedback
        long likeCount    = countForUser(likes, userId);
        long negativeCount = countForUser(skips, userId) + countForUser(hates, userId);

        long total = likeCount + negativeCount;
        if (total == 0) {
            return 0.5; 
        }
        return (double) likeCount / total;
    }
}