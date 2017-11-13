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

###Окончание работы со Standalone
features:uninstall fileMover
features:removeurl mvn:ru.cinimex.task/fileMover-features/1.0-SNAPSHOT/xml/features

#Работа с FuseFabric
При распаковке нового jboss-fuse
1. Расскоментируйте в C:\jboss-fuse-6.3.0.redhat-254\etc\user.properties
1. Выполнить пункт Log директория  и Target директория
`fabric:create --wait-for-provisioning`
`fabric:container-create-child root child `
`fabric:container-list`
`fabric:profile-create --parent jboss-fuse-full myProfile`
`fabric:profile-edit --repository mvn:ru.cinimex.task/fileMover-features/1.0-SNAPSHOT/xml/features myProfile`
`fabric:profile-edit --feature fileMover myProfile`
`fabric:container-change-profile child myProfile`
ждем инсталяции profile 