FROM jboss/wildfly:24.0.0.Final

COPY ./cli /cli
COPY ./install.sh /cli/
COPY ./settings.xml /cli/
RUN ln -s /cli/postgresql-42.2.8.jar $JBOSS_HOME/standalone/deployments/postgresql-42.2.8.jar

USER root
RUN yum -y install maven
RUN mv /cli/settings.xml $M2_HOME/
USER jboss

#ENV M2_HOME /opt/jboss/.m2
#RUN mkdir $M2_HOME
#RUN chmod a+r+w $M2_HOME

RUN mv $JBOSS_HOME/standalone/configuration/standalone.xml $JBOSS_HOME/standalone/configuration/standalone-old.xml
RUN mv $JBOSS_HOME/standalone/configuration/standalone-full.xml $JBOSS_HOME/standalone/configuration/standalone.xml

RUN $JBOSS_HOME/bin/add-user.sh root root --silent

RUN echo 'JAVA_OPTS="$JAVA_OPTS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8787"' >> $JBOSS_HOME/bin/standalone.conf

CMD ["/bin/sh", "-c", "/cli/install.sh"]