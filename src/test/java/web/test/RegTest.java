package web.test;

import static org.junit.Assert.*;

import org.junit.Test;
import com.bl.*;

public class RegTest {
		
	@Test
	public void test() {
		business bus = new business();
		//fail("Not yet implemented");
		assertEquals(bus.getRating(5), 9);
	}

}
