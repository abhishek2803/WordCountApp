package com.as.wordcount.service.impl;

import com.as.wordcount.dto.WordCount;
import com.as.wordcount.service.WordCountService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class DefaultWordCountService implements WordCountService
{

	public static final String REGEX = "\\W+";

	/**
	 * Read the words in the String content and returns WordCount which contains distinct word and its respective counts
	 *
	 * @return List of distinct WordCount in descending order
	 */
	@Override
	public List<WordCount> countWordsInDescendingOrder(final String content)
	{
		Objects.requireNonNull(content);

		var stringLongMap = Pattern.compile(REGEX)
				.splitAsStream(content.toLowerCase())
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		return stringLongMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.map(stringLongEntry -> WordCount.builder().word(stringLongEntry.getKey())
						.count(Math.toIntExact(stringLongEntry.getValue())).build())
				.collect(Collectors.toList());
	}
}
