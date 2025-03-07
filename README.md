# Android UI Package
This is a package inspired by Material UI and React Structure for Android.


### Usage
```java
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





##### Themes
The application gets a default Theme which does not need any theme provider in the layout.
With the ```useTheme()``` method a state of the current theme will be returned.

The theme can be used to switched between ```dark``` and ```light``` mode and
components rely on the themes color set.

The theme uses **background** and **fallback** color as "static" colors, that is
colors that will always exist in the theme.
But "dynamic" colors also exists, they are the colors that the components use and
if they don't exists the fallback color will be used.
```java
// A Theme example
val theme = useTheme()

color = theme.getColor("myColor") // Returns a color from the color set with the provided name

colorSet = theme.getColorSet("myColorSet") // Returns a color set by its name
```

A color set consist of different colors for different settings
```java
ThemeColorSet(
    lightColor  // Light Color
    darkColor   // Dark Color
)
```

When using the ```getColor(<name>)``` method the color returned will be the color matching the
theme settings, so light color for light mode and dark color for dark mode.



###### Custom Theme
To get a custom theme use the ```ThemeProvider``` with a custom theme as parameter in the
root layout.
```java
/// Application.kt - RootLayout Class - Layout method

ThemeProvider(myCustomTheme) {
    children() // Will have the theme context
}





/// MyTheme.kt
val myCustomTheme: Theme {
    dark: Boolean // Dark Mode

    // Static Colors
    background: ThemeColorSet
    fallback: ThemeColorSet

    // Dynamic Colors
    colors: HashMap<String, ThemeColorSet>
}
```



###### Note
Components use some dynamic colors, by default these are provided but when creating a custom theme
these colors are not set and while it is not needed as non-found colors use the fallback color, it
could be nice to set the colors wanted.

The provided colors are:
- primary
- success
- error

- background : For other components such as cards, not the application background
- outline : For outlines

- text
- dark text


To change colors on components use the ```color``` parameter, not all components have them.
The **color** parameter is a **String** type and will be used to get the color from the theme.
```java
Button(color = "myCustomColor") // Will Create a button with the color set "myCustomColor"

Button() // Will create a button with the default color, "primary"
```





#### Components
Android UI comes with the following components
```java
Typography("Text") // Comes with different types, default paragraph

Button() {
    // Children
}
```


There are also some context providers
```java
RouterProvider() // This is present in the layout in RootLayout and provides a way to switch pages
useRouter() // Provides the router context to switch pages


ThemeProvider() // A default theme is used if this does not exist, and it is not provided in the RootLayout
useTheme() // Provides the theme context to get theme and change dark mode
```


Android UI provides a RootLayout to easily style all pages.
With the router context there is no need for multiple activities, only one is needed.
There is a simple way if loading pages with and without parameters.
```java
val router = useRouter() // Gets the router

// Switch Page
router.setLocation(MyComposablePage()) // Switch to a page that is a composable component
router.setLocation({ MyComposablePage(<params>) }) // Switch to a page with parameters


router.setLocation("<route>") // Loads Page with route, parameter less pages that uses Intent Extras
```

There are also some helping classes such as ```Style``` which provides styling to the components.
Some components have margin and padding so elements position have a bit more flexibility.

And Metadata is provided to the RootLayout. If there is no metadata a default set is used.
The metadata is used to provide some Layout metadata for RootLayout, and to change settings for the
application use the ```override fun onSetup() {}``` from RootLayout.





### Examples
```java
/// Underline Title



// Without Android UI
Text("Title", fontSize = 24.sp, color = Color.White,
    modifier = Modifier.drawBehind {
        drawLine(
            color = Color.White,
            start = Offset(0f, size.height),
            end = Offset(size.width, size.height),
            strokeWidth = 2f
        )
    }
)

// With Android UI
Typography("Title", type = TextType.TITLE, style = Style(underline = true))
```
