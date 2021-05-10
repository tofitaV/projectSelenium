package properties;

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;

@Resource.File("src/main/resources/properties")
public interface Properties {

    @Property("platform")
    String browserPlatform();

    @Property("browserName")
    String browserName();

    @Property("env")
    String getEnv();

    @Property("url")
    String url();

    @Property("tester1.login")
    String tester1Login();

    @Property("tester1.password")
    String tester1Password();

    Properties props = PropertyLoader.newInstance().populate(Properties.class);
}
