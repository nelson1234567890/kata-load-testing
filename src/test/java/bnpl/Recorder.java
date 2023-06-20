package bnpl;

import io.gatling.recorder.GatlingRecorder;
import io.gatling.recorder.config.RecorderPropertiesBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.Option;

import java.nio.file.Path;

public class Recorder {

    private static final Logger LOGGER = LoggerFactory.getLogger(Recorder.class);
    private Recorder() {
        LOGGER.info("Recorder");
    }
    public static void main(String[] args) {
        RecorderPropertiesBuilder props = new RecorderPropertiesBuilder()
                .simulationsFolder(IDEPathHelper.mavenSourcesDirectory.toString())
                .resourcesFolder(IDEPathHelper.mavenResourcesDirectory.toString())
                .simulationPackage("computerdatabase")
                .simulationFormatJava();

        GatlingRecorder.fromMap(props.build(), Option.<Path> apply(IDEPathHelper.recorderConfigFile));
    }
}
