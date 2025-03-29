import CodeBlock from "@/components/code/code"
import { Box, Typography } from "@mui/material"
import Link from "next/link"
import { ReactElement } from "react"

export default function Page() : ReactElement {
    return(<div>
        <Typography variant="h4">Root Layout</Typography>
        <Box>
            <Typography>
                It is not required to have a <code>RootLayout</code> to
                use <code>Android UI</code> but it is the recommended way
                of using this library.
            </Typography>
            <Typography marginTop={"25px"}>
                <code>AUI</code> comes with some default pages for getting started.
                The default starter page <code>StarterPage()</code> and the fallback
                page <code>Error()</code> exists in the library but can be changed
                for custom pages.
            </Typography>


            {/* Simple RootLayout */}
            <Box marginTop={"75px"}>
                <Typography variant="h5">Creating a simple RootLayout</Typography>
                <Typography>
                    Android UI comes with the function of using one <code>Activity</code> to
                    run the whole application from.
                    <br/>
                    Similar to <code>React</code>, a layout can be created and applied over
                    many pages in an android application.
                    <br/>
                    To create an application layout, start with creating a <code>class</code> and
                    extend it with the <code>RootLayout</code> class.
                </Typography>
                <CodeBlock>{'class App : RootLayout(metadata = Meta()) {}'}</CodeBlock>

                <Typography>
                    The <code>RootLayout</code> takes <code>meta data</code> as a parameter
                    for determining <code>fullscreen</code> and <code>edgeToEdge</code>.
                    <br />
                    It can also be used to set a routing map and default error page.
                </Typography>
                <CodeBlock>{
                "val metadata = Meta(\n" +
                    "\tfullscreen = false,\n" +
                    "\tedgeToEdge = true,\n\n" +

                    "\trouting = HashMap<String, @Composable () -> Unit>().apply {\n" +
                    "\t\tput('/') { StarterPage() }\n" +
                    "\t},\n\n" +

                    "\tstart = { StarterPage() },\n" +
                    "\tfallback = { Error() }\n" +
                ")\n"
                }</CodeBlock>
                <Typography>
                    The <code>fallback</code> and <code>start</code> is to
                    tell the router what page to load if a page could not
                    be loaded and what page to load first when the application starts.
                </Typography>
            </Box>

            {/* RootLayout Setup */}
            <Box marginTop={"75px"}>
                <Typography variant="h5">Creating an application Layout</Typography>
                <Typography>
                    The <code>RootLayout</code> has two abstract methods to help
                    create the application.
                    <br />
                    The <code>onSetup()</code> is called before the layout is created,
                    and can be used to set some application settings.
                    And the <code>Layout()</code> method is where he application layout
                    is placed.
                    <br />
                    By default a <code><Link href={"./router"} className="link">RouterProvider</Link></code> is
                    created for the layout.
                </Typography>
                <CodeBlock>{
                    "class MyApplication : RootLayout() {\n\n" +

                        "\toverride fun onSetup() {}\n\n" +


                        "\t@Composable\n" +
                        "\toverride fun Layout(children: @Composable () -> Unit) {\n" +
                        "\t}\n" +
                    "}\n"
                }</CodeBlock>

                <Typography marginTop={"25px"}>
                    When using <code>RootLayout</code> an instance for <code>LocalStorage</code> is
                    automatically created.

                    Normally with android it is required to have a <code>context</code> but thanks
                    to <code>RootLayout</code> the LocalStorage is initialized with a context and
                    therefore does not need one later on.
                </Typography>
                <CodeBlock>{
                    'LocalStorage.put("<name>", "<data>") // Store data\n' +
                    'LocalStorage.get("<name>") // Returns Data or null\n'
                }</CodeBlock>
                <Typography>
                    LocalStorage can be accessed from anywhere and does <code>not</code> need its
                    calling parent to be <code>Composable</code> to work.
                </Typography>
            </Box>
        </Box>
    </div>)
}
