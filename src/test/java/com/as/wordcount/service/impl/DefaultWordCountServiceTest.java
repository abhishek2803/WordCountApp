package com.as.wordcount.service.impl;

import com.as.wordcount.service.WordCountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


class DefaultWordCountServiceTest
{
	private static final String CONTENT = "This is the ultimate test of the test of time. The best time of my of life";
	private static final String SHUFFLEDCONTENT = "The best ultimate time of my of life. This is the test of the test of time. ";
	WordCountService wordCountService;
	WordCountService wordCountService1;

	@BeforeEach
	void setUp()
	{
		wordCountService = new DefaultWordCountService(CONTENT);
	}


	@Test
	void countWordsInDescendingOrderShouldBeNullIfContentIsNull()
	{
		wordCountService = new DefaultWordCountService(null);
		assertThatExceptionOfType(NullPointerException.class)
				.isThrownBy(() -> wordCountService.countWordsInDescendingOrder())
				.withNoCause();
	}

	@Test
	void countWordsInDescendingOrderShouldBeOfCount1ifContentContains1Word()
	{
		wordCountService = new DefaultWordCountService("asasassDSADASDASDSA");
		var wordCounts = wordCountService.countWordsInDescendingOrder();
		assertThat(wordCounts).isNotNull();
		assertThat(wordCounts).size().isEqualTo(1);
	}

	@Test
	void countWordsInDescendingOrderShouldNotBeNullIfContentIsNotNull()
	{
		var wordCounts = wordCountService.countWordsInDescendingOrder();
		assertThat(wordCounts).isNotNull();
	}

	@Test
	void countWordsInDescendingOrderShouldContainExpectedCountOfDistinctWords()
	{
		var wordCounts = wordCountService.countWordsInDescendingOrder();
		assertThat(wordCounts).isNotNull();
		assertThat(wordCounts).size().isEqualTo(10);
	}

	@Test
	void countWordsInDescendingOrderShouldContainExpectedCountOfDistinctWordsInDescendingOrder()
	{
		var wordCounts = wordCountService.countWordsInDescendingOrder();
		assertThat(wordCounts).isNotNull();
		assertThat(wordCounts).size().isEqualTo(10);
		assertThat(wordCounts.get(0).getWord()).isEqualTo("of");
		assertThat(wordCounts.get(0).getCount()).isGreaterThanOrEqualTo(wordCounts.get(1).getCount());
		assertThat(wordCounts.get(2).getCount()).isGreaterThanOrEqualTo(wordCounts.get(3).getCount());
		assertThat(wordCounts.get(3).getCount()).isGreaterThanOrEqualTo(wordCounts.get(4).getCount());
		assertThat(wordCounts.get(4).getCount()).isGreaterThanOrEqualTo(wordCounts.get(5).getCount());
		assertThat(wordCounts.get(5).getCount()).isGreaterThanOrEqualTo(wordCounts.get(6).getCount());
		assertThat(wordCounts.get(6).getCount()).isGreaterThanOrEqualTo(wordCounts.get(7).getCount());
		assertThat(wordCounts.get(7).getCount()).isGreaterThanOrEqualTo(wordCounts.get(8).getCount());
		assertThat(wordCounts.get(8).getCount()).isGreaterThanOrEqualTo(wordCounts.get(9).getCount());
	}

	@Test
	void consistentWordCountAcross2ContentWhenWordsShuffled()
	{
		var wordCounts = wordCountService.countWordsInDescendingOrder();
		wordCountService1 = new DefaultWordCountService(SHUFFLEDCONTENT);
		var wordCounts1 = wordCountService1.countWordsInDescendingOrder();
		assertThat(wordCounts).isNotNull();
		assertThat(wordCounts1).isNotNull();
		assertThat(wordCounts).size().isEqualTo(wordCounts1.size());
		for (int i = 0; i < wordCounts.size(); i++)
		{
			assertThat(wordCounts.get(i).getCount()).isEqualTo(wordCounts1.get(i).getCount());

		}
	}
}