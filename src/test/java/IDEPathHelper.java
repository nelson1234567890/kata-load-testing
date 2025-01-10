import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.util.Objects.requireNonNull;

public class IDEPathHelper {

  static final Path MAVEN_SOURCES_DIRECTORY;
  static final Path MAVEN_RESOURCES_DIRECTORY;
  static final Path MAVEN_BINARIES_DIRECTORY;
  static final Path RESULTS_DIRECTORY;
  static final Path RECORDER_CONFIG_FILE;

  static {
    try {
      Path projectRootDir = Paths.get(requireNonNull(IDEPathHelper.class.getResource("gatling.conf"),
              "Couldn't locate gatling.conf").toURI()).getParent().getParent().getParent();
      Path mavenTargetDirectory = projectRootDir.resolve("target");
      Path mavenSrcTestDirectory = projectRootDir.resolve("src").resolve("test");

      MAVEN_SOURCES_DIRECTORY = mavenSrcTestDirectory.resolve("java");
      MAVEN_RESOURCES_DIRECTORY = mavenSrcTestDirectory.resolve("resources");
      MAVEN_BINARIES_DIRECTORY = mavenTargetDirectory.resolve("test-classes");
      RESULTS_DIRECTORY = mavenTargetDirectory.resolve("gatling");
      RECORDER_CONFIG_FILE = MAVEN_RESOURCES_DIRECTORY.resolve("recorder.conf");
    } catch (URISyntaxException e) {
      throw new ExceptionInInitializerError(e);
    }
  }

  private IDEPathHelper() {
    //Nothing
  }
}
