package com.nullpoint.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nullpoint.demo.component.ContactConverter;
import com.nullpoint.demo.entity.Contact;
import com.nullpoint.demo.model.ContactModel;
import com.nullpoint.demo.repository.ContactRepository;
import com.nullpoint.demo.service.ContactService;

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService {

	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;

	@Override
	public ContactModel addContact(ContactModel contactModel) {
		return ContactConverter
				.contact2ContactModel(contactRepository.save(ContactConverter.contactModel2Contact(contactModel)));
	}

	@Override
	public List<ContactModel> listAllContacts() {
		List<ContactModel> contacts = new ArrayList<ContactModel>();

		for (Contact contact : contactRepository.findAll())
			contacts.add(ContactConverter.contact2ContactModel(contact));

		return contacts;
	}

	@Override
	public ContactModel findContactById(int id) {
		return ContactConverter.contact2ContactModel(contactRepository.findById(id));
	}

	@Override
	public void removeContact(int id) {
		Contact contact = contactRepository.findById(id);

		if (contact != null)
			contactRepository.delete(contact);
	}
}
