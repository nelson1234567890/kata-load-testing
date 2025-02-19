package bnpl;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.util.Objects.requireNonNull;
public class IDEPathHelper {
    private IDEPathHelper() {
        throw new IllegalStateException("Utility class");
    }
    static final Path MAVENSOURCESDIRECTORY;
    static final Path MAVENRESOURCESDIRECTORY;
    static final Path MAVENBINARIESDIRECTORY;
    static final Path RESULTSDIRECTORY;
    static final Path RECORDERCONFIGFILE;
    static {
        try {
            Path projectRootDir = Paths.get(requireNonNull(IDEPathHelper.class.getResource("gatling.conf"),
                    "Couldn't locate gatling.conf").toURI()).getParent().getParent().getParent();
            Path mavenTargetDirectory = projectRootDir.resolve("target");
            Path mavenSrcTestDirectory = projectRootDir.resolve("src").resolve("test");
            MAVENSOURCESDIRECTORY = mavenSrcTestDirectory.resolve("java");
            MAVENRESOURCESDIRECTORY = mavenSrcTestDirectory.resolve("resources");
            MAVENBINARIESDIRECTORY = mavenTargetDirectory.resolve("test-classes");
            RESULTSDIRECTORY = mavenTargetDirectory.resolve("gatling");
            RECORDERCONFIGFILE = MAVENRESOURCESDIRECTORY.resolve("recorder.conf");
        } catch (URISyntaxException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
