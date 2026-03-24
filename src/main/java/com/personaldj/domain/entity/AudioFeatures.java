package com.personaldj.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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

    public Track getTrack() { return track; }
    public void setTrack(Track track) { this.track = track; }
    public double getEnergy() { return energy; }
    public void setEnergy(double energy) { this.energy = energy; }
    public double getValence() { return valence; }
    public void setValence(double valence) { this.valence = valence; }
    public double getDanceability() { return danceability; }
    public void setDanceability(double danceability) { this.danceability = danceability; }
    public double getTempo() { return tempo; }
    public void setTempo(double tempo) { this.tempo = tempo; }
    public double getAcousticness() { return acousticness; }
    public void setAcousticness(double acousticness) { this.acousticness = acousticness; }
}
