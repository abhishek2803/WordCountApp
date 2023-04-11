package com.as.wordcount;

import com.as.wordcount.service.impl.DefaultFileReader;
import com.as.wordcount.service.impl.DefaultWordCountService;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Main
{

	public static void main(String[] args)
	{
		log.info("Running the main method..");
		String fileName;
		if (args.length > 0)
		{
			fileName = args[0];
			log.info("The path entered is :" + fileName);
		}
		else
		{
			fileName = "file.txt";//default file
			log.info("Using default fileName: " + fileName);
		}

		var defaultFileReader = new DefaultFileReader(fileName);
		var wordCounts = new DefaultWordCountService().countWordsInDescendingOrder(defaultFileReader.readContent());
		log.info("Count of distinct words in descending order {} ", wordCounts);
	}
}
