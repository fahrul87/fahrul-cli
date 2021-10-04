package com.fahrul.cli;

import org.springframework.stereotype.Component;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.PrintWriter;

import java.util.Scanner;
import java.util.concurrent.Callable;

@Component
@Command(name = "myCommand")
public class MyCommand implements Callable<String> {

	static StringBuilder sb = new StringBuilder();

	@Option(names = "--spring.config.location", hidden = true)
	private String springConfigLocation;

	@Option(names = "-t", description = "Opens a file and path ")
	private String fileToReadPath;

	@Option(names = "-t.text", description = "Opens a file and view Text ")
	private String fileToReadPathTxt;

	@Option(names = "-t.json", description = "Opens a file and view json ")
	private static String fileToReadPathjson;

	@Option(names = "-o", description = "copy file")
	private String fileCopy;

	@Option(names = { "-h", "--help" }, usageHelp = true, description = "Displays this help message and quits.")
	private boolean helpRequested = false;

	public String call() throws Exception {

		if (fileToReadPath != null) {

			try {
				File myObj = new File(fileToReadPath);
				Scanner myReader = new Scanner(myObj);
				while (myReader.hasNextLine()) {
					String data = myReader.nextLine();

					System.out.println(data);
					sb.append(data);

				}
				myReader.close();
			} catch (FileNotFoundException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}

		}

		if (fileToReadPathTxt != null) {

			try {
				File myObj = new File(fileToReadPathTxt);
				Scanner myReader = new Scanner(myObj);
				while (myReader.hasNextLine()) {
					String data = myReader.nextLine();

					System.out.println(data);
					sb.append(data);

				}
				myReader.close();
			} catch (FileNotFoundException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}

		}

		if (fileToReadPathjson != null) {

			try {
				File myObj = new File(fileToReadPathjson);
				Scanner myReader = new Scanner(myObj);
				while (myReader.hasNextLine()) {
					String data = myReader.nextLine();

					System.out.println(jsonStringConveter(data));
					sb.append(data);
				}
				myReader.close();
			} catch (FileNotFoundException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}

		}

		if (fileCopy != null) {

			if (fileToReadPath != null) {
				File x = new File(fileToReadPath);
				File y = new File(fileCopy);
				copyContent(x, y);
			}
			if (fileToReadPathTxt != null) {
				File x = new File(fileToReadPathTxt);
				File y = new File(fileCopy);
				copyContent(x, y);
			}
			if (fileToReadPathjson != null) {
				File x = new File(fileToReadPathjson);
				File y = new File(fileCopy);
				copyContent(x, y);
			}

		}

		System.out.println("Istimiwir");
		return "success";
	}

	private static String jsonStringConveter(String stringResponse) {
		String[] parts = stringResponse.split("\\r\n");
		String jsonString = "{\"";
		for (int i = 0; i < parts.length; i++) {
			jsonString += parts[i].replace("=", "\":\"");
			jsonString += (i < parts.length - 1) ? "\",\"" : "";
		}
		return jsonString += "\"}";
	}

	public static void copyContent(File a, File b) throws Exception {
		FileInputStream in = new FileInputStream(a);
		FileOutputStream out = new FileOutputStream(b);

		try (PrintWriter p = new PrintWriter(new FileOutputStream(b, true))) {
			if (fileToReadPathjson != null) {
				p.println(jsonStringConveter(sb.toString()));
			} else {
				p.println(sb.toString());
			}

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		try {

			int n;

			while ((n = in.read()) != -1) {

			}
		} finally {
			if (in != null) {

				in.close();
			}

			if (out != null) {
				out.close();
			}
		}
		System.out.println("File Copied");
	}

}
