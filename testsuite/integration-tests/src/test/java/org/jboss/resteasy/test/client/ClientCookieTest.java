package org.jboss.resteasy.test.client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.resteasy.utils.TestUtil;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Nicolas NESMON
 * @tpSubChapter Resteasy-client
 * @tpChapter Integration tests
 * @tpTestCaseDetails Test for cookie management support in Resteasy client.
 * @tpSince RESTEasy
 *
 */
@RunWith(Arquillian.class)
@RunAsClient
public class ClientCookieTest extends ClientTestBase {

    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public static class ClienCookieResource {

        @GET
        @Path("createCookie")
        public Response createCookie() {
            return Response.ok().cookie(new NewCookie("Cookie", "CookieValue")).build();
        }

        @GET
        @Path("getCookiesCount")
        public Response getCookiesCount(@Context HttpHeaders httpHeaders) {
            return Response.ok(httpHeaders.getCookies().size()).build();
        }

    }

    @Deployment
    public static Archive<?> deploy() {
        WebArchive war = TestUtil.prepareArchive(ClientCookieTest.class.getSimpleName());
        war.addClass(ClientTestBase.class);
        return TestUtil.finishContainerPrepare(war, null, ClienCookieResource.class);
    }

    @Test
    public void client_Should_NotStoreCookie_When_NotConfigured() {
        Client client = ClientBuilder.newClient();
        try {

            try (Response response = client.target(generateURL("/createCookie")).request(MediaType.TEXT_PLAIN_TYPE).get()) {
                NewCookie cookie = response.getCookies().get("Cookie");
                Assert.assertNotNull(cookie);
            }

            int cookiesCount = client.target(generateURL("/getCookiesCount")).request(MediaType.TEXT_PLAIN_TYPE)
                    .get(Integer.class);
            Assert.assertEquals(0, cookiesCount);

        } finally {
            client.close();
        }
    }

}
