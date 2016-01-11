package com.jetbrains.youtrack.helpers;

import ru.qatools.properties.Property;
import ru.qatools.properties.Resource;

@Resource.Classpath("configuration.properties")
public interface Configuration {
    @Property("baseUrl")
    String getBaseUrl();

    @Property("browser")
    String getBrowser();
}
