# JBoss Fuse 
## Лучше стала понимать Maven ( раньше использовала Gradlew)

1. Создавать в Maven  новый проект основанный  на архетипе(применялись karaf-soap-archetype и karaf-camel-cbr-archetype)
1. Работа с локальным репозиторием Maven (C:\Users\efischenko\.m2\) и setings.xml

## Работа с Karaf(standalone):
Добавляем непосредственно в контейнер
1.	Работа с OSGI bundle
        1. Установка с запуском: `osgi:install [-s] {UrlList}` или  `install -s mvn:org.fusesource.example/cxf-basic/1.0-SNAPSHOT`
        1. Вывод списка уже установленных bundels ` osgi:list` или `list`
        1. Остановка запушенного бандла `osgi:stop {bundleID}`
        1. Демонтаж??? ( Uninstall) bundle `osgi:uninstall {bundleID}`
        1. И другие команды в соответствии с lifecycle (Installed// Resolved// Starting// Active// Stopping// Uninstalled) 
                
1. Pабота с feature :
    1. Создание кастоного feature репозитория
        1. В директории проекта создаем файл `features.xml` 
        1. Добавляем содержание 
        ```
        <?xml version="1.0" encoding="UTF-8"?>
          <features name="MyFeaturesRepoName">
            <feature name="MyFeatureName">
              <bundle>UrlBundle</bundle>
            </feature>
          </features>
          ```
    1. Add the local repository URL to the features service `features:addUrl {UrlFeaturesRepo}`
    1. Установка feature с консоли `features:install {MyFeatureName}`
    1. Демонтаж `features:uninstall {MyFeatureName}` 
1. Основы конфигурации (OSGi Config Admin service)

## Работа с JBoss Fuse Fabric:
### Теория
JBoss Fuse Fabric:
Используется для группировки группы контейнеров в кластер, обладающий общим набором конфигурацией и общим набором репозиториев.
Fuse Fabric сoстоит из
     Fabric Ensemble - это набор Fabric Servers, который 
Группа контейнеров в фабрике для этого пользуется общим fabric registry( Реплицированная база данных, в которой хранится вся информация связанная с подготовкой и управлением контейнерами. )

Необходимо, когда большое количество контейнеров запускают на различных хостах и они должны между собой взаимодействовать
####Создание простой фабрики( Single fabric server )
1. Создание fabric server 
    ```
    fabric:create --new-user AdminUser
    --new-user-password AdminPass 
    --new-user-role Administrator 
    --resolver manualip
    --manual-ip 127.0.0.1
    --zookeeper-password ZooPass
    --wait-for-provisioning
    ```
    2. !!!Одну можно создавать только для обучения. Создаем 3 или больше. НЕЧЕТНОЕ КОЛВО( БОЛЬШЕ ОДНОГО)
    2. Имя созданного контейнера можно конфигурировать в `InstallDirJboss-fuse/etc/system.properties` в строке `karaf.name=NameFabricServer`
    
    А КАК СОЗДАТЬ FABRIC ANSABLE ?
       
1. Создание дочерних контейнеров(managed conteqner) `fabric:container-create-child {parent} {name} [number]  `
1. Вывести список дочерних контейнеров  `fabric:container-list`
1. Остановка дочерних контейнеров `fabric:container-stop {name}` 
1. Остановка фабрики `shutdown` ! Важно т.к. дочернии контейнеры работают на отдельных JVM остановка fabric server не ведет
 к остановке дочерних контейнеров
 
#### Работа с Profile!!! В Fabric conteinere вы не можете непосредственно запустить bundle или features
1. Просмотр списка profile: `fabric:profile-list`
1. Cоздание profile на основе родительского profile  `fabric:profile-create --parent {NameParentProfile} {nameProfile}`. 
В качестве родительского профиля в компании чаще всего используются `default` и `jboss-fuse-full`
1. Добавление/удаление feature в profile `fabric:profile-edit  [--delete] --feature {nameFeateres} {nameProfile}`
1. Так же в profile можно добавлять
    1. Url репозитория featers
    1. featers
    1. bundles
    1. конфигурационные настройки для OSGi Config Admin service
    1. Java system properties that affect the Apache Karaf container(analogous to editing etc/config.properties)
    1. Java system properties that affect installed bundles (analogous to editing etc/system.properties)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
1.Просмотр информации о конкретном profile `fabric:profile-display myProfile`
1. Удаление profile `fabric:profile-delete {NameProfile}`
1.Установка profile в контейнер `fabric:container-change-profile container-1 myProfile`











   
    
