package euphoria.setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationXML {
	private static Properties conf;

	public ConfigurationXML() {
		conf = new Properties();
	}

	public static boolean loadXML(String filename) {
		if (new File(filename).exists()) {
			try {
				conf.loadFromXML(new FileInputStream(filename));
				return true;
			} catch (IOException e) {
				System.err.println("Cannot open " + filename + ".");
				e.printStackTrace();
				return false;
			}
		} else {
			return false;
		}
	}

	public static String getProperty(String key) {
		if (conf.containsKey(key))
			return conf.getProperty(key);
		else {
			System.err.println("Key not found: " + key);
			return "";
		}
	}

	public static  void setProperty(String key, String value) {
		conf.setProperty(key, value);
	}

	public static void storeToXML(String filename, String comments) {
		try {
			conf.storeToXML(new FileOutputStream(filename), comments);
		} catch (IOException e) {
			System.err.println("Cannot open " + filename + ".");
			e.printStackTrace();
		}
	}

}