package com.epam.CustomList;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyList<E>{
	
	private static final Logger LOGGER=LogManager.getLogger(MyList.class);
	private int size = 0;
	private int DefaultCapacity = 10;
	
	private Object[] listElements;
	
	
	
	public MyList() {
		LOGGER.info("Custom List has been initialized....");
		listElements = new Object[DefaultCapacity];
	}
	
	public void add(E element) {
		
		
		if(size == DefaultCapacity) {
			reviseSize();
		}
		LOGGER.info("A new element has been inserted into custom list...");
		listElements[size++] = element;
	}
	
	public void reviseSize() {
		LOGGER.info("The size of the list is revised!...");
//		Object[] temp = new Object[DefaultCapacity + 1];
//		for(int i =0 ; i< listElements.length; i++) {
//			temp[i] = listElements[i];
//		}
//		listElements = temp;
		double loadFactor = 0.8;
		int newCapacity = (int) (DefaultCapacity + (DefaultCapacity*loadFactor));
		DefaultCapacity=newCapacity;
		
		listElements=Arrays.copyOf(listElements,DefaultCapacity);
	}
	
	@SuppressWarnings("unchecked")
	public E remove(int index) {
		Object element;
		if(index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		else {
			element = listElements[index];
			for(int i = index; i < listElements.length; i++) {
				listElements[i] = listElements[i+1];
				size--;
			}
		}
		LOGGER.info("An element has been removed from the CustomList!...");
		return (E) element;	
	}
	
	@SuppressWarnings("unchecked")
	public E getElement(int index) {
		if(index >= size)
			throw new IndexOutOfBoundsException();
		return (E) listElements[index];
	}
	
	public String display() {
		LOGGER.info("Custom is viwed on console!...");
		StringBuilder displayString = new StringBuilder();
		displayString.append('[');
		for(int i = 0; i < size; i++ ) {
			displayString.append(listElements[i].toString());
			if(i<size-1) {
				displayString.append(", ");
			}
		}
		displayString.append(']');
		return displayString.toString();
	}
	
}
