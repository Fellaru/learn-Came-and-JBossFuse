

features:addUrl mvn:ru.cinimex.task/fileMover-features/1.0-SNAPSHOT/xml/features
features:install fileMover

features:uninstall fileMover
features:removeurl mvn:ru.cinimex.task/fileMover-features/1.0-SNAPSHOT/xml/features







По умолчанию фалы переходят в C:/G
Что бы поменять директорию Необходимо:
В директории `C:\jboss-fuse-6.3.0.redhat-254\etc\ ` создайте файл `camel.cfg`
В файл добавить 
result=Новая директория
После
features:uninstall fileMover
features:install fileMover
Готово!)

