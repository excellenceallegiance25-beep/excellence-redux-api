package com.eapl.excellence.utilities;

import java.lang.reflect.Field;
import java.util.List;

public class XmlConverter {

	public static <T> String convertListToXml(List<T> list, String rootName, String itemName) {

		if (list == null || list.isEmpty()) {
			return null;
		}

		StringBuilder xml = new StringBuilder();
		xml.append("<").append(rootName).append(">");

		for (T obj : list) {
			xml.append("<").append(itemName).append(">");

			for (Field field : obj.getClass().getDeclaredFields()) {
				try {
					field.setAccessible(true);
					Object value = field.get(obj);

					xml.append("<").append(field.getName()).append(">").append(value != null ? value : "").append("</")
							.append(field.getName()).append(">");
				} catch (Exception e) {
					throw new RuntimeException("Error converting object to XML", e);
				}
			}

			xml.append("</").append(itemName).append(">");
		}

		xml.append("</").append(rootName).append(">");

		return xml.toString();
	}
}
