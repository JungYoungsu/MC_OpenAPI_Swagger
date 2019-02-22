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
@Api(value="ContactList Service Controller, ����ó RESTful ����")
public class ContactRestController {
	
	@Autowired
	private ContactService contactService;
	
	@ApiOperation(value="����ó ��ȸ", notes="���� ����ó�� ��ȸ�մϴ�. .... ")
	@RequestMapping(method = RequestMethod.GET)
	public ContactList getContactList() {
		return contactService.getContactList();
	}
	
	@ApiOperation(value="����ó �߰�", notes="����ó�� �߰��մϴ�. .... ")
	@RequestMapping(method = RequestMethod.POST)
	public Result insertContact(
			@ApiParam(value="�߰��� ����ó ����") @RequestBody Contact c) {
		return contactService.insertContact(c);
	}
}
