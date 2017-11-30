package com.denofprogramming.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.denofprogramming.model.MessageValue;

@Service("dynamicMessageOfDay")
public class DynamicMessageOfTheDayImpl implements MessageOfTheDayService {

	
	// Messages held in an Array
	private String[] messagesArray;

	private MessageValue[] messagesValueArray = {};

	// Messages held in a List
	private List<String> messagesList = new ArrayList<String>();

	private List<MessageValue> messagesValueList;

	// Messages held in a Map
	private Map<Integer, String> messagesMap = new HashMap<Integer, String>();

	@Inject
	private Map<String, MessageValue> messagesValueMap;

	public DynamicMessageOfTheDayImpl() {
		System.out.println("no-arg Constructor called for " + DynamicMessageOfTheDayImpl.class.getName());
	}

	public DynamicMessageOfTheDayImpl(String[] messages) {
		System.out.println("String[] Constructor called for " + DynamicMessageOfTheDayImpl.class.getName());
		this.messagesArray = (String[]) messages.clone();
	}

	public DynamicMessageOfTheDayImpl(MessageValue[] messagesValues) {
		System.out.println("MessageValue[] Constructor called for " + DynamicMessageOfTheDayImpl.class.getName());
		this.messagesValueArray = (MessageValue[]) messagesValues.clone();
	}

	public void init() {
		System.out.println("init() called for " + DynamicMessageOfTheDayImpl.class.getName());
	}

	public void destroy() {
		System.out.println("destroy() called for " + DynamicMessageOfTheDayImpl.class.getName());
	}

	public String getMessage() {

		// What day is it today??
		final int day = GregorianCalendar.getInstance().get(Calendar.DAY_OF_WEEK);

		// days start at on in Java
		String message = "";

		// Array examples
		if (messagesArray != null && messagesArray.length > 0) {
			message = "From Array:" + messagesArray[day - 1];
		}
		if (messagesValueArray != null && messagesValueArray.length > 0) {
			message = "From Array:" + messagesValueArray[day - 1].getMessage();
		}

		// List examples
		if (messagesList != null && !messagesList.isEmpty()) {
			message = "From List:" + messagesList.get(day - 1);
		}

		if (messagesValueList != null && !messagesValueList.isEmpty()) {
			message = "From List:" + messagesValueList.get(day - 1).getMessage();
		}

		// Map examples
		if (messagesMap != null && !messagesMap.isEmpty()) {
			message = "From Map:" + messagesMap.get(day);
		}

		if (messagesValueMap != null && !messagesValueMap.isEmpty()) {
			message = "From Map:" + messagesValueMap.get(Integer.toString(day)).getMessage();
		}

		return message;
	}

	public void setMessagesArray(final String[] messagesArray) {
		// make a defensive copy of the array contents
		this.messagesArray = (String[]) messagesArray.clone();
	}

	public void setMessagesValueArray(final MessageValue[] messagesValueArray) {
		// make a defensive copy of the array contents
		this.messagesValueArray = (MessageValue[]) messagesValueArray.clone();
	}

	public void setMessagesList(final List<String> messagesList) {
		// make a defensive copy of the list contents
		this.messagesList.addAll(messagesList);
	}

	public void setMessagesValueList(final List<MessageValue> messagesValueList) {
		// make a defensive copy of the list contents
		this.messagesValueList.addAll(messagesValueList);
	}

	public void setMessagesMap(final Map<Integer, String> messagesMap) {
		// make a defensive copy of the map contents
		this.messagesMap.putAll(messagesMap);
	}

	public void setMessagesValueMap(final Map<String, MessageValue> messagesValueMap) {
		// make a defensive copy of the map contents
		this.messagesValueMap.putAll(messagesValueMap);
	}

}
