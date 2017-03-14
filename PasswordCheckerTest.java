import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the methods of PasswordChecker
 * 
 * @author Justin Kuo
 *		
 */
public class PasswordCheckerTest {
	ArrayList<String> passwords, studentPasswords;
	String password1, password2, studentPassword1, studentPassword2;
	PasswordChecker passwordChecker;
	
	@Before
	public void setUp() throws Exception {
		String[] p = { "334455BB", "Im2cool4U", "george2ZZZ", "4sale", "bertha22", "4wardMarch", "august30", "abcdef",
				"Applesxx", "aa11b", "pilotProject", "myPassword", "myPassword2" };
		passwordChecker = new PasswordChecker();
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(p)); // puts strings into the ArrayList
		
		String[] sp = { "11223344BB", "Password2000", "george2ZZZ", "short", "pass1122", "4wardMarch", "august30",
				"ABCDEF", "abcdef", "aa11b", "goodPassword", "myPassword12", "myPassword2" };
		passwordChecker = new PasswordChecker();
		studentPasswords = new ArrayList<String>();
		studentPasswords.addAll(Arrays.asList(sp));
	}
	
	@After
	public void tearDown() throws Exception {
		passwords = null;
		studentPasswords = null;
	}
	
	/**
	 * Test if the password is less than 8 characters long. This test should
	 * throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort() {
		try {
			assertTrue(passwordChecker.isValidPassword("abcABC12"));
			passwordChecker.isValidPassword("abc12");
			assertTrue("Did not throw lengthException", false);
		}
		catch (LengthException e) {
			assertTrue("Successfully threw a lengthExcepetion", true);
		}
		catch (Exception e) {
			assertTrue("Threw some other exception besides lengthException", false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character This test
	 * should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha() {
		try {
			assertTrue(passwordChecker.isValidPassword("1234567aA"));
			passwordChecker.isValidPassword("1234567a");
			assertTrue("Did not throw NoUpperAlphaException", false);
		}
		catch (NoUpperAlphaException e) {
			assertTrue("Successfully threw a NoUpperAlphaExcepetion", true);
		}
		catch (Exception e) {
			assertTrue("Threw some other exception besides NoUpperAlphaException", false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character This test
	 * should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha() {
		try {
			assertTrue(passwordChecker.isValidPassword("1234567Aa"));
			passwordChecker.isValidPassword("1234567A");
			assertTrue("Did not throw NoLowerAlphaException", false);
		}
		catch (NoLowerAlphaException e) {
			assertTrue("Successfully threw a NoLowerAlphaExcepetion", true);
		}
		catch (Exception e) {
			assertTrue("Threw some other exception besides NoLowerAlphaException", false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence() {
		try {
			assertEquals(true, passwordChecker.isValidPassword("1234aaAA"));
			passwordChecker.isValidPassword("1234aAAA");
			assertTrue("Did not throw an InvalidSequenceException", false);
		}
		catch (InvalidSequenceException e) {
			assertTrue("Successfully threw an InvalidSequenceExcepetion", true);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an InvalidSequenceException", false);
		}
	}
	
}
