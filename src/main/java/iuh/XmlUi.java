package iuh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import jdepend.xmlui.JDepend;

public class XmlUi {
	public static void main(String[] args) throws IOException {
		runXmlUi("Library-Assistant", "report.xml", "D:\\21138281_NguyenHongSon\\21138281_NguyenHongSon\\jdepend-ui",
				"com.mycompany.library");
	}

	public static void runXmlUi(String project, String reportXml, String directoryJdependUi, String classPrefix)
			throws IOException {
		JDepend jdpXml = new JDepend(
				new PrintWriter("D:\\21138281_NguyenHongSon\\21138281_NguyenHongSon\\Library-Assistant\\report.xml"));
		jdpXml.addDirectory("D:\\21138281_NguyenHongSon\\21138281_NguyenHongSon\\Library-Assistant");
		jdpXml.analyze();
		System.out.println("DONE directory report.xml saved: ");
		System.out.print(reportXml);
		ProcessBuilder processBuilder = new ProcessBuilder();

		processBuilder.command("cmd.exe", "/c", "cd " + directoryJdependUi + "&& npm run jdepend-ui " + reportXml + " "
				+ classPrefix + " && index.html");

		try {

			Process process = processBuilder.start();

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}

			int exitCode = process.waitFor();
			System.out.println("\nExited with error code : " + exitCode);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
