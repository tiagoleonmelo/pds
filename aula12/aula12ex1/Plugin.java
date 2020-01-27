package aula12ex1;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

abstract class PluginManager {
	public static IPlugin load(String name) throws Exception {
			Class<?> c = Class.forName(name);
			return (IPlugin) c.getDeclaredConstructor().newInstance();
		}
}

public class Plugin {
	public static void main(String[] args) throws Exception {
		File proxyList = new File("bin/aula12");
		ArrayList<IPlugin> plgs = new ArrayList<IPlugin>();

		for (String f: proxyList.list()) {
			if (f.endsWith(".class")) {
				try {
					plgs.add(PluginManager.load("aula12."
							+ f.substring(0, f.lastIndexOf('.'))));
				} catch (Exception e) {
					System.out.println("\t" + f + ": Componente ignorado. N�o � IPlugin.");
				}
			}
		}

		Iterator<IPlugin> it = plgs.iterator();
		while (it.hasNext()) {
			it.next().fazQualQuerCoisa();
		}
	}
}
