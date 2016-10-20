# RxJava training

In case unthinkable happens and we will have to work offline, plz prepare your environment:

1. jdk 8, favourite IDE (intellij community is enough), docker, git
1. clone this repo
1. download all dependencies:

    ```
    ./gradlew test -Dtest.single=EmptyTest
    docker pull training/webapp
    docker pull postgres:9.6.1
    ```
1. import project into your IDE and check if you can:
   1. see sources & javadocs (for example `rx.Completable`)
   1. run the test inside `EmptyTest.java`
