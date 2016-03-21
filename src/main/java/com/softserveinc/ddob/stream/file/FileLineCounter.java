package com.softserveinc.ddob.stream.file;

import org.springframework.util.Assert;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FileLineCounter {
    private static final String SRC_PATH = "D:/dev/zaas2/salesmax";

    private final Path path;
    private final String fileRegex;
    private final Charset encoding;

    public FileLineCounter(String path, Charset encoding, String fileRegex) {
        Assert.hasText(path);
        Assert.hasText(fileRegex);

        this.path = Paths.get(path);
        this.encoding = encoding;
        this.fileRegex = fileRegex;
    }

    public long countLines() {
        return countLines(line -> true);
    }

    public long countLines(Predicate<String> linePredicate) {
        try (Stream<Path> allInPath = Files.walk(path)) {
            try (Stream<String> lines = allInPath
                    .filter(path -> Files.isRegularFile(path) && path.toString().matches(fileRegex))
                    .flatMap(this::getLines)
                    .filter(linePredicate)
            ) {
                return lines.count();
            }
        } catch (IOException ex) {
            throw new InvalidPathException(path.toString(), ex.getMessage());
        }
    }

    private Stream<String> getLines(Path path) {
        try {
            return Files.lines(path, encoding);
        } catch (IOException ex) {
            throw new InvalidPathException(path.toString(), ex.getMessage());
        }
    }

    private static void printJavaCodeLineCount() {
        System.out.println(String.format("Java: %d lines",
                new FileLineCounter(SRC_PATH, Charset.defaultCharset(), ".*com\\\\zilliant\\\\.*\\.java")
                        .countLines(line -> !line.matches(".*(\\*|//).*"))
        ));
    }

    private static void printSqlCodeLineCount() {
        System.out.println(String.format("SQL: %d lines",
                new FileLineCounter(SRC_PATH, Charset.forName("ISO-8859-1"), ".*\\.sql")
                        .countLines(line -> !line.matches(".*--.*"))
        ));
    }

    public static void main(String[] args) {
        printJavaCodeLineCount();
        printSqlCodeLineCount();
    }
}
