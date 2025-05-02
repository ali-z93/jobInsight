package com.ali.jobInsight.review;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
	private ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}

	@GetMapping("/reviews")
	public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
		return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);

	}

	@GetMapping("/reviews/{reviewId}")
	public ResponseEntity<Review> getReview(@PathVariable Long reviewId, @PathVariable Long companyId) {
		return new ResponseEntity<>(reviewService.getReview(companyId, reviewId), HttpStatus.OK);
	}

	@PostMapping("reviews")
	public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review) {
		boolean isReviewSaved = reviewService.addReview(companyId, review);
		if (isReviewSaved) {
			return new ResponseEntity<>("review ADDED successfully", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("review NOT SAVED", HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/reviews/{reviewId}")
	public ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId,
			@RequestBody Review review) {
		boolean isReviewUpdated = reviewService.updateReview(companyId, reviewId, review);
		if (isReviewUpdated) {
			return new ResponseEntity<>("review UPDATED successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("review NOT UPDATED", HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/reviews/{reviewId}")
	public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId) {

		boolean isReviewUpdated = reviewService.deleteReview(companyId, reviewId);
		if (isReviewUpdated) {
			return new ResponseEntity<>("review DELETED successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("review NOT DELETED", HttpStatus.NOT_FOUND);
		}
	}

}
