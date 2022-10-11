plugins {
    id("org.springframework.boot") version "2.7.3"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10"
}

group = "cn.honour"
version = "1.0"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    maven(url = "https://maven.aliyun.com/repository/public/")
    maven(url = "https://maven.aliyun.com/repository/spring/")
    mavenCentral()
}

dependencies {
    // implementation  当前项目依赖，当其他项目引入本项目依赖时，不会引入
    // runtimeOnly 运行时才依赖
    // compile 当前项目依赖，并且可以传递依赖，当其他项目引入本项目依赖时，会引入

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    runtimeOnly("mysql:mysql-connector-java:8.0.30")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.2")

    val mybatisMapperVersion = "2.0.0"
    implementation("io.mybatis:mybatis-mapper:$mybatisMapperVersion")
    // TODO 按需选择依赖
    // 使用 Service 层封装时
    implementation("io.mybatis:mybatis-service:$mybatisMapperVersion")
    // 使用 ActiveRecord 模式时
    implementation("io.mybatis:mybatis-activerecord:$mybatisMapperVersion")

    // 支付
//    implementation("com.alipay.sdk:alipay-sdk-java:4.33.44.ALL")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}
