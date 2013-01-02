tiles2.pdf-spring-webmvc
========================

Simple on the fly pdf generator from tiles2-generated views. Use with out the [smartview-spring-webmvc](https://github.com/kpacha/smartview-spring-webmvc) package in order to allow the streaming of already stored pdf files.

Maven dependency
-----------------

    <dependencies>
        ...
        <dependency>
            <groupId>com.github.kpacha</groupId>
            <artifactId>tiles2.pdf-spring-webmvc</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>
        ...
    </dependencies>

Simple configuration
-----------------

        <bean class="org.springframework.web.servlet.view.ContentNegotiatingViewResolver">
                <property name="order" value="1" />
                <property name="mediaTypes">
                        <map>
                                <entry key="pdf" value="application/pdf" />
                        </map>
                </property>
                <property name="ignoreAcceptHeader" value="true" />
        </bean>

        <bean id="tilesPDFViewResolver"
                class="org.springframework.web.servlet.view.tiles2.TilesPDFViewResolver">
                <property name="order" value="2" />
                <property name="viewNames">
                        <list>
                                <value>*.pdf</value>
                        </list>
                </property>
        </bean>

        <bean id="tilesViewResolver"
                class="org.springframework.web.servlet.view.tiles2.TilesViewResolver">
                <property name="order" value="3" />
        </bean>

