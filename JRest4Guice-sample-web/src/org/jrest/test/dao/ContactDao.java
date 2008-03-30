package org.jrest.test.dao;

import java.util.List;

import org.jpa4guice.annotation.Dao;
import org.jpa4guice.annotation.DaoMethod;
import org.jpa4guice.annotation.DaoMethodType;
import org.jpa4guice.annotation.FirstResult;
import org.jpa4guice.annotation.MaxResults;
import org.jrest.test.entity.Contact;

import com.google.inject.name.Named;

@Dao
public interface ContactDao {
	@DaoMethod(type=DaoMethodType.PERSIST)
	public void createContact(Contact contact);

	@DaoMethod(type=DaoMethodType.LIST,namedQuery="list")
	public List<Contact> listContacts(@FirstResult int first,@MaxResults int max);
	
	@DaoMethod(type=DaoMethodType.LIST,namedQuery="byName")
	public List<Contact> findContactByName(@Named("name") String name);

	@DaoMethod(type=DaoMethodType.FIND)
	public Contact findContactById(String contactId);
	
	@DaoMethod(type=DaoMethodType.MERGE)
	public void updateContact(Contact contact);

	@DaoMethod(type=DaoMethodType.REMOVE)
	public void deleteContact(Contact contact);
}
