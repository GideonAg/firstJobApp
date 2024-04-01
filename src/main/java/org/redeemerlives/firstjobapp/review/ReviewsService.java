package org.redeemerlives.firstjobapp.review;

import org.redeemerlives.firstjobapp.review.Reviews;

import java.util.List;

public interface ReviewsService {
    List<Reviews> getAllReviews(int companyId);

    Reviews createReview(int company, Reviews review);

    Reviews getReviewById(int companyId, int reviewId);

    Boolean deleteReviewById(int companyId, int reviewId);

    Reviews updateReviewById(int companyId, int reviewId, Reviews reviewUpdate);
}
