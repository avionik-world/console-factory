# Console Factory 🦆
This allows you to create a console with JLine to create commands for the terminal.

## Using the Console Factory in your plugin

### Maven
```xml
<repositories>
  <repository>
     <id>github</id>
     <url>https://maven.pkg.github.com/avionik-world/console-factory</url>
   </repository>
</repositories>
```

```xml
<dependencies>
 <dependency>
    <groupId>world.avionik</groupId>
    <artifactId>console-factory</artifactId>
    <version>1.0.1</version>
    <scope>provided</scope>
  </dependency>
</dependencies>
```

### Gradle
```groovy
repositories {
    maven { url = 'https://maven.pkg.github.com/avionik-world/console-factory' }
}
```

```groovy
dependencies {
    compileOnly 'world.avionik:console-factory:1.0.1'
}
```

## How to create a new Console
You can implement the [Console](https://github.com/avionik-world/console-factory/blob/master/src/main/kotlin/world/avionik/console/factory/Console.kt) class in your Main class. That was actually all. Now you have the possibility to create commands. 
There is the [ConsoleInput](https://github.com/avionik-world/console-factory/blob/master/src/main/kotlin/world/avionik/console/factory/input/ConsoleInput.kt) class. There you can set what the command should be called and what must be executed.
``` kotlin
class MainConsoleClass : Console(
    ConsoleInput("first") { println("Second") }
)
```

## What is a ConsoleInputExecutor
To have a "better code structure" there is the [ConsoleInputExecutor](https://github.com/avionik-world/console-factory/blob/master/src/main/kotlin/world/avionik/console/factory/input/ConsoleInputExecutor.kt). You can use it to create a class, implement this executor and write your command there. Here is an example:
``` kotlin
class BirdExecutor : ConsoleInputExecutor {

    override fun execute() {
        println("Im a bird")
    }

}
```

Once you have implemented this executor, you only need to integrate it into your main class that has implemented the Console interface. There you can register the executor with the ConsoleInput class. Here is another example:
``` kotlin
class MainConsoleClass : Console(
    ConsoleInput("fly", executor = BirdExecutor())
)

// And this is how you can add aliases
class MainConsoleClass : Console(
    ConsoleInput("fly" "bird", executor = BirdExecutor())
)
```
