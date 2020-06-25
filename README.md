# Unit Converter
Unit converter written in Kotlin

That's a project I've done while learning on [JetBrains Academy][hyperskill]

## Overview
When you travel, everything changes: people, languages, time zones, and even units. It may be difficult to read the temperature in Fahrenheit when you’ve always used Celsius, or to measure yourself in kilos if you’ve only used pounds. It’s no easy matter, though a nice unit converter could certainly help! In this project, you will write a converter that handles distance, weight, and temperature units – all the traveller’s essentials.

```sh
Enter what you want to convert (or exit): 
> 1 kn to feet
Conversion from ??? to feet is impossible

Enter what you want to convert (or exit): 
> 1 km to feet
1.0 kilometer is 3280.839895013123 feet

Enter what you want to convert (or exit): 
> 3 pound to ounces
3.0 pounds is 47.99999999999999 ounces

Enter what you want to convert (or exit): 
> 3 kelvins to grams
Conversion from kelvins to grams is impossible

Enter what you want to convert (or exit): 
> 1 K in C
1.0 kelvin is -272.15 degrees Celsius

Enter what you want to convert (or exit): 
> one boa in parrots
Parse error

Enter what you want to convert (or exit): 
> exit
```

## Requirements
- Download [JDK][openjdk-14] and extract
- Add JDK `/bin` directory to your PATH

## Usage
- Download [release]
- Run where you placed `converter.jar`:
```sh
java -jar converter.jar
```
- Or you can run Kotlin class (see Build)
- Run in `/converter` parent directory:
```sh
kotlin converter.MainKt
```

## Build
- Install [Kotlin compiler][kotlinc], same as JDK (see requirements)
- Run the following from project directory


- To build artifact:
```sh
kotlinc src/converter/Main.kt -include-runtime -d out/artifacts/converter.jar
```
- To build Kotlin class:
```sh
kotlinc src/converter/Main.kt -d out/production/classes
```

[openjdk-14]: http://jdk.java.net/14/
[kotlinc]: https://github.com/JetBrains/kotlin/releases/latest
[hyperskill]: https://hyperskill.org/projects/70
[release]: https://github.com/mihael-stormrage/unit-converter-kotlin/releases
