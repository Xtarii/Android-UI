import CodeBlock from "@/components/code/code"
import { Box, List, ListItem, Typography } from "@mui/material"
import Link from "next/link"
import { ReactElement } from "react"

export default function Page() : ReactElement {
    return(<div>
        <Typography variant="h4">Router and RouterProvider</Typography>

        {/* Router Provider */}
        <Box marginTop={"25px"}>
            <div id="provider" />
            <Typography variant="h5">RouterProvider</Typography>
            <Typography>
                By default a <code>RouterProvider</code> is supplied in
                the <code><Link href={"./layout"} className="link">RootLayout</Link></code>.
            </Typography>
            <Typography>
                The RouterProvider takes the following parameters,
            </Typography>
            <List>
                <ListItem>Routing map</ListItem>
                <ListItem>A Start Page</ListItem>
                <ListItem>A Fallback Page</ListItem>
                <ListItem>The Application Content</ListItem>
            </List>
            <CodeBlock>{
                "RouterProvider(\n" +
                    "\trouting: HashMap<String, @Composable () -> Unit>,\n" +
                    "\tstart: @Composable () -> Unit,\n" +
                    "\tfallback: @Composable () -> Unit,\n" +
                    "\tchildren: @Composable () -> Unit\n" +
                ")\n"
            }</CodeBlock>
        </Box>

        {/* Router */}
        <Box marginTop={"75px"}>
            <div id="router" />
            <Typography variant="h5">Router</Typography>
            <Typography>
                The router can be accessed with <code>useRouter()</code>.
                The router can be used to change where in the application
                a user is located with either a <code>Composable Page</code> or
                a <code>string</code> that links to a <code>router mapping</code>.
            </Typography>
            <CodeBlock>{
                "@Composable\n" +
                "fun Page() {\n" +
                    "\tval router = useRouter()\n\n" +

                    "\trouter.setLocation { Page() }\n" +
                    "\trouter.setLocation('some route')\n" +
                    "\trouter.setLocation() // Loads Start Page\n" +
                "}\n"
            }</CodeBlock>
        </Box>

        {/* Routes */}
        <Box marginTop={"75px"}>
            <div id="routes" />
            <Typography variant="h5">Routes</Typography>
            <Typography>
                If there are pages that does not take any parameters they
                can be added to the routers mapping system.
                <br />
                That way other applications can start those pages when they
                start the application activity, and a new page does not need
                to be created every time,
                instead the router reuses the old page.
            </Typography>
            <CodeBlock>{
                "val meta = Meta(\n" +
                    "\trouting = HashMap<String, @Composable () -> Unit>().apply {\n" +
                        "\t\tput('foo') { Foo() }\n" +
                    "\t}\n" +
                ")\n"
            }</CodeBlock>
            <Typography>
                If another activity loads in the application, the <code>route</code> extras can
                be used to set what page the application should load.
            </Typography>
            <CodeBlock>{
                "startActivity(\n" +
                    "\tIntent(\n" +
                        "\t\tcontext,\n" +
                        "\t\tApp::class.java\n" +
                    "\t).apply { putExtra('route', 'foo') }\n" +
                ")\n"
            }</CodeBlock>
            <Typography>
                This only works if the application builds on the <code><Link href={"./layout"} className="link">RootLayout</Link></code>.
            </Typography>
        </Box>
    </div>)
}
