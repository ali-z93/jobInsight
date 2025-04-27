package com.ali.jobInsight.job.JobServiceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ali.jobInsight.job.Job;
import com.ali.jobInsight.job.JobRepository;
import com.ali.jobInsight.job.JobService;

@Service
public class JobServiceImpl implements JobService {

	JobRepository jobRepository;

	public JobServiceImpl(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}


	@Override
	public List<Job> findAll() {

		return jobRepository.findAll();
	}

	@Override
	public void createJob(Job job) {
		jobRepository.save(job);

	}

	@Override
	public Job getJobByID(long id) {
		// TODO Auto-generated method stub
		return jobRepository.findById(id).orElse(null);
	}

	@Override
	public boolean deleteJobById(long id) {
		try {
			jobRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean updateJob(long id, Job updatedJob) {
		// TODO Auto-generated method stub

		Optional<Job> jobOptional = jobRepository.findById(id);
		if (jobOptional.isPresent()) {
			Job job = jobOptional.get();
			job.setTitle(updatedJob.getTitle());
			job.setDescription(updatedJob.getDescription());
			job.setMaxSalary(updatedJob.getMaxSalary());
			job.setMinSalary(updatedJob.getMinSalary());
			job.setLocation(updatedJob.getLocation());
			jobRepository.save(job);
			return true;
		}

		return false;
	}
}
