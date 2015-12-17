package tw.leonchen.oop.io.nio;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class TestNIO2FileVisitorWalkingTreeEx1 implements FileVisitor<Path> {

	public static void main(String[] args) throws Exception {
		Files.walkFileTree(Paths.get("d:/temp"),
				new TestNIO2FileVisitorWalkingTreeEx1());
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
			throws IOException {
		// System.out.println("Walk The File Tree");
		return FileVisitResult.CONTINUE;

	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
			throws IOException {
		System.out.println(file.getFileName());
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc)
			throws IOException {
		// TODO Auto-generated method stub
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc)
			throws IOException {
		System.out.println("[" + dir.getFileName() + "]");
		return FileVisitResult.CONTINUE;
	}

}
