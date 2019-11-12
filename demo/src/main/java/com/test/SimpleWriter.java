package com.test;

import java.util.List;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemWriter;

import com.test.model.Report;

public class SimpleWriter implements ItemWriter<Report> {

	@Override
	public void write(List<? extends Report> list) throws Exception {
		// TODO Auto-generated method stub

		for (Report report : list) {

			System.out.println(report.getDate() + " " + report.getEarning());
		}

	}

	@BeforeStep
	public void beforeStep(StepExecution stepExecution) {
		System.out.println("In before step:" + stepExecution.getStepName());
	}

	@AfterStep
	public void afterStep(StepExecution stepExecution) {
		System.out.println("In after step" + stepExecution.getStepName());
		System.out.println("Step Execution Status:" + stepExecution.getExitStatus());
	}

}
