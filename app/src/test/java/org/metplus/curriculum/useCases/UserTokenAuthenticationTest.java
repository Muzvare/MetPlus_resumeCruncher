package org.metplus.curriculum.useCases;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.metplus.curriculum.test.BeforeAfterInterface;
import org.metplus.curriculum.test.BeforeAfterRule;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@RunWith(Suite.class)
@Suite.SuiteClasses({UserTokenAuthenticationTest.AuthenticationSuccessful.class,
        UserTokenAuthenticationTest.AuthenticationFail.class})
public class UserTokenAuthenticationTest {

    public static class DefaultTokenAuthenticationTest implements BeforeAfterInterface {
        @Rule
        public BeforeAfterRule beforeAfter = new BeforeAfterRule(this);
        protected UserTokenAuthentication useCase;

        @Override
        public void after() {
        }

        @Override
        public void before() {
            useCase = new UserTokenAuthentication();
        }
    }

    public static class AuthenticationSuccessful extends DefaultTokenAuthenticationTest {
        @Test
        public void correctToken_shouldReturnTrue() throws Exception {
            String token = "123456";
            assertTrue(useCase.canLogin(token));
        }
    }

    public static class AuthenticationFail extends DefaultTokenAuthenticationTest {
        @Test
        public void incorrectToken_shouldReturnFalse() throws Exception {
            String token = "1234567";
            assertFalse(useCase.canLogin(token));
        }
    }
}