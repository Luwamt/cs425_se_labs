package edu.miu.cs.cs425.eregistrar.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name="transcripts")
public class Transcript {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transcriptId;
    @Column(nullable = false)
    private String degreeTitle;

//    @OneToOne(mappedBy = "transcript", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    private Student student;

    public Transcript( String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }
    public Transcript(Long transcriptId, String degreeTitle) {
        this.transcriptId = transcriptId;
        this.degreeTitle = degreeTitle;
    }
}
