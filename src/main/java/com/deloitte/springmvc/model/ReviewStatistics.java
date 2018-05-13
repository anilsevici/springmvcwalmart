package com.deloitte.springmvc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReviewStatistics {

    private Double averageOverallRating;
    private Integer overallRatingRange;
    private Integer totalReviewCount;

    public Double getAverageOverallRating() {
        return averageOverallRating;
    }

    public void setAverageOverallRating(Double averageOverallRating) {
        this.averageOverallRating = averageOverallRating;
    }

    public Integer getOverallRatingRange() {
        return overallRatingRange;
    }

    public void setOverallRatingRange(Integer overallRatingRange) {
        this.overallRatingRange = overallRatingRange;
    }

    public Integer getTotalReviewCount() {
        return totalReviewCount;
    }

    public void setTotalReviewCount(Integer totalReviewCount) {
        this.totalReviewCount = totalReviewCount;
    }
}
