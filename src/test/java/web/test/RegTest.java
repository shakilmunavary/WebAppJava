package web.test;

import static org.junit.Assert.*;
import org.junit.Test;
import com.bl.*;

public class RegTest {
	
	@Test
	public void test() throws InterruptedException {
		assertEquals(new business().getRating(6), 12);
	}
}
