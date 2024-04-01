package org.redeemerlives.firstjobapp.review.Impl;

import org.redeemerlives.firstjobapp.company.*;
import org.redeemerlives.firstjobapp.review.ReviewRepository;
import org.redeemerlives.firstjobapp.review.Reviews;
import org.redeemerlives.firstjobapp.review.ReviewsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewsServiceImpl implements ReviewsService {
    private final ReviewRepository reviewsRepository;
    private final CompanyRepository companyRepository;

    public ReviewsServiceImpl(ReviewRepository reviewsRepository, CompanyRepository companyRepository) {
        this.reviewsRepository = reviewsRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Reviews> getAllReviews(int companyId) {
        return reviewsRepository.getAllByCompanyId(companyId);
    }

    @Override
    public Reviews createReview(int companyId, Reviews review) {
        Optional<Company> company = companyRepository.findById(companyId);
        if (company.isPresent()) {
            Reviews newReview = new Reviews(review.getReviewBody(), company.get(), review.getTitle(), review.getRating());
            return reviewsRepository.save(newReview);
        }
        return null;
    }

    @Override
    public Reviews getReviewById(int companyId, int reviewId) {
        return reviewsRepository.getReviewsByIdAndCompanyId(reviewId, companyId);
    }

    @Override
    public Reviews updateReviewById(int companyId, int reviewId, Reviews reviewUpdate) {
        Optional<Reviews> review = reviewsRepository.findById(reviewId);
        Optional<Company> company = companyRepository.findById(companyId);

        if (company.isPresent() && review.isPresent()) {
            review.get().setReviewBody(reviewUpdate.getReviewBody());
            review.get().setTitle(reviewUpdate.getTitle());
            review.get().setRating(reviewUpdate.getRating());
            return reviewsRepository.save(review.get());
        }

        return null;
    }

    @Override
    public Boolean deleteReviewById(int companyId, int reviewId) {
        Optional<Company> company = companyRepository.findById(companyId);
        Optional<Reviews> review = reviewsRepository.findById(reviewId);

        if (company.isPresent() && review.isPresent()) {
            reviewsRepository.deleteById(reviewId);
            return true;
        }
        return false;
    }
}
