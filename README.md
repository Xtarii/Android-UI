# Android UI Package
This is a package inspired by Material UI and React Structure for Android.


### Usage
```kt
// Create a RootLayout
class MyApplication : RootLayout() {

    override fun onSetup() {} // Application Settings should be applied here


    @Composable
    override fun Layout(children: @Composable () -> Unit) {
        // Application Layout goes here,
        //
        // children is the page that the router supplies
        // to the application
    }
}
```
