package com.sks.learn.dsalgo;

import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.sks.learn.dsalgo.algo.SortingAlgosTester;
import com.sks.learn.dsalgo.ds.DSTester;
import com.sks.learn.dsalgo.testutility.CSVReaderTester;

@RunWith(Suite.class)
@SuiteClasses({ CSVReaderTester.class, DSTester.class, SortingAlgosTester.class, })
public class AllTestsSuite {
	@Rule
	public TestRule watcher = new TestWatcher() {
		protected void starting(Description description) {
			System.out.println("************************Starting testSuite: " + description.getDisplayName()
					+ "************************");
		}
	};
}
