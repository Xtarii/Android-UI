import CodeBlock from "@/components/code/code";
import { Box, List, ListItem, ListItemText, Typography } from "@mui/material";
import { ReactElement } from "react";

export default function Page() : ReactElement {
    return(<div>
        <Box>
            <Typography variant="h4">Themes and Style</Typography>

            {/* Style */}
            <Box sx={{ marginTop: "25px" }}>
                <Typography variant="h5">Style</Typography>
                <Typography>
                    Components use <code>style</code> to specify how
                    the component should look in the application.
                </Typography>
                <CodeBlock>{
                    "val customStyle = Style(\n" +
                        "\tbackgroundColor = Color.Black, // Component Color\n" +
                        "\tcolor = Color.White, // Any Inner Component Color\n\n" +

                        "\tmargin = PaddingValues(50.dp),\n" +
                    ")\n"
                }</CodeBlock>
                <Typography>
                    Some components may not use all the style options available.
                    <br />
                    And all the components use a default style located
                    in <code>org.android.ui.styles.DefaultStyles</code>.
                    <br />
                    And for the components color the components use the contexts
                    theme color map if there is no other color specified in <code>Style</code>.
                </Typography>
            </Box>

            {/* ThemeProvider */}
            <Box sx={{ marginTop: "75px" }}>
                <Typography variant="h5">ThemeProvider</Typography>
                <Typography>
                    The ThemeProvider gives components a map of
                    preset colors to use.
                    <br />
                    If there is no ThemeProvider in the application a
                    default theme will be used when calling <code>useTheme()</code>
                </Typography>

                <Typography sx={{ marginTop: "25px" }}>
                    For custom themes use the <code>ThemeProvider</code> and give it a
                    custom theme as argument.
                    It is also possible to use the ThemeProvider without a specified Theme.
                    <br />
                    If there is no Theme specified the ThemeProvider will use a default theme with
                    dark mode set to system theme mode.
                </Typography>
                <CodeBlock>{
                    "ThemeProvider { ... } // Default Theme and system default as dark mode\n"
                }</CodeBlock>

                <Typography>To use a custom theme, create the theme</Typography>
                <CodeBlock>{
                    "val customTheme = Theme(\n" +
                        "\tdark = true,\n" +
                        "\tbackground = ThemeColorSet(\n" +
                            "\t\tlightColor = Color.LightGray,\n" +
                            "\t\tdarkColor = Color.DarkGray\n" +
                        "\t),\n" +
                        "\tfallbackColorSet = ThemeColorSet(\n" +
                            "\t\tlightColor = Color.Blue,\n" +
                            "\t\tdarkColor = Color.Yellow\n" +
                        "\t),\n" +
                        "\tcolors = HashMap<ThemeKeysType, ThemeColorSet>().apply {\n" +
                            '\t\tput("myColor", ThemeColorSet(\n' +
                                "\t\t\tlightColor = Color.DarkGray,\n" +
                                "\t\t\tdarkColor = Color.LightGray\n" +
                            "\t\t))\n" +
                        "\t}\n" +
                    ")\n"
                }</CodeBlock>
                <Typography>
                    The themes colors use a color set to separate dark and light colors.
                    <br />
                    To make sure that there is always a background color and a
                    fallback color available a <code>static</code> color set is
                    specified as <code>background</code> and <code>tfallbackColorSet</code>.
                    <br />
                    All other color sets are added to the <code>colors</code> map.
                </Typography>
                <Typography sx={{ marginTop: "10px" }}>
                    By default the theme has a color map with color set
                </Typography>
                <List>
                    {[
                        "primary",
                        "success",
                        "error",
                        "background",
                        "outline",
                        "text",
                        "dark text"
                    ].map((value, index) => <ListItem key={index}>
                        <ListItemText>{value}</ListItemText>
                    </ListItem>)}
                </List>

                <Typography>
                    To use the custom theme in the ThemeProvider add the theme as an argument.
                </Typography>
                <CodeBlock>{
                    "ThemeProvider(customTheme) { ... }\n"
                }</CodeBlock>
            </Box>

            {/* useTheme */}
            <Box sx={{ marginTop: "75px" }}>
                <Typography variant="h5">Getting the Theme context</Typography>
                <Box>
                    <Typography>
                        The <code>AUI</code> components use the theme to get the components colors.
                        <br />
                        To get the theme in the current context use the function <code>useTheme()</code>
                    </Typography>
                    <CodeBlock>{
                        "val theme = useTheme()\n\n" +

                        "val isDark = theme.dark\n" +
                        "val bg = theme.background // Gets background color\n" +
                        'val color = theme.getColor("primary") // Gets primary color\n\n' +

                        "// Getting a color set\n" +
                        'val colorSet = theme.getColorSet("primary") // Gets primary color set\n' +
                        "\n"
                    }</CodeBlock>
                    <Typography>
                        It is possible to get the hole color set by the theme.
                        <br />
                        But if only the color is needed, calling <code>getColor("name")</code> will
                        return the <code>dark color</code> if theme is <code>dark theme</code> or
                        the <code>light color</code> if the theme is <code>light theme</code>.
                    </Typography>

                    <Typography sx={{ marginTop: "25px" }}>
                        To set if the theme should use <code>dark</code> or <code>light</code> mode,
                        use the <code>theme.dark</code>.
                    </Typography>
                    <CodeBlock>{
                        "val theme = useTheme()\n" +
                        "var value by remember { mutableStateOf(theme.dark) }\n\n" +

                        "Button(onClick = {\n" +
                            "\tvalue = !value\n" +
                            "\ttheme.dark = value\n" +
                        "})\n"
                    }</CodeBlock>
                </Box>
            </Box>
        </Box>
    </div>)
}
