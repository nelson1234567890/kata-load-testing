package bnpl;

import io.gatling.app.Gatling;
import io.gatling.core.config.GatlingPropertiesBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Engine {

  private static final Logger LOGGER = LoggerFactory.getLogger(Engine.class);
  private Engine() {
    LOGGER.info("Engine");
  }

  public static void main(String[] args) {
    GatlingPropertiesBuilder props = new GatlingPropertiesBuilder()
      .resourcesDirectory(IDEPathHelper.mavenResourcesDirectory.toString())
      .resultsDirectory(IDEPathHelper.resultsDirectory.toString())
      .binariesDirectory(IDEPathHelper.mavenBinariesDirectory.toString());

    Gatling.fromMap(props.build());
  }
}
