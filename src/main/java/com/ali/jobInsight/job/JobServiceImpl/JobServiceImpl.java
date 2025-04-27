package com.ali.jobInsight.job.JobServiceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ali.jobInsight.job.Job;
import com.ali.jobInsight.job.JobService;

@Service
public class JobServiceImpl implements JobService {

	private List<Job> jobs = new ArrayList<>();
	private Long nextId = 1L;

	@Override
	public List<Job> findAll() {
		// TODO Auto-generated method stub
		return jobs;
	}

	@Override
	public void createJob(Job job) {
		// TODO Auto-generated method stub
		job.setId(nextId++);
		jobs.add(job);

	}

	@Override
	public Job getJobByID(long id) {
		// TODO Auto-generated method stub
		for (Job job : jobs) {
			if (job.getId().equals(id)) {
				return job;
			}
		}
		return null;
	}

	@Override
	public boolean deleteJobById(long id) {
		// TODO Auto-generated method stub

		Iterator<Job> iterator = jobs.iterator();
		while (iterator.hasNext()) {
			Job job = iterator.next();
			if (job.getId().equals(id)) {
				jobs.remove(job);
				return true;
			}

		}
		return false;
	}

	@Override
	public boolean updateJob(long id, Job updatedJob) {
		// TODO Auto-generated method stub
		Iterator<Job> iterator = jobs.iterator();
		while (iterator.hasNext()) {
			Job job = iterator.next();
			if (job.getId().equals(id)) {
				job.setTitle(updatedJob.getTitle());
				job.setDescription(updatedJob.getDescription());
				job.setMaxSalary(updatedJob.getMaxSalary());
				job.setMinSalary(updatedJob.getMinSalary());
				job.setLocation(updatedJob.getLocation());
				return true;
			}
		}

		return false;
	}

}
