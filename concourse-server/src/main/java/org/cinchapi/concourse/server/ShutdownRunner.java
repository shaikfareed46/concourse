/*
 * The MIT License (MIT)
 * 
 * Copyright (c) 2013 Jeff Nelson, Cinchapi Software Collective
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.cinchapi.concourse.server;

import static org.cinchapi.concourse.server.GlobalState.SHUTDOWN_PORT;
import static org.cinchapi.concourse.util.Loggers.getLogger;

import java.io.IOException;
import java.net.Socket;

import org.slf4j.Logger;

/**
 * Connects to the {@link ConcourseServer#SHUTDOWN_PORT} in order to
 * initiate a graceful shutdown.
 * 
 * @author jnelson
 */
public class ShutdownRunner {
	
	private static final Logger log = getLogger();

	/**
	 * Prompt the server to shutdown
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String... args) {
		try {
			log.info("Binding to shutdown port {}", SHUTDOWN_PORT);
			Socket socket = new Socket("localhost", SHUTDOWN_PORT);
			socket.close();
			System.exit(0);
		}
		catch (IOException e) {
			// do nothing
		}
	}
}