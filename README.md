spring-web-portal
=================
@author a.minchekov

Developer's portal

Application and container can be simply run from command line: mvn jetty:run -Djetty.port=9191
In order to access database web interface go to localhost:9292 (customize if root-context.xml),
there use Embedded mode of h2 server and jdbcUrl=jdbc:h2:schema-h2-image/portal;AUTO_SERVER=TRUE;TRACE_LEVEL_FILE=3
(get taken from jdbc.properties)
