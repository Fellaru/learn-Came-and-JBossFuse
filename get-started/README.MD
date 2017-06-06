
features:uninstall fileMover
features:removeurl mvn:ru.cinimex.task/fileMover-features/1.0-SNAPSHOT/xml/features
features:addUrl mvn:ru.cinimex.task/fileMover-features/1.0-SNAPSHOT/xml/features
features:install fileMover

features:uninstall fileMover
features:removeurl mvn:ru.cinimex.task/fileMover-features/1.0-SNAPSHOT/xml/features


config:edit camel
config:proplist --pid camel
config:propset --pid camel result {NewUrl}



По умолчанию фалы переходят в C:/G
Что бы поменять директорию Необходимо:
В директории `C:\jboss-fuse-6.3.0.redhat-254\etc\ ` создайте файл `camel.cfg`
Шаблон файла лежит в get-stated/configProperties/camel.cfg

В этом файле изменяем строку `result=Новая директория`

Или работа с консолью 
После
features:uninstall fileMover
features:install fileMover
Готово!)

