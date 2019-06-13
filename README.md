# smoothie
Simple way to handle the Idling Resource in your Espresso tests. 

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
