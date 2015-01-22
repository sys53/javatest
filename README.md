fdap产品介绍
=================================

Quick Start
---------------------------------

构建项目
---------------------------------

### 1.安装svn客户端
1. windows安装
2. linux安装
yum install subversion
or:apt-get install subversion

### 2.安装maven

    cd ~
    wget http://www.apache.org/dist//maven/binaries/apache-maven-3.2.2-bin.tar.gz
    tar zxvf apache-maven-3.2.2-bin.tar.gz
    vi .bash_profile
    - edit: export PATH=$PATH:~/apache-maven-3.2.2/bin
    source .bash_profile

### 3.检出fdap源代码:

    cd ~
    svn co svn://172.16.16.220/fdap/trunk fdap

### 4.使用idea导入项目

### 5.构建二进制包

    cd ~/fdap
    mvn clean install -Dmaven.test.skip=true
    cd fdap/target
    ls

### 6.安装redis数据库

### 7.安装db2数据库

### 8.初始化数据库

执行sql：fdap.sql

### 9.配置数据库

config.properties

    //app db config
    app.db.url=jdbc:db2://ip:port/库名
    app.db.driver=com.ibm.db2.jcc.DB2Driver
    app.db.user=用户名
    app.db.password=密码

    //work db config,此处根据实现数据仓库或者事实表数据库类型进行设置,需要与fdap.properies中的方言进行匹配
    work.db.url=jdbc:db2://ip:port/库名
    work.db.driver=com.ibm.db2.jcc.DB2Driver
    work.db.user=用户名
    work.db.password=密码

    //redis  config
    redis.hostName=ip:port
    redis.database=0 //选择数据库，默认是0,1,2,3,...
    redis.password=密码

fdap.properies

    //数据库方言设置，目前只支持db2,oracle数据库
    fdap.db.dialect=com.sunyard.fdap.sqllib.dialect.DB2Dialect

### 10. 启动fdap的webapp

    cd ~/fdap/fdap-server/fdap-webapp
    mvn tomcat:run

http://ip:8080/fdap/workbench.action

### 11. 下载fdap-webapp的依赖库

    cd ~/fdap/fdap-server/fdap-webapp
    mvn dependency:copy-dependencies -DoutputDirectory=~/lib

系统集成
---------------------------------

### 1.独立部署模式

### 2.内嵌部署模式

1.执行deploy-integration.sh

    cd ~/fdap
    chmod 755 deploy-integration.sh
    ./deploy-integration.sh


2. 进入~/targetsys目录，手动配置相关文件

 * web.xml，将下面内容copy到被集成系统的web.xml中去，如有重复内容请检查后去重

        <filter>
    		<filter-name>encodingFilter</filter-name>
    		<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    		<init-param>
    			<param-name>encoding</param-name>
    			<param-value>UTF-8</param-value>
    		</init-param>
    		<init-param>
    			<param-name>forceEncoding</param-name>
    			<param-value>true</param-value>
    		</init-param>
    	</filter>




    	<filter-mapping>
    		<filter-name>encodingFilter</filter-name>
    		<url-pattern>/*</url-pattern>
    	</filter-mapping>

    	<filter>
    		<filter-name>springSecurityFilterChain</filter-name>
    		<filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
    	</filter>

    	<filter-mapping>
    		<filter-name>springSecurityFilterChain</filter-name>
    		<url-pattern>/*</url-pattern>
    	</filter-mapping>

    	<servlet>
    		<servlet-name>fdapServlet</servlet-name>
    		<servlet-class>com.sunyard.fdap.core.servlet.FdapServlet</servlet-class>
    	</servlet>
    	<servlet-mapping>
    		<servlet-name>fdapServlet</servlet-name>
    		<url-pattern>*.action</url-pattern>
    	</servlet-mapping>
    	<session-config>
    		<session-timeout>30</session-timeout>
    	</session-config>


        <!-- spring -->
    	<context-param>
    		<param-name>contextConfigLocation</param-name>
            <param-value>classpath:spring/fdap-*.xml</param-value>
        </context-param>
    	<listener>
    		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    	</listener>




    	<!-- Http Flex Session attribute and binding listener support -->
    	<listener>
    		<listener-class>flex.messaging.HttpFlexSession</listener-class>
    	</listener>



    	<!-- MessageBroker Servlet -->
    	<servlet>
    		<servlet-name>MessageBrokerServlet</servlet-name>
    		<servlet-class>flex.messaging.MessageBrokerServlet</servlet-class>
    		<init-param>
    			<param-name>services.configuration.file</param-name>
    			<param-value>/WEB-INF/flex/services-config.xml</param-value>
    		</init-param>
            <init-param>
                <param-name>messageBrokerId</param-name>
                <param-value>messageBrokerId</param-value>
            </init-param>
    		<load-on-startup>1</load-on-startup>
    	</servlet>


    	<servlet-mapping>
    		<servlet-name>MessageBrokerServlet</servlet-name>
    		<url-pattern>/messagebroker/*</url-pattern>
    	</servlet-mapping>

        <!--文件上传-->
        <servlet>
            <servlet-name>FileUpload</servlet-name>
            <servlet-class>com.sunyard.fdap.core.servlet.FileUpload</servlet-class>
        </servlet>
        <servlet-mapping>
            <servlet-name>FileUpload</servlet-name>
            <url-pattern>/servlet/FileUpload</url-pattern>
        </servlet-mapping>


  * fdap-config.xml，将文件中的内容替换为以下内容：（jsp页面路径改为fdap目录下）

        <?xml version="1.0" encoding="UTF-8"?>
        <fdap>
        <action path="help/search" class="com.sunyard.fdap.action.help.HelpAction">
            <result name="success" page="helplist.jsp"></result>
            <result name="error" page="fdap/error.jsp"></result>
        </action>
        <action path="workbench" class="com.sunyard.fdap.action.WorkbenchAction">
            <result name="success" page="fdap/workbench.jsp"></result>
        </action>
        <action path="view" class="com.sunyard.fdap.action.WorkbenchAction">
            <result name="success" page="fdap/workbech.jsp"></result>
        </action>
        <action path="/design" class="com.sunyard.fdap.action.WorkbenchAction">
            <result name="success" page="fdap/workbech.jsp"></result>
        </action>
        <action path="inittable" class="com.sunyard.fdap.action.InitTableAction">
            <result name="success" page="fdap/inittable-success.jsp"></result>
        </action>
        </fdap>

  * config/config.xml，内容改为如下,将ip,port改为目标系统的ip,port，将targetsys改为目标系统的apppath

        <config>
            <endpoint>http://ip:port/targetsys/fdap/messagebroker/amf</endpoint>
            <streamingamf>http://ip:port/targetsys/fdap/messagebroker/streamingamf</streamingamf>
            <upload>http://ip:port/targetsys/fdap/servlet/FileUpload</upload>
            </config>

 *config.properties与fdap.properties的配置见上面第9条

3. 其它集成问题请联系统fdap项目小组,小组成员如下：
    [章辉](hui.z@sunyard.com)
    [王海江](haij.wang@sunyard.com)
    [孔文文](wenw.kong@sunyard.com)
    [刘朦](meng.l@sunyard.com)
    [沈永生](yongsheng.s@sunyard.com)
