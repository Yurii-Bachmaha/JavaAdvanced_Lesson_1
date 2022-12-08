package task01;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class CinemaTest {

	private static Cinema cinema;

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
		cinema = new Cinema("Cinema", new Time(9, 00), new Time(23, 00));
	}

	@AfterClass
	public static void afterTest() {
		cinema = null;
	}

	@Test(expected = AssertionError.class)
	public void isCinemaOpenShouldBeFalseTest() {
		boolean isFalse = cinema.isCinemaOpen(new Seance(new Movie("Movie", new Time(2, 00)), new Time(22, 00)));
		Assert.assertFalse(isFalse);
	}

	@Test
	public void isCinemaOpenTest() {
		boolean isTrue = cinema.isCinemaOpen(new Seance(new Movie("Movie2", new Time(3, 00)), new Time(12, 00)));
		Assert.assertTrue(isTrue);
	}
}