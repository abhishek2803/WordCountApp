package com.as.wordcount.service.impl;

import com.as.wordcount.exception.FileHandlingException;
import com.as.wordcount.service.FileReader;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;


@Slf4j
public class DefaultFileReader implements FileReader
{
	private final String fileName;

	public DefaultFileReader(final String fileName)
	{
		this.fileName = fileName;
	}

	@Override
	public String readContent()
	{
		Objects.requireNonNull(fileName);

		log.info("file location : " + fileName);
		try
		{
			Path filePath = Path.of(fileName);
			return Files.readString(filePath);
		}
		catch (IOException e)
		{
			log.error("file not found = " + fileName);
			throw new FileHandlingException("file not found = " + fileName);
		}
	}

}
