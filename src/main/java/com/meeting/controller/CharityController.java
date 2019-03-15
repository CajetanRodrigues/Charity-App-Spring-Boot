package com.meeting.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meeting.model.Charity;
import com.meeting.repository.CharityRepository;
import com.meeting.repository.MeetingRepository;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
@RequestMapping(value="/rest")
public class CharityController {
	
	@Autowired
	 private CharityRepository charityRepository;
	@Autowired
	private MeetingRepository meetingRepository;
	 @RequestMapping(value = "/get-charity-trusts", method = RequestMethod.GET)
		public List<Charity> getCharityTrusts() {
			return charityRepository.findAll();// return a list of objects
		}
	 
	 @RequestMapping(method=RequestMethod.POST,value="/charity-trust-create")
	 public Charity addTrust(@RequestBody Charity trust)
		{
		 	Charity c=new Charity();
		 	c.setAmount(trust.getAmount());
		 	c.setCategory(trust.getCategory());
		 	c.setCharityname(trust.getCharityname());
		 	c.setCity(trust.getCity());
		 	c.setCountry(trust.getCountry());
		 	c.setDescription(trust.getDescription());
		 	c.setEmail(trust.getEmail());
		 	c.setId(trust.getId());
		 	c.setImage(trust.getImage());
		 	c.setLatitude(trust.getLatitude());
		 	c.setLongitude(trust.getLongitude());
		 	c.setSlogan(trust.getSlogan());
		 	c.setState(trust.getState());
		 	c.setUrl(trust.getUrl());
		 	c.setZipcode(trust.getZipcode());
			charityRepository.save(c);
			return c;
		}
	 @RequestMapping(method=RequestMethod.GET,value="/charity-trust-category/{category}")
	 public List<Charity> searchTrust(@PathVariable("category") String category)
	 {
		
			return charityRepository.getTrustByCategory(category);
	 }
	 @RequestMapping(method=RequestMethod.GET,value="/charity-trust-by-id/{id}")
	 public Charity searchTrustById(@PathVariable int id)
	 {
		 Charity charitytrusts=new Charity();
			return charityRepository.getTrustById(id);
	 }
	 @RequestMapping(method=RequestMethod.GET,value="/charity-trust-funds/{id}/{funds}")
	 public Charity addFundsToTrust(@PathVariable int id,@PathVariable String funds)
	 {
		 
		 
		  Charity trust=new Charity();
		 trust = charityRepository.getTrustById(id);
		 trust.setAmount(funds);
		 charityRepository.save(trust);
		 double amount;
		 
		 amount=Double.parseDouble(funds);
		 double value=Double.parseDouble(trust.getFunds());
		 value=value+Double.parseDouble(funds);
		 trust.setFunds(Double.toString(value));
			charityRepository.addFundsToTrust(Double.toString(value),id);
			return charityRepository.getTrustById(id);
	 }
}
