package com.candidate.interview.hiringevent.runtime.model;

public class InterviewRound  extends ModelEntity{

    private Integer id;
    private Integer interviewId;
    private String candidateEmailId;
    private Integer interviewerEmailId;

    private String title; // ROUND 1 (CODING), ROUND 2 (TECH DISCUSSION), ROUND 3(SYSTEM_DESIGN), ROUND 4 (HR)

    private String interviewDate;
    private String interviewTime;

    private String virtualLink;

    private String interviewFeedBack;

    private InterviewStatus status;

}
