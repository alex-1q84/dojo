package com.best.demo.staff.task;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.best.demo.staff.dao.StaffStatistic;
import com.best.demo.staff.service.StaffService;

@Component
public class StaffStatisticsTask {

	@Autowired
	private StaffService staffService;
	
	public void execute(){
		List<StaffStatistic> reports = staffService.statistic();
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonGenerator generator = mapper.getJsonFactory().
					createJsonGenerator(System.out, JsonEncoding.UTF8);
			generator.writeObject(reports);
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
