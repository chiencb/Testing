#!/bin/bash
cp pom.xml pom.xml_bk
TEMPLATE_ADD_PLUGIN="s/<plugins>/<plugins><plugin><groupId>org\.codehaus\.mojo<\/groupId><artifactId>jaxws-maven-plugin<\/artifactId><configuration><wsdlUrls><wsdlUrl>WSDL_URL<\/wsdlUrl><\/wsdlUrls><keep>true<\/keep><packageName>PACKAGE_NAME<\/packageName><sourceDestDir>src\/main\/java<\/sourceDestDir><\/configuration><\/plugin>/g"
CONFIG_FILE=src/main/resources/application.properties

# Generate code for SOAP AIAFBusiness service
soap_url=`grep SOAP_WSDL_URL_1 $CONFIG_FILE | cut -d = -f 2`
soap_url=${soap_url//\//\\/} # replace "/" to "\/"
soap_url=${soap_url//\./\\.} # replace "." to "\."
soap_package_name=`grep SOAP_PACKAGE_NAME_1 $CONFIG_FILE | cut -d = -f 2`
soap_package_name=${soap_package_name//\./\\.} # replace "." to "\."
plugin_replace_statement=${TEMPLATE_ADD_PLUGIN/WSDL_URL/$soap_url}
plugin_replace_statement=${plugin_replace_statement/PACKAGE_NAME/$soap_package_name}
echo $plugin_replace_statement
`sed -i $plugin_replace_statement pom.xml`
mvn clean jaxws:wsimport

# Generate code for SOAP case360 service
cp pom.xml_bk pom.xml
soap_url=`grep SOAP_WSDL_URL_2 $CONFIG_FILE | cut -d = -f 2`
soap_url=${soap_url//\//\\/} # replace "/" to "\/"
soap_url=${soap_url//\./\\.} # replace "." to "\."
soap_package_name=`grep SOAP_PACKAGE_NAME_2 $CONFIG_FILE | cut -d = -f 2`
soap_package_name=${soap_package_name//\./\\.} # replace "." to "\."
plugin_replace_statement=${TEMPLATE_ADD_PLUGIN/WSDL_URL/$soap_url}
plugin_replace_statement=${plugin_replace_statement/PACKAGE_NAME/$soap_package_name}
echo $plugin_replace_statement
`sed -i $plugin_replace_statement pom.xml`
mvn clean jaxws:wsimport

# restore pom.xml file
cp pom.xml_bk pom.xml
rm pom.xml_bk