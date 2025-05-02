package com.ali.jobInsight.review.reviewServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ali.jobInsight.company.Company;
import com.ali.jobInsight.company.CompanyService;
import com.ali.jobInsight.review.Review;
import com.ali.jobInsight.review.ReviewRepository;
import com.ali.jobInsight.review.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	private ReviewRepository reviewRepository;
	private CompanyService companyService;

	public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
		this.reviewRepository = reviewRepository;
		this.companyService = companyService;
	}

	@Override
	public List<Review> getAllReviews(Long companyId) {
		List<Review> reviews = reviewRepository.findByCompanyId(companyId);
		return reviews;
	}

	@Override
	public boolean addReview(Long companyId, Review review) {
		// TODO Auto-generated method stub
		Company company = companyService.getCompanyById(companyId);

		if (company != null) {
			review.setCompany(company);
			reviewRepository.save(review);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public Review getReview(Long companyId, Long reviewId) {
		// TODO Auto-generated method stub
		List<Review> reviews = reviewRepository.findByCompanyId(companyId);

		return reviews.stream().filter(review -> review.getId().equals(reviewId)).findFirst().orElse(null);
	}

	@Override
	public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
		// TODO Auto-generated method stub
		if (companyService.getCompanyById(companyId) != null) {
			updatedReview.setCompany(companyService.getCompanyById(companyId));
			updatedReview.setId(reviewId);
//			updatedReview.setDescription();
			reviewRepository.save(updatedReview);
			return true;

		} else {
			return false;
		}

	}

	@Override
	public boolean deleteReview(Long companyId, Long reviewId) {
		// TODO Auto-generated method stub
		if (companyService.getCompanyById(companyId) != null && reviewRepository.existsById(reviewId)) {
			Review review = reviewRepository.findById(reviewId).orElse(null);
			Company company = review.getCompany();
			company.getReviews().remove(review);
			review.setCompany(null);
			companyService.updateCompany(company, companyId);
			reviewRepository.deleteById(reviewId);
			return true;

		} else {
			return false;
		}

	}

}
