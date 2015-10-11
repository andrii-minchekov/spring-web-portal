spring-web-portal
=================
@author a.minchekov

Developer's portal

Application and container can be simply run from command line: mvn jetty:run -Djetty.port=9191.
In order to access database web interface go to localhost:9292 (could be customized at root-context.xml).
Application use Embedded mode of h2 server with the next url for JDBC driver jdbcUrl=jdbc:h2:schema-h2-image/portal;AUTO_SERVER=TRUE;TRACE_LEVEL_FILE=3
(could be customized at jdbc.properties).
