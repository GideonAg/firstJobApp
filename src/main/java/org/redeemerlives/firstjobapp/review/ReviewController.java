package org.redeemerlives.firstjobapp.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/companies/{companyId}/reviews")
public class ReviewController {

    private final ReviewsService reviewsService;

    public ReviewController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @GetMapping
    public ResponseEntity<List<Reviews>> getAllReviews(@PathVariable int companyId) {
        return ResponseEntity.ok(reviewsService.getAllReviews(companyId));
    }

    @PostMapping
    public ResponseEntity<Reviews> createReview(@PathVariable int companyId, @RequestBody Reviews reviewBody) {
        Reviews review = reviewsService.createReview(companyId, reviewBody);
        if (review != null)
            return ResponseEntity.status(HttpStatus.CREATED).body(review);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Reviews> getReviewById(@PathVariable int companyId, @PathVariable int reviewId) {
        Reviews review = reviewsService.getReviewById(companyId, reviewId);

        if (review != null)
            return ResponseEntity.ok(review);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<Reviews> updateReviewById(@PathVariable int companyId, @PathVariable int reviewId, @RequestBody Reviews reviewUpdate) {
        Reviews review = reviewsService.updateReviewById(companyId, reviewId, reviewUpdate);

        if (review != null)
            return ResponseEntity.ok(review);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReviewById(@PathVariable int companyId, @PathVariable int reviewId) {
        Boolean deleted = reviewsService.deleteReviewById(companyId, reviewId);
        if (deleted)
            return ResponseEntity.ok("review deleted successfully");
        return new ResponseEntity<>("review not found", HttpStatus.NOT_FOUND);
    }
}
