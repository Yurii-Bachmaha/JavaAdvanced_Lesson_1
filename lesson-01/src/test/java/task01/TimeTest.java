package task01;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class TimeTest {

	private static Time time;

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		protected void failed(Throwable e, org.junit.runner.Description description) {
			System.out.println("FAILED--> " + description.getMethodName());
		};

		protected void succeeded(org.junit.runner.Description description) {
			System.out.println("SUCCEED--> " + description.getMethodName());
		};
	};

	@BeforeClass
	public static void beforeTest() {
		time = new Time(0, 0);

	}

	@AfterClass
	public static void afterTest() {
		time = null;
	}

	@Test
	public void timeTest() {
		new Time(10, 50);
	}

	@Test
	public void sumTimeTest() {
		Time actualSum = time.sumTime(new Time(12, 15), new Time(2, 10));
		Time expectedTime = new Time(14, 25);
		Assert.assertEquals(expectedTime, actualSum);
	}

	@Test(expected = AssertionError.class)
	public void sumTimeWrongTest() {
		Time actualSum = time.sumTime(new Time(12, 15), new Time(2, 10));
		Time expectedTime = new Time(15, 25);
		Assert.assertEquals(expectedTime, actualSum);
	}
}