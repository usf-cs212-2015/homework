import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class HTTPHeaderServer {

	public static void main(String[] args) throws Exception {

		// TODO Start server on port 8080.
		// TODO Map /check to HeaderServlet.

	}

	@SuppressWarnings("serial")
    public static class HeaderServlet extends HttpServlet {

		@Override
		protected void doGet(
				HttpServletRequest request,
				HttpServletResponse response)
				throws ServletException, IOException {

			// Check to make sure the browser is not requesting favicon.ico
			if (request.getRequestURI().endsWith("favicon.ico")) {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
				return;
			}

			response.setContentType("text/html");

			// TODO Output HTML form.

			// TODO Parse GET parameter if present and show headers.

			response.setStatus(HttpServletResponse.SC_OK);
		}
	}
}
