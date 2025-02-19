package bnpl;

import io.gatling.recorder.GatlingRecorder;
import io.gatling.recorder.config.RecorderPropertiesBuilder;
import scala.Option;

import java.nio.file.Path;

public final class Recorder {
    public static void main(String[] args) {
        RecorderPropertiesBuilder props = new RecorderPropertiesBuilder()
                .simulationsFolder(IDEPathHelper.MAVENRESOURCESDIRECTORY.toString())
                .resourcesFolder(IDEPathHelper.MAVENRESOURCESDIRECTORY.toString())
                .simulationPackage("computerdatabase")
                .simulationFormatJava();

        GatlingRecorder.fromMap(props.build(), Option.<Path>apply(IDEPathHelper.RECORDERCONFIGFILE));
    }
    private Recorder() {
        //not called
    }
}
