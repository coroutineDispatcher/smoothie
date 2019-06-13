# Smoothie 🍦⛸🍨❄
Simple way to handle the Idling Resource in your Espresso tests. 

# Download

## Add it in your root build.gradle at the end of repositories:

```Groovy
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
    
## Add the dependency

```Groovy
	dependencies {
	        implementation 'com.github.stavro96:smoothie:1.0'
	}
```

# Usage: 

## In your class where you have some async operation: 

To increment: 

```Kotlin
Smoothie.startProcess()
```
To decrement: 

```Kotlin
Smoothie.endProcess()
```
In your Espresso test: 

```Kotlin
    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(Smoothie.countingIdlingResource)
        //other dependencies
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(Smoothie.countingIdlingResource)
        print("Finished testing")
    }
```

Note: The library supports the latest version for Idling-Resources with the AndroidX usage: 
```Groovy
    implementation 'androidx.test.espresso:espresso-idling-resource:3.2.0'
```
And we are good to go. 




```
Copyright 2019 stavro96.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
