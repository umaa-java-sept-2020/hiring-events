package com.candidate.interview.hiringevent.runtime.model;

import java.util.List;

public class Interview extends ModelEntity {

    private Integer id;
    private String title; // INTERVIEW JAVA ENGG 2 | JOHN DOE | 6 YEARS
    private Integer jobDetailsId;
    private String candidateEmail;

    private InterviewStatus status;

    private List<InterviewRound> rounds;
}
