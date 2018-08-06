package com.expertsystem.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.expertsystem.model.ExpertModel;
import com.expertsystem.model.ExpertJsonObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class ExpertDataTable {

	@Autowired
	SessionFactory sessionFactory; 


    @RequestMapping(value = "/ExpertPaginationDataTables", method = RequestMethod.GET)
    public @ResponseBody String springPaginationDataTables(HttpServletRequest  request) throws IOException {
		
    	//Fetch the page number from client
    	Integer pageNumber = 0;
    	if (null != request.getParameter("iDisplayStart"))
    		pageNumber = (Integer.valueOf(request.getParameter("iDisplayStart"))/10)+1;		
    	
    	//Fetch search parameter
    	String searchParameter = request.getParameter("sSearch");
    	
    	//Fetch Page display length
    	Integer pageDisplayLength = Integer.valueOf(request.getParameter("iDisplayLength"));
    	
    	//Create page list data
    	List<ExpertModel> personsList = createPaginationData(pageDisplayLength);
		
		//Here is server side pagination logic. Based on the page number you could make call 
		//to the data base create new list and send back to the client. For demo I am shuffling 
		//the same list to show data randomly
		if (pageNumber == 1) {
			Collections.shuffle(personsList);
		}else if (pageNumber == 2) {
			Collections.shuffle(personsList);
		}else {
			Collections.shuffle(personsList);
		}
		
		//Search functionality: Returns filtered list based on search parameter
		personsList = getListBasedOnSearchParameter(searchParameter,personsList);
		
		
		ExpertJsonObject personJsonObject = new ExpertJsonObject();
		//Set Total display record
		personJsonObject.setiTotalDisplayRecords(500);
		//Set Total record
		personJsonObject.setiTotalRecords(500);
		personJsonObject.setAaData(personsList);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json2 = gson.toJson(personJsonObject);
	
		return json2;
    }

	private List<ExpertModel> getListBasedOnSearchParameter(String searchParameter,List<ExpertModel> personsList) {		
		
		if (null != searchParameter && !searchParameter.equals("")) {
			List<ExpertModel> personsListForSearch = new ArrayList<ExpertModel>();
			searchParameter = searchParameter.toUpperCase();
			for (ExpertModel person : personsList) {
				
				if (person.getFname().toUpperCase().indexOf(searchParameter)!= -1 || person.getCounty().toUpperCase().indexOf(searchParameter)!= -1
						|| person.getEmailaddress().toUpperCase().indexOf(searchParameter)!= -1 || person.getLname().toUpperCase().indexOf(searchParameter)!= -1
						|| person.getSurname().toUpperCase().indexOf(searchParameter)!= -1 || person.getJobDescription().toUpperCase().indexOf(searchParameter)!= -1) {
					personsListForSearch.add(person);					
				}
				
			}
			personsList = personsListForSearch;
			personsListForSearch = null;
		}
		return personsList;
	}

	private List<ExpertModel> createPaginationData(Integer pageDisplayLength) {
		List<ExpertModel> personsList = new ArrayList<ExpertModel>();
		List<ExpertModel> l = new ArrayList<ExpertModel>();
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();		
		
		Query qry = session.createQuery("from ExpertModel p ");		
		
		personsList=qry.list();		
		
		return personsList;
	}
}
