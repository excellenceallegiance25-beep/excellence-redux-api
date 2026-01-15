package com.eapl.excellence.mailConfig;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class TemplateUtil {

	/*
	 * 
	 * Date: 25-May-2023 Method: getEmailBody Purpose: to get sending email body
	 * 
	 */
	public String getEmailBody(Map<String, String> replacers, String emailTemplatePath)
			throws FileNotFoundException, IOException {

		File template = new File(emailTemplatePath);

		if (template.exists()) {
			String templateContent = FileUtils.readFileToString(template, "UTF-8");
			String[] replacedContent = { templateContent };
			replacers.forEach((key, val) -> {
				replacedContent[0] = StringUtils.replace(replacedContent[0], key, val);
			});
			return replacedContent[0];
		} else {
			throw new FileNotFoundException("Template File not found in specified path: " + template.getAbsolutePath());
		}

	}

}
