package com.personaldj.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "audio_features")
@Data
@NoArgsConstructor
public class AudioFeatures {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "track_id", nullable = false)
    private Track track;

    /** Spotify energy value in range [0.0, 1.0] */
    private double energy;

    /** Spotify valence (mood positivity) in range [0.0, 1.0] */
    private double valence;

    /** Spotify danceability in range [0.0, 1.0] */
    private double danceability;

    /** Estimated tempo in BPM */
    private double tempo;

    /** Spotify acousticness in range [0.0, 1.0] */
    private double acousticness;
}
