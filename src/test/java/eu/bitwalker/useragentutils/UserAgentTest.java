/**
 * 
 */
package eu.bitwalker.useragentutils;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author harald
 * 
 */
public class UserAgentTest {

	/**
	 * Test method for {@link eu.bitwalker.useragentutils.UserAgent#parseUserAgentString(java.lang.String)}.
	 */
	@Test
	public void testParseUserAgentString() {
		UserAgent userAgent = UserAgent.parseUserAgentString("Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; SV1; .NET CLR 1.1.4322; .NET CLR 2.0.50727)");
		assertEquals(OperatingSystem.WINDOWS_XP, userAgent.getOperatingSystem());
		assertEquals(Browser.IE6, userAgent.getBrowser());

		userAgent = UserAgent.parseUserAgentString("Mozilla/5.0 (Windows NT 6.1; Trident/7.0; rv:11.0) like Gecko");
		assertEquals(OperatingSystem.WINDOWS_7, userAgent.getOperatingSystem());
		assertEquals(Browser.IE11, userAgent.getBrowser());

		userAgent = UserAgent.parseUserAgentString("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.11 Safari/537.36 OPR/21.0.1432.5 (Edition Developer)");
		assertEquals(OperatingSystem.WINDOWS_XP, userAgent.getOperatingSystem());
		assertEquals(Browser.OPERA21, userAgent.getBrowser());

		userAgent = UserAgent.parseUserAgentString("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.94 Safari/537.36 OPR/24.0.1558.51 (Edition Next)");
		assertEquals(OperatingSystem.MAC_OS_X, userAgent.getOperatingSystem());
		assertEquals(Browser.OPERA24, userAgent.getBrowser());

		userAgent = UserAgent.parseUserAgentString("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.3 Safari/537.36 OPR/28.0.1750.5");
		assertEquals(OperatingSystem.WINDOWS_7, userAgent.getOperatingSystem());
		assertEquals(Browser.OPERA28, userAgent.getBrowser());

		userAgent = UserAgent.parseUserAgentString("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.120 Safari/537.36");
		assertEquals(OperatingSystem.WINDOWS_7, userAgent.getOperatingSystem());
		assertEquals(Browser.CHROME37, userAgent.getBrowser());

		userAgent = UserAgent.parseUserAgentString("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36");
		assertEquals(OperatingSystem.WINDOWS_7, userAgent.getOperatingSystem());
		assertEquals(Browser.CHROME39, userAgent.getBrowser());

		userAgent = UserAgent.parseUserAgentString("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.94 Safari/537.36");
		assertEquals(OperatingSystem.WINDOWS_7, userAgent.getOperatingSystem());
		assertEquals(Browser.CHROME40, userAgent.getBrowser());

		userAgent = UserAgent.parseUserAgentString("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_3) AppleWebKit/537.75.14 (KHTML, like Gecko) Version/7.0.3 Safari/7046A194A");
		assertEquals(OperatingSystem.MAC_OS_X, userAgent.getOperatingSystem());
		assertEquals(Browser.SAFARI7, userAgent.getBrowser());

		userAgent = UserAgent.parseUserAgentString("Mozilla/5.0 (iPhone; CPU iPhone OS 8_0_2 like Mac OS X) AppleWebKit/600.1.4 (KHTML, like Gecko) Version/8.0 Safari/600.1.4");
		assertEquals(OperatingSystem.iOS8_IPHONE, userAgent.getOperatingSystem());
		assertEquals(Browser.SAFARI8, userAgent.getBrowser());

		userAgent = UserAgent.parseUserAgentString("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:32.0) Gecko/20100101 Firefox/32.0");
		assertEquals(OperatingSystem.WINDOWS_7, userAgent.getOperatingSystem());
		assertEquals(Browser.FIREFOX32, userAgent.getBrowser());

		userAgent = UserAgent.parseUserAgentString("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:35.0) Gecko/20100101 Firefox/35.0");
		assertEquals(OperatingSystem.WINDOWS_7, userAgent.getOperatingSystem());
		assertEquals(Browser.FIREFOX40, userAgent.getBrowser());
	}

	/**
	 * Test method for {@link eu.bitwalker.useragentutils.UserAgent#parseUserAgentString(java.lang.String)} that checks for proper handling of a <code>null</code> userAgentString.
	 */
	@Test
	public void testParseUserAgentStringNull() {
		UserAgent userAgent = UserAgent.parseUserAgentString(null);
		assertEquals(OperatingSystem.UNKNOWN, userAgent.getOperatingSystem());
		assertEquals(Browser.UNKNOWN, userAgent.getBrowser());
		assertNull(userAgent.getBrowserVersion());
	}

	/**
	 * Test method for {@link eu.bitwalker.useragentutils.UserAgent#toString()}.
	 */
	@Test
	public void testToString() {
		UserAgent userAgent = UserAgent.parseUserAgentString("Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; SV1; .NET CLR 1.1.4322; .NET CLR 2.0.50727)");
		assertEquals(OperatingSystem.WINDOWS_XP.toString() + "-" + Browser.IE6.toString(), userAgent.toString());
	}

	/**
	 * Test method for {@link eu.bitwalker.useragentutils.UserAgent#valueOf(int)}.
	 */
	@Test
	public void testValueOf() {
		UserAgent userAgent = UserAgent.parseUserAgentString("Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; SV1; .NET CLR 1.1.4322; .NET CLR 2.0.50727)");
		UserAgent retrievedUserAgent = UserAgent.valueOf(userAgent.getId());
		assertEquals(userAgent, retrievedUserAgent);
	}

	/**
	 * Test method for {@link eu.bitwalker.useragentutils.UserAgent#valueOf(String)}.
	 */
	@Test
	public void testValueOf2() {
		UserAgent userAgent = UserAgent.parseUserAgentString("Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; SV1; .NET CLR 1.1.4322; .NET CLR 2.0.50727)");
		UserAgent retrievedUserAgent = UserAgent.valueOf(userAgent.toString());
		assertEquals(userAgent, retrievedUserAgent);
	}

}
