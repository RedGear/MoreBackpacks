package redgear.morebackpacks.config;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Stack;

import redgear.morebackpacks.core.MoreBackpacks;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import forestry.api.storage.BackpackManager;
import forestry.api.storage.IBackpackDefinition;

public class ConfigReader {

	private static Gson gson;

	static {
		gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
	}

	public static void read(String file) {
		read(new File(file));
	}

	public static void read(File file) {

		try {
			BackpackData data = gson.fromJson(new FileReader(file), BackpackData.class);

			IBackpackDefinition backpack = BackpackManager.definitions.get(data.getBackpackKey());

			if (backpack == null) {
				MoreBackpacks.inst.logDebug("ConfigReader Can't Find Backpack: " + data.getBackpackKey());
				return;
			}

			data.addItems(backpack);
		} catch (Exception e) {
			MoreBackpacks.inst.myLogger.warn("ConfigReader doesn't understand file: " + file.getPath());
		}

	}

	public static void write(String file, BackpackData data) {
		write(new File(file), data);
	}

	public static void write(File file, BackpackData data) {
		try {
			if (!file.exists()) {
				Writer writer = new FileWriter(file);
				gson.toJson(data, writer);
				writer.close();
			} else
				MoreBackpacks.inst.logDebug("File: ", file, " already exists.");
		} catch (Exception e) {
			MoreBackpacks.inst.logDebug("ConfigReader couldn't write file: " + file, e);
		}
	}

	public static void readAll(File directory) {
		Stack<File> files = new Stack<File>();
		files.add(directory);

		File next;

		while (!files.empty()) {
			next = files.pop();

			if (next == null)
				continue;

			if (next.isDirectory())
				files.addAll(Arrays.asList(next.listFiles()));
			else if (next.getName().endsWith(".json"))
				read(next);

		}
	}
}
