package com.lijiangt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.h2.tools.Server;

/**
 * This sample program opens the same database once in embedded mode, and once
 * in the server mode. The embedded mode is faster, but only the server mode
 * supports remote connections.
 */
public class MixedMode extends Thread {

	static class Select extends Thread {
		private int from;
		public Select(int from) {
			super();
			this.from = from;
		}
		@Override
		public void run() {
			try {
				Class.forName("org.h2.Driver");
				Connection conn = DriverManager.getConnection(
						"jdbc:h2:file:/home/lijt/tmp/t/test;MVCC=TRUE;DB_CLOSE_DELAY=10",
						"analysis", "analysisanalysis");

				Statement stat = conn.createStatement();

				long start = System.currentTimeMillis();
				for (int i = from; i < from+100000; i++) {
					// stat.execute("INSERT INTO TIMER VALUES('"+i+"', now(),"+i+","+i+")");
					stat.execute("select * from TIMER where ID='anlsdifuq8<P:KMIOJai9udfa9yq87679898adf" + i + "'");
				}
				System.out.println(""+from+" Select cost: "
						+ (System.currentTimeMillis() - start));
				// while (true) {
				// runs forever, except if you drop the table remotely
				// stat.execute("MERGE INTO TIMER VALUES(1, NOW())");
				// Thread.sleep(1000);
				// }
				conn.close();
			} catch (Throwable e) {
				System.out.println("Error: " + e.toString());
			}

		}
	}

	static class Insert extends Thread {
		private int from;

		public Insert(int from) {
			super();
			this.from = from;
		}

		@Override
		public void run() {
			try {
				Class.forName("org.h2.Driver");
				Connection conn = DriverManager.getConnection(
						"jdbc:h2:file:/home/lijt/tmp/t/test;MVCC=TRUE;DB_CLOSE_DELAY=10",
						"analysis", "analysisanalysis");

				Statement stat = conn.createStatement();

				long start = System.currentTimeMillis();
				for (int i = from; i < from + 100000; i++) {
					stat.execute("INSERT INTO TIMER VALUES('anlsdifuq8<P:KMIOJai9udfa9yq87679898adf" + i + "', now(),"
							+ i + "," + i + ")");
				}
				System.out.println(""+ from+" Insert cost: "
						+ (System.currentTimeMillis() - start));
				// while (true) {
				// runs forever, except if you drop the table remotely
				// stat.execute("MERGE INTO TIMER VALUES(1, NOW())");
				// Thread.sleep(1000);
				// }
				conn.close();
			} catch (Throwable e) {
				System.out.println("Error: " + e.toString());
			}

		}
	}

	/**
	 * This method is called when executing this sample application from the
	 * command line.
	 * 
	 * @param args
	 *            the command line parameters
	 */
	public static void main(String... args) throws Exception {

		// start the server, allows to access the database remotely
		Server server = Server.createTcpServer("-tcpPort", "9081");
		server.start();

		System.out
				.println("You can access the database remotely now, using the URL:");
		System.out
				.println("jdbc:h2:tcp://localhost:9081/file:/home/lijt/test (user: analysis, password: analysisanalysis)");

		// now use the database in your application in embedded mode
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection(
				"jdbc:h2:file:/home/lijt/tmp/t/test;MVCC=TRUE;DB_CLOSE_DELAY=10", "analysis",
				"analysisanalysis");

		// some simple 'business usage'
		Statement stat = conn.createStatement();
		 stat.execute("DROP TABLE TIMER IF EXISTS");
		// //
		// stat.execute("CREATE TABLE TIMER(ID INT PRIMARY KEY, TIME VARCHAR)");
		 stat.execute("CREATE TABLE TIMER(ID VARCHAR(255) PRIMARY KEY, REQUEST_TIME TIMESTAMP,CREATIVE_ID BIGINT,WIN_PRICE BIGINT NOT NULL)");
		// CREATE TABLE RESULT_LOGS(ID VARCHAR(255) PRIMARY KEY,REQUEST_TIME
		// TIMESTAMP,CREATIVE_ID BIGINT,WIN_PRICE BIGINT NOT NULL);
		System.out.println("Execute this a few times: SELECT TIME FROM TIMER");
		System.out
				.println("To stop this application (and the server), run: DROP TABLE TIMER");
		try {
			long start = System.currentTimeMillis();
			for (int i = 0; i < 100000; i++) {
				 stat.execute("INSERT INTO TIMER VALUES('anlsdifuq8<P:KMIOJai9udfa9yq87679898adf"+i+"', now(),"+i+","+i+")");
//				stat.execute("select * from TIMER where ID='" + i + "'");
			}
			System.out.println("Time cost: "
					+ (System.currentTimeMillis() - start));
			// while (true) {
			// runs forever, except if you drop the table remotely
			// stat.execute("MERGE INTO TIMER VALUES(1, NOW())");
			// Thread.sleep(1000);
			// }
		} catch (SQLException e) {
			System.out.println("Error: " + e.toString());
		}
		conn.close();
		for (int i = 0; i < 9; i++) {
			new Insert((i+1)*100000).start();
		}
		Thread.sleep(5000);
		for (int i = 0; i < 10; i++) {
			new Select(i*100000).start();
		}
		// stop the server
		//server.stop();
	}
}