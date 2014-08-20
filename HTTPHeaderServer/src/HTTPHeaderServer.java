import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class HTTPHeaderServer {

	/**
	 * Starts a Jetty server on port 8080, and maps /check
	 * requests to the {@link HeaderServlet}.
	 *
	 * @param args - unused
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO
	}

	/**
     * Returns the HTTP headers for a URL, or null if unable
     * to connect to the URL.
     */
	public static String getHeaders(String link) {
		// TODO
		return null;
	}

	/**
	 * Servlet to GET handle requests to /check.
	 */
	public static class HeaderServlet extends HttpServlet {

		/**
		 * Displays a form where users can enter a URL to check. When the
		 * button is pressed, submits the URL back to /check as a GET
		 * request.
		 *
		 * If a URL was included as a parameter in the GET request, fetch
		 * and display the HTTP headers of that URL.
		 */
		@Override
		protected void doGet(
				HttpServletRequest request,
				HttpServletResponse response)
				throws ServletException, IOException {

			// TODO

		}
	}
}
