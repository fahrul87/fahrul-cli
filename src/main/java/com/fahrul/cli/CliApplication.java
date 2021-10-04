package com.fahrul.cli;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import picocli.CommandLine;
import picocli.CommandLine.IFactory;

@SpringBootApplication
public class CliApplication implements CommandLineRunner, ExitCodeGenerator {

	private IFactory factory;
	private MyCommand myCommand;
	private int exitCode;

	CliApplication(IFactory factory, MyCommand myCommand) {
		this.factory = factory;
		this.myCommand = myCommand;
	}

	@Override
	public void run(String... args) {

		exitCode = new CommandLine(myCommand, factory).execute(args);
	}
	@Override
	public int getExitCode() {
		return exitCode;
	}

	public static void main(String[] args) {

		System.exit(SpringApplication.exit(SpringApplication.run(CliApplication.class, args)));
	}
}
