package iuh;

import java.io.IOException;

import jdepend.framework.JDepend;

public class SwingUi {
	public static void main(String[] args) throws IOException {
		JDepend jdepend = new JDepend();
		jdepend.addDirectory("src/main/java/iuh");
		jdepend.analyze();
	}
}
