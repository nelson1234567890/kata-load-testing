package runner;

import io.gatling.recorder.GatlingRecorder;
import io.gatling.recorder.config.RecorderPropertiesBuilder;
import scala.Option;

import java.nio.file.Path;

public class Recorder {

    private Recorder() {
    }

    public static void main(String[] args) {
        RecorderPropertiesBuilder props = new RecorderPropertiesBuilder()
                .simulationsFolder(IDEPathHelper.MAVEN_SOURCES_DIRECTORY.toString())
                .resourcesFolder(IDEPathHelper.MAVEN_RESOURCES_DIRECTORY.toString())
                .simulationPackage("computerdatabase")
                .simulationFormatJava();

        GatlingRecorder.fromMap(props.build(), Option.<Path>apply(IDEPathHelper.RECORDER_CONFIG_FILE));
    }
}
