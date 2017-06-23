Задачи по review выполнять в первую очередь, задачи из backlog брать только после стабилизации текущего функционала.

TASK_REVIEW_23.06.2017:
1. Удалить директории target и внести их в .gitignore
2. Добавить проект soapUI в репозиторий
3. Привести названия модулей в нижний регистр
4. Перенести общие плагины (например, fabric8-maven-plugin) в parent pom.
5. Перенести стандартные настройки манифестов из плагина Felix в parent pom.
6. Перенести версии пакетов (properties) в parent pom.
7. Добавить в feature необходимые feature и bundle (для Hibernate и т.п., что требуется для установки на чистый Karaf)
8. Завести единое хранилище настроек для всех модулей. Каждый property-placeholder просто должен иметь одинаковое имя (т.е. persistent-id) и ссылаться на один файл, шаблон файла можно расположить в src/main/resources в корне проекта.

Backlog:
TASK1. Перенести XSD и WSDL в выделенный модуль model вместе с плагином wsdl2java
TASK2. Перенести Entity в модуль model
TASK3. Разнести Database на модули datasource и dao. Создать модуль datasource и определить в нем bean с DataSource. Настройки должны задаваться через property-placeholder. 
    Вывесить DataSource как сервис. В модуле dao оставить настройки hibernate (без настроек подключения) и логику работы с БД.
    Entity импортировать из модуля model.
TASK4. Переделать обработку транзакций с ручной на Blueprint.
    xmlns:jpa="http://aries.apache.org/xmlns/jpa/v1.1.0"
    xmlns:tx="http://aries.apache.org/xmlns/transactions/v1.0.0"
    Пример бина:
    <bean id="dynamicRoutingDaoImpl"
            class="ru.cinimex.rgs.dal.DynamicRoutingDaoImpl"
            activation="eager" init-method="startUp">
        <jpa:context unitname="jpaData" property="entityManager"/>
        <tx:transaction method="*" value="RequiresNew"/>
    </bean>