package com.as.wordcount.service.impl;

import com.as.wordcount.exception.FileHandlingException;
import com.as.wordcount.service.FileReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class DefaultFileReaderTest
{

	FileReader fileContentReader;

	@BeforeEach
	void setUp()
	{
		fileContentReader = new DefaultFileReader(null);
	}

	@Test
	void readFileContentShouldThrowExceptionIfFileNotFound()
	{
		assertThatExceptionOfType(NullPointerException.class)
				.isThrownBy(() -> fileContentReader.readContent())
				.withNoCause();
	}

	@Test
	void readFileContentShouldGiveEmptyContentWhenFileContainsEmptyContent()
	{
		fileContentReader = new DefaultFileReader(getClass().getClassLoader().getResource("empty.txt").getFile());
		assertThat(fileContentReader.readContent().isEmpty());
	}


	@Test
	void readFileContentShouldGiveContentWhenFileContainsContent()
	{
		fileContentReader = new DefaultFileReader(getClass().getClassLoader().getResource("content.txt").getFile());
		assertThat(!fileContentReader.readContent().isEmpty());
		assertThat(fileContentReader.readContent()).isEqualTo("hi i am a test paper. read me to fail the paper.");

	}

	@Test
	void readFileContentShouldGiveContentWhenFileContainsContent1()
	{
		fileContentReader = new DefaultFileReader("invalid.txt");
		assertThatExceptionOfType(FileHandlingException.class)
				.isThrownBy(() -> fileContentReader.readContent())
				.withMessage("file not found = invalid.txt")
				.withNoCause();
	}
}