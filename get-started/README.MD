##Установка Фичи в Standalone

features:addUrl mvn:ru.cinimex.task/fileMover-features/1.0-SNAPSHOT/xml/features
features:install fileMover

###Настройка пути к директориям 

#### Target директория( куда файл переходит)
По умолчанию фалы переходят в C:/G
Что бы поменять директорию Необходимо:
В директории `C:\jboss-fuse-6.3.0.redhat-254\etc\ ` создайте файл `camel.cfg`
Шаблон файла лежит в get-stated/configProperties/camel.cfg

Далее есть 2 пути.
1. РУКАМИ
В файле camel.cfg изменяем строку `result={NewUrl}`

1. Или работа с консолью 
config:edit camel
config:proplist --pid camel
config:propset --pid camel result {NewUrl}
config:update

###Log директория ( где будет создан файл mylog.log)
Что бы логирование велось в файл mylog.log необходимо
В директории `C:\jboss-fuse-6.3.0.redhat-254\etc\ ` измените файл `org.ops4j.pax.logging.cfg`
Шаблон файла лежит в get-stated/configProperties/org.ops4j.pax.logging.cfg
Вставить необходимо выделенный элемент подписанный как GET-STARTED
Путь прописанный изначально в этом куске кода C://LOG_DIR/mylog.log

Далее есть 2 пути.
1. РУКАМИ
В файле org.ops4j.pax.logging.cfg изменяем строку `log4j.appender.customFileAppender.file={NewUrl}`

1. Или работа с консолью 
config:edit org.ops4j.pax.logging
config:proplist --pid org.ops4j.pax.logging
config:propset --pid org.ops4j.pax.logging log4j.appender.customFileAppender.file {NewUrl}

features:install fileMover
features:uninstall fileMover

###Окончание работы со Standalone
features:uninstall fileMover
features:removeurl mvn:ru.cinimex.task/fileMover-features/1.0-SNAPSHOT/xml/features

#Работа с FuseFabric