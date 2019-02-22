package com.multi.contactsapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.multi.contactsapp.domain.Contact;
import com.multi.contactsapp.domain.ContactList;
import com.multi.contactsapp.domain.Result;
import com.multi.contactsapp.service.ContactService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value="contacts")
@Api(value="ContactList Service Controller, 연락처 RESTful 서비스")
public class ContactRestController {
	
	@Autowired
	private ContactService contactService;
	
	@ApiOperation(value="연락처 조회", notes="기존 연락처를 조회합니다. .... ")
	@RequestMapping(method = RequestMethod.GET)
	public ContactList getContactList() {
		return contactService.getContactList();
	}
	
	@ApiOperation(value="연락처 추가", notes="연락처를 추가합니다. .... ")
	@RequestMapping(method = RequestMethod.POST)
	public Result insertContact(
			@ApiParam(value="추가할 연락처 정보") @RequestBody Contact c) {
		return contactService.insertContact(c);
	}
}
