package com.minecrafttas.discombobulator.test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.gradle.internal.impldep.org.apache.commons.compress.utils.FileNameUtils;

import com.minecrafttas.discombobulator.utils.Pair;

public class TestBase {

	protected Path testResources = Paths.get("src/test/resources");

	protected Pair<List<String>, List<String>> getLines(String folder, String actualName, String expectedName) throws IOException {

		List<String> linesBase = null;
		if (actualName != null) {
			Path actualFile = testResources.resolve(String.format("%s/%s", folder, actualName));
			linesBase = Files.readAllLines(actualFile, StandardCharsets.UTF_8);
		}

		List<String> linesExpected = null;
		if (expectedName != null) {
			Path expectedFile = testResources.resolve(String.format("%s/%s", folder, expectedName));
			linesExpected = Files.readAllLines(expectedFile, StandardCharsets.UTF_8);
		}

		return Pair.of(linesBase, linesExpected);
	}

	protected String getExtension(String actualName) {
		return FileNameUtils.getExtension(Paths.get(actualName));
	}

	protected List<String> readTestResourcesFile(Path file) throws IOException {
		return Files.readAllLines(testResources.resolve(file), StandardCharsets.UTF_8);
	}
}
