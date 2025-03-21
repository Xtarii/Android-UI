import CodeBlock from "@/components/code/code";
import { Box, Typography } from "@mui/material";
import Link from "next/link";

export default function Home() {
    return (<div>
        <main>
            <Box>
                <Typography variant="h3">Getting Started</Typography>
                <Box sx={{ marginTop: "25px" }}>
                    <Typography variant="h4">Adding <code>AUI</code> to a project</Typography>
                    <Typography>Maven</Typography>
                    <CodeBlock language="html">{
                        "<dependency>\n" +
                            "\t<groupId>org.android.ui</groupId>\n" +
                            "\t<artifactId>aui</artifactId>\n" +
                            "\t<version>1.0.1a3</version>\n" +
                        "</dependency>\n"
                    }</CodeBlock>

                    <Typography>Gradle : <code>build.gradle.kts</code></Typography>
                    <CodeBlock>{
                        "dependencies {\n" +
                            '\timplementation("org.android.ui:aui:1.0.1a3")\n' +
                        "}\n"
                    }</CodeBlock>
                </Box>

                <Box sx={{ marginTop: "125px" }}>
                    <Typography variant="h4">Creating a Layout</Typography>
                    <CodeBlock>{
                        "class App : RootLayout() {\n" +
                            "\toverride fun onSetup() {}\n\n\n" +



                            "\t@Composable\n" +
                            "\toverride fun Layout(children: @Composable () -> Unit) {\n" +
                                "\t\tThemeProvider {\n" +
                                    "\t\t\tval theme = useTheme()\n" +
                                    "\t\t\tColumn(modifier = Modifier.fillMaxSize().background(theme.background)) {\n" +
                                        "\t\t\t\t// Application Layout\n" +
                                    "\t\t\t}\n" +
                                "\t\t}\n" +
                            "\t}\n" +
                        "}\n"
                    }</CodeBlock>
                </Box>
            </Box>
        </main>
        <footer>
        </footer>
    </div>)
}
