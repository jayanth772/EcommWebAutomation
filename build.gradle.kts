

plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}




dependencies {
    //implementation(platform("org.junit:junit-bom:5.10.0"))
    //implementation("org.junit.jupiter:junit-jupiter")

    implementation("org.seleniumhq.selenium:selenium-java:4.25.0")
    implementation("org.testng:testng:7.10.2")
    implementation("org.apache.logging.log4j:log4j-core:2.24.0")
    implementation("io.github.bonigarcia:webdrivermanager:5.9.2")


}

tasks.test {
    useTestNG()
    systemProperties = System.getProperties().map { it.key.toString() to it.value }.toMap()
}




tasks.register<Test>("runWebTests") {
    outputs.upToDateWhen { false }
    useTestNG {
        useDefaultListeners = true
         setOutputDirectory(layout.buildDirectory.dir("web-reports").get().asFile)
    }
}