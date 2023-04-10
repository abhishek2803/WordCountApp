package com.as.wordcount.service;

import com.as.wordcount.dto.WordCount;

import java.util.List;


public interface WordCountService
{
	List<WordCount> countWordsInDescendingOrder();
}
