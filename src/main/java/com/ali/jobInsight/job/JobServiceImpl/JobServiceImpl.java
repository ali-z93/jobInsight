package com.ali.jobInsight.job.JobServiceImpl;

import java.util.ArrayList;
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
		for(Job job: jobs) {
			if(job.getId().equals(id)) {
				return job;
			}
		}
		return null;
	}

}
