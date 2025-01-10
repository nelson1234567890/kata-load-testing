import io.gatling.app.Gatling;
import io.gatling.core.config.GatlingPropertiesBuilder;


public final class Engine {

    public static void main(String[] args) {
        GatlingPropertiesBuilder props = new GatlingPropertiesBuilder()
                .resourcesDirectory(IDEPathHelper.MAVEN_RESOURCES_DIRECTORY.toString())
                .resultsDirectory(IDEPathHelper.RESULTS_DIRECTORY.toString())
                .binariesDirectory(IDEPathHelper.MAVEN_BINARIES_DIRECTORY.toString());

        Gatling.fromMap(props.build());
    }

    private Engine() {
        //not called
    }
}
