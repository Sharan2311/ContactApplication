package com.sharan.service;

import java.util.List;

import com.sharan.domain.Contact;

public interface ContactInterface {
public void save(Contact c);
public void update(Contact c);
public void delete(Integer contactId);
public void delete(Integer[] contactIds);
/**
 * This method is used to get all the contacts of the User logged in.
 * @param userId
 * @return
 */
public List<Contact> findUserContact(Integer userId);
/**
 * This method is used for the txt based search of the contacts for the user logged in
 * @param userId
 * @param txt
 * @return
 */
public List<Contact> findUserContact(Integer userId,String txt);

}
