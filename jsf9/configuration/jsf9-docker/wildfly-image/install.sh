#!/usr/bin/env sh

echo "Start wildfly for configuration ..."
$JBOSS_HOME/bin/standalone.sh &
sleep 10

$JBOSS_HOME/bin/jboss-cli.sh -c --file=/cli/jboss.cli --properties=/cli/jboss.properties
$JBOSS_HOME/bin/jboss-cli.sh -c command=:shutdown
sleep 3

echo "Copy exposed wildfly..."

rm -r /opt/exposed-wildfly/wildfly
cp -r $JBOSS_HOME /opt/exposed-wildfly/wildfly/

echo "Wildfly configured, starting for real work"

$JBOSS_HOME/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0 --debug