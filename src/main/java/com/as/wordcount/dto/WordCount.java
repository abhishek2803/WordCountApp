package com.as.wordcount.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Builder
@AllArgsConstructor
@Getter
public class WordCount
{
	private String word;
	private int count;

	@Override
	public String toString()
	{
		return word +
				":" + count;
	}
}
