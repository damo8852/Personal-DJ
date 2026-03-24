package com.personaldj.domain.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_feedback")
@Data
@NoArgsConstructor
public class UserFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "track_id", nullable = false)
    private Track track;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id", nullable = false)
    private DjSession session;

    /** e.g. LIKE, SKIP, DISLIKE */
    @Column(nullable = false)
    private String feedbackType;

    private LocalDateTime recordedAt;

    public String getFeedbackType() {
        return feedbackType;
    }

    public Track getTrack() {
        return track;
    }

    public void setFeedbackType(String feedbackType) { this.feedbackType = feedbackType; }
    public void setTrack(Track track) { this.track = track; }
    public DjSession getSession() { return session; }
    public void setSession(DjSession session) { this.session = session; }
    public LocalDateTime getRecordedAt() { return recordedAt; }
    public void setRecordedAt(LocalDateTime recordedAt) { this.recordedAt = recordedAt; }
    public Long getId() { return id; }
}
