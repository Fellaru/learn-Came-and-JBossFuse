#BUNDLE
features:install hibernate
install -s mvn:ru.cinimex.learn/Database/1.0-SNAPSHOT
install -s mvn:ru.cinimex.learn/Route/1.0-SNAPSHOT
install -s mvn:ru.cinimex.learn/PhonebookWS/1.0-SNAPSHOT


#FEATURE 
### Fisrt run
please delete data at \jboss-fuse-6.3.0.redhat-254\ or profile 
features:addurl mvn:ru.cinimex.learn/featuresRepo/1.0-SNAPSHOT/xml/features
features:install first_run
list

### Run 2 services
uninstall PhonebookWS
uninstall Route
features:refreshUrl
features:install all_Services
list

### Run only route
uninstall Route
features:refreshUrl
features:install general
list

### End
features:uninstall
uninstall
features:removeUrl mvn:ru.cinimex.learn/featuresRepo/1.0-SNAPSHOT/xml/features
features:listurl
