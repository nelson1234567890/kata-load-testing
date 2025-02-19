package bnpl;
import io.gatling.app.Gatling;
import io.gatling.core.config.GatlingPropertiesBuilder;
public final class Engine {
    public static void main(String[] args) {
        GatlingPropertiesBuilder props = new GatlingPropertiesBuilder()
                .resourcesDirectory(IDEPathHelper.MAVENRESOURCESDIRECTORY.toString())
                .resultsDirectory(IDEPathHelper.RESULTSDIRECTORY.toString())
                .binariesDirectory(IDEPathHelper.MAVENBINARIESDIRECTORY.toString());
        Gatling.fromMap(props.build());
    }
    private Engine() {
        //not called
    }
}