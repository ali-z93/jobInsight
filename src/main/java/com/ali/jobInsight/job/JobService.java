package com.ali.jobInsight.job;

import java.util.List;

public interface JobService {

	List<Job> findAll();

	void createJob(Job job);
	
	Job getJobByID(long id);
	

}
